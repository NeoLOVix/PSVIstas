/*
 * Vista para buscar pelis en la BBDD TMDBapi
 * Se introduce titulo y al pulsar en Buscar aparecen las pelis estrenadas que contengan ese título
 * 
 */
package ddr.pelisseries.vista;

import ddr.pelisseries.modelo.peliculasEncontradas;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class GUIBuscarPeli extends javax.swing.JFrame {

    /**
     * Crear ventana Series Vistas
     */
    DefaultListModel<peliculasEncontradas> encontradas = new DefaultListModel<>(); //definimos modelo lista clase peliculasEncontradas
    String peliSeleccionada = ""; //variable que pasaremos como peliseleccionada
    String estreno = "";


    public GUIBuscarPeli() {
        initComponents();
        this.setLocationRelativeTo(null);
        jListBuscarPelisEcontradas.setModel(encontradas);
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
        jLabel2 = new javax.swing.JLabel();
        jTextBuscarPeli = new javax.swing.JTextField();
        jButtonBuscarPeli = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListBuscarPelisEcontradas = new javax.swing.JList<>();
        BotonBuscarNuevaPeli = new javax.swing.JButton();
        poster = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("Buscar Peli");

        jButtonCerrarSeriesVistas.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonCerrarSeriesVistas.setText("Cerrar");
        jButtonCerrarSeriesVistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSeriesVistasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel2.setText("Título de la Peli:");

        jButtonBuscarPeli.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jButtonBuscarPeli.setText("Buscar Peli");
        jButtonBuscarPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPeliActionPerformed(evt);
            }
        });

        jListBuscarPelisEcontradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListBuscarPelisEcontradasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListBuscarPelisEcontradas);

        BotonBuscarNuevaPeli.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        BotonBuscarNuevaPeli.setIcon(new javax.swing.ImageIcon("D:\\Proyectos\\PelisSeries\\Imágenes\\palomitas-de-maiz_45x45.png")); // NOI18N
        BotonBuscarNuevaPeli.setText("Nueva Peli Vista");
        BotonBuscarNuevaPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarNuevaPeliActionPerformed(evt);
            }
        });

        poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextBuscarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(BotonBuscarNuevaPeli))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBuscarPeli, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(poster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCerrarSeriesVistas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextBuscarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarPeli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(poster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBuscarNuevaPeli)
                    .addComponent(jButtonCerrarSeriesVistas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarSeriesVistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSeriesVistasActionPerformed
        // TODO add your handling code here:        
        this.setVisible(false);
        dispose();

    }//GEN-LAST:event_jButtonCerrarSeriesVistasActionPerformed

    private void jButtonBuscarPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPeliActionPerformed
        // Al pulsar el boton BUSCAR PELI, lee el contenido del texto introducido y lo carga en la tabla
        encontradas.clear();
        String peliBuscada = jTextBuscarPeli.getText(); //almacenamos en variable el título de la peli

        if (peliBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningún dato", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TmdbSearch busqueda = new TmdbApi("f57ae39e733b57b4ffc7da40546e6f24").getSearch(); //cargamos api KEY personal
            MovieResultsPage peli = busqueda.searchMovie(peliBuscada, null, "es", false, null); //buscamos peli

            if (peli.getTotalResults() > 0) { //si hay peli
                for (MovieDb e : peli) {
                    peliculasEncontradas peliencontrada = new peliculasEncontradas(e.getTitle(), e.getReleaseDate(), e.getId());
                    peliencontrada.setTitulo(e.getTitle());
                    peliencontrada.setIdPeli(e.getId());
                    peliencontrada.setEstreno(e.getReleaseDate());
                    if (e.getPosterPath() == null) {
                        System.out.println("no hay");  ///si no hay poster.. habrá que poner otra imagen
                    } else {
                        peliencontrada.setUrlPoster(e.getPosterPath());
                        System.out.println(e.getPosterPath());
                        System.out.println(peliencontrada.getUrlPoster());
                    }
                    encontradas.addElement(peliencontrada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado película para la búsqueda realizada", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonBuscarPeliActionPerformed

    private void BotonBuscarNuevaPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarNuevaPeliActionPerformed
        // Abrimos la ventana Nueva Peli Vista
        GUINuevaPeli nu = new GUINuevaPeli(peliSeleccionada, estreno);
        nu.setVisible(true);

    }//GEN-LAST:event_BotonBuscarNuevaPeliActionPerformed

    private void jListBuscarPelisEcontradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBuscarPelisEcontradasMouseClicked
        // al seleccionar una peli en el JLIST
        peliSeleccionada = jListBuscarPelisEcontradas.getSelectedValue().getTitulo();
        estreno = jListBuscarPelisEcontradas.getSelectedValue().getEstreno();
        String txt = jListBuscarPelisEcontradas.getSelectedValue().getUrlPoster();

        URL url;
        try {
            url = new URL(txt);
            Image image = ImageIO.read(url);
            Image img = image.getScaledInstance(139, 229, 139);
            poster.setIcon(new ImageIcon(img));
        } catch (MalformedURLException ex) {
            Logger.getLogger(GUIBuscarPeli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUIBuscarPeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListBuscarPelisEcontradasMouseClicked

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
            java.util.logging.Logger.getLogger(GUIBuscarPeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBuscarPeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBuscarPeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBuscarPeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new GUIBuscarPeli().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscarNuevaPeli;
    private javax.swing.JButton jButtonBuscarPeli;
    private javax.swing.JButton jButtonCerrarSeriesVistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<peliculasEncontradas> jListBuscarPelisEcontradas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextBuscarPeli;
    private javax.swing.JLabel poster;
    // End of variables declaration//GEN-END:variables
}
