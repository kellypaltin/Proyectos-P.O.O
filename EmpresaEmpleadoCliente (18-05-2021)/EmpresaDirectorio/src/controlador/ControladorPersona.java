/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Directivo;
import modelo.Empleado;
import modelo.Persona;

/**
 *
 * @author kellypaltin
 */
public class ControladorPersona {
    private List<? super Persona> listaPersona;
    private Persona seleccionado;
    
    public ControladorPersona(){
        listaPersona = new ArrayList();
        seleccionado = null;
    }
    public long generarId(){
        if(listaPersona.size()>0)
            return ((Persona)listaPersona.get(listaPersona.size() -1)).getId() + 1;
        return 1;
    }
    public boolean crearDirectivo(String nombre, String apellido, String cedula, String direccion, double sueldoBruto, String categoria){
        Directivo directivo = new Directivo(generarId(), nombre, apellido, cedula, direccion, sueldoBruto, categoria);
        return listaPersona.add(directivo);
    }
    public boolean crearEmpleado(String nombre, String apellido, String cedula, String direccion, double sueldoBruto){
        Empleado empleado = new Empleado(generarId(), nombre, apellido, cedula, direccion, sueldoBruto);
        return listaPersona.add(empleado);
    }
    public boolean crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono){
        Cliente cliente = new Cliente(generarId(), nombre, apellido, cedula, direccion, telefono);
        return listaPersona.add(cliente);
    }
    public Persona buscar(String cedula){
        for (Object objeto : listaPersona) {
            if(((Persona)objeto).getCedula().equals(cedula))
                return (Persona)objeto;
        }
        return null;
    }
    public boolean actualizarDirectivo(String nombre, String apellido, String cedula, String direccion, double sueldoBruto, String categoria){
        Persona persona = buscar(cedula);
        if(persona !=null){
            int posicion = listaPersona.indexOf(persona);
            Directivo directivo = (Directivo) persona;
            directivo.setApellido(apellido);
            directivo.setNombre(nombre);
            directivo.setSueldoBruto(sueldoBruto);
            directivo.setCategoria(categoria);
            directivo.setDireccion(direccion);
            listaPersona.set(posicion, directivo);
            return true;
        }
        return false;
    }
    public boolean actualizarEmpleador(String nombre, String apellido, String cedula, String direccion, double sueldoBruto){
        Persona persona = buscar(cedula);
        if(persona !=null){
            int posicion = listaPersona.indexOf(persona);
            Empleado empleado = (Empleado) persona;
            empleado.setApellido(apellido);
            empleado.setNombre(nombre);
            empleado.setSueldoBruto(sueldoBruto);
            empleado.setDireccion(direccion);
            listaPersona.set(posicion, empleado);
            return true;
        }
        return false;
    }
    public boolean actualizarCliente(String nombre, String apellido, String cedula, String direccion, String telefono){
        Persona persona = buscar(cedula);
        if(persona !=null){
            int posicion = listaPersona.indexOf(persona);
            Cliente cliente = (Cliente) persona;
            cliente.setApellido(apellido);
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            listaPersona.set(posicion, cliente);
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Persona persona = this.buscar(cedula);
        return listaPersona.remove(persona);
    }
    public List<? super Persona> getListaPersona() {
        return listaPersona;
    }
    public void setListaPersona(List<? super Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    public Persona getSeleccionado() {
        return seleccionado;
    }
    public void setSeleccionado(Persona seleccionado) {
        this.seleccionado = seleccionado;
    }
}
