/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Cliente;
import Clases.Producto;
import java.util.ArrayList;
import Conexion.cone_posgres;
import java.sql.ResultSet;
import java.sql.SQLException;
import Control_Tablas.Control_tab_Cliente;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author vale_
 */
public class C_Cliente {
    ArrayList<Cliente> lista_cliente = new ArrayList<>();
    Control_tab_Cliente obj_tab = new Control_tab_Cliente();
    
    public C_Cliente(JTable tablaE){
        obj_tab.Entrada(tablaE);
    }
    
    public void listar(){
        cone_posgres ob_po = new cone_posgres();
        ob_po.Conectar_Base();
        ResultSet lista = ob_po.consultar("SELECT * FROM public.\"Clientes\";");
        
        try{
            while (lista.next()){
                Cliente ob_per = new Cliente();
                ob_per.setCodigo(lista.getInt(1));
                ob_per.setCedula(lista.getString(13));
                ob_per.setNombre(lista.getString(2));
                ob_per.setDireccion(lista.getString(3));
                ob_per.setTelefono(lista.getString(5));
                ob_per.setCelular(lista.getString(6));
                ob_per.setEmail(lista.getString(10));
                lista_cliente.add(ob_per);
                obj_tab.llenar_Tabla(ob_per);
            }
        }
        catch (SQLException e){
            
        }
        ob_po.Cerrar_Base();
    }
    
    public void guardar(int cod, String ced, String nom, String dir,
            String tel, String cel, String mail, String email2, String tip_pers, 
            String vend, String ciudad, String provincia, String cod_post, 
            String pais, String iva, String cli_ac, String con, String cat){
        Cliente obj_per = new Cliente();
        obj_per.setCodigo(cod);
        obj_per.setCedula(ced);
        obj_per.setNombre(nom);
        obj_per.setDireccion(dir);
        obj_per.setTelefono(tel);
        obj_per.setCelular(cel);
        obj_per.setEmail(mail);
        obj_per.setEmail2(email2);
        obj_per.setTip_pers(tip_pers);
        obj_per.setVend(vend);
        obj_per.setCiudad(ciudad);
        obj_per.setProvincia(provincia);
        obj_per.setCod_post(cod_post);
        obj_per.setPais(pais);
        obj_per.setIva(iva);
        obj_per.setCliente_ac(cli_ac);
        obj_per.setContacto(con);
        obj_per.setCategoria(cat);
        lista_cliente.add(obj_per);
        obj_tab.llenar_Tabla(obj_per);
        insert_base(obj_per);
    }
    public void insert_base(Cliente ob_cl){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("INSERT INTO public.\"Clientes\"(\n" +
"	\"Codigo\", \"Nombre\", \"Direccion\", \"Ciudad\", \"Telefono\", \"Celular\", \n" +
"	\"Provincia\", \"Contacto\", \"Codigo_Postal\", \"Correo_1\", \"Pais\", \n" +
"	\"Correo_2\", \"Cedula/Ruc\", \"Persona\", \"Vendedor\", \"Impuesto_incluido\", \"Categoria\", \"Activo\")\n" +
"	VALUES ('"+ob_cl.getCodigo()+"', '"+ob_cl.getNombre()+"', '"+ob_cl.getDireccion()+"',"
                + "'"+ob_cl.getCiudad()+"', '"+ob_cl.getTelefono()+"', '"+ob_cl.getCelular()+"', "
                + "'"+ob_cl.getProvincia()+"', '"+ob_cl.getContacto()+"',"+ob_cl.getCod_post()+"', "
                + "'"+ob_cl.getEmail()+"', '"+ob_cl.getPais()+"', '"+ob_cl.getEmail2()+"', "
                + "'"+ob_cl.getCedula()+"', '"+ob_cl.getTip_pers()+"', '"+ob_cl.getVend()+"', "
                + "'"+ob_cl.getIva()+"', '"+ob_cl.getCategoria()+"', '"+ob_cl.getCliente_ac()+"');");
        
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Cliente guardado satisfactoriamente");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public void Actualizar_base(int cod, String ced, String nom, String dir,
            String tel, String cel, String mail, String email2, String tip_pers, 
            String vend, String ciudad, String provincia, String cod_post, 
            String pais, String iva, String cli_ac){
        Cliente obj_cl = new Cliente();
        obj_cl.setCodigo(cod);
        obj_cl.setCedula(ced);
        obj_cl.setNombre(nom);
        obj_cl.setDireccion(dir);
        obj_cl.setTelefono(tel);
        obj_cl.setCelular(cel);
        obj_cl.setEmail(mail);
        obj_cl.setEmail2(email2);
        obj_cl.setTip_pers(tip_pers);
        obj_cl.setVend(vend);
        obj_cl.setCiudad(ciudad);
        obj_cl.setProvincia(provincia);
        obj_cl.setCod_post(cod_post);
        obj_cl.setPais(pais);
        obj_cl.setIva(iva);
        obj_cl.setCliente_ac(cli_ac);
        obj_tab.Elimina_datos();
        update_base(obj_cl);
        listar();
    }
    
    public void update_base(Cliente ob_cli){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("UPDATE public.\"Clientes\"\n" +
"	SET \"Nombre\"= '"+ob_cli.getNombre()+"', \"Direccion\"='"+ob_cli.getDireccion()+"', "
                + "\"Ciudad\"= '"+ob_cli.getCiudad()+"', \"Telefono\"= '"+ob_cli.getTelefono()+"', "
                + "\"Celular\"='"+ob_cli.getCelular()+"', \"Provincia\"= '"+ob_cli.getProvincia()+"', "
                + "\"Contacto\"='"+ob_cli.getContacto()+"', \"Codigo_postal\"= '"+ob_cli.getCod_post()+"', "
                + "\"Correo_1\"='"+ob_cli.getEmail()+"', \"Pais\"= '"+ob_cli.getPais()+"', "
                + "\"Correo_2\"= '"+ob_cli.getEmail2()+"', \"Cedula/Ruc\"= '"+ob_cli.getCedula()+"', "
                + "\"Persona\"= '"+ob_cli.getTip_pers()+"', \"Vendedor\"= '"+ob_cli.getVend()+"', "
                + "\"Impuesto_incluido\"= '"+ob_cli.getIva()+"', \"Categoria\"= '"+ob_cli.getCategoria()+"', "
                + "\"Activo\"= '"+ob_cli.getCliente_ac()+"'\n" +
"	WHERE \"Codigo\" = '"+ob_cli.getCodigo()+"';");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Se actualizo satisfactoriamente");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public void eliminar_base(int cod, String ced, String nom, String dir,
            String tel, String cel, String mail, String email2, String tip_pers, 
            String vend, String ciudad, String provincia, String cod_post, 
            String pais, String iva, String cli_ac){
        Cliente obj_cl = new Cliente();
        obj_cl.setCodigo(cod);
        obj_cl.setCedula(ced);
        obj_cl.setNombre(nom);
        obj_cl.setDireccion(dir);
        obj_cl.setTelefono(tel);
        obj_cl.setCelular(cel);
        obj_cl.setEmail(mail);
        obj_cl.setEmail2(email2);
        obj_cl.setTip_pers(tip_pers);
        obj_cl.setVend(vend);
        obj_cl.setCiudad(ciudad);
        obj_cl.setProvincia(provincia);
        obj_cl.setCod_post(cod_post);
        obj_cl.setPais(pais);
        obj_cl.setIva(iva);
        obj_cl.setCliente_ac(cli_ac);
        obj_tab.Elimina_datos();
        update_base(obj_cl);
        listar();
    }
    
    public void delete_base(Cliente ob_cl){
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("DELETE FROM public.\"Clientes\"\n" +
"	WHERE \"Codigo\" = '"+ob_cl.getCodigo()+"';");
        if (mensaje.equals("")){
            JOptionPane.showMessageDialog(null, "Cliente Eliminado");
        }
        else{
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}