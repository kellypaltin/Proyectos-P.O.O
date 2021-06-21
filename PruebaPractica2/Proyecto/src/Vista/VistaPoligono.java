/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFigura;
import Controlador.ControladorPoligono;
import Modelo.Poligono;
import java.util.Scanner;

/**
 *
 * @author kellypaltin
 */
public class VistaPoligono {
    private Scanner teclado;
    private ControladorPoligono controladorPoligono;
    private ControladorFigura controladorFigura;
    
    public VistaPoligono(ControladorFigura controladorFigura){
        controladorPoligono = new ControladorPoligono();
        this.controladorFigura = controladorFigura;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("GESTION DE POLIGONOS");
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
        System.out.println("Ingrese el numero de lineas del poligono: ");
        int numeroLineas = teclado.nextInt();
        System.out.println("Ingrese el perimetro de metodo diferido: ");
        double perimetro = teclado.nextDouble();
        System.out.println("Ingrese un area generico: ");
        double area = teclado.nextDouble();
        System.out.println("Poligono Creada: " + controladorPoligono.crear(numeroLineas, perimetro, area, controladorFigura.getSeleccionado()));
    }
    
    public Poligono buscar(){
        System.out.println("Ingrese el numero de lineas: ");
        int numeroLineas = teclado.nextInt();
        Poligono poligono = controladorPoligono.buscar(numeroLineas);
        System.out.println(poligono);
        return poligono;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el numero de lineas del poligono que se desea actualizar: ");
        int numeroLineas = teclado.nextInt();
        System.out.println("Ingrese un nuevo perimetro: ");
        double perimetro = teclado.nextInt();
        System.out.println("Ingrese un nuevo area: ");
        double area = teclado.nextInt();
        boolean resultado = controladorPoligono.actualizar(numeroLineas, perimetro, area);
        System.out.println("Poligono Actualizada: " + resultado);
    }
        
    public void listar(){
        for(Poligono poligono : controladorPoligono.getListaPoligonos()){
            System.out.println(poligono);
        }
    }
    
    public void eliminar(){
        Poligono poligono = buscar();
        if(poligono != null){
            System.out.println("Poligono Eliminado: "+ controladorPoligono.eliminar(poligono.getNumeroLineas()));
        }
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public ControladorPoligono getControladorPoligono() {
        return controladorPoligono;
    }

    public void setControladorPoligono(ControladorPoligono controladorPoligono) {
        this.controladorPoligono = controladorPoligono;
    }

    public ControladorFigura getControladorFigura() {
        return controladorFigura;
    }

    public void setControladorFigura(ControladorFigura controladorFigura) {
        this.controladorFigura = controladorFigura;
    }
    
    public void seleccionarPoligono(Poligono poligono){
        controladorPoligono.setSeleccionado(poligono);
    }
  
}
