/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPersona;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Directivo;
import modelo.Empleado;
import modelo.Persona;

/**
 *
 * @author kellypaltin
 */
public class VistaPersona {

    public ControladorPersona controladorPersona;
    public Scanner teclado;
    public Class tipo; 
    public VistaPersona(Class tipo) {
        controladorPersona = new ControladorPersona();
        teclado = new Scanner(System.in);
        this.tipo = tipo;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    listar();
                    break;
            }
        } while (opcion < 6);
    }
    public void crear() {
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido");
        String apellido = teclado.next();
        System.out.println("Ingrese el cedula");
        String cedula = teclado.next();
        System.out.println("Ingrese el direccion");
        String direccion = teclado.next();
        if (tipo == Cliente.class) {
            System.out.println("Ingrese el telefono");
            String telefono = teclado.next();
            System.out.println("Resultado: " + controladorPersona.crearCliente(nombre, apellido, cedula, direccion, telefono));
        } else if (tipo == Empleado.class) {
            System.out.println("Ingrese el sueldo");
            double sueldo = teclado.nextDouble();
            System.out.println("Resultado: " + controladorPersona.crearEmpleado(nombre, apellido, cedula, direccion, sueldo));
        } else {
            System.out.println("Ingrese el sueldo");
            double sueldo = teclado.nextDouble();
            System.out.println("Ingrese el categoria");
            String categoria = teclado.next();
            System.out.println("Resultado: " + controladorPersona.crearDirectivo(nombre, apellido, cedula, direccion, sueldo, categoria));
        }
    }

    public Persona buscar() {
        System.out.println("Ingrese el cedula");
        String cedula = teclado.next();
        Persona persona = controladorPersona.buscar(cedula);
        System.out.println(persona);
        return persona;
    }

    public void actualizar() {
        Persona persona = buscar();
        if (persona != null) {
            System.out.println("Ingrese el nombre");
            String nombre = teclado.next();
            System.out.println("Ingrese el apellido");
            String apellido = teclado.next();
            System.out.println("Ingrese el direccion");
            String direccion = teclado.next();
            if (tipo == Cliente.class) {
                System.out.println("Ingrese el telefono");
                String telefono = teclado.next();
                System.out.println("Resultado: " + controladorPersona.actualizarCliente(nombre, apellido, persona.getCedula(), direccion, telefono));
            } else if (tipo == Empleado.class) {
                System.out.println("Ingrese el sueldo");
                double sueldo = teclado.nextDouble();
                System.out.println("Resultado: " + controladorPersona.actualizarEmpleador(nombre, apellido, persona.getCedula(), direccion, sueldo));
            } else {
                System.out.println("Ingrese el sueldo");
                double sueldo = teclado.nextDouble();
                System.out.println("Ingrese el categoria");
                String categoria = teclado.next();
                System.out.println("Resultado: " + controladorPersona.actualizarDirectivo(nombre, apellido, persona.getCedula(), direccion, sueldo, categoria));
            }
        }
    }

    public void eliminar() {
       Persona persona = buscar();
        if (persona != null) {
            System.out.println("Resultado: " + controladorPersona.eliminar(persona.getCedula()));
        }
    }
    public void listar() {
        for (Object objeto : controladorPersona.getListaPersona()) {
            if(objeto.getClass() == Empleado.class){
                Empleado empleado = (Empleado) objeto;
                System.out.println(empleado);
            }else if(objeto.getClass() == Cliente.class){
                Cliente cliente = (Cliente) objeto;
                System.out.println(cliente);
            }else {
                Directivo directivo = (Directivo) objeto;
                System.out.println(directivo);
            }
        }
    }

    public ControladorPersona getControladorPersona() {
        return controladorPersona;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public Class getTipo() {
        return tipo;
    }

    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }

}
