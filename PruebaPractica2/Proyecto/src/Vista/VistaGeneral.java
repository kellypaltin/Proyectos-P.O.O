/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.util.Scanner;
import Modelo.Figura;
import Modelo.Jefe;
import Modelo.Linea;
import Modelo.Plano;
import Modelo.Poligono;
import Modelo.Proyecto;        

/**
 *
 * @author kellypaltin
 */
public class VistaGeneral {
    public Scanner teclado;
    public VistaFigura vistaFigura;
    public VistaJefe vistaJefe;
    public VistaLinea vistaLinea;
    public VistaPlano vistaPlano;
    public VistaPoligono vistaPoligono;
    public VistaProyecto vistaProyecto;

    public VistaGeneral() {
        vistaJefe = new VistaJefe();
        vistaProyecto = new VistaProyecto(vistaJefe.getControladorJefe());
        vistaPlano = new VistaPlano(vistaProyecto.getControladorProyecto());
        vistaFigura = new VistaFigura(vistaPlano.getControladorPlano());
        vistaPoligono = new VistaPoligono(vistaFigura.getControladorFigura());
        vistaLinea = new VistaLinea(vistaPoligono.getControladorPoligono());
        teclado = new Scanner(System.in);
    }
    
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("GESTIONAR");
            System.out.println("1. Jefe del Proyecto");
            System.out.println("2. Proyecto");
            System.out.println("3. Planos");
            System.out.println("4. Figuras");
            System.out.println("5. Poligonos");
            System.out.println("6. Lineas"); 
            System.out.println("7. Salir"); 
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: vistaJefe.menu(); break;
                case 2: proyecto(); break;
                case 3: planos(); break;
                case 4: figuras(); break;
                case 5: poligonos(); break;
                case 6: lineas();break;                
            }
        } while (opcion < 7);
    }
    
    public void proyecto(){
        System.out.println("Ingrese el codigo del jefe del proyecto que desea gestionar: ");
        Jefe jefe = vistaJefe.buscar();
        if(jefe != null){
            vistaProyecto.menu();
        }else{
            System.out.println("No existe el jefe ingresado");
            this.proyecto();
        }
    }
    
    public void planos(){
        System.out.println("Ingrese el codigo del proyecto que desea gestionar los planos: ");
        Proyecto proyecto = vistaProyecto.buscar();
        if(proyecto != null){
            vistaProyecto.seleccionarProyecto(proyecto);
            vistaPlano.menu();
        }else{
            System.out.println("No existe el proyecto ingresado");
            this.planos();
        }
    }
    
    public void figuras(){
        System.out.println("Ingrese el numero de identificacion del plano que desea gestionar las figuras: ");
        Plano plano = vistaPlano.buscar();
        if(plano != null){
            vistaPlano.seleccionarPlano(plano);
            vistaFigura.menu();
        }else{
            System.out.println("No existe el plano ingresado");
            this.figuras();
        }
    }
    
    public void poligonos(){
        System.out.println("Ingrese el identificador de la figura que desea gestionar los poligonos: ");
        Figura figura = vistaFigura.buscar();
        if(figura != null){
            vistaFigura.seleccionarFigura(figura);
            vistaPoligono.menu();
        }else{
            System.out.println("No existe la figura ingresado");
            this.poligonos();
        }
    }
    
    public void lineas(){
        System.out.println("Ingrese el numero de lineas del poligono que se desea gestionar: ");
        Poligono poligono = vistaPoligono.buscar();
        if(poligono != null){
            vistaPoligono.seleccionarPoligono(poligono);
            vistaLinea.menu();
        }else{
            System.out.println("No existe el poligono ingresado");
            this.lineas();
        }
    }
}
