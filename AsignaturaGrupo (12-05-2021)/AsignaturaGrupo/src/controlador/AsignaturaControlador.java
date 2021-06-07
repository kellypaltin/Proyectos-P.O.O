/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;


/**
 *
 * @author kellypaltin
 */
public class AsignaturaControlador {
    private List<Asignatura> listaAsignatura;
    private Asignatura seleccionado;
    
    public AsignaturaControlador(){
        listaAsignatura = new ArrayList();
        seleccionado = null;
    }
    
    public boolean crear(long id, String nombre){
        Asignatura asignatura = new Asignatura(id, nombre); 
        return listaAsignatura.add(asignatura); 
    }
   
            
    public Asignatura buscar (String nombre){
        for(Asignatura asignatura : listaAsignatura){  
            if(asignatura.getNombre().equals(nombre)== true){
                return asignatura;
            }
        }
        return null;
    }
    
    public boolean actualizar(String nombre, String nuevoNombre){
        Asignatura asignatura = this.buscar(nombre) ;
        if(asignatura != null){
            int posicion = listaAsignatura.indexOf(asignatura);
            asignatura.setNombre(nuevoNombre);
            listaAsignatura.set(posicion, asignatura);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String nombre){
        Asignatura asignatura = this.buscar(nombre);
        return listaAsignatura.remove(asignatura);
    }
    
    public void imprimir(){
        for(Asignatura asignatura : listaAsignatura){
            System.out.println(asignatura);
        }
    }
    
    public List<Asignatura> getListaAsignatura(){
        return listaAsignatura;
    }
    
    public void setListaAsignatura(List<Asignatura> listaAsignatura){
        this.listaAsignatura = listaAsignatura;
    }

    public Asignatura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Asignatura seleccionado) {
        this.seleccionado = seleccionado;
    }


}
