/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author vale_
 */
public class Producto {
    int can_min;
    String codigo, descripcion, unidad, iva;
    double precio,total;

    public Producto() {
        this.codigo = "";
        this.can_min = 0;
        this.descripcion = "";
        this.unidad = "";
        this.iva = "";
        this.precio = 0;
        this.total = 0;
    }

    public Producto(String codigo, String descripcion, double precio, String unidad, int can_min, String iva) {
        this.codigo = codigo;
        this.can_min = can_min;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.iva = iva;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCan_min() {
        return can_min;
    }

    public void setCan_min(int can_min) {
        this.can_min = can_min;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
}
