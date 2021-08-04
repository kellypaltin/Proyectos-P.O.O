/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Usuario;
import java.util.ArrayList;
import Conexion.cone_posgres;
import java.sql.ResultSet;
import java.sql.SQLException;
import Control_Tablas.Control_tab_Usu;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author vale_
 */
public class Control_Usuario {
    ArrayList<Usuario> lista_usuario = new ArrayList<>();
    Control_tab_Usu obj_tab = new Control_tab_Usu();
    
    public Control_Usuario(JTable tablaE){
        obj_tab.Entrada(tablaE);
    }
    
    public void listar(){
        cone_posgres ob_po = new cone_posgres();
        ob_po.Conectar_Base();
        ResultSet lista = ob_po.consultar("SELECT * FROM public.\"Usuario\";");
        
        try{
            while (lista.next()){
                Usuario ob_usu = new Usuario();
                ob_usu.setCodigo(lista.getString(1));
                ob_usu.setNombre(lista.getString(2));
                ob_usu.setApellido(lista.getString(3));
                ob_usu.setN_usuario(lista.getString(4));
                ob_usu.setClave(lista.getString(5));
                ob_usu.setTipo_usuario(lista.getString(6));
                lista_usuario.add(ob_usu);
                obj_tab.llenar_Tabla(ob_usu);
            }
        }
        catch (SQLException e){
            
        }
        ob_po.Cerrar_Base();
    }
    
    public void guardar(String cod, String nom, String ape, String nu,
            String cl, String tu){
        Usuario obj_usu = new Usuario();
        obj_usu.setCodigo(cod);
        obj_usu.setNombre(nom);
        obj_usu.setApellido(ape);
        obj_usu.setN_usuario(nu);
        obj_usu.setClave(cl);
        obj_usu.setTipo_usuario(tu);
        lista_usuario.add(obj_usu);
        obj_tab.llenar_Tabla(obj_usu);
        insert_base(obj_usu);
    }
    public void insert_base(Usuario ob_us){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("INSERT INTO public.\"Usuario\"(\n" +
"	\"Codigo\", \"Nombres\", \"Apellidos\", \"Nombre_usuario\", \"Clave\", \"Tipo_usuario\")\n" +
"	VALUES ('"+ob_us.getCodigo()+"', '"+ob_us.getNombre()+"', "
        + "'"+ob_us.getApellido()+"', "
        + "'"+ob_us.getN_usuario()+"', "
                + "'"+ob_us.getClave()+"', '"+ob_us.getTipo_usuario()+"');");
        
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Usuario Ingresado");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public void Actualizar_base(String cod, String nom, String ape, 
            String nu, String cl, String tu){
        Usuario obj_us = new Usuario();
        obj_us.setCodigo(cod);
        obj_us.setNombre(nom);
        obj_us.setApellido(ape);
        obj_us.setN_usuario(nu);
        obj_us.setClave(cl);
        obj_us.setTipo_usuario(tu);
        obj_tab.Elimina_datos();
        update_base(obj_us);
        listar();
    }
    
    public void update_base(Usuario ob_us){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("UPDATE public.\"Usuario\"\n" +
"	SET \"Nombres\"='"+ob_us.getNombre()+"', "
        + "\"Apellidos\"='"+ob_us.getApellido()+"', "
        + "\"Nombre_usuario\"='"+ob_us.getN_usuario()+"', "
                + "\"Clave\"='"+ob_us.getClave()+"', "
                + "\"Tipo_usuario\"='"+ob_us.getTipo_usuario()+"'\n" +
"	WHERE \"Codigo\" = '"+ob_us.getCodigo()+"';");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Usuario Actualizado");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public void eliminar_base(String cod, String nom, String ape, 
            String nu, String cl, String tu){
        Usuario obj_us = new Usuario();
        obj_us.setCodigo(cod);
        obj_us.setNombre(nom);
        obj_us.setApellido(ape);
        obj_us.setN_usuario(nu);
        obj_us.setClave(cl);
        obj_us.setTipo_usuario(tu);
        obj_tab.Elimina_datos();
        delete_base(obj_us);
        listar();
    }
    
    public void delete_base(Usuario ob_us){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("DELETE FROM public.\"Usuario\"\n" +
"	WHERE \"Codigo\" = '"+ob_us.getCodigo()+"';");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
}
