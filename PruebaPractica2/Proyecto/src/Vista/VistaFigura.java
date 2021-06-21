/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFigura;
import Controlador.ControladorPlano;
import Modelo.Figura;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaFigura {
    private Scanner teclado;
    private ControladorFigura controladorFigura;
    private ControladorPlano controladorPlano;
    
    public VistaFigura(ControladorPlano controladorPlano){
        controladorFigura = new ControladorFigura();
        this.controladorPlano = controladorPlano;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DE FIGURAS: ");
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
        System.out.println("Ingrese el identificador de la figura: ");
        String identificadorFigura = teclado.next();
        System.out.println("Ingrese el nombre de la figura: ");
        String nombreFigura = teclado.next();
        System.out.println("Ingrese el color de la figura: ");
        String color = teclado.next();
        System.out.println("Figura Creada: " + controladorFigura.crear(identificadorFigura, nombreFigura, color, controladorPlano.getSeleccionado()));
    }
    
    public Figura buscar(){
        System.out.println("Ingrese el identificador de la figura: ");
        String identificadorFigura = teclado.next();
        Figura figura = controladorFigura.buscar(identificadorFigura);
        System.out.println(figura);
        return figura;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el identificador de la figura que se desea actualizar: ");
        String identificadorFigura = teclado.next();
        System.out.println("Ingrese el nuevo nombre de la figura");
        String nombreFigura = teclado.next();
        System.out.println("Ingrese el nuevo color de la figura: ");
        String color = teclado.next();
        boolean resultado = controladorFigura.actualizar(identificadorFigura, nombreFigura, color);
        System.out.println("Figura Actualizado: "+ resultado);
    }
    
    public void listar(){
        for(Figura figura : controladorFigura.getListaFiguras()){
            System.out.println(figura);
        }
    }
    
    public void eliminar(){
        Figura figura = buscar();
        if(figura != null){
            System.out.println("Figura Eliminado: "+ controladorFigura.eliminar(figura.getIdentificadorFigura()));
        }
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorFigura getControladorFigura() {
        return controladorFigura;
    }

    public void setControladorFigura(ControladorFigura controladorFigura) {
        this.controladorFigura = controladorFigura;
    }
    
    public void seleccionarFigura(Figura figura){
        controladorFigura.setSeleccionado(figura);
    }
}
