/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Realizar la transpuesta de la matriz 
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese filas");
        int fila = teclado.nextInt();
        System.out.println("Ingrese columnas");
        int columna = teclado.nextInt();
        int matriz[][]= new int [fila][columna];
        for (int i = 0; i < matriz.length; i++){
            for (int j=0; j < matriz[i].length; j++){
                System.out.println("Escriba el valor para la posicion " +i+ " y " +j);
                matriz[i][j]=teclado.nextInt();
            }
        }
        System.out.println("Matriz original");
        for (int i =0; i < matriz.length; i++){
            for (int j=0; j < matriz[i].length; j++){              
            System.out.print(matriz[i][j]+"\t");
            } 
            System.out.println("");
        }
        int aux;
        for (int i =0; i < matriz.length; i++){
            for (int j=0; j < i; j++){
                aux = matriz[i][j];
                matriz[i][j]=matriz[j][i];
                matriz[j][i]=aux;
            }
        System.out.println("");
        }    
        System.out.println("Matriz transpuesta");
        for (int i =0; i < matriz.length; i++){
            for (int j=0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("");
        }
        //Generar el vector de numeros y ordenar de mayor a menor
        System.out.println("");
        
        Scanner elementos = new Scanner(System.in);
        System.out.println("Ingrese el tamanio del vector");
        int tamanio= elementos.nextInt();
        int vector[]=new int[tamanio];
        System.out.println("Ingrese los numeros deseados en el vector:");
        for (int x=0; x<vector.length; x++){
            vector[x]=elementos.nextInt();
        }
        System.out.println("Vector original: ");
        for (int x=0; x<vector.length; x++){
            System.out.print(vector[x]+"\t");
        }
        System.out.println("");
        int a;
        System.out.println("Vector ordenado de mayor a menor: ");
        for (int x =0; x < vector.length; x++){
            for (int y=x+1; y < (vector.length-1); y++){
                if (vector[x]>vector[y]);
                a = vector[x];
                vector[x]=vector[y+1];
                vector[y+1]=a;
            }
        System.out.print(vector[x]+"\t");
        }
    }
    
}
