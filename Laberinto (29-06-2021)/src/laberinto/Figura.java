/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author kellypaltin
 */
public class Figura {
    private int x = 40;
    private int y = 40;
    private final int alto = 40;
    private final int ancho =40;
    private final int movimiento = 40;
    
    public void paint(Graphics grafico){
        grafico.setColor(Color.WHITE);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.BLACK);
        grafico.drawOval(x, y, ancho, alto);
    }
    
    public void moverFigura(MouseEvent ae, Graphics grafico){
        if(ae.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
            grafico.setColor(Color.WHITE);
            grafico.fillOval(x, y, ancho, alto);
            grafico.setColor(Color.BLACK);
            grafico.drawOval(x, y, ancho, alto);
        }
    }
}
