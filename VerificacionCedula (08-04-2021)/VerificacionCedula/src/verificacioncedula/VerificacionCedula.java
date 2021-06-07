/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacioncedula;

import java.util.Scanner;

/**
 *
 * @author Fdo
 */
public class VerificacionCedula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner teclado = new Scanner (System.in);
       int vector[]= new int[9];
       for(int i=0; i<vector.length; i++){ 
           System.out.println("Escriba el digito de la posicion " +i);
                vector[i]=teclado.nextInt();
       }              
       int suma=0;
       int num=2;
       for ( int i=0; i < vector.length; i++){
           System.out.println("Posicion [" + i + "]=" + vector[i]);
        }
       vector[0]=vector[0]*2; 
       if (vector[0]>=10){
           vector[0]=vector[0]-9;
       }
       System.out.println("Valor posicion 0 = " + vector[0]);

       vector[1]=vector[1]*1;
       if (vector[1]>=10){
           vector[1]=vector[1]-9;
       }
       System.out.println("Valor posicion 1 = " + vector[1]);
       
       vector[2]=vector[2]*2;
       if (vector[2]>=10){
           vector[2]=vector[2]-9;
       }
       System.out.println("Valor posicion 2 = " + vector[2]);
       
       vector[3]=vector[3]*1;
       if (vector[3]>=10){
           vector[3]=vector[3]-9;
       }
       System.out.println("Valor posicion 3 = " + vector[3]);

       vector[4]=vector[4]*2;
       if (vector[4]>=10){
           vector[4]=vector[4]-9;
       }
       System.out.println("Valor posicion 4 = " + vector[4]);
       
       vector[5]=vector[5]*1;
       if (vector[5]>=10){
           vector[5]=vector[5]-9;
       }
       System.out.println("Valor posicion 5 = " + vector[5]);
       
       vector[6]=vector[6]*2;
       if (vector[6]>=10){
           vector[6]=vector[6]-9;
       }
       System.out.println("Valor posicion 6 = " + vector[6]);
       
       vector[7]=vector[7]*1;
       if (vector[7]>=10){
           vector[7]=vector[7]-9;
       }
       System.out.println("Valor posicion 7 = " + vector[7]);
       
       vector[8]=vector[8]*2;
       if (vector[8]>=10){
           vector[8]=vector[8]-9;
       }
       System.out.println("Valor posicion 8 = " + vector[8]);
      
       for(int valor: vector){
            suma+=valor;
        }
        System.out.println("Suma de los valores = "+suma);
        
        int x;
        int resta=0;
        if((suma%10)!=0){
            x=((suma/10)+1)*10;
            resta=x-suma;
        }
        System.out.println("El ultimo valor de la cedula es = "+resta);
    }
    
}
