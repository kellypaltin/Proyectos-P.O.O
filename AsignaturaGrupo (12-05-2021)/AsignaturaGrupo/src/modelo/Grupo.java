/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kellypaltin
 */
public class Grupo {
    private long id;
    private String nombre;
    private List<Asignatura> listaAsignaturas;

    public Grupo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Grupo(long id, String nombre, List<Asignatura> listaAsignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.listaAsignaturas = new ArrayList();
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

    public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nombre=" + nombre + ", lista asignatura=" + listaAsignaturas + '}';
    }

}
