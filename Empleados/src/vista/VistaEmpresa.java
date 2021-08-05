/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpresa;
import java.util.Scanner;
import modelo.Empresa;

/**
 *
 * @author kellypaltin
 */
public class VistaEmpresa {
    private ControladorEmpresa controladorEmpresa;
    private VistaCliente vistaCliente;
    private VistaEmpleado vistaEmpleado;
    private VistaDirectivo vistaDirectivo;
    private Scanner teclado;
    
    public VistaEmpresa(VistaCliente vistaCliente, VistaEmpleado vistaEmpleado, VistaDirectivo vistaDirectivo ){
        controladorEmpresa = new ControladorEmpresa();
        this.vistaCliente = vistaCliente;
        this.vistaEmpleado = vistaEmpleado;
        this.vistaDirectivo = vistaDirectivo;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do{
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: crear(); break;
                case 2: actualizar(); break;
                case 3: buscar(); break;
                case 4: eliminar(); break;
                case 5: listar(); break;
            }        
            
        }while(opcion<6);
    }
    
    public void crear(){
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        System.out.println("Resultado: "+ controladorEmpresa.crear(nombre));
    }
    
    public Empresa buscar(){
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Empresa empresa = controladorEmpresa.buscar(nombre);
        controladorEmpresa.setSeleccionado(empresa);
        System.out.println(empresa);
        return empresa;
    }
    
    public void actualizar(){
        System.out.println("Ingrese el nombre");
        Empresa empresa = buscar();
        System.out.println("Ingrese nombre nuevo");
        String nombreNuevo = teclado.next();
        System.out.println("Resultado: "+ controladorEmpresa.actualizar(empresa.getNombre(), nombreNuevo));
    }
    
    public void eliminar(){
        Empresa empresa = buscar();
        System.out.println("Resultado: "+ controladorEmpresa.eliminar(empresa.getNombre()));
    }
    
    public void listar(){
        for(Empresa empresa : controladorEmpresa.getListaEmpresa()){
            System.out.println(empresa);
        }
    }
    public void cliente() {
        Empresa empresa = buscar();
        if (empresa != null) {
            vistaCliente.getControladorCliente().setListaCliente(empresa.getListadoClientes());
            vistaCliente.menu();
        }
    }

    public void empleado() {
        Empresa empresa = buscar();
        if (empresa != null) {
            vistaEmpleado.getControladorEmpleado().setListaEmpleado(empresa.getListadoEmpleados());
            vistaEmpleado.menu();
        }
    }

    public void directivo() {
        Empresa empresa = buscar();
        if (empresa != null) {
            vistaDirectivo.getControladorDirectivo().setListaDirectivo(empresa.getListadoDirectivo());
            vistaDirectivo.menu();
        }
    }
}
