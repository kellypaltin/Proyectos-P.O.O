/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Grupo;
import modelo.Asignatura;

/**
 *
 * @author kellypaltin
 */
public class GrupoControlador {
    private List<Grupo> listaGrupo;
    private Grupo seleccionado;
    
    public GrupoControlador(){
        listaGrupo = new ArrayList<Grupo>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaGrupo.size() > 0) { 
            return listaGrupo.get(listaGrupo.size() -1 ).getId() + 1; 
        }else {
            return 1; 
        }
    }
    
    public boolean crear(String nombre){
        Grupo grupo = new Grupo(this.generarId(), nombre);
        return listaGrupo.add(grupo);
    }
    
    public boolean crear(long id, String nombre){
        return listaGrupo.add(new Grupo(generarId(), nombre));
    }
    
    public Grupo buscar(String nombre){
        for(Grupo grupo : listaGrupo){
            if(grupo.getNombre().equals(nombre)){
                return grupo;
            }
        }
        return null;
    }
    
    public boolean actualizar(String nombreAnterior, String nombreNuevo){
        Grupo grupo = this.buscar(nombreAnterior);
        if(grupo != null){
            int posicion = listaGrupo.indexOf(grupo);
            grupo.setNombre(nombreNuevo);
            listaGrupo.set(posicion, grupo);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String nombre){
        Grupo grupo = this.buscar(nombre);
        if(grupo != null){
            return listaGrupo.remove(grupo);
        }
        return false;
    }
    
    public void imprimir(){
        for(Grupo grupo : listaGrupo){
            System.out.println(grupo);
        }
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
