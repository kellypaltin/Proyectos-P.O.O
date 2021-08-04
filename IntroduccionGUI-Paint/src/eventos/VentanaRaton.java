/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import javax.swing.JFrame;

/**
 *
 * @author kellypaltin
 */
public class VentanaRaton extends JFrame{
    
    public PanelRaton panelRaton;
    public VentanaRaton(){
        setTitle("Escuchador de Evenos Raton");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        panelRaton = new PanelRaton();
        setContentPane(panelRaton);
        panelRaton.repaint();
        addMouseListener(panelRaton);
        addMouseMotionListener(panelRaton);
    }
    
}
