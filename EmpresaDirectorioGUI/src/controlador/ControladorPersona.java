/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepciones.ValidadorCedula;
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
    public boolean crearDirectivo(String nombre, String apellido, String cedula, String direccion, double sueldoBruto, String categoria) throws ValidadorCedula{
        this.validarCedula(cedula);
        Directivo directivo = new Directivo(generarId(), nombre, apellido, cedula, direccion, sueldoBruto, categoria);
        return listaPersona.add(directivo);
    }
    public boolean crearEmpleado(String nombre, String apellido, String cedula, String direccion, double sueldoBruto){
        Empleado empleado = new Empleado(generarId(), nombre, apellido, cedula, direccion, sueldoBruto);
        return listaPersona.add(empleado);
    }
    public boolean crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono) throws ValidadorCedula{
        this.validarCedula(cedula);
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
    
    public boolean validarCedula(String cedula) throws ValidadorCedula{
        int suma=0;
        if(cedula.length()==10){
            for(int i=0; i< cedula.length()-1; i++){
                int valor = Integer.parseInt(String.valueOf(cedula.charAt(i)));
                if(i== cedula.length()-1){
                    System.out.println(suma+" - "+valor);
                    if(((10-suma%10)== valor)|| (suma%10 == valor && valor ==0)){
                        return true;
                    }   
                }
                if(i%2 == 0){
                    int sum = valor * 2;
                    suma += (sum>9)? sum-9:sum;
                }else{
                    suma += valor;
                }
            }
        }
        throw new ValidadorCedula();
    }
}
