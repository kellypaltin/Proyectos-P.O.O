/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.ControladorEmpresa;
import controlador.ControladorPersona;
import excepciones.ValidadorCedula;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Directivo;
import modelo.Empleado;
import modelo.Persona;

/**
 *
 * @author kellypaltin
 */
public class VistaPersona extends javax.swing.JInternalFrame {

    public ControladorPersona controladorPersona;
    public ControladorEmpresa controladorEmpresa;
    public DefaultTableModel tblModeloPersona;
    public Class tipo;
    public VistaPersona(ControladorEmpresa controladorEmpresa, ControladorPersona controladorPersona, Class tipo) {
        initComponents();
        this.controladorEmpresa = controladorEmpresa;
        this.controladorPersona = controladorPersona;
        this.tipo = tipo;
        tblModeloPersona = (DefaultTableModel) tblPersona.getModel();
        tblPersona.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tblPersona.getSelectedRow() >=0){
                    String cedula =tblPersona.getModel().getValueAt(tblPersona.getSelectedRow(), 3).toString();
                    controladorPersona.setSeleccionado(controladorPersona.buscar(cedula));
                    mostrarDatos();
                }else{
                    limpiarDatos();
                }
            }
        });
        cargarDatos();
        ocultarComponentes();
    }
    public void ocultarComponentes(){
        if(tipo == Cliente.class){
            lblSueldo.setVisible(false);
            lblCategoria.setVisible(false);
            txtSueldo.setVisible(false);
            txtCategoria.setVisible(false);
        }else if(tipo == Empleado.class){
            txtTelefono.setVisible(false);
            lblTelefono.setVisible(false);
            lblCategoria.setVisible(false);
            txtCategoria.setVisible(false);
        }else if(tipo == Directivo.class){
            txtTelefono.setVisible(false);
            lblTelefono.setVisible(false);
        }
    }
    public void limpiarDatos(){
        txtApellido.setText("");
        txtNombre.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCategoria.setText("");
        txtSueldo.setText("");
        controladorPersona.setSeleccionado(null);
    }
    public void mostrarDatos(){
        txtNombre.setText(controladorPersona.getSeleccionado().getNombre());
        txtApellido.setText(controladorPersona.getSeleccionado().getApellido());
        txtCedula.setText(controladorPersona.getSeleccionado().getCedula());
        txtDireccion.setText(controladorPersona.getSeleccionado().getDireccion());
        if(tipo == Cliente.class){
            txtTelefono.setText(((Cliente)controladorPersona.getSeleccionado()).getTelefono());
        }else if(tipo == Empleado.class){
            txtSueldo.setText(""+((Empleado)controladorPersona.getSeleccionado()).getSueldoBruto());
        }else if(tipo == Directivo.class){
            txtSueldo.setText(""+((Directivo)controladorPersona.getSeleccionado()).getSueldoBruto());
            txtCategoria.setText(""+((Directivo)controladorPersona.getSeleccionado()).getCategoria());
        }
    }
    public void cargarDatos(){
        tblModeloPersona.setRowCount(0);
        for (Object objeto : controladorPersona.getListaPersona()) {
            if(objeto.getClass().equals(tipo)){
                Persona persona = (Persona) objeto;
                String datos[] = {String.valueOf(persona.getId()), persona.getNombre(), persona.getApellido(), persona.getCedula(), persona.getDireccion()};
                tblModeloPersona.addRow(datos);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        lblTelefono = new javax.swing.JLabel();
        lblSueldo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Personas");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido");

        lblCedula.setText("Cedula");

        lblDireccion.setText("Dirección");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Cedula", "Dirección"
            }
        ));
        jScrollPane1.setViewportView(tblPersona);

        lblTelefono.setText("Telefono");

        lblSueldo.setText("Sueldo");

        lblCategoria.setText("Categoria");

        txtSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSueldo)
                                .addGap(26, 26, 26)
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblDireccion)
                                    .addGap(35, 35, 35))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCedula)
                                    .addGap(51, 51, 51)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(txtCedula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnEliminar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellido)
                        .addComponent(lblDireccion)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSueldo)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(tipo == Cliente.class){
            if(controladorPersona.getSeleccionado() == null)
                try {
                    controladorPersona.crearCliente(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText());
            } catch (ValidadorCedula ex) {
                Logger.getLogger(VistaPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            else
                controladorPersona.actualizarCliente(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText());
        }else if(tipo == Empleado.class){
            if(controladorPersona.getSeleccionado() == null){
                try{
                    //double sueldoBruto = Integer.parseInt (txtSueldo.getText())/0;
                    //System.out.println(controladorPersona.getSeleccionado().getApellido());
                    controladorPersona.crearEmpleado(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), Double.parseDouble(txtSueldo.getText()));
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Oye, ingresa un valor numerica en sueldo");
                }catch(ArithmeticException ec){
                    JOptionPane.showMessageDialog(this, "Oye, no hay divisiones para 0");
                }catch(NullPointerException er){
                    JOptionPane.showMessageDialog(this, "Oye, no tienes nada seleccionado");
                }
            }else{
                controladorPersona.actualizarEmpleador(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), Double.parseDouble(txtSueldo.getText()));
            }
        }else if(tipo == Directivo.class){
            if(controladorPersona.getSeleccionado() == null)
                try {
                    controladorPersona.crearDirectivo(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), Double.parseDouble(txtSueldo.getText()), txtCategoria.getText());
            } catch (ValidadorCedula ex) {
                Logger.getLogger(VistaPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            else
                controladorPersona.actualizarDirectivo(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtDireccion.getText(), Double.parseDouble(txtSueldo.getText()), txtCategoria.getText());
        }
        cargarDatos();
        limpiarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Persona persona = controladorPersona.getSeleccionado();
        controladorPersona.eliminar(persona.getCedula());
        cargarDatos();
        limpiarDatos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSueldo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblPersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
