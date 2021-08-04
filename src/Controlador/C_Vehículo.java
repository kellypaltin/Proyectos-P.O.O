/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Producto;
import java.util.ArrayList;
import Conexion.cone_posgres;
import java.sql.ResultSet;
import java.sql.SQLException;
import Control_Tablas.Control_tab_Prod;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author vale_
 */
public class C_Vehículo {
    ArrayList<Producto> lista_cliente = new ArrayList<>();
    Control_tab_Prod obj_tab = new Control_tab_Prod();
    
    public C_Vehículo(JTable tablaE){
        obj_tab.Entrada(tablaE);
    }
    
    public void listar(){
        cone_posgres ob_po = new cone_posgres();
        ob_po.Conectar_Base();
        ResultSet lista = ob_po.consultar("SELECT * FROM public.\"Productos\";");
        
        try{
            while (lista.next()){
                Producto ob_pr = new Producto();
                ob_pr.setCodigo(lista.getString(1));
                ob_pr.setDescripcion(lista.getString(2));
                ob_pr.setPrecio(lista.getDouble(3));
                ob_pr.setCan_min(lista.getInt(4));
                ob_pr.setUnidad(lista.getString(5));
                ob_pr.setIva(lista.getString(6));
                lista_cliente.add(ob_pr);
                obj_tab.llenar_Tabla(ob_pr);
            }
        }
        catch (SQLException e){
            
        }
        ob_po.Cerrar_Base();
    }
    
    public void guardar(String cod, String des, double pvp, int cm,
            String uni, String iva){
        Producto obj_pr = new Producto();
        obj_pr.setCodigo(cod);
        obj_pr.setDescripcion(des);
        obj_pr.setPrecio(pvp);
        obj_pr.setCan_min(cm);
        obj_pr.setUnidad(uni);
        obj_pr.setIva(iva);
        lista_cliente.add(obj_pr);
        obj_tab.llenar_Tabla(obj_pr);
        insert_base(obj_pr);
    }
    public void insert_base(Producto ob_pr){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("INSERT INTO public.\"Productos\"(\n" +
"	\"Codigo\", \"Descripción\", \"Precio\", \"Cantidad_minima\", \"Unidad\", \"Iva\")\n" +
"	VALUES ('"+ob_pr.getCodigo()+"', '"+ob_pr.getDescripcion()+"', '"+ob_pr.getPrecio()+"', "
                + "'"+ob_pr.getCan_min()+"', '"+ob_pr.getUnidad()+"', '"+ob_pr.getIva()+"');");
        
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Se insertó satisfactoriamente");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public void Actualizar_base(String cod, String des, double pvp, int cm,
            String uni, String iva){
        Producto obj_pr = new Producto();
        obj_pr.setCodigo(cod);
        obj_pr.setDescripcion(des);
        obj_pr.setPrecio(pvp);
        obj_pr.setCan_min(cm);
        obj_pr.setUnidad(uni);
        obj_pr.setIva(iva);
        update_base(obj_pr);
        listar();
    }
    
    public void update_base(Producto ob_pr){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("UPDATE public.\"Productos\"\n" +
"	SET \"Descripción\"= '"+ob_pr.getDescripcion()+"', \"Precio\"= '"+ob_pr.getPrecio()+"', "
                + "\"Cantidad_minima\"= '"+ob_pr.getCan_min()+"', \"Unidad\"= '"+ob_pr.getUnidad()+"', "
                + "\"Iva\"= '"+ob_pr.getIva()+"'\n" +
"	WHERE \"Codigo\"= '"+ob_pr.getCodigo()+"'");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Se actualizo satisfactoriamente");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }    
    
    public void eliminar_base(String cod, String des, double pvp, int cm,
            String uni, String iva){
        Producto obj_pr = new Producto();
        obj_pr.setCodigo(cod);
        obj_pr.setDescripcion(des);
        obj_pr.setPrecio(pvp);
        obj_pr.setCan_min(cm);
        obj_pr.setUnidad(uni);
        obj_pr.setIva(iva);
        obj_tab.Elimina_datos();
        delete_base(obj_pr);
        listar();
    }
    
    public void delete_base(Producto ob_pr){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("DELETE FROM public.\"Productos\"\n" +
"	WHERE \"Codigo\" = '"+ob_pr.getCodigo()+"';");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}
