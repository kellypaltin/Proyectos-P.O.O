/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kellypaltin
 */
public class Empleado extends Persona {
    private double sueldoBruto;

    public Empleado(long id, String nombre, String apellido, String cedula, String direccion) {
        super(id, nombre, apellido, cedula, direccion);
    }

    public Empleado(long id, String nombre, String apellido, String cedula, String direccion, double sueldoBruto) {
        super(id, nombre, apellido, cedula, direccion);
        this.sueldoBruto = sueldoBruto;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "sueldoBruto=" + sueldoBruto +super.toString()+ '}';
    }
 
    
}
