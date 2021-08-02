/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Modelo.ModeloJugador;
import archivo.palabras;

/**
 *
 * @author kellypaltin
 */
public class ControladorJugador {
    private List<ModeloJugador> ficha;
    private ModeloJugador seleccionado;
    private palabras palabras;
    private ArrayList palabra;
    
    public ControladorJugador(palabras palabras){
        ficha=new ArrayList<>();
        this.palabras=palabras;
        palabra=new ArrayList<>();        
    }
    
    public boolean crear(String nombre, int numeroIntentos, int numeroAciertos){
        ModeloJugador fichero=new ModeloJugador(nombre, this.leer(), numeroIntentos, numeroAciertos);
        seleccionado=fichero;
        return ficha.add(fichero);
    }
    
    public ModeloJugador buscar(String nombre){
        for (ModeloJugador fichero : ficha) {
            if (fichero.getNombre().equals(nombre)) {
                return fichero;
            }
        }
        return null;
    }
    
    public boolean actualizar(String nombre, int numeroIntentos, int numeroAciertos){
        ModeloJugador fichero = this.buscar(nombre);
        if (fichero!=null) {
            int posicion=ficha.indexOf(fichero);
            fichero.setNombre(nombre);
            fichero.setPalabra(this.leer());
            fichero.setNumeroIntentos(numeroIntentos);
            fichero.setNumeroAciertos(numeroAciertos);
            ficha.set(posicion, fichero);
            return true;
        }
        return false;
    }
    
    public String leer(){
        Random random=new Random();
        List<String> lista= new ArrayList<>();
        lista=palabras.leer();
        int next=random.nextInt(lista.size()-1);
        String palabra=lista.get(next);
        return palabra;
    }
    
    public boolean eliminar(String nombre){
        ModeloJugador fichero=this.buscar(nombre);
        if (fichero!=null) {
            ficha.remove(fichero);
            return true;
        }
        return false;
    }
    
    public int verificar(String l, String palabra){ 
        char [] longitud = palabra.toCharArray();
        for (int x = 0; x < longitud.length; x++) {
            String com=String.valueOf(longitud[x]);
            if (com.equals(l)) {
                return x+1;
            }
        }
        return 0;
    }
    
    public List<ModeloJugador> getFicha() {
        return ficha;
    }

    public void setAhorcados(List<ModeloJugador> ficha) {
        this.ficha = ficha;
    }

    public palabras getPalabras() {
        return palabras;
    }

    public void setPalabras(palabras palabras) {
        this.palabras = palabras;
    }

    public ModeloJugador getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(ModeloJugador seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
