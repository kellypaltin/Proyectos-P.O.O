/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author josea
 */
import Clases.Factura_Compra;
import java.util.ArrayList;
import Conexion.cone_posgres;
import java.sql.ResultSet;
import java.sql.SQLException;
import Control_Tablas.Control_tab_Factura_C;
import java.sql.Date;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class C_Espacio {

    ArrayList<Factura_Compra> lista_cliente = new ArrayList<>();
    Control_tab_Factura_C obj_tab = new Control_tab_Factura_C();

    public C_Espacio(JTable tablaE) {
        obj_tab.Entrada(tablaE);
    }

    public void listar() {
        cone_posgres ob_po = new cone_posgres();
        ob_po.Conectar_Base();
        ResultSet lista = ob_po.consultar("SELECT * FROM public.\"factura_compra\";");

        try {
            while (lista.next()) {
                Factura_Compra ob_per = new Factura_Compra();
                ob_per.setNumero_factura(lista.getString(1));
                ob_per.setCedula(lista.getString(2));
                ob_per.setEmision(lista.getDate(3));
                ob_per.setTotal(lista.getDouble(8));
               
                lista_cliente.add(ob_per);
                obj_tab.llenar_Tabla(ob_per);
            }
        } catch (SQLException e) {

        }
        ob_po.Cerrar_Base();
    }

    public void guardar(String numero_factura, String cedula, Date emision, Date vence, double subtotal,
            double descuento, double iva, double total) {
        Factura_Compra obj_per = new Factura_Compra();

        obj_per.setNumero_factura(numero_factura);
        obj_per.setCedula(cedula);
        obj_per.setEmision(emision);
        obj_per.setVence(vence);
        obj_per.setSubtotal(subtotal);
        obj_per.setDescuento(descuento);
        obj_per.setIva(iva);
        obj_per.setTotal(total);
        lista_cliente.add(obj_per);
        obj_tab.llenar_Tabla(obj_per);
        
        insert_base(obj_per);
    }

    public void insert_base(Factura_Compra ob_cl) {
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("INSERT INTO public.factura_compra(\n" +
"	\"Numero_factura\", \"Cedula/ruc\", \"Emision\", \"Vence\", \"Subtotal\", \"Descuento\", \"Iva\", \"Total\")\n" +
"	VALUES ('"+ob_cl.getNumero_factura()+"', '"+ob_cl.getCedula()+"', '"+ob_cl.getEmision()+"', "
        + "'"+ob_cl.getVence()+"', '"+ob_cl.getSubtotal()+"', '"+ob_cl.getDescuento()+"', "
        + "'"+ob_cl.getIva()+"', '"+ob_cl.getTotal()+"');");
        if (mensaje.equals("")) {
            JOptionPane.showMessageDialog(null, "Factura Grabada con Éxito");
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public void Actualizar_base(String numero_factura, String cedula, Date emision, Date vence, double subtotal,
            double descuento, double iva, double total) {
        Factura_Compra obj_cl = new Factura_Compra();
       obj_cl.setNumero_factura(numero_factura);
        obj_cl.setCedula(cedula);
        obj_cl.setEmision(emision);
        obj_cl.setVence(vence);
        obj_cl.setSubtotal(subtotal);
        obj_cl.setDescuento(descuento);
        obj_cl.setIva(iva);
        obj_cl.setTotal(total);
        update_base(obj_cl);
        listar();
    }

    public void update_base(Factura_Compra ob_cli) {
        cone_posgres obj_cpo = new cone_posgres();
        obj_cpo.Conectar_Base();
        String mensaje = obj_cpo.ejecutar_sql("UPDATE public.\"factura_compra\"\n"
                + "	SET \"Numero_facura\"= '" + ob_cli.getNumero_factura()+ "', \"Cedula/ruc\"='" + ob_cli.getCedula()+ "', "
                + "\"Emision\"= '" + ob_cli.getEmision()+ "', \"Vence\"= '" + ob_cli.getVence()+ "', "
                + "\"Subtotal\"='" + ob_cli.getSubtotal()+ "', \"Descuento\"= '" + ob_cli.getDescuento()+ "', "
                + "\"Iva\"='" + ob_cli.getIva()+ "', \"Total\"= '" + ob_cli.getTotal()+ "',;");
        if (mensaje.equals("")) {
            JOptionPane.showMessageDialog(null, "Se actualizo satisfactoriamente");
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}


