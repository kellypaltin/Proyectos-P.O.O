/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import controlador.AsignaturaControlador;
import controlador.GrupoControlador;
import modelo.Asignatura;
import modelo.Grupo;

/**
 *
 * @author kellypaltin
 */
public class AsignaturaVista {
    private Scanner teclado;
    private AsignaturaControlador asignaturaControlador;
    private GrupoControlador grupoControlador;
    
    public AsignaturaVista(GrupoControlador grupoControlador){
        teclado = new Scanner(System.in);
        asignaturaControlador = new AsignaturaControlador();
        this.grupoControlador = grupoControlador;
    }

    
    public void menu(){
        int opcion=0;
        
        do{
            System.out.println("\nGestion de asignaturas: ");
            System.out.println("1. Crear ");
            System.out.println("2. Actualizar ");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar ");
            System.out.println("5. Listar");
            System.out.println("6. Salir ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    this.crear();
                break;
                case 2:
                    this.actualizar();
                break;
                case 3:
                    this.buscar();
                break;
                case 4:
                    this.eliminar();
                break;
                case 5: 
                    this.listar();
                break;
            }
        }while(opcion<6);
    }
    
    public void crear(){
        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("Id: ");
        long id = teclado.nextLong();
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Asignatura creado: " + asignaturaControlador.crear(id, nombre));        
    }
    
    public void actualizar(){
        System.out.println("Actualizar: ");
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Nuevo nombre: ");
        String nuevoNombre = teclado.next();
        boolean resultado = asignaturaControlador.actualizar(nombre, nuevoNombre);
        System.out.println("Asignatura actualizado: "+resultado);
    }
    
     public Asignatura buscar(){
        System.out.println("Buscar Asignatura");
        System.out.println("Nombre: ");
        String nombre= teclado.next();
        Asignatura asignatura = asignaturaControlador.buscar(nombre);
        System.out.println(asignatura);
        return asignatura;
    }
     
    public void eliminar(){
        System.out.println("Eliminar Asignatura");
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        boolean resultado = asignaturaControlador.eliminar(nombre);
        System.out.println("Asignatura eliminado: "+resultado);
    }
    
    public void listar(){
        for (Asignatura asignatura : asignaturaControlador.getListaAsignatura()) {
            System.out.println(asignatura);
        }
    }
    
    public void asignarSeleccionado(Asignatura asignatura){
        asignaturaControlador.setSeleccionado(asignatura);
    }

    public AsignaturaControlador getAsignaturaControlador() {
        return asignaturaControlador;
    }

    public void setAsignaturaControlador(AsignaturaControlador asignaturaControlador) {
        this.asignaturaControlador = asignaturaControlador;
    }

    public GrupoControlador getGrupoControlador() {
        return grupoControlador;
    }

    public void setGrupoControlador(GrupoControlador grupoControlador) {
        this.grupoControlador = grupoControlador;
    }
}
