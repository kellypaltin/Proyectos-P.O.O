/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class Proyecto {
    private long id;
    private String codigoProyecto;
    private String nombreProyecto;
    private Jefe jefeProyecto;
    private List<Plano> listaPlanos;
    
    public Proyecto(long id, String codigoProyecto, String nombreProyecto) {
        this.id = id;
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
    }
    
    public Proyecto(long id, String codigoProyecto, String nombreProyecto, Jefe jefeProyecto) {
        this.id = id;
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
        this.jefeProyecto = jefeProyecto;
        this.listaPlanos = new ArrayList<>();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Jefe getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(Jefe jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", codigoProyecto=" + codigoProyecto + ", nombreProyecto=" + nombreProyecto + ", jefeProyecto=" + jefeProyecto + '}';
    }
    
}
