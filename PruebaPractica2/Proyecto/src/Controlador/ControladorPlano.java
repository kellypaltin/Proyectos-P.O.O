/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Plano;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class ControladorPlano {
    private List<Plano> listaPlanos;
    private Plano seleccionado;
    
    public ControladorPlano(){
        listaPlanos = new ArrayList<>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaPlanos.size()>0){
            return listaPlanos.get(listaPlanos.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(int numeroIdentificacion, Date fechaEntrega, int arquitectos, boolean dibujo, int numeroFiguras) {
        return listaPlanos.add(new Plano(generarId(), numeroIdentificacion, fechaEntrega, arquitectos, dibujo, numeroFiguras));
    }
    
    public boolean crear(int numeroIdentificacion, Date fechaEntrega, int arquitectos, boolean dibujo, int numeroFiguras, Proyecto proyecto) {
        Plano plano = new Plano(this.generarId(), numeroIdentificacion, fechaEntrega, arquitectos, dibujo, numeroFiguras, proyecto);
        proyecto.getListaPlanos().add(plano);
        return listaPlanos.add(plano);
    }
    
    public Plano buscar(int numeroIdentificacion){
        for(Plano plano : listaPlanos){
            if(plano.getNumeroIdentificacion() == numeroIdentificacion){
                return plano;
            }
        }
        return null;
    }
    
    public boolean actualizar(int numeroIdentificacion, Date fechaEntrega, int arquitectos, boolean dibujo, int numeroFiguras){
        Plano plano = buscar(numeroIdentificacion);
        if(plano != null){
            int posicion = listaPlanos.indexOf(plano);
            plano.setFechaEntrega(fechaEntrega);
            plano.setArquitectos(arquitectos);
            plano.setDibujo(dibujo);
            plano.setNumeroFiguras(numeroFiguras);
            listaPlanos.set(posicion, plano);
            return true;
        }
        return false;
    }
    
    public void listar(){
        for (Plano plano : listaPlanos) {
            System.out.println(plano);
        }
    }
    
    public boolean eliminar(int numeroIdentificacion){
        Plano plano = buscar(numeroIdentificacion);
        return listaPlanos.remove(plano);
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    public Plano getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Plano seleccionado) {
        this.seleccionado = seleccionado;
    }

    
}
