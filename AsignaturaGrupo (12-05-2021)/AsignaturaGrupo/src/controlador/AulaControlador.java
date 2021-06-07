/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Aula;
import modelo.Asignatura;
import modelo.Grupo;

/**
 *
 * @author kellypaltin
 */
public class AulaControlador {
    private List<Aula> listaAula;
    private Aula seleccionado;

    public AulaControlador(){
        listaAula = new ArrayList();
        seleccionado = null;
    }
    public long generarId(){
        if(listaAula.size() > 0) { 
            return listaAula.get(listaAula.size() -1 ).getId() + 1; 
        }else {
            return 1; 
        }
    }
    
    public boolean crear(long id, String descripcion){
        Aula aula = new Aula(id, descripcion);
        return listaAula.add(aula);
    }  
    
    public Aula buscar(String descripcion){
        for(Aula aula : listaAula){
            if(aula.getDescripcion().equals(descripcion)){
                return aula;
            }
        }
        return null;
    }
    
    public boolean actualizar(String descripcionAnterior, String descripcionNuevo){
        Aula aula = this.buscar(descripcionAnterior);
        if(aula != null){
            int posicion = listaAula.indexOf(aula);
            aula.setDescripcion(descripcionNuevo);
            listaAula.set(posicion, aula);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String descripcion){
        Aula aula = this.buscar(descripcion);
        if(aula != null){
            return listaAula.remove(aula);
        }
        return false;
    }

    public List<Aula> getListaAula() {
        return listaAula;
    }

    public void setListaAula(List<Aula> listaAula) {
        this.listaAula = listaAula;
    }

    public Aula getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Aula seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
