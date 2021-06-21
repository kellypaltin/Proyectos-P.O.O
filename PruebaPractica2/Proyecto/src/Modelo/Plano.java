/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class Plano {
    private long id;
    private int numeroIdentificacion;
    private Date fechaEntrega;
    private int arquitectos;
    private boolean dibujo;
    private int numeroFiguras;
    private List<Figura> listaFiguras;
    private Proyecto proyecto;

    public Plano(long id, int numeroIdentificacion, Date fechaEntrega, int arquitectos, boolean dibujo, int numeroFiguras) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaEntrega = fechaEntrega;
        this.arquitectos = arquitectos;
        this.dibujo = dibujo;
        this.numeroFiguras = numeroFiguras;
    }

    public Plano(long id, int numeroIdentificacion, Date fechaEntrega, int arquitectos, boolean dibujo, int numeroFiguras, Proyecto proyecto) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaEntrega = fechaEntrega;
        this.arquitectos = arquitectos;
        this.dibujo = dibujo;
        this.numeroFiguras = numeroFiguras;
        this.proyecto = proyecto;
        this.listaFiguras = new ArrayList<>();
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getArquitectos() {
        return arquitectos;
    }

    public void setArquitectos(int arquitectos) {
        this.arquitectos = arquitectos;
    }

    public boolean isDibujo() {
        return dibujo;
    }

    public void setDibujo(boolean dibujo) {
        this.dibujo = dibujo;
    }

    public int getNumeroFiguras() {
        return numeroFiguras;
    }

    public void setNumeroFiguras(int numeroFiguras) {
        this.numeroFiguras = numeroFiguras;
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Plano{" + "id=" + id + ", numeroIdentificacion=" + numeroIdentificacion + ", fechaEntrega=" + fechaEntrega + ", arquitectos=" + arquitectos + ", dibujo=" + dibujo + ", numeroFiguras=" + numeroFiguras + ", proyecto=" + proyecto + '}';
    }
    
    
}
