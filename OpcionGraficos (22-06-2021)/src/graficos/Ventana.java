/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kellypaltin
 */
public class Ventana extends JFrame{
    private Panel panelPrincipal;
    private JPanel panelSeleccion;
    private JButton botonLinea;
    private JButton botonCuadrado;
    private JButton botonRectangulo;
    private JButton botonCirculo;
    
    public Ventana(){
        super();
        setTitle("Seleccionar Graficos");
        setBounds(0, 0, 500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponentes();
    }
    
    public void initComponentes(){
        panelSeleccion= new JPanel();
        panelPrincipal = new Panel();
        
        botonLinea = new JButton("Linea");
        botonLinea.setBounds(0, 0, 50, 50);
        panelSeleccion.add(botonLinea);
        
        botonCuadrado = new JButton("Cuadrado");
        botonCuadrado.setBounds(0, 0, 50, 50);
        panelSeleccion.add(botonCuadrado);
        
        botonRectangulo = new JButton("Rectangulo");
        botonRectangulo.setBounds(0, 0, 50, 50);
        panelSeleccion.add(botonRectangulo);
        
        botonCirculo = new JButton("Circulo");
        botonCirculo.setBounds(0, 0, 50, 50);
        panelSeleccion.add(botonCirculo);
        
        add(panelSeleccion, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);
        
        botonLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelPrincipal.setTipoFigura(1);
                panelPrincipal.getFigura().setX(100);
                panelPrincipal.getFigura().setY(100);
                panelPrincipal.getFigura().setAncho(200);
                panelPrincipal.getFigura().setAlto(200);
                panelPrincipal.repaint();
            }
        });
        
        botonCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelPrincipal.setTipoFigura(2);
                panelPrincipal.getFigura().setX(100);
                panelPrincipal.getFigura().setY(100);
                panelPrincipal.getFigura().setAncho(200);
                panelPrincipal.getFigura().setAlto(200);
                panelPrincipal.repaint();
            }
        });
        
        botonRectangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelPrincipal.setTipoFigura(3);
                panelPrincipal.getFigura().setX(100);
                panelPrincipal.getFigura().setY(100);
                panelPrincipal.getFigura().setAncho(200);
                panelPrincipal.getFigura().setAlto(200);
                panelPrincipal.repaint();
            }
        });
        
        botonCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelPrincipal.setTipoFigura(4);
                panelPrincipal.getFigura().setX(100);
                panelPrincipal.getFigura().setY(100);
                panelPrincipal.getFigura().setAncho(200);
                panelPrincipal.getFigura().setAlto(200);
                panelPrincipal.repaint();
            }
        });
    }
}
