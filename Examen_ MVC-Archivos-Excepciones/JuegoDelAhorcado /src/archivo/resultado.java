/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import Modelo.ModeloJugador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellypaltin
 */
public class resultado {
    private String ruta;
    
    public resultado(String ruta){
        this.ruta=ruta;
    }
    public void escribir(List<ModeloJugador> jugadores){
        try {
            FileWriter archivoResultado=new FileWriter(this.ruta);
            BufferedWriter escribirResultado=new BufferedWriter(archivoResultado);
            for (ModeloJugador jugador : jugadores) {
                escribirResultado.append(jugador.getNombre()+"\n");
                escribirResultado.append(jugador.getPalabra()+"\n");
                escribirResultado.append(jugador.getNumeroIntentos()+"\n");
                escribirResultado.append(jugador.getNumeroAciertos()+"\n");
            }
            escribirResultado.close();
            archivoResultado.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<ModeloJugador> leer(){
        List<ModeloJugador> jugadores = new ArrayList<>();
        try {
            FileReader archivoResultado = new FileReader(this.ruta);
            BufferedReader leerResultado = new BufferedReader(archivoResultado);
            String leerNombre = " ";
            String leerPalabra = " ";
            String leerNumIntentos = " ";
            String leerNumAciertos = " ";
            while(leerNumIntentos != null && leerNombre != null){
                leerNombre = leerResultado.readLine();
                leerPalabra = leerResultado.readLine();
                leerNumIntentos = leerResultado.readLine();
                leerNumAciertos = leerResultado.readLine();
                if(leerNumIntentos != null && leerNombre != null){
                    ModeloJugador e = new ModeloJugador(leerNombre, leerPalabra, Integer.parseInt(leerNumIntentos), Integer.parseInt(leerNumAciertos));
                    jugadores.add(e);}
            }
            leerResultado.close();
            archivoResultado.close();
            return jugadores;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jugadores;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
