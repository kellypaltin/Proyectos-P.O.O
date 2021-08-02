/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

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
public class palabras {
    private String ruta;
    private int contador;

    public palabras(String ruta) {
        this.ruta = ruta;
        this.contador = -1;
    }
    
    public void escribir(List<String> palabras) {
        try {
            FileWriter archivoPalabras = new FileWriter(this.ruta);
            BufferedWriter escribirPalabras = new BufferedWriter(archivoPalabras);
            for (String palabra : palabras) {
                escribirPalabras.append(palabra + "\n");
            }
            escribirPalabras.close();
            archivoPalabras.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<String> leer(){
        List<String> listaPalabras= new ArrayList<>();
        try {
            FileReader archivoPalabras = new FileReader(this.ruta);
            BufferedReader leerPalabras = new BufferedReader(archivoPalabras);
            String leerNombre = " ";
            while (leerNombre != null) {                
                leerNombre = leerPalabras.readLine();
                if (leerNombre!=null) {
                    String palabra= new String(leerNombre);
                    listaPalabras.add(palabra);
                    this.contador++;
                }
            }
            leerPalabras.close();
            archivoPalabras.close();
            return listaPalabras;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return listaPalabras;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
