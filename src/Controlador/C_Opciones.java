/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Opciones;
import Vista.V_Opciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ginav
 */
public class C_Opciones implements ActionListener{
    
    V_Opciones vista = new V_Opciones();
    M_Opciones modelo = new M_Opciones();
    
    String num_reserva, fec_ini, fec_fin, cli_reserva, pla_reserva;
    Double costo_reserva;
    
    String cod_vehiculo, mod_vehiculo, dueño_vehiculo;
    
    String nom_usuario, usu_usuaio, cla_usuario, tip_usuario;
    
    String ced_cliente, nom_cliente, dir_cliente, tel_cliente;
    
    String cod_espacio, ubi_espacio, reser_espacio;
    double cost_espacio;

    public C_Opciones(V_Opciones vista, M_Opciones modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.Reservas.addActionListener(this);
        this.vista.Vehiculo.addActionListener(this);
        this.vista.Compras.addActionListener(this);
        this.vista.Usuarios.addActionListener(this);
        this.vista.Salir.addActionListener(this);
        this.vista.NotaCredito.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
