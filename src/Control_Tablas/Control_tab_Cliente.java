/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;

import Conexion.cone_posgres;
import Clases.Cliente;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale_
 */
public class Control_tab_Cliente {
    DefaultTableModel modeloEntrada;
    
    public void Entrada (JTable tablaE){
        modeloEntrada = new DefaultTableModel();
        modeloEntrada.addColumn("Código");
        modeloEntrada.addColumn("Cedula");
        modeloEntrada.addColumn("Nombres");
        modeloEntrada.addColumn("Dirección");
        modeloEntrada.addColumn("Teléfono");
        modeloEntrada.addColumn("Celular");
        modeloEntrada.addColumn("E-Mail");
        tablaE.setModel(modeloEntrada);
    }
    
    public void llenar_Tabla (Cliente ob_cl){
        modeloEntrada.addRow(new Object[]{ob_cl.getCodigo(),
            ob_cl.getCedula(),ob_cl.getNombre(),
            ob_cl.getDireccion(),ob_cl.getTelefono(),
            ob_cl.getCelular(),ob_cl.getEmail()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Cliente ob_cl = new Cliente();
        ResultSet matris_resultad = obj_conexcion.consultar("select * from Clientes");
        try{
            while (matris_resultad.next()){
                ob_cl.setCodigo(matris_resultad.getInt(1));
                ob_cl.setCedula(matris_resultad.getString(13));
                ob_cl.setNombre(matris_resultad.getString(2));
                ob_cl.setDireccion(matris_resultad.getString(3));
                ob_cl.setTelefono(matris_resultad.getString(5));
                ob_cl.setCelular(matris_resultad.getString(6));
                ob_cl.setEmail(matris_resultad.getString(10));
                llenar_Tabla(ob_cl);
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void Elimina_datos(){
        modeloEntrada.setRowCount(0);
    }
    
}
