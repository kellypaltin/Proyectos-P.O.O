/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccionFigura;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kellypaltin
 */
public class PanelFigura extends JPanel {

    private FiguraSeleccion figuraSeleccion;
    private int tipoFigura;

    public PanelFigura() {
        setBounds(100, 100, 500, 500);
        figuraSeleccion = new FiguraSeleccion(0, 0, 200, 200);
        tipoFigura = 0;
    }

    @Override
    public void paint(Graphics lienzo) {
        lienzo.clearRect(0, 0, 500, 500);
        lienzo.setColor(Color.blue);
        lienzo.drawString("Paint", 50, 50);
        switch (tipoFigura) {
            case 1: lienzo.drawLine(figuraSeleccion.getX(), figuraSeleccion.getY(), figuraSeleccion.getAncho(), figuraSeleccion.getAlto());
            break;
            case 2: lienzo.drawRect(figuraSeleccion.getX(), figuraSeleccion.getY(), figuraSeleccion.getAncho(), figuraSeleccion.getAlto());
            break;
            case 3: lienzo.drawOval(figuraSeleccion.getX(), figuraSeleccion.getY(), figuraSeleccion.getAncho(), figuraSeleccion.getAlto());
            break;
            case 4: lienzo.drawRoundRect(figuraSeleccion.getX(), figuraSeleccion.getY(), figuraSeleccion.getAncho(), figuraSeleccion.getAlto(), 20, 20);
            break;
        }
    }

    public FiguraSeleccion getFiguraSeleccion() {
        return figuraSeleccion;
    }

    public void setFiguraSeleccion(FiguraSeleccion figuraSeleccion) {
        this.figuraSeleccion = figuraSeleccion;
    }

    public int getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(int tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    
}
