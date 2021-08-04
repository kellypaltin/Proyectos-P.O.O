/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introducciongui;

import eventos.VentanaRaton;
import graficas.Ventana;
import seleccionFigura.VentanaFigura;
import vista.VistaInicio;

/**
 *
 * @author kellypaltin
 */
public class IntroduccionGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //VistaInicio vistaInicio = new VistaInicio();
        //vistaInicio.setVisible(true);
        
        //Ventana ventana = new Ventana();
        //ventana.setVisible(true);
        
        VentanaRaton ventanaRaton = new VentanaRaton();
        ventanaRaton.setVisible(true);
        
        //VentanaFigura ventanaFigura = new VentanaFigura();
        //ventanaFigura.setVisible(true);
    }
    
}
