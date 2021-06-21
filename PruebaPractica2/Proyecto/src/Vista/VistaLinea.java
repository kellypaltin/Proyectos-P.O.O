/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorLinea;
import Controlador.ControladorPoligono;
import Modelo.Linea;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaLinea {
    private Scanner teclado;
    private ControladorLinea controladorLinea;
    private ControladorPoligono controladorPoligono;
    
    public VistaLinea(ControladorPoligono controladorPoligono){
        controladorLinea = new ControladorLinea();
        this.controladorPoligono = controladorPoligono;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DE LINEAS");
            System.out.println("1. Crear");
            System.out.println("2. Buscar");
            System.out.println("3. Actualizar");
            System.out.println("4. Listar");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: crear(); break;
                case 2: buscar(); break;
                case 3: actualizar(); break;
                case 4: listar(); break;
                case 5: eliminar(); break;
            }
        }while(opcion<6);
    }
    
    public void crear(){
        System.out.println("Ingrese el identificador de la linea: ");
        String identificadorLinea = teclado.next();
        System.out.println("Ingrese el punto de origen en X: ");
        double puntoOrigenX = teclado.nextDouble();
        System.out.println("Ingrese el punto de origen en Y: ");
        double puntoOrigenY = teclado.nextDouble();
        System.out.println("Ingrese el punto final en X: ");
        double puntoFinalX = teclado.nextDouble();
        System.out.println("Ingrese el punto final en Y: ");
        double puntoFinalY = teclado.nextDouble();
        double longitud = this.longitud(puntoOrigenX, puntoFinalX, puntoOrigenY, puntoFinalY);
        System.out.println("Linea Creada: " + controladorLinea.crear(identificadorLinea, puntoOrigenX, puntoOrigenY, puntoFinalX, puntoFinalY, longitud, controladorPoligono.getSeleccionado()));
    }
    
    public Linea buscar(){
        System.out.println("Ingrese el identificador de la linea: ");
        String identificadorLinea = teclado.next();
        Linea linea = controladorLinea.buscar(identificadorLinea);
        controladorLinea.setSeleccionado(linea);
        System.out.println(linea);
        return linea;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el identificador de la linea que se desea actualizar:");
        String identificadorLinea = teclado.next();
        System.out.println("Ingrese el nuevo punto de origen X: ");
        double puntoOrigenX = teclado.nextDouble();
        System.out.println("Ingrese el nuevo  punto de origen Y: ");
        double puntoOrigenY = teclado.nextDouble();
        System.out.println("Ingrese el nuevo punto final X: ");
        double puntoFinalX = teclado.nextDouble();
        System.out.println("Ingrese el nuevo punto final Y: ");
        double puntoFinalY = teclado.nextDouble();
        double longitud = this.longitud(puntoOrigenX, puntoFinalX, puntoOrigenY, puntoFinalY);
        boolean resultado = controladorLinea.actualizar(identificadorLinea, puntoOrigenX, puntoOrigenY, puntoFinalX, puntoFinalY, longitud);
        System.out.println("Linea Actualizada: "+ resultado);
    }
    
    public void listar(){
        for(Linea linea : controladorLinea.getListaLineas()){
            System.out.println(linea);
        }
    }
    
    public void eliminar(){
        Linea linea = buscar();
        if(linea != null){
            System.out.println("Linea Eliminada: "+ controladorLinea.eliminar(linea.getIdentificadorLinea()));
        }
    }
    public double longitud(double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY){
        double valor = Math.pow((puntoFinalX - puntoOrigenX), 2) + Math.pow((puntoFinalY - puntoOrigenY),2);//
        double respuesta = Math.sqrt(valor);
        return respuesta;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorLinea getControladorLinea() {
        return controladorLinea;
    }

    public void setControladorLinea(ControladorLinea controladorLinea) {
        this.controladorLinea = controladorLinea;
    }
    
    public void seleccionarLinea(Linea linea){
        controladorLinea.setSeleccionado(linea);
    }
}
