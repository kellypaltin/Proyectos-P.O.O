/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorJefe;
import Controlador.ControladorProyecto;
import Modelo.Proyecto;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaProyecto {
    private Scanner teclado;
    private ControladorProyecto controladorProyecto;
    private ControladorJefe controladorJefe;
    
    public VistaProyecto(ControladorJefe controladorJefe){
        controladorProyecto = new ControladorProyecto();
        this.controladorJefe = controladorJefe;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DEL PROYECTO");
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
        System.out.println("Ingrese el codigo del proyecto: ");
        String codigoProyecto = teclado.next();
        System.out.println("Ingrese el nombre del proyecto: ");
        String nombreProyecto = teclado.next();
        System.out.println("Proyecto Creado: " + controladorProyecto.crear(codigoProyecto, nombreProyecto, controladorJefe.getSeleccionado()));
    }
    
    public Proyecto buscar(){
        System.out.println("Ingrese el codigo del proyecto: ");
        String codigoProyecto = teclado.next();
        Proyecto proyecto = controladorProyecto.buscar(codigoProyecto);
        System.out.println(proyecto);
        return proyecto;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el codigo del proyecto que se desea actualizar: ");
        String codigoProyecto = teclado.next();
        System.out.println("Ingrese el nuevo nombre del proyecto: ");
        String nombreProyecto = teclado.next();
        boolean resultado = controladorProyecto.actualizar(codigoProyecto, nombreProyecto);
        System.out.println("Proyecto Actualizado: "+ resultado);
        
    }
    
    public void listar(){
        for(Proyecto proyecto : controladorProyecto.getListaProyecto()){
            System.out.println(proyecto);
        }
    }
    
    public void eliminar(){
        Proyecto proyecto = buscar();
        if(proyecto != null){
            System.out.println("Proyecto Eliminado: "+ controladorProyecto.eliminar(proyecto.getCodigoProyecto()));
        }
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorProyecto getControladorProyecto() {
        return controladorProyecto;
    }

    public void setControladorProyecto(ControladorProyecto controladorProyecto) {
        this.controladorProyecto = controladorProyecto;
    }
    
    public void seleccionarProyecto(Proyecto proyecto){
        controladorProyecto.setSeleccionado(proyecto);
    }
}
