/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;

import Conexion.cone_posgres;
import Clases.Proveedor;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale_
 */
public class Control_tab_Prov {
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
    
    public void llenar_Tabla (Proveedor ob_prov){
        modeloEntrada.addRow(new Object[]{ob_prov.getCodigo(),
            ob_prov.getCedula(),ob_prov.getNombre(),
            ob_prov.getDireccion(),ob_prov.getTelefono(),
            ob_prov.getCelular(),ob_prov.getEmail()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Proveedor ob_pr = new Proveedor();
        ResultSet matris_resultad = obj_conexcion.consultar("select * from Proveedores");
        try{
            while (matris_resultad.next()){
                ob_pr.setCodigo(matris_resultad.getInt(1));
                ob_pr.setCedula(matris_resultad.getString(13));
                ob_pr.setNombre(matris_resultad.getString(2));
                ob_pr.setDireccion(matris_resultad.getString(3));
                ob_pr.setTelefono(matris_resultad.getString(5));
                ob_pr.setCelular(matris_resultad.getString(6));
                ob_pr.setEmail(matris_resultad.getString(10));
                llenar_Tabla(ob_pr);
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void Elimina_datos(){
        modeloEntrada.setRowCount(0);
    }
}
