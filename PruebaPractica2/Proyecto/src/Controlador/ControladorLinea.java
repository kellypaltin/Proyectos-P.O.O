/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Linea;
import Modelo.Poligono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class ControladorLinea {
    private List<Linea> listaLineas;
    private Linea seleccionado;
    
    public ControladorLinea(){
        listaLineas = new ArrayList<>();
        seleccionado = null;
    }
    public long generarId(){
        if(listaLineas.size()>0){
            return listaLineas.get(listaLineas.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(String identificadorLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud){
        return listaLineas.add(new Linea(generarId(), identificadorLinea, puntoOrigenX, puntoOrigenY, puntoFinalX, puntoFinalY, longitud));
    }
    
    public boolean crear(String identificadorLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud, Poligono poligono){
        Linea linea = new Linea(this.generarId(), identificadorLinea, puntoOrigenX, puntoOrigenY, puntoFinalX, puntoFinalY, longitud, poligono);
        poligono.getListaLineas().add(linea);
        return listaLineas.add(linea);
    }
    
    public Linea buscar(String identificadorLinea){
        for(Linea linea : listaLineas){
            if(linea.getIdentificadorLinea().equals(identificadorLinea)){
                return linea;
            }
        }
        return null;
    }
    
    public boolean actualizar(String identificadorLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud){
        Linea linea = buscar(identificadorLinea);
        if(linea != null){
            int posicion = listaLineas.indexOf(linea);
            linea.setPuntoOrigenX(puntoOrigenX);
            linea.setPuntoOrigenY(puntoOrigenY);
            linea.setPuntoFinalX(puntoFinalX);
            linea.setPuntoFinalY(puntoFinalY);
            linea.setLongitud(longitud);
            listaLineas.set(posicion, linea);
            return true;
        }
        return false;
    }
    public void listar(){
        for (Linea linea : listaLineas) {
            System.out.println(linea);
        }
    }
    public boolean eliminar(String identificadorLinea){
        return listaLineas.remove(buscar(identificadorLinea));
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Linea getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Linea seleccionado) {
        this.seleccionado = seleccionado;
    }
    
            
}
