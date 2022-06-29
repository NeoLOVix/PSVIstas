/*
 * Esta vista leerá las series desde el fichero csv y lo cargará en el jTable 
 */
package ddr.pelisseries.vista;

import ddr.pelisseries.controlador.Controlador;
import ddr.pelisseries.modelo.series;
import ddr.pelisseries.modelo.seriesBD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GUISeriesFichero extends javax.swing.JFrame {

    String serieSeleccionada = "";
    String tempSerieSeleccionada = "";
    String capSerieSeleccionada = "";
    String fechaSerieSeleccionada = "";

    /**
     * Crear ventana Series Fichero
     */
    public GUISeriesFichero() {
        initComponents();
        this.setLocationRelativeTo(null);

        Object[][] datos;
//        
        //Cargamos los datos del tabla series
        datos = Controlador.getDatosSerieFichero();
        //Cargamos la primera fila de encabezado.
        String cols[] = Controlador.getColumnasSeriesFichero();
//        
        DefaultTableModel model = (DefaultTableModel) jTableSeriesVistas.getModel();
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
        jButtonCerrarSeriesVistas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSeriesVistas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Series Fichero");

        jButtonCerrarSeriesVistas.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonCerrarSeriesVistas.setText("Cerrar");
        jButtonCerrarSeriesVistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSeriesVistasActionPerformed(evt);
            }
        });

        jTableSeriesVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSeriesVistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSeriesVistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSeriesVistas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButtonCerrarSeriesVistas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jButtonCerrarSeriesVistas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarSeriesVistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSeriesVistasActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        dispose();

    }//GEN-LAST:event_jButtonCerrarSeriesVistasActionPerformed

    private void jTableSeriesVistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSeriesVistasMouseClicked
        // Cuando se seleccione una serie de la lista, debe comparar si ya está en la BBDD 
        // o si no hace falta actualizarse porque ya lo está
        //o si hay que actualizarse

        //al picar en cualquier parte de la tabla, se selecciona la serie que está en esa fila        
        serieSeleccionada = jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 0).toString();

        if (seriesBD.getDatosSeriesPorTitulo(serieSeleccionada)) {
            // la serie existe.. por lo que hay que comparr con tempo y caps...
            tempSerieSeleccionada = jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 1).toString();
            capSerieSeleccionada = jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 2).toString();
            fechaSerieSeleccionada = jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 3).toString();
            if (seriesBD.necesitaActualizarSerie(serieSeleccionada, tempSerieSeleccionada, capSerieSeleccionada)) {
                JOptionPane.showMessageDialog(null, "En la BBDD ya están registrados esos capitulos, por lo que no se actualizará.", "NO HAY QUE ACTUALIZAR SERIE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String[] opcion = {"Sí", "No"};
                int seleccion = JOptionPane.showOptionDialog(null, "¿Desea actualizar la BBDD con la Serie: " + serieSeleccionada.toUpperCase() + ",\n Temporada: " + tempSerieSeleccionada + ", Capitulo: " + capSerieSeleccionada + "?", "Actualizar serie desde fichero", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
                if (seleccion == 0) {
                    //actualizar
                    boolean response = false;
                    series actualizar = new series(serieSeleccionada, Integer.parseInt(tempSerieSeleccionada), Integer.parseInt(capSerieSeleccionada), fechaSerieSeleccionada);
                    response = Controlador.updateSerieBD(actualizar);

                    if (response) {
                        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operación No realizada");
                    }
                } else if (seleccion == 1) {
                    //cancelar
                    JOptionPane.showMessageDialog(null, "No se ha actualizado la serie, quizás más tarde", "NO HA HABIDO ACTUALIZACION DE SERIE", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            boolean response = false;
            System.out.println("AÑADIR NUEVA SERIE");
            series nuevaSerie = new series(serieSeleccionada, Integer.parseInt(tempSerieSeleccionada), Integer.parseInt(capSerieSeleccionada), fechaSerieSeleccionada);
            response = Controlador.insertNuevaSerieCSV(nuevaSerie);

            if(response)    {
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            } else 
                JOptionPane.showMessageDialog(null, "Operación No realizada");
        }


    }//GEN-LAST:event_jTableSeriesVistasMouseClicked

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
            java.util.logging.Logger.getLogger(GUISeriesFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISeriesFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISeriesFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISeriesFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            new GUISeriesFichero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSeriesVistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSeriesVistas;
    // End of variables declaration//GEN-END:variables
}