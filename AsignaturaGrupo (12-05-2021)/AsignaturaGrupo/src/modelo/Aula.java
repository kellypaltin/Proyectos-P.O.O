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
public class Aula {
    private long id;
    private String descripcion;
    private List<Grupo> listaGrupo; 
    private List<Asignatura> listaAsignaturas;

    public Aula(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.listaGrupo = listaGrupo;
    }

    public Aula(long id, String descripcion, List<Grupo> listaGrupo, List<Asignatura> listaAsignaturas) {
        this.id = id;
        this.descripcion = descripcion;
        this.listaGrupo = listaGrupo;
        this.listaAsignaturas = listaAsignaturas;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListagrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", descripcion=" + descripcion + ", listaGrupo=" + listaGrupo + ", listaAsignaturas=" + listaAsignaturas + '}';
    }

    
       
}
