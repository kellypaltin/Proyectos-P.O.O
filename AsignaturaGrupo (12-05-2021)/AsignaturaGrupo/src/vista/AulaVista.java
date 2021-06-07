/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.AulaControlador;
import java.util.Scanner;
import modelo.Aula;
import modelo.Grupo;

/**
 *
 * @author kellypaltin
 */
public class AulaVista {
    private AulaControlador aulaControlador;
    private Scanner teclado;
    
    public AulaVista(){
        aulaControlador = new AulaControlador();
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
           System.out.println("\n Gestion Aula");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.crear(); break;
                case 2: this.actualizar();break;
                case 3: this.buscar();break;
                case 4: this.eliminar();break;
                case 5: this.imprimir(); break;  
            }
        } while(opcion < 6);
    }
    
    public void crear(){
        System.out.println("Ingresar los siguientes datos:");
        System.out.println("Id");
        long id = teclado.nextLong();
        System.out.println("Descripcion");
        String descripcion = teclado.next();
        boolean resultado = aulaControlador.crear(id, descripcion);
        System.out.println("Creado = " + resultado);
    }
    
    public void actualizar(){
        System.out.println("Descripcion");
        String descripcionAnterior = teclado.next();
        System.out.println("Nueva descripcion");
        String descripcionNuevo = teclado.next();
        boolean resultado = aulaControlador.actualizar(descripcionAnterior, descripcionNuevo);
        System.out.println("Actualizado = " + resultado);
    }
    
    public Aula buscar(){
        System.out.println("Descripcion");
        String descripcion = teclado.next();
        Aula aula = aulaControlador.buscar(descripcion);
        return aula;
    }
    
    public void eliminar(){
        System.out.println("Descripcion");
        String descripcion = teclado.next();
        boolean resultado = aulaControlador.eliminar(descripcion);
        System.out.println("Eliminado = " + resultado);
    }
    
    public void imprimir(){ 
        for (Aula aula : aulaControlador.getListaAula()) {
            System.out.println(aula);
            this.imprimirGrupos(aula);
        }
    }
    
    public void imprimirGrupos(Aula aula){
        for (Grupo grupo : aula.getListaGrupo()) {
            System.out.println(grupo);
        }
    }
    
    public void asignarSelecionado(Aula aula){
        aulaControlador.setSeleccionado(aula);
    }
     
    public AulaControlador getAulaControlador() {
        return aulaControlador;
    }

    public void setEmpresaControlador(AulaControlador aulaControlador) {
        this.aulaControlador = aulaControlador;
    }
}
