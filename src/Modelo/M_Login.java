/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.Cls_Excel;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pabli
 */
public class M_Login {
    public Cls_Excel cex;
    private static String usuario;
    private static String password;
    
    public boolean Buscar_usuario(String usuario, String contraseña) 
    {
        boolean band = false;
        cex = new Cls_Excel("Usuario.xlsx");
        List<Object[]> datos = cex.Datos_Hoja(0);
        for (Object[] col : datos){
            if (col[1].equals(usuario)) {
                if(col[2].equals(contraseña)){
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    band = true;
                    return band;
                }
                else{
                    band = false;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta, vuelva a escribirla");
                }
            }
            else{
                band = false;
                JOptionPane.showMessageDialog(null, "El usuario no se encuentra creado");
            }

        }
        return band;
    }
}
