/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import modelo.Asignatura;
import modelo.Aula;
import modelo.Grupo;

/**
 *
 * @author kellypaltin
 */
public class VistaGeneral {
    private AulaVista aulaVista;
    private GrupoVista grupoVista;
    private AsignaturaVista asignaturaVista;
    private Scanner teclado;
    
    public VistaGeneral(){
        aulaVista = new AulaVista();
        grupoVista = new GrupoVista(aulaVista.getAulaControlador());
        asignaturaVista = new AsignaturaVista(grupoVista.getGrupoControlador());
        teclado = new Scanner(System.in);
    }
    
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Seleccione una opción");
            System.out.println("1. Aula");
            System.out.println("2. Grupo");
            System.out.println("3. Asignatura");
            System.out.println("4. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: aulaVista.menu(); break;
                case 2: this.grupo(); break;
                case 3: this.asignatura(); break;
            }
        } while (opcion < 4);
    }
    public void grupo() {
        System.out.println("Seleccione un aula para gestionar los grupos");
        Aula aula = aulaVista.buscar();
        if(aula != null){ 
           aulaVista.asignarSelecionado(aula);
            grupoVista.menu();
        }else {
            System.out.println("No existe la aula");
            this.grupo();
        }
    }
    public void asignatura(){
        System.out.println("Seleccione un grupo para gestionar las asignaturas");
        Grupo grupo = grupoVista.buscar();
        if(grupo != null){ 
            grupoVista.asignarSeleccionado(grupo);
            grupoVista.menu();
        }else {
            System.out.println("No existe el grupo");
            this.grupo();
        }
    }

}
