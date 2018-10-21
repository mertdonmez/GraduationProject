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
        Double [][] doubleArray = new Double[517][13];
        int count = 0 ;
        Double [] sutunOrts = new Double[13];
       
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
                           System.out.print(doubleArray[i][j] + " ");
                        }
                           System.out.print("\n");
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
                        System.out.println(sutunOrts[i]);
                }
                 
                // sutun ortalamaları bulundu varyanslar bulunacak
                
                 
                    
                    
                    
                    
                    
                    
                    
          
    }
    
}
