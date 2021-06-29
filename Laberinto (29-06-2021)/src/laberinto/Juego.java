/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author kellypaltin
 */
public class Juego extends JPanel{
    
    Laberinto laberinto = new Laberinto();
    Figura figura = new Figura();
    
    public Juego(){
        addMouseMotionListener(new MouseMotionListener(){
            public void mouseDragged(MouseEvent ae, Graphics grafico) {
                figura.moverFigura(ae, grafico);
            }

            @Override
            public void mouseMoved(MouseEvent ae) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
            
        });
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics grafico){
        laberinto.paint(grafico);
        figura.paint(grafico);
    }
    
    public static void main(String[] args) {
        JFrame ventanaPrincipal = new JFrame("LABERINTO");
        Juego juego = new Juego();
        ventanaPrincipal.add(juego);
        
        ventanaPrincipal.setSize(920, 540);
        ventanaPrincipal.setLocation(300, 200);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
