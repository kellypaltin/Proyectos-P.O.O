/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccionFigura;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kellypaltin
 */
public class VentanaFigura extends JFrame{
    
    public PanelFigura panelFigura;
    public JPanel panelBotones;
    public JButton btnLinea;
    public JButton btnCuadrado;
    public JButton btnCirculo;
    public JButton btnCirculoCuadrado;
    
    public VentanaFigura(){
        setTitle("Ventana de figuras");
        setBounds(0,0,600,600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    public void initComponents(){
        panelBotones = new JPanel();
        panelFigura = new PanelFigura();
        btnLinea = new JButton("Linea");
        panelBotones.add(btnLinea);
        btnCuadrado = new JButton("Cuadrado");
        panelBotones.add(btnCuadrado);
        btnCirculo = new JButton("Circulo");
        panelBotones.add(btnCirculo);
        btnCirculoCuadrado = new JButton("CirculoCuadrado");
        panelBotones.add(btnCirculoCuadrado);
        add(panelBotones, BorderLayout.NORTH);
        add(panelFigura, BorderLayout.CENTER);
        btnLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelFigura.setTipoFigura(1);
                panelFigura.getFiguraSeleccion().setX(100);
                panelFigura.getFiguraSeleccion().setY(100);
                panelFigura.getFiguraSeleccion().setAncho(200);
                panelFigura.getFiguraSeleccion().setAlto(200);
                panelFigura.repaint();
            }
        });
        btnCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelFigura.setTipoFigura(2);
                panelFigura.getFiguraSeleccion().setX(100);
                panelFigura.getFiguraSeleccion().setY(100);
                panelFigura.getFiguraSeleccion().setAncho(200);
                panelFigura.getFiguraSeleccion().setAlto(200);
                panelFigura.repaint();
            }
        });
        btnCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelFigura.setTipoFigura(3);
                panelFigura.getFiguraSeleccion().setX(100);
                panelFigura.getFiguraSeleccion().setY(100);
                panelFigura.getFiguraSeleccion().setAncho(200);
                panelFigura.getFiguraSeleccion().setAlto(200);
                panelFigura.repaint();
            }
        });
        btnCirculoCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelFigura.setTipoFigura(4);
                panelFigura.getFiguraSeleccion().setX(100);
                panelFigura.getFiguraSeleccion().setY(100);
                panelFigura.getFiguraSeleccion().setAncho(200);
                panelFigura.getFiguraSeleccion().setAlto(200);
                panelFigura.repaint();
            }
        });
    }
    
    
}
