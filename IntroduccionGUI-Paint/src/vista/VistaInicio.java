/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kellypaltin
 */
public class VistaInicio extends JFrame{
    private JPanel panelPrincipal;
    private JButton boton1;
    private JTextField cuadroTexto;
    private JLabel etiqueta;
    private JTextArea cuadroTextoGrande;
    private JComboBox cajaCombo;
    private String azar;
    
    public VistaInicio(){
        super();
        setTitle("Primer GUI");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponentesGridLayout();
        setContentPane(panelPrincipal);
        generarValor();
    }
    
    public void initComponentesGridLayout(){
        this.panelPrincipal = new JPanel();
        GridLayout tablaPlantilla = new GridLayout(4, 3);
        panelPrincipal.setLayout(tablaPlantilla);
        int contador = 0;
        for (int i = 0; i < tablaPlantilla.getRows(); i++) {
            for (int j = 0; j < tablaPlantilla.getColumns(); j++) {
                String texto = "" + contador;
                if(contador == 11){
                    texto = "Reiniciar";
                } 
                JButton boton = new JButton(texto);
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JButton btn = (JButton)ae.getSource();
                        if(btn.getText().equals("Reiniciar")){
                            generarValor();
                        }else if (btn.getText().equals(azar)){
                            JOptionPane.showMessageDialog(panelPrincipal, "Ganastes !!");
                        }else {
                            JOptionPane.showMessageDialog(panelPrincipal, "Estas cerca");
                        }
                    }
                });
                panelPrincipal.add(boton);
                contador ++;
            }
        }
    }
    
    public void generarValor(){
        Random rnd = new Random();
        azar = ""+rnd.nextInt(10);
    }
    
    public void initComponentesBorderLayout(){
        this.panelPrincipal = new JPanel();
        panelPrincipal.setBounds(50, 50, 200, 200);
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(Color.yellow);
        boton1 = new JButton();
        boton1.setText("Mi primer boton");
        boton1.setBackground(Color.blue);
        boton1.setBounds(50, 50, 50, 40);
        panelPrincipal.add(boton1,BorderLayout.CENTER);
        cuadroTexto = new JTextField("");
        panelPrincipal.add(cuadroTexto, BorderLayout.NORTH);
        cuadroTextoGrande = new JTextArea("");
        panelPrincipal.add(cuadroTextoGrande, BorderLayout.SOUTH);
        etiqueta = new JLabel("Este es una etiqueta");
        panelPrincipal.add(etiqueta, BorderLayout.WEST);
        cajaCombo = new JComboBox();
        cajaCombo.addItem("Seleccion 1");
        cajaCombo.addItem("Seleccion 2");
        cajaCombo.addItem("Seleccion 3");
        panelPrincipal.add(cajaCombo, BorderLayout.EAST);
    }
    
}
