/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edades;

/**
 *
 * @author kellypaltin
 */
public class Edades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Generar una aplicacion que permita determinar el grupo en base a la edad
        // <2 bebes
        // <12
        // <18 jovenes
        // <65 adultos
        // adultos mayores
        int a=17; 
        if (a<2){
            System.out.println("Segun su edad, pertenece al grupo de bebes");
        }else if (a<12){
            System.out.println("Segun su edad, pertenece al grupo de niños");
        }else if (a<18){
            System.out.println("Segun su edad, pertenece al grupo de jovenes");
        }else if (a<65){
            System.out.println("Segun su edad, pertenece al grupo de adultos");
        }else{
            System.out.println("Segun su edad, pertenece al grupo de adultos mayores");
        }  
    }
    
}
