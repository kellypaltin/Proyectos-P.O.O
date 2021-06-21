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
public class Jefe {
    private long id;
    private String codigoJefe;
    private String nombreJefe;
    private String direccion;
    private int telefono;
    private Proyecto proyecto;

    public Jefe(long id, String codigoJefe, String nombreJefe, String direccion, int telefono) {
        this.id = id;
        this.codigoJefe = codigoJefe;
        this.nombreJefe = nombreJefe;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Jefe(long id, String codigoJefe, String nombreJefe, String direccion, int telefono, Proyecto proyecto) {
        this.id = id;
        this.codigoJefe = codigoJefe;
        this.nombreJefe = nombreJefe;
        this.direccion = direccion;
        this.telefono = telefono;
        this.proyecto = proyecto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoJefe() {
        return codigoJefe;
    }

    public void setCodigoJefe(String codigoJefe) {
        this.codigoJefe = codigoJefe;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Jefe{" + "id=" + id + ", codigoJefe=" + codigoJefe + ", nombreJefe=" + nombreJefe + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
