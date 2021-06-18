/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kellypaltin
 */
public class VistaInicio extends JFrame implements ActionListener{   
    
    private JButton btn10,btn11,btn12,btn13,btn14,btn15; 
    private JButton btn[]=new JButton[10];
    private int valor,num1,num2;
    private JTextField respuesta;
    private char opcion; 
    
    public VistaInicio(){
        super();
        setTitle("CALCULADORA");
        setLayout(new BorderLayout());
        JPanel panelPrincipal=new JPanel();
        panelPrincipal.setLayout(new GridLayout(4,4));
        
        for(int i=0;i<=9;i++){
            btn[i]=new JButton(i+"");
            panelPrincipal.add(btn[i]);
            btn[i].addActionListener(this);
        }
        
        btn10=new JButton("+");
        panelPrincipal.add(btn10);
        btn10.addActionListener(this);
 
        btn11=new JButton("-");
        panelPrincipal.add(btn11);
        btn11.addActionListener(this);
 
        btn12=new JButton("*");
        panelPrincipal.add(btn12);
        btn12.addActionListener(this);
 
        btn13=new JButton("/");
        panelPrincipal.add(btn13);
        btn13.addActionListener(this);
 
        btn14=new JButton("=");
        panelPrincipal.add(btn14);
        btn14.addActionListener(this);
 
        btn15=new JButton("C");
        panelPrincipal.add(btn15);
        btn15.addActionListener(this);
 
        respuesta=new JTextField(10);
        add(panelPrincipal,BorderLayout.CENTER);
        add(respuesta,BorderLayout.NORTH);
        setSize(500,500);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    JButton btnseleccionado=(JButton)ae.getSource();
    
    if(btnseleccionado == btn15){
        valor=num1=num2=0;
        respuesta.setText("");
    }else if(btnseleccionado==btn14){
        num2=Integer.parseInt(respuesta.getText());
        operaciones();
  	respuesta.setText(""+valor);
    }else{
 	boolean seleccion=false;
 	if(btnseleccionado==btn10){ 
            opcion='+';
            seleccion=true;
	}
 	if(btnseleccionado==btn11){ 
            opcion='-';
            seleccion=true;
        }
	if(btnseleccionado==btn12){ 
            opcion='*';
            seleccion=true;
        }
        if(btnseleccionado==btn13){ 
            opcion='/';
            seleccion=true;
        }
	if(seleccion==false){
            for(int i=0;i<10;i++){
		if(btnseleccionado==btn[i]){
                    String texto=respuesta.getText();
                    texto+=i;
                    respuesta.setText(texto);
		}
            }
	}else{
            num1=Integer.parseInt(respuesta.getText());
            respuesta.setText("");
        }
    }
}
    public int operaciones(){
        switch(opcion){
            case '+':   
                valor=num1+num2;  
                break;
            case '-':    
                valor=num1-num2;   
                break;
            case '*':    
                valor=num1*num2; 
                break;
            case '/':    
                valor=num1/num2; 
                break;
        }   
        return 0;
    }   
}