/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;

import Conexion.cone_posgres;
import Clases.Usuario;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale_
 */
public class Control_tab_Usu {
    DefaultTableModel modeloEntrada;
    
    public void Entrada (JTable tablaE){
        modeloEntrada = new DefaultTableModel();
        modeloEntrada.addColumn("Cedula");
        modeloEntrada.addColumn("Nombres");
        modeloEntrada.addColumn("Apellidos");
        modeloEntrada.addColumn("Nombre de Usuario");
        modeloEntrada.addColumn("Clave");
        modeloEntrada.addColumn("Tipo de Usuario");
        tablaE.setModel(modeloEntrada);
    }
    
    public void llenar_Tabla (Usuario ob_usu){
        modeloEntrada.addRow(new Object[]{ob_usu.getCodigo(),
            ob_usu.getNombre(),ob_usu.getApellido(),
            ob_usu.getN_usuario(),ob_usu.getClave(),
            ob_usu.getTipo_usuario()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Usuario obj_usu = new Usuario();
        ResultSet matris_resultad = obj_conexcion.consultar("select * from Usuarios");
        
        try{
            while (matris_resultad.next()){
                obj_usu.setCodigo(matris_resultad.getString(1));
                obj_usu.setNombre(matris_resultad.getString(2));
                obj_usu.setApellido(matris_resultad.getString(3));
                obj_usu.setN_usuario(matris_resultad.getString(4));
                obj_usu.setClave(matris_resultad.getString(5));
                obj_usu.setTipo_usuario(matris_resultad.getString(6));
                llenar_Tabla(obj_usu);
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void Elimina_datos(){
        modeloEntrada.setRowCount(0);
    }
}
