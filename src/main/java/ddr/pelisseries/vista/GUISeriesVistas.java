/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddr.pelisseries.vista;

import ddr.pelisseries.controlador.Controlador;
import ddr.pelisseries.modelo.peliculasBD;
import ddr.pelisseries.modelo.peliculasEncontradas;
import ddr.pelisseries.modelo.seriesBD;
import ddr.pelisseries.modelo.seriesEncontradas;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.tv.TvSeries;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Usuario
 */
public class GUISeriesVistas extends javax.swing.JFrame {

    /**
     * Crear ventana Series Vistas
     */
    
    public GUISeriesVistas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Object[][] datos;
        
        //Cargamos los datos del tabla series
        datos = Controlador.getDatosSeriesVistas();
        //Cargamos la primera Fila de encabezado.
        String cols[] = Controlador.getColumnasSeriesVistas();
        
        DefaultTableModel model = (DefaultTableModel) jTableSeriesVistas.getModel();
        
        model.setDataVector(datos, cols);     

        // Autoajuste de columnas
        setJTableColumnsWidth(jTableSeriesVistas, 538, 10, 50, 10, 10, 20);        

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
        jButtonBorrarSerie = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSeriesVistas = new javax.swing.JTable();
        poster = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(787, 516));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Series Vistas");

        jButtonCerrarSeriesVistas.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonCerrarSeriesVistas.setText("Cerrar");
        jButtonCerrarSeriesVistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSeriesVistasActionPerformed(evt);
            }
        });

        jButtonBorrarSerie.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonBorrarSerie.setText("Borrar");
        jButtonBorrarSerie.setEnabled(false);
        jButtonBorrarSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarSerieActionPerformed(evt);
            }
        });

        jTableSeriesVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableSeriesVistas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableSeriesVistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableSeriesVistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSeriesVistasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSeriesVistas);

        poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButtonBorrarSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jButtonCerrarSeriesVistas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarSerie)
                    .addComponent(jButtonCerrarSeriesVistas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarSeriesVistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSeriesVistasActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jButtonCerrarSeriesVistasActionPerformed

    private void jButtonBorrarSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarSerieActionPerformed
        // Boton borrar serie. Al pulsarlo debe saltar mensaje de AVISO y si se acepta, se borrará la serie.
        String[] opcion = {"Sí", "No"};
        int seleccion = JOptionPane.showOptionDialog(null, "ATENCION: esta acción será irreversible.\n ¿Desea eliminar la serie seleccionada?", "Borrar Serie", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        if (seleccion == 0){
            int codigo;
            codigo = Integer.parseInt(jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 0).toString());
            Controlador.serieBorrar(codigo); //pasamos la serie seleccionada para borrar
            JOptionPane.showMessageDialog(null, "Serie eliminada correctamente.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha borrado ninguna serie.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonBorrarSerieActionPerformed

    private void jTableSeriesVistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSeriesVistasMouseClicked
        // al seleccionar serie, se activa botón borrar ..mostrar cartel serie 
        jButtonBorrarSerie.setEnabled(true);
        String serieSeleccion = jTableSeriesVistas.getValueAt(jTableSeriesVistas.getSelectedRow(), 1).toString(); //seleccionamos la serie 

        String estreno = seriesBD.obtenerEstrenoSerie(serieSeleccion);

        TmdbSearch busqueda = new TmdbApi("f57ae39e733b57b4ffc7da40546e6f24").getSearch(); //cargamos api KEY personal
        TvResultsPage serie = busqueda.searchTv(serieSeleccion, "es", null); //buscamos serie

        if (serie.getTotalResults() > 0) { //si hay peli
            for (TvSeries e : serie) {
                    seriesEncontradas serieencontrada = new seriesEncontradas(e.getName(), e.getFirstAirDate(), e.getId());
                    serieencontrada.setTitulo(e.getName());
                    serieencontrada.setIdSerie(e.getId());
                    serieencontrada.setEstreno(e.getFirstAirDate());
                
                if (estreno.equals(serieencontrada.getEstreno())){
                    if (e.getPosterPath() == null) {
                        System.out.println("no hay");  ///si no hay poster.. habrá que poner otra imagen
                    } else {
                        serieencontrada.setUrlPoster(e.getPosterPath());
                    }
                    
                    String txt = serieencontrada.getUrlPoster();
                    URL url;
                    try {
                        url = new URL(txt);
                        Image image = ImageIO.read(url);
                        Image img = image.getScaledInstance(185, 262, Image.SCALE_SMOOTH); //213x328
                        poster.setIcon(new ImageIcon(img));
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(GUIBuscarPeli.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GUIBuscarPeli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }  
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jTableSeriesVistasMouseClicked

    
    /*
    * Autoajuste de columnas. Se pasa la tabla, el ANCHO MAXIMO en pixeles y los porcentajes de cada columna
    */
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }
    
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
            java.util.logging.Logger.getLogger(GUISeriesVistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISeriesVistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISeriesVistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISeriesVistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUISeriesVistas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarSerie;
    private javax.swing.JButton jButtonCerrarSeriesVistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSeriesVistas;
    private javax.swing.JLabel poster;
    // End of variables declaration//GEN-END:variables
}
