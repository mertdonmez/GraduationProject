/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduationproject;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import Jama.examples.MagicSquareExample;

/**
 *
 * @author yigido
 */
public class GraduationProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        File dataset=new File("C:\\Users\\yigido\\Desktop\\Bitirme\\datasets.txt");
        FileInputStream oku=new FileInputStream(dataset);
        DataInputStream okumak2=new DataInputStream(oku);
        String satirOku=okumak2.readLine();
        String [] stringArray = satirOku.split(",");
        String [][] stringModifiedArray = new String[517][13];
        double [][] doubleArray = new double[517][13];
        int count = 0 ;
        double [] sutunOrts = new double[13];
        double [] sutunVar = new double[13];
        double [][] scaledArray = new double [517][13];
       double [][] transpozeArray = new double [13][517];
       double [][] covarrianceArray = new double [13][13];
       
            while (satirOku!=null) {
            
                for (int i = 0; i < 517; i++) {
                    for (int j = 0; j < 13; j++) {
                
                        stringModifiedArray[i][j] = stringArray[count];
                
                        count++;
                        if(count == 13){
                             count = 0;
                        }
                    }
                        satirOku=okumak2.readLine();
                        if(satirOku == null){
                             break;
                         }
                        stringArray = satirOku.split(",");
                }
            }
        
            String replace ;
        
            for (int i = 0; i < 517; i++) {
                for (int j = 0; j < 13; j++) {
                
                 replace = stringModifiedArray[i][j].replaceAll("mar", "3");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("oct", "9");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("aug", "8");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("sep", "10");  stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("apr", "4");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("jun", "6");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("jul", "7");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("feb", "2");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("dec", "12");  stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("may", "5");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("jan", "1");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("nov", "11");  stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("fri", "6");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("tue", "3");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("sat", "7");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("sun", "1");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("mon", "2");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("wed", "4");   stringModifiedArray[i][j] = replace;
                 replace = stringModifiedArray[i][j].replaceAll("thu", "5");   stringModifiedArray[i][j] = replace;
             
                }
            }
        
                for (int i = 0; i < 517; i++) {
                    for (int j = 0; j < 13; j++) {
                        doubleArray[i][j] = Double.parseDouble(stringModifiedArray[i][j]);
                    }
        }
            
                    for (int i = 0; i < 517; i++) {
                        for (int j = 0; j < 13; j++) {
                     //     System.out.print(doubleArray[i][j] + " ");
                        }
                      //    System.out.print("\n");
                    }
                    
                 int x = 0;
                 int y = 0 ;
                 int z = 0;
                 double toplam = 0;
                 double ort = 0;
                 
//                 while(x != 517){
//                     toplam +=  doubleArray[x][y];
//                    x++;
//                 }
//                 
//                 System.out.println(toplam / 517);
                 
                while(x != 517){
                    toplam +=  doubleArray[x][y];
                    x++;
                    
                    if(x == 517){
                        ort = toplam / 517 ;
                        sutunOrts[z] = ort;
                        x = 0;
                        y++;
                        z++;
                        ort = 0;
                        toplam = 0;
                    }
                    
                    if(y == 13){
                        break;
                    }
                }
                 
                for (int i = 0; i < 13; i++) {
                    //    System.out.println(sutunOrts[i]);
                }
                
                System.out.println("-------------------------------------------------------------------------");
                // sutun ortalamaları bulundu varyanslar bulunacak
                
                int a = 0 , b = 0 , c = 0; 
                double toplamVar = 0 , toplamVar1 = 0;
                
                   while(a != 517){
                      toplamVar =  doubleArray[a][b] - sutunOrts[c];
                      toplamVar1 +=  Math.pow(toplamVar, 2);
                      a++;
                        
                      if(a == 517){
                       
                        sutunVar[c] = Math.sqrt(toplamVar1 / 516);
                        a = 0;
                        b++;
                        toplamVar1 = 0;
                        c++;
                      }
                      
                      toplamVar = 0;
                      
                       if(c == 13){
                        break;
                    }
                    
                   } 
                   
                    for (int i = 0; i < 13; i++) {
                   //    System.out.println(sutunVar[i]);
                }
                    
//                    int zz = 0;
//                    double zzz = 0 , zzz1 = 0;
//                    double tp = 0;
//                    while(zz != 517){
//                         zzz =  doubleArray[zz][12] - sutunOrts[12];
//                         zzz1 +=  Math.pow(zzz, 2);
//                         zz++;
//                    }
//                    zzz1 = zzz1 / 516;
//                    tp = Math.sqrt(zzz1);
//                    
//                    System.out.println("tp  :" + tp);
                    
                a = 0; b = 0; c = 0;
                
                while(a != 517){
                  scaledArray[a][b]  = ((doubleArray[a][b] - sutunOrts[c]) / sutunVar[c]);
                  a++;
                  if(a == 517){
                      a = 0;
                      b++;
                      c++;
                  }
                  
                  if ( c == 13){
                      break;
                  }
                  
                }
                
                  for (int i = 0; i < 517; i++) {
                   for (int j = 0; j < 13; j++) {
                    //   System.out.print(scaledArray[i][j] + "  ");
                   }
                  //   System.out.println("");
        }
                  
               for (int i = 0; i < 517; i++) {
                   for (int j = 0; j < 13; j++) {
                       transpozeArray[j][i] = scaledArray[i][j];
                   }
        }
               
               
                for (int i = 0; i < 13; i++) {
                 for (int j = 0; j < 517; j++) {
                 //    System.out.print(transpozeArray[i][j] + "   ");
                 }
              //   System.out.println("");
        }
               
                 for (int i = 0; i < 13; i++) {
                 for (int j = 0; j < 13; j++) {
                     covarrianceArray[i][j] = 0.0;
                 }
        }
               
                 for (int i = 0; i < 13; i++) {
                  for (int j = 0; j < 13; j++) {
                      for (int k = 0; k < 517; k++) {
                           covarrianceArray[i][j]+=(transpozeArray[i][k]*scaledArray[k][j]);
                      }
                  }
        }       
                
                  for (int i = 0; i < 13; i++) {
                  for (int j = 0; j < 13; j++) {
                  //   System.out.print(covarrianceArray[i][j] + "  ");
                  }
                 //   System.out.println("");
        }
                  
                 Matrix mat = new Matrix(covarrianceArray);
              
             //    EigenvalueDecomposition ee = mat.eig();
             //    Matrix V = ee.getV();
             //    Matrix D = ee.getD();
                
                 
                EigenvalueDecomposition E = new EigenvalueDecomposition(mat.plus(mat.transpose()).times(0.5));
           
                 double [] d = E.getRealEigenvalues();
             
                 Matrix v = E.getV();
                 Matrix dd = E.getD();
                 System.out.println("Eigenvectors : ?");
                         
                 v.print(5,5);
                 dd.print(5, 5);
                 
              System.out.println("Eigenvalues : ");
              
              
                 for (int i = 0; i < d.length; i++) {
                     // System.out.print(d[i] + "    ");
        }

              //   V.print(13, 13);
                  
                 // D.print(13, 13);

                //  System.out.println("----------------------------------------");
                  
                  
                // check that v is orthogonal
             //  System.out.println(v.times(v.transpose()).minus(Matrix.identity(13, 13)).normInf());
               
                // check that mat v = dd v
              //    System.out.println(mat.times(v).minus(v.times(dd)).normInf());
                  
    }
    
}
