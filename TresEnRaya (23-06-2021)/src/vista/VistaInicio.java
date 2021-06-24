/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kellypaltin
 */
public class VistaInicio extends JFrame{
    private Panel panelPrincipal;
    private JPanel panelBoton;
    private String jugador1;
    private String jugador2;
    private String matriz[][];
    private JButton botonReinicio;
    
    public VistaInicio(){
        super();
        jugador1="X";
        setTitle("JUEGO DE TRES EN RAYA");
        setBounds(0,0,500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        matriz();
        tablero();
        ganador();
        setContentPane(panelPrincipal); 
    }
    
    public void matriz(){
        matriz=new String[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=" ";
            }
        }
    }
    
    public void tablero(){
        panelBoton=new JPanel();
        
        botonReinicio = new JButton("Reiniciar juego");
        botonReinicio.setBounds(0, 0, 50, 50);
        panelBoton.add(botonReinicio);
        add(panelBoton, BorderLayout.NORTH);
        
        botonReinicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<matriz.length; i++){
                    for(int j=0; j<matriz[i].length; j++){
                        matriz[i][j]=" ";
                    }
                }
            }
        });      
        
        panelPrincipal=new Panel();
        GridLayout tablero=new GridLayout(3,3);
        panelPrincipal.setLayout(tablero);
        for (int i = 0; i < tablero.getRows(); i++) {
            for (int j = 0; j < tablero.getColumns(); j++) {
                JButton seleccion=new JButton();
                seleccion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent pal) {
                        if (jugador1=="X") {
                            jugador2=jugador1;
                            seleccion.setText(jugador1);
                            jugador1="O";
                        }else if (jugador1=="O") {
                            seleccion.setText(jugador1);
                            jugador2=jugador1;
                            jugador1="X";
                        }
                    }
                });
                panelPrincipal.add(seleccion);
            }
        }
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    public void ganador(){
        if(matriz[0][0].equals("X") && matriz[0][1].equals("X") &&  matriz[0][2].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[1][0].equals("X")&& matriz[1][1].equals("X") &&  matriz[1][2].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[2][0].equals("X")&& matriz[2][1].equals("X") &&  matriz[2][2].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[0][0].equals("X")&& matriz[1][0].equals("X") &&  matriz[2][0].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[0][1].equals("X")&& matriz[1][1].equals("X") &&  matriz[2][1].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[0][2].equals("X")&& matriz[1][2].equals("X") &&  matriz[2][2].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");    
        }else if(matriz[0][0].equals("X")&& matriz[1][1].equals("X") &&  matriz[2][2].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[0][2].equals("X")&& matriz[1][1].equals("X") &&  matriz[2][0].equals("X")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 1!");
        }else if(matriz[0][0].equals("O")&& matriz[0][1].equals("O") &&  matriz[0][2].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[1][0].equals("O")&& matriz[1][1].equals("O") &&  matriz[1][2].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[2][0].equals("O")&& matriz[2][1].equals("O") &&  matriz[2][2].equals("O")){ 
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[0][0].equals("O")&& matriz[1][0].equals("O") &&  matriz[2][0].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[0][1].equals("O")&& matriz[1][1].equals("O") &&  matriz[2][1].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[0][2].equals("O")&& matriz[1][2].equals("O") &&  matriz[2][2].equals("O")){ 
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[0][0].equals("O")&& matriz[1][1].equals("O") &&  matriz[2][2].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }else if(matriz[0][2].equals("O")&& matriz[1][1].equals("O") &&  matriz[2][0].equals("O")){
            JOptionPane.showMessageDialog(panelPrincipal,"El ganador es el jugador 2!");
        }
    }
}