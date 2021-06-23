/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kellypaltin
 */
public class Panel extends JPanel{
    private Figura figura;
    private int tipoFigura;
    
    public Panel(){
        setBounds(0, 0, 500, 500);
        figura= new Figura(0, 0, 200, 200);
        tipoFigura = 0;
    }
    
    @Override
    public void paint(Graphics lienzo){
        //lienzo.clipRect(0, 0, 500, 500);
        lienzo.setColor(Color.GRAY);
        switch (tipoFigura){
            case 1:
                lienzo.drawLine(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
            case 2:
                lienzo.drawRect(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
            case 3:
                lienzo.drawRoundRect(20, 50, 300, 200, 50, 30);
                break;
            case 4:
                lienzo.drawOval(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
        }
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public int getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(int tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

}
