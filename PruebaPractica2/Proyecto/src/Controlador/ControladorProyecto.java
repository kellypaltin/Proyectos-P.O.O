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
public class ControladorProyecto {
    private List<Proyecto> listaProyecto;
    private Proyecto seleccionado;
    
    public ControladorProyecto(){
        listaProyecto = new ArrayList<>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaProyecto.size()>0){
            return listaProyecto.get(listaProyecto.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(String codigoProyecto, String nombreProyecto){
        return listaProyecto.add(new Proyecto(generarId(), codigoProyecto, nombreProyecto));
    }
    
    public boolean crear(String codigoProyecto, String nombreProyecto, Jefe jefeProyecto){
        return listaProyecto.add(new Proyecto(generarId(), codigoProyecto, nombreProyecto, jefeProyecto));
    }
    
    public Proyecto buscar(String codigoProyecto){
        for(Proyecto proyecto : listaProyecto){
            if(proyecto.getCodigoProyecto().equals(codigoProyecto)){
                return proyecto;
            }
        }
        return null;
    }
    
    public boolean actualizar(String codigoProyecto, String nombreProyecto){
        Proyecto proyecto = buscar(codigoProyecto);
        if(proyecto != null){
            int posicion = listaProyecto.indexOf(proyecto);
            proyecto.setNombreProyecto(nombreProyecto);
            listaProyecto.set(posicion, proyecto);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String codigoProyecto){
        return listaProyecto.remove(buscar(codigoProyecto));
    }

    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    public Proyecto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proyecto seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
