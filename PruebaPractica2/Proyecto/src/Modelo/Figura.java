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
public class Figura {
    private long id;
    private String identificadorFigura;
    private String nombreFigura;
    private String color;
    private List<Poligono> listaPoligonos;
    private Plano plano;
    
    public Figura(long id, String identificadorFigura, String nombreFigura, String color) {
        this.id = id;
        this.identificadorFigura = identificadorFigura;
        this.nombreFigura = nombreFigura;
        this.color = color;
    }
    
    public Figura(long id, String identificadorFigura, String nombreFigura, String color, Plano plano) {
        this.id = id;
        this.identificadorFigura = identificadorFigura;
        this.nombreFigura = nombreFigura;
        this.color = color;
        this.listaPoligonos = new ArrayList<>();
        this.plano = plano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificadorFigura() {
        return identificadorFigura;
    }

    public void setIdentificadorFigura(String identificadorFigura) {
        this.identificadorFigura = identificadorFigura;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Poligono> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligono> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Figura{" + "id=" + id + ", identificadorFigura=" + identificadorFigura + ", nombreFigura=" + nombreFigura + ", color=" + color +  ", plano=" + plano + '}';
    }
    
}