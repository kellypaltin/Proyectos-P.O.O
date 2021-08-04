/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;

import Conexion.cone_posgres;
import Clases.Producto;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale_
 */
public class Control_tab_Prod {
    DefaultTableModel modeloEntrada;
    
    public void Entrada (JTable tablaE){
        modeloEntrada = new DefaultTableModel();
        modeloEntrada.addColumn("Código");
        modeloEntrada.addColumn("Descripción");
        modeloEntrada.addColumn("Precio");
        modeloEntrada.addColumn("Cantidad Mínima");
        modeloEntrada.addColumn("Unidad");
        modeloEntrada.addColumn("Iva");
        tablaE.setModel(modeloEntrada);
    }
    
    public void llenar_Tabla (Producto ob_pr){
        modeloEntrada.addRow(new Object[]{ob_pr.getCodigo(),
            ob_pr.getDescripcion(),ob_pr.getPrecio(),
            ob_pr.getCan_min(),ob_pr.getUnidad(),
            ob_pr.getIva()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Producto ob_pr = new Producto();
        ResultSet matris_resultad = obj_conexcion.consultar("select * from Productos");
        try{
            while (matris_resultad.next()){
                ob_pr.setCodigo(matris_resultad.getString(1));
                ob_pr.setDescripcion(matris_resultad.getString(2));
                ob_pr.setPrecio(matris_resultad.getDouble(3));
                ob_pr.setCan_min(matris_resultad.getInt(5));
                ob_pr.setUnidad(matris_resultad.getString(4));
                ob_pr.setIva(matris_resultad.getString(6));
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
