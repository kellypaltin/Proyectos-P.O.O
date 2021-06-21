/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorJefe;
import Modelo.Jefe;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaJefe {
    private Scanner teclado;
    private ControladorJefe controladorJefe;
    
    public VistaJefe(){
        controladorJefe = new ControladorJefe();
        teclado = new Scanner(System.in);
    }
    
     public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DEL JEFE");
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
        System.out.println("Ingrese el codigo del jefe: ");
        String codigoJefe = teclado.next();
        System.out.println("Ingrese el nombre del jefe: ");
        String nombreJefe = teclado.next();
        System.out.println("Ingrese la direccion: ");
        String direccion = teclado.next();
        System.out.println("Ingrese el numero de telefono: ");
        int telefono = teclado.nextInt();
        System.out.println("Jefe Creado: " + controladorJefe.crear(codigoJefe, nombreJefe, direccion, telefono));
    }
    
    public Jefe buscar(){
        System.out.println("Ingrese el codigo del jefe: ");
        String codigoJefe = teclado.next();
        Jefe jefe = controladorJefe.buscar(codigoJefe);
        System.out.println(jefe);
        controladorJefe.setSeleccionado(jefe);
        return jefe;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el codigo del jefe que se desea actualizar: ");
        String codigoJefe = teclado.next();
        System.out.println("Ingrese el nuevo nombre del jefe: ");
        String nombreJefe = teclado.next();
        System.out.println("Ingrese la nueva direccion: ");
        String direccion = teclado.next();
        System.out.println("Ingrese el nuevo numero de telefono");
        int telefono = teclado.nextInt();
        boolean resultado = controladorJefe.actualizar(codigoJefe, nombreJefe, direccion, telefono);
        System.out.println("Jefe Actualizado: "+ resultado);
    }
    
    public void listar(){
        for(Jefe jefe : controladorJefe.getListaJefe()){
            System.out.println(jefe);
        }
    }
    
    public void eliminar(){
        Jefe jefe = buscar();
        if(jefe != null){
            System.out.println("Jefe Eliminado: "+ controladorJefe.eliminar(jefe.getCodigoJefe()));
        }
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorJefe getControladorJefe() {
        return controladorJefe;
    }

    public void setControladorJefe(ControladorJefe controladorJefe) {
        this.controladorJefe = controladorJefe;
    }
    
    public void seleccionarJefe(Jefe jefe){
        controladorJefe.setSeleccionado(jefe);
    }
}
