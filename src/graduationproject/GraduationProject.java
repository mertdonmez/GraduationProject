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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.Covariance;
import flanagan.analysis.PCA;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.ChartLauncher;
import org.jzy3d.chart.SwingChart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import static org.jzy3d.chart.factories.AWTChartComponentFactory.chart;
import static org.jzy3d.chart.factories.NewtChartComponentFactory.chart;
import static org.jzy3d.chart.factories.NewtChartComponentFactory.chart;
import static org.jzy3d.chart.factories.NewtChartComponentFactory.chart;
import static org.jzy3d.chart.factories.SwingChartComponentFactory.chart;
import static org.jzy3d.chart.factories.SwingChartComponentFactory.chart;
import static org.jzy3d.chart.factories.SwingChartComponentFactory.chart;
import static org.jzy3d.chart.factories.SwingChartComponentFactory.chart;
import static org.jzy3d.chart2d.Chart2dComponentFactory.chart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.AbstractDrawable;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.primitives.ScatterMultiColor;
import org.jzy3d.plot3d.rendering.canvas.Quality;


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
                // sutun ortalamaları bulundu standart sapmalar bulunacak
                
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
               
                   int zz = 0;
           double toplammm = 0;
           while(zz != 517){
               toplammm += scaledArray[zz][0];
               zz++;
           }
           
         //  System.out.println(" toplam :"+toplammm);
        
         //  System.out.println(" top    :"+ toplammm/517);
               
               
               
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
                //     System.out.print(covarrianceArray[i][j] + "  ");
                  }
                //    System.out.println("");
        }
          
               
               // ucuncu kutuphane 
               
                      PCA pca = new PCA();
                 
                 pca.enterScoresAsRowPerPerson(doubleArray);
              
                    pca.useCovarianceMatrix();
                    System.out.println("to");
                   
                   
                  double [] son = pca.orderedEigenValues();
                   double[][] dene =  pca.orderedEigenVectors();
                  
                  
                   for (int i = 0; i < 13; i++) {
                       for (int j = 0; j < 13; j++) {
                           System.out.print(dene[i][j] + "  ");
                       }
                       System.out.println("");
        }
                   double tempDizi [][] = new double[13][3];
                   
                   int temp1 = 0 , temp2 = 0;
                   
                   while(temp1 != 13){
                       tempDizi[temp1][temp2] = dene[temp1][temp2];
                       temp2++;
                       
                       if(temp2 == 3){
                           temp2 = 0;
                           temp1++;
                       }
                       
                   }
                   
                   
                   System.out.println("");
                   
//                      for (int i = 0; i < son.length; i++) {
//                      System.out.println("son:  " +son[i] + "    ");
//        }
//          
                         System.out.println("");
              double toplamm =  son[0]+son[1]+son[2]; 
                 double toplammm2 = 0;
                 
                 
                 for (int i = 0; i < son.length; i++) {
                  toplammm2 += son[i];
        }
                 
               double sonuc =  (toplamm / toplammm2)*100; 
                 
               System.out.println("sonuc son   :" +sonuc);
               
               double sonDizi [][] = new double[517][3];
               
            
                     
                     System.out.println("tempdizii");
               
                     for (int i = 0; i < 13; i++) {
                         for (int j = 0; j < 3; j++) {
                        //     System.out.print(tempDizi[i][j] + "  ");
                         }
                     //    System.out.println("");
        }
                     
                     
                        for (int i = 0; i < 517; i++) {
                 for (int j = 0; j < 3; j++) {
                     sonDizi[i][j] = 0.0;
                 }
        }
                     
                     System.out.println("-------------------------------------------");
                                for (int i = 0; i < 517; i++) {
                  for (int j = 0; j < 3; j++) {
                      for (int k = 0; k < 13; k++) {
                           sonDizi[i][j]+=(doubleArray[i][k]*tempDizi[k][j]);
                      }
                  }
        } 
                     for (int i = 0; i < 517; i++) {
                         for (int j = 0; j < 3; j++) {
                          //   System.out.print(sonDizi[i][j] + "  ");
                         }
                      //   System.out.println("");
        }
                     
     int size = 100000;
float xx;
float yy;
float zzz;
Coord3d[] points = new Coord3d[size];

// Create scatter points
for(int i=0; i<size; i++){
    xx = (float)Math.random() - 0.5f;
    yy = (float)Math.random() - 0.5f;
    zzz = (float)Math.random() - 0.5f;
    points[i] = new Coord3d(xx, yy, zzz);
}       

    // Create a drawable scatter with a colormap
    ScatterMultiColor scatter = new ScatterMultiColor( points, new ColorMapper( new ColorMapRainbow(), -0.5f, 0.5f ) );

    // Create a chart and add scatter
        SwingChart  chart = new SwingChart();
    chart.getAxeLayout().setMainColor(Color.WHITE);
    chart.getView().setBackgroundColor(Color.BLACK);
    chart.getScene().add(scatter);
    ChartLauncher.openChart(chart);                
              
               
               
          
    }
   
    
    
     public static void Write(String string[][]){
       
      try{
          FileWriter fr = new FileWriter("C:\\Users\\yigido\\Desktop\\dataset.txt");
          BufferedWriter br = new BufferedWriter(fr);
          PrintWriter out = new PrintWriter(br);
          for(int i=0; i<517; i++){
              for (int j = 0; j < 13; j++) {
                  if(string[i][j] != null){
                   
            out.write(string[i][j] + " ");
            
            if(j != 12)
            out.write(",");
            
            if(j == 12)
                 out.write("\n");
               
                  }
               
              }
            br.newLine();
          }
          out.close();
      }
      catch(IOException e){
       System.out.println(e);   
      }
  }
}
