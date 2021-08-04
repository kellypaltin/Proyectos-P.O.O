/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Empresa;

/**
 *
 * @author kellypaltin
 */
public class ClienteControlador {
    private List<Cliente> datos;
    private Cliente seleccionado;
    
    public ClienteControlador() {
        datos = new ArrayList<Cliente>();
        seleccionado = null;
    }
    public long generarId(){
        if(datos.size() > 0)
            return datos.get(datos.size() -1).getId() + 1;
        return 1;
    }
    // CRUD -> Create, Read , Update, Delete -- Crear Leer/Buscar Actualizar Eliminar
    public boolean crear(String nombre, String apellido, String cedula) {
        Cliente cliente = new Cliente(generarId(), nombre, apellido, cedula); // Creo un nuevo cliente
        return datos.add(cliente); // Agrego a mi lista de datos
    }
    public boolean crear(String nombre, String apellido, String cedula, Empresa empresa) {
        Cliente cliente = new Cliente(generarId(), nombre, apellido, cedula, empresa); 
        empresa.getListaCliente().add(cliente); // Relación bidireccional, agregamos a la lista de cliente de la empresa 
        return datos.add(cliente); 
    }
    public Cliente buscar(String cedula){
        for (Cliente cliente : datos) { // Recorre cada uno de los clientes dentro de la lista de datos
            if(cliente.getCedula().equals(cedula) == true){ // comparo la cedula de cada cliente con la que envio por parametro de busqueda
                return cliente; // Retorno el cliente que coincide con la cedula
            }
        }
        return null;  
    }
    public Cliente buscar(Long id){
        for (Cliente cliente : datos) { // Recorre cada uno de los clientes dentro de la lista de datos
            if(cliente.getId() == id){ // comparo el id de cada cliente con la que envio por parametro de busqueda
                return cliente; 
            }
        }
        return null;
    }
    public boolean actualizar(String nombre, String apellido, String cedula) {
        Cliente cliente = this.buscar(cedula); // busco cliente con la cedula
        if(cliente != null) { // Comprobar que cliente exista
            int posicion = datos.indexOf(cliente); // obtengo la posición del cliente actual
            cliente.setNombre(nombre); // Actualizo nombre
            cliente.setApellido(apellido); // Actualizo apellido
            datos.set(posicion, cliente); // actualizo base a la posicion del cliente.
            return true;
        }
        return false;
    }
    public boolean actualizar(String nombre, String apellido, String cedula, Empresa empresa) {
        Cliente cliente = this.buscar(cedula); // busco cliente con cedula
        if(cliente != null) { // Comprobar que cliente exista
            int posicion = datos.indexOf(cliente); // obtengo posición del cliente actual
            cliente.setNombre(nombre); // Actualizo nombre
            cliente.setApellido(apellido); // Actualizo apellido
            cliente.setEmpresa(empresa);
            datos.set(posicion, cliente); // actualizo en base a posicion del cliente.
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula) {
        Cliente cliente = this.buscar(cedula);
        if(cliente != null){
            cliente.getEmpresa().getListaCliente().remove(cliente);
            return datos.remove(cliente);
        }
        return false;
    }
    
    public List<Cliente> getDatos() {
        return datos;
    }

    public void setDatos(List<Cliente> datos) {
        this.datos = datos;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
    
}
