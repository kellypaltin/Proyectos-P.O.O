/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class Empresa {
    private long id;
    private String nombre;
    private List<? extends Persona> listadoPersonas; // Permite almacenar cualquier objeto que extienda de persona
    
    public Empresa(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listadoPersonas = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<? extends Persona> getListadoPersonas() {
        return listadoPersonas;
    }

    public void setListadoPersonas(List<? extends Persona> listadoPersonas) {
        this.listadoPersonas = listadoPersonas;
    }
 
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
