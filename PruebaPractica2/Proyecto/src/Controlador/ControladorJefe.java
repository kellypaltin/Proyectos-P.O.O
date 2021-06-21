/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Jefe;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class ControladorJefe {
    private List<Jefe> listaJefe;
    private Jefe seleccionado;
    
    public ControladorJefe(){
        listaJefe = new ArrayList<>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaJefe.size()>0){
            return listaJefe.get(listaJefe.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(String codigoJefe, String nombreJefe, String direccion, int telefono){
        return listaJefe.add(new Jefe(generarId(), codigoJefe, nombreJefe, direccion, telefono));
    }
    
    public boolean crear(String codigoJefe, String nombreJefe, String direccion, int telefono, Proyecto proyecto){
        Jefe jefe = new Jefe(this.generarId(), codigoJefe, nombreJefe, direccion, telefono, proyecto);
        proyecto.setJefeProyecto(jefe);
        return listaJefe.add(jefe);
    }
    
    public Jefe buscar(String codigoJefe){
        for(Jefe jefe : listaJefe){
            if(jefe.getCodigoJefe().equals(codigoJefe)){
                return jefe;
            }
        }
        return null;
    }
    
    public boolean actualizar(String codigoJefe, String nombreJefe, String direccion, int telefono){
        Jefe jefe = buscar(codigoJefe);
        if(jefe != null){
            int posicion = listaJefe.indexOf(jefe);
            jefe.setNombreJefe(nombreJefe);
            jefe.setDireccion(direccion);
            jefe.setTelefono(telefono);
            listaJefe.set(posicion, jefe);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String codigoJefe){
        return listaJefe.remove(buscar(codigoJefe));
    }

    public List<Jefe> getListaJefe() {
        return listaJefe;
    }

    public void setListaJefe(List<Jefe> listaJefe) {
        this.listaJefe = listaJefe;
    }

    public Jefe getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Jefe seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
