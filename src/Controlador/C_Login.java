package Controlador;

import Modelo.M_Login;
import Modelo.M_Opciones;
//import Modelo.M_Producto;
import Vista.V_Login;
import Vista.V_Opciones;
//import Vista.V_Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ginav
 */
public class C_Login implements ActionListener {

    V_Login vista = new V_Login();
    M_Login modelo = new M_Login();
    

    String usuario, contraseña;

    public C_Login(V_Login vista, M_Login modelo) {//Instanciamos las variables de las clases Modelo y Vista
        this.vista = vista;
        this.modelo = modelo;
        //Añadimos los eventos a los botones de la vista
        this.vista.btnIngresar.addActionListener(this); 
//        this.vista.btn_registro.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    public void Agrerar_Usuario() { //Registramos un nuevo Usuario
        //Asignamos el texto obtenido en la Vista a las variables del controlador
        this.usuario = vista.txtUsuario.getText();
        this.contraseña = vista.txtPaswword.getText();
        //comparamos si los campos estan vacios
        if (usuario.length()==0 || contraseña.length()==0) {
            JOptionPane.showMessageDialog(null, "Ingrese Todos los Datos");
        }
        else{
           // String resp = modelo.Insertar_usuario(usuario, contraseña);
            //JOptionPane.showMessageDialog(null, resp);
            vista.txtPaswword.setText("");
            vista.txtUsuario.setText("");
        }
        
    }

    public void Buscar_Usuario() throws IOException {//Busca un dato en la agenda
        usuario = vista.txtUsuario.getText();//ingresar datos usuario
        contraseña ="";
        char c[] = vista.txtPaswword.getPassword();//creo un arrary de la constraseña
            for (int j = 0; j < c.length; j++) {//almaceno la contra en string
                contraseña = contraseña + c[j];
                //  xD=1;
            }
        if (usuario.length()==0 || contraseña.length()==0) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
        } else {
            if (modelo.Buscar_usuario(usuario,contraseña) == true) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                vista.txtPaswword.setText("");
                vista.txtUsuario.setText("");
                V_Opciones v_opciones = new V_Opciones();
                //M_Opciones m_opciones = new M_Opciones();
               // C_Opciones c_opciones = new C_Opciones(v_opciones, m_opciones);
                v_opciones.setLocationRelativeTo(null);
                v_opciones.setVisible(true);
            }   
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar){
            try {
                Buscar_Usuario();
            } catch (IOException ex) {
                Logger.getLogger(C_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnSalir){
            System.exit(0);
        }
    }
}
    

