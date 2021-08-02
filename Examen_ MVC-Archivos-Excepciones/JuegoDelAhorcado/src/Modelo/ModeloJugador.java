/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kellypaltin
 */
public class ModeloJugador {
    private String nombre;
    private String palabra;
    private int numeroIntentos;
    private int numeroAciertos;

    public ModeloJugador(String nombre, String palabra, int numeroIntentos, int numeroAciertos) {
        this.nombre = nombre;
        this.palabra = palabra;
        this.numeroIntentos = numeroIntentos;
        this.numeroAciertos = numeroAciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

    public int getNumeroAciertos() {
        return numeroAciertos;
    }

    public void setNumeroAciertos(int numeroAciertos) {
        this.numeroAciertos = numeroAciertos;
    }

    @Override
    public String toString() {
        return "ModeloJugador{" + "nombre=" + nombre + ", palabra=" + palabra + ", numeroIntentos=" + numeroIntentos + ", numeroAciertos=" + numeroAciertos + '}';
    }

}
