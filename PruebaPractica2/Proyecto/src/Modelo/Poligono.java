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
public class Poligono {
    private long id;
    private int numeroLineas;
    private double perimetro;
    private double area;
    private List<Linea> listaLineas;
    private Figura figura;

    public Poligono(long id, int numeroLineas, double perimetro, double area) {
        this.id = id;
        this.numeroLineas = numeroLineas;
        this.perimetro = perimetro;
        this.area = area;
    }

    public Poligono(long id, int numeroLineas, double perimetro, double area, Figura figura) {
        this.id = id;
        this.numeroLineas = numeroLineas;
        this.perimetro = perimetro;
        this.area = area;
        this.listaLineas = new ArrayList<>();
        this.figura = figura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "Poligono{" + "id=" + id + ", numeroLineas=" + numeroLineas + ", perimetro=" + perimetro + ", area=" + area + ", figura=" + figura + '}';
    }
    
}
