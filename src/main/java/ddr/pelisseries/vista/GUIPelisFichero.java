/*
 * Esta vista leerá las pelis desde el fichero csv y lo cargará en el jTable 
 */
package ddr.pelisseries.vista;

import ddr.pelisseries.controlador.Controlador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GUIPelisFichero extends javax.swing.JFrame {

    String peliSeleccionada = "";
    String fechaPeliSeleccionada = "";

    /**
     * Crear ventana Series Fichero
     */
    public GUIPelisFichero() {
        initComponents();
        this.setLocationRelativeTo(null);

        Object[][] datos;
//        
        //Cargamos los datos del tabla series
        datos = Controlador.getDatosPelisFichero();
        //Cargamos la primera fila de encabezado.
        String cols[] = Controlador.getColumnasPelisFichero();
//        
        DefaultTableModel model = (DefaultTableModel) jTablePelisVistas.getModel();
//        
        model.setDataVector(datos, cols);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonCerrarPelisVistas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePelisVistas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Pelis Fichero");

        jButtonCerrarPelisVistas.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonCerrarPelisVistas.setText("Cerrar");
        jButtonCerrarPelisVistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarPelisVistasActionPerformed(evt);
            }
        });

        jTablePelisVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePelisVistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePelisVistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePelisVistas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButtonCerrarPelisVistas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(278, 278, 278)
                .addComponent(jButtonCerrarPelisVistas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarPelisVistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarPelisVistasActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        dispose();

    }//GEN-LAST:event_jButtonCerrarPelisVistasActionPerformed

    private void jTablePelisVistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePelisVistasMouseClicked
        // Cuando se seleccione una peli de la lista, debe comparar si ya está en la BBDD 
        // o si no hace falta actualizarse porque ya lo está
        //o si hay que actualizarse

        //al picar en cualquier parte de la tabla, se selecciona la peli que está en esa fila        
        peliSeleccionada = jTablePelisVistas.getValueAt(jTablePelisVistas.getSelectedRow(), 0).toString();
        fechaPeliSeleccionada = jTablePelisVistas.getValueAt(jTablePelisVistas.getSelectedRow(), 1).toString();
        
        GUIPeliFicheroBuscar pfb = new GUIPeliFicheroBuscar(peliSeleccionada, fechaPeliSeleccionada);
        pfb.setVisible(true);
        
    }//GEN-LAST:event_jTablePelisVistasMouseClicked

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
            java.util.logging.Logger.getLogger(GUIPelisFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPelisFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPelisFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPelisFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUIPelisFichero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarPelisVistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePelisVistas;
    // End of variables declaration//GEN-END:variables
}
