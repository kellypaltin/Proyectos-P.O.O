/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.AsignaturaControlador;
import controlador.AulaControlador;
import controlador.GrupoControlador;
import java.util.Scanner;
import modelo.Grupo;
import modelo.Aula;

/**
 *
 * @author kellypaltin
 */
public class GrupoVista {
    private GrupoControlador grupoControlador;
    private AulaControlador aulaControlador;
    private AsignaturaControlador asignaturaControlador;
    private Scanner teclado;
    
    public GrupoVista(AulaControlador aulaControlador){
        this.teclado = new Scanner(System.in);
        this.grupoControlador = new GrupoControlador();
        this.aulaControlador = aulaControlador;
        this.asignaturaControlador = asignaturaControlador;
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("Gestión de Grupos");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
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
                    System.out.println("Listado de grupos: ");
                    grupoControlador.imprimir(); 
                break;
            }
        }while(opcion<6);
    }
    
     public void crear() {
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Id: ");
        long id = teclado.nextLong();
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Grupo creado: " + grupoControlador.crear(nombre));
    }
    public void actualizar(){
        System.out.println("Actualizar");
        System.out.println("Nombre: ");
        String nombreAnterior = teclado.next();
        System.out.println("Nuevo nombre: ");
        String nombreNuevo = teclado.next();
        boolean resultado = grupoControlador.actualizar(nombreAnterior, nombreNuevo);
        System.out.println("Grupo actualizado: " + resultado);
    }
    public void eliminar(){
        System.out.println("Eliminar grupo");
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        boolean resultado = grupoControlador.eliminar(nombre);
        System.out.println("Grupo eliminado: " + resultado);
    }
    public Grupo buscar(){
        System.out.println("Buscar grupo");
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        Grupo grupo = grupoControlador.buscar(nombre);
        System.out.println(grupo);
        return grupo;
    }
    public void asignarSeleccionado(Grupo grupo) {
        grupoControlador.setSeleccionado(grupo);
    }


    public GrupoControlador getGrupoControlador() {
        return grupoControlador;
    }

    public void setGrupoControlador(GrupoControlador grupoControlador) {
        this.grupoControlador = grupoControlador;
    }

    public AulaControlador getAulaControlador() {
        return aulaControlador;
    }

    public void setAulaControlador(AulaControlador aulaControlador) {
        this.aulaControlador = aulaControlador;
    }
}
