/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author kellypaltin
 */
public class PanelRaton extends JPanel implements MouseListener, MouseMotionListener{
    public FiguraRaton figuraRaton;
    public Random rnd;
    public PanelRaton(){
        setBounds(0, 0, 500, 500);
        figuraRaton = new FiguraRaton(0, 0, 10, 10);
        rnd = new Random();
    }
    
    @Override
    public void paint(Graphics lienzo){
        //lienzo.clearRect(0, 0, 500, 500);
        lienzo.setColor(generadorColorAleatorio());
        lienzo.fillOval(figuraRaton.getX(), figuraRaton.getY(), 
                figuraRaton.getAncho(), figuraRaton.getAlto());
    }
    public Color generadorColorAleatorio(){
        float r = rnd.nextFloat();
        float g = rnd.nextFloat();
        float b = rnd.nextFloat();
        Color colorrnd = new Color(r, g, b);
        return colorrnd;
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        //String mensaje = "Click en X: " + me.getX() + 
        //        "Click en Y: " + me.getY();
        //JOptionPane.showMessageDialog(this, mensaje);
        figuraRaton.setX(me.getX());
        figuraRaton.setY(me.getY());
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        figuraRaton.setX(me.getX());
        figuraRaton.setY(me.getY());
        this.repaint();
    }
    
}
