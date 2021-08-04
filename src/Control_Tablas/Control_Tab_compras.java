/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;
import Conexion.cone_posgres;
import Clases.Factura_Compra;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vale_
 */
public class Control_Tab_compras {
    DefaultTableModel modeloEntrada;
    
    public void Entrada (JTable tablaE){
        modeloEntrada = new DefaultTableModel();
        modeloEntrada.addColumn("Nro.Compra");
        modeloEntrada.addColumn("Proveedor");
        modeloEntrada.addColumn("Fecha");
        modeloEntrada.addColumn("Total");
        tablaE.setModel(modeloEntrada);
    }
    
    public void llenar_Tabla (Factura_Compra ob_pr){
        modeloEntrada.addRow(new Object[]{ob_pr.getNumero_factura(),
            ob_pr.getCedula(),ob_pr.getEmision(),ob_pr.getTotal()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Factura_Compra ob_pr = new Factura_Compra();
        ResultSet matris_resultad = obj_conexcion.consultar("SELECT * FROM public.\"factura_compra\"");
        try{
            while (matris_resultad.next()){
                ob_pr.setNumero_factura(matris_resultad.getString(1));
                ob_pr.setCedula(matris_resultad.getString(2));
                ob_pr.setEmision(matris_resultad.getDate(3));
                ob_pr.setTotal(matris_resultad.getDouble(8));
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