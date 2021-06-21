/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figura;
import Modelo.Poligono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class ControladorPoligono {
    private List<Poligono> listaPoligonos;
    private Poligono seleccionado;
    
    public ControladorPoligono(){
        listaPoligonos = new ArrayList<>();
        seleccionado = null;
    }
    
    public long generarId(){
        if(listaPoligonos.size()>0){
            return listaPoligonos.get(listaPoligonos.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    
    public boolean crear(int numeroLineas, double perimetro, double area){
        return listaPoligonos.add(new Poligono(generarId(), numeroLineas, perimetro, area));
    }
    
    public boolean crear(int numeroLineas, double perimetro, double area, Figura figura){
        Poligono poligono = new Poligono(this.generarId(), numeroLineas, perimetro, area, figura);
        figura.getListaPoligonos().add(poligono);
        return listaPoligonos.add(poligono);
    }
    
    public Poligono buscar(int numeroLineas){
        for(Poligono poligono : listaPoligonos){
            if(poligono.getNumeroLineas() == numeroLineas){
                seleccionado = poligono;
                return poligono;
            }
        }
        return null;
    }
    
    public boolean actualizar(int numeroLineas, double perimetro, double area){
        Poligono poligono = buscar(numeroLineas);
        if(poligono != null){
            int posicion = listaPoligonos.indexOf(poligono);
            poligono.setPerimetro(perimetro);
            poligono.setArea(area);
            listaPoligonos.set(posicion, poligono);
            return true;
        }
        return false;
    }
    public void listar(){
        for (Poligono poligono : listaPoligonos) {
            System.out.println(poligono);
        }
    }
    
    public boolean eliminar(int numeroLineas){
        return listaPoligonos.remove(buscar(numeroLineas));
    }

    public List<Poligono> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligono> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }

    public Poligono getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Poligono seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
