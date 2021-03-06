/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorJugador;
import archivo.palabras;
import archivo.resultado;


/**
 *
 * @author kellypaltin
 */
public class Main extends javax.swing.JFrame {
    private ControladorJugador controladorJugador;
    private palabras palabras;
    private resultado resultado;
    
    /**
     * 
     */
    public Main() {
        initComponents();
        palabras=new palabras("/Users/kellypaltin/Desktop/JuegoDelAhorcado/src/archivo/palabras.txt");
        controladorJugador=new ControladorJugador(palabras);
        resultado=new resultado("/Users/kellypaltin/Desktop/JuegoDelAhorcado/src/archivo/resultado.txt");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtpJuegoMain = new javax.swing.JDesktopPane();
        lblTitulo = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dtpJuegoMain.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Beirut", 0, 18)); // NOI18N
        lblTitulo.setText("JUEGO  DEL   AHORCADO");

        btnContinuar.setText("CONTINUAR");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        dtpJuegoMain.setLayer(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dtpJuegoMain.setLayer(btnContinuar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpJuegoMainLayout = new javax.swing.GroupLayout(dtpJuegoMain);
        dtpJuegoMain.setLayout(dtpJuegoMainLayout);
        dtpJuegoMainLayout.setHorizontalGroup(
            dtpJuegoMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpJuegoMainLayout.createSequentialGroup()
                .addGroup(dtpJuegoMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dtpJuegoMainLayout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dtpJuegoMainLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(btnContinuar)))
                .addContainerGap(341, Short.MAX_VALUE))
        );
        dtpJuegoMainLayout.setVerticalGroup(
            dtpJuegoMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpJuegoMainLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnContinuar)
                .addContainerGap(479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpJuegoMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpJuegoMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        VistaJuego pagina = new VistaJuego( controladorJugador,  palabras,  resultado);
        dtpJuegoMain.add(pagina);
        pagina.show();
    }//GEN-LAST:event_btnContinuarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JDesktopPane dtpJuegoMain;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
