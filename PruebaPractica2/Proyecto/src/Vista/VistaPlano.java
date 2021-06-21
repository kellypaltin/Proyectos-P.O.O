/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPlano;
import Controlador.ControladorProyecto;
import Modelo.Plano;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaPlano {
    private Scanner teclado;
    private ControladorPlano controladorPlano;
    private ControladorProyecto controladorProyecto;
    public SimpleDateFormat formatoFecha;
    
    public VistaPlano(ControladorProyecto controladorProyecto){
        teclado = new Scanner(System.in);
        controladorPlano = new ControladorPlano();
        formatoFecha = new SimpleDateFormat("dd/mm/yyy");
        this.controladorProyecto = controladorProyecto;
        
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DE PLANOS");
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
        System.out.println("Ingrese un numero de identificacion para el plano: ");
        int numeroIdentificacion = teclado.nextInt();
        System.out.println("Ingrese la fecha de entrega del plano (dd/mm/yyyy): ");
        String fechaEntrega = teclado.next();
        System.out.println("Ingrese el numero de arquitectos que trabajaron en el plano: ");
        int arquitectos = teclado.nextInt();
        System.out.println("Ingrese si se incluye el dibujo del plano general (True or False): ");
        boolean dibujo = teclado.nextBoolean();
        System.out.println("Ingrese el numero de figuras en el plano: ");
        int numeroFiguras = teclado.nextInt();
        try {
            System.out.println("Plano Creado: " + controladorPlano.crear(numeroIdentificacion, formatoFecha.parse(fechaEntrega), arquitectos, dibujo, numeroFiguras, controladorProyecto.getSeleccionado()));
        }catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Plano buscar(){
        System.out.println("Ingrese el numero de identificacion del plano: ");
        int numeroIdentificacion = teclado.nextInt();
        Plano plano = controladorPlano.buscar(numeroIdentificacion);
        System.out.println(plano);
        return plano;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el numero de identificacion del plano que se desea actualizar: ");        
        int numeroIdentificacion = teclado.nextInt();
        System.out.println("Ingrese la nueva fecha de entrega (dd/mm/yyyy):");
        String fechaEntrega = teclado.next();   
        System.out.println("Ingrese el nuevo numero de arquitectos que trabajaron en el plano: ");
        int arquitectos = teclado.nextInt();
        System.out.println("Ingrese nuevamente si se incluye el dibujo del plano general (True or False): ");
        boolean dibujo = teclado.nextBoolean();
        System.out.println("Ingrese el nuevo numero de figuras en el plano: ");
        int numeroFiguras = teclado.nextInt();
        try {
            System.out.println("Plano Actualizado:" + controladorPlano.actualizar(numeroIdentificacion, formatoFecha.parse(fechaEntrega), arquitectos, dibujo, numeroFiguras));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listar(){
        for(Plano plano : controladorPlano.getListaPlanos()){
            System.out.println(plano);
        }
    }
    
    public void eliminar(){
        Plano plano = buscar();
        if(plano != null){
            System.out.println("Plano Eliminado: "+ controladorPlano.eliminar(plano.getNumeroIdentificacion()));
        }
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorPlano getControladorPlano() {
        return controladorPlano;
    }

    public void setControladorPlano(ControladorPlano controladorPlano) {
        this.controladorPlano = controladorPlano;
    }
    
    public void seleccionarPlano(Plano plano){
        controladorPlano.setSeleccionado(plano);
    }
}
