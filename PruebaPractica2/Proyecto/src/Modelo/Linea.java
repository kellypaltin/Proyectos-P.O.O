/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kellypaltin
 */
public class Linea {
    private long id;
    private String identificadorLinea;
    private double puntoOrigenX;
    private double puntoOrigenY;
    private double puntoFinalX;
    private double puntoFinalY;
    private double longitud;
    private Poligono poligono;

    public Linea(long id, String identificadorLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud) {
        this.id = id;
        this.identificadorLinea = identificadorLinea;
        this.puntoOrigenX = puntoOrigenX;
        this.puntoOrigenY = puntoOrigenY;
        this.puntoFinalX = puntoFinalX;
        this.puntoFinalY = puntoFinalY;
        this.longitud = longitud;
    }
    
    public Linea(long id, String identificadorLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud, Poligono poligono) {
        this.id = id;
        this.identificadorLinea = identificadorLinea;
        this.puntoOrigenX = puntoOrigenX;
        this.puntoOrigenY = puntoOrigenY;
        this.puntoFinalX = puntoFinalX;
        this.puntoFinalY = puntoFinalY;
        this.longitud = longitud;
        this.poligono = poligono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificadorLinea() {
        return identificadorLinea;
    }

    public void setIdentificadorLinea(String identificadorLinea) {
        this.identificadorLinea = identificadorLinea;
    }

    public double getPuntoOrigenX() {
        return puntoOrigenX;
    }

    public void setPuntoOrigenX(double puntoOrigenX) {
        this.puntoOrigenX = puntoOrigenX;
    }

    public double getPuntoOrigenY() {
        return puntoOrigenY;
    }

    public void setPuntoOrigenY(double puntoOrigenY) {
        this.puntoOrigenY = puntoOrigenY;
    }

    public double getPuntoFinalX() {
        return puntoFinalX;
    }

    public void setPuntoFinalX(double puntoFinalX) {
        this.puntoFinalX = puntoFinalX;
    }

    public double getPuntoFinalY() {
        return puntoFinalY;
    }

    public void setPuntoFinalY(double puntoFinalY) {
        this.puntoFinalY = puntoFinalY;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Poligono getPoligono() {
        return poligono;
    }

    public void setPoligono(Poligono poligono) {
        this.poligono = poligono;
    }

    @Override
    public String toString() {
        return "Linea{" + "id=" + id + ", identificadorLinea=" + identificadorLinea + ", puntoOrigenX=" + puntoOrigenX + ", puntoOrigenY=" + puntoOrigenY + ", puntoFinalX=" + puntoFinalX + ", puntoFinalY=" + puntoFinalY + ", longitud=" + longitud + ", poligono=" + poligono + '}';
    }
    
    
}
