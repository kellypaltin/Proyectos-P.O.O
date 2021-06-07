/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriefibonacci;

/**
 *
 * @author Fdo
 */
public class SerieFibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //Empleando las tres estructuras repetitivas generar la serie fibonacci, ademas indicar el numero de elementos a generar
        //0,1,1,2,3,5,8,...
        
        //While
        int contador = 1;
        int a = 0;
        int b = 1;
        int n = 10;
        System.out.println("Se generara " + n + " elementos");
        System.out.println(a);
        System.out.println(b);
        while(contador <= (n-2)){
            int resultado = a + b;
            System.out.println(resultado);
            a = b;
            b = resultado;
            contador++;
        }
        //Do-While 
        int contador1 = 1;
        int a1 = 0;
        int b1 = 1;
        int n1 = 10;
        System.out.println("Se generara " + n1 + " elementos");
        System.out.println(a1);
        System.out.println(b1);
        do{
            int resultado1 = a1 + b1;
            System.out.println(resultado1);
            a1 = b1;
            b1 = resultado1;
            contador1++;
        }while(contador1 <= (n1-2));
        
        //For 
        int a2 = 0;
        int b2 = 1;
        int n2 = 10;
        System.out.println("Se generara " + n2 + " elementos");
        System.out.println(a2);
        System.out.println(b2);
        for(int contador2 = 1; contador2 <= (n2-2); contador2++){
            int resultado2 = a2 + b2;
            System.out.println(resultado2);
            a2 = b2;
            b2 = resultado2;
            
        }
    }
    
}
