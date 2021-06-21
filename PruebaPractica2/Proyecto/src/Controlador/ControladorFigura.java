/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figura;
import Modelo.Plano;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class ControladorFigura {
    private List<Figura> listaFiguras;
    private Figura seleccionado;
    
    public ControladorFigura(){
        listaFiguras = new ArrayList<>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaFiguras.size()>0){
            return listaFiguras.get(listaFiguras.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(String identificadorFigura, String nombreFigura, String color){
        return listaFiguras.add(new Figura(generarId(), identificadorFigura, nombreFigura, color)); 
    }
    
    public boolean crear(String identificadorFigura, String nombreFigura, String color,  Plano plano){
        Figura figura = new Figura(this.generarId(), identificadorFigura, nombreFigura, color, plano);
        plano.getListaFiguras().add(figura);
        return listaFiguras.add(figura); 
    }
    
    public Figura buscar(String identificadorFigura){
        for(Figura figura : listaFiguras){
            if(figura.getIdentificadorFigura().equals(identificadorFigura)){
                return figura;
            }
        }
        return null;
    }
    
    public boolean actualizar(String identificadorFigura, String nombreFigura, String color){
        Figura figura = this.buscar(identificadorFigura);
        if(figura != null){
            int posicion = listaFiguras.indexOf(figura);
            figura.setNombreFigura(nombreFigura);
            figura.setColor(color);
            listaFiguras.set(posicion, figura);
            return true;
        }
        return false;
    }
    
    public void listar(){
        for (Figura figura : listaFiguras) {
            System.out.println(figura);
        }
    }
    
    public boolean eliminar(String identificadorFigura){
        return listaFiguras.remove(buscar(identificadorFigura));
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public Figura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Figura seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
