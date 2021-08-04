/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Tablas;

/**
 *
 * @author josea
 */
import Conexion.cone_posgres;
import Clases.Factura;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Control_tab_Factura {
    DefaultTableModel modeloEntrada;
    
    public void Entrada (JTable tablaE){
        modeloEntrada = new DefaultTableModel();
        modeloEntrada.addColumn("Numero_factura");
        modeloEntrada.addColumn("Cliente");
        modeloEntrada.addColumn("Fecha");
        modeloEntrada.addColumn("Total");
     
        tablaE.setModel(modeloEntrada);
    }
    
    public void llenar_Tabla (Factura ob_cl){
        modeloEntrada.addRow(new Object[]{ob_cl.getNumero_factura(),
            ob_cl.getCedula(),ob_cl.getEmision(),ob_cl.getTotal()});
    }
    
    public void consultar(){
        cone_posgres obj_conexcion = new cone_posgres();
        obj_conexcion.Conectar_Base();
        Factura ob_cl = new Factura();
        ResultSet matris_resultad = obj_conexcion.consultar("select * from factura_venta");
        try{
            while (matris_resultad.next()){
                ob_cl.setNumero_factura(matris_resultad.getString(1));
                ob_cl.setCedula(matris_resultad.getString(2));         
                ob_cl.setEmision(matris_resultad.getDate(3));
                ob_cl.setTotal(matris_resultad.getDouble(8));
                llenar_Tabla(ob_cl);
            }
        }
        catch(Exception e){
            
        }
    }
}
