/*
 * Clase que controla la obtencion/insercción/modificacion de pelis de la BBDD
 */
package ddr.pelisseries.modelo;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ddr.pelisseries.vista.GUIPrincipal;
import ddr.pelisseries.vista.GUISeriesFichero;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dany
 */
public class peliculasBD {
    
    public static ConexionBD con;
    
    //insertar nueva peli
    public static boolean insertNuevaPeliBD(peliculas pelicula) {

        try (Connection con = new ConexionBD().conectarBD();) {
            String sql = "INSERT INTO peliculas (titulo,fecha_pelivista,estreno) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getFecha());
            ps.setString(3, pelicula.getEstreno());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("Duplicate entry")){ //AVISO DE PELI DUPLICADA
                JOptionPane.showMessageDialog(null, "Operación No realizada: La película ya existe en la base de datos");
            }
            
            return false;
        }
        
        return true;

    }
    
    //recuperar peliculas vistas
    public static Object[][] getDatosPelisVistas() {

        Object[][] obj = null;
        
        try (Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT * FROM peliculas ORDER BY titulo";
                try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    rs.last();
                    int numCols = rsmd.getColumnCount();
                    int numFils = rs.getRow();
                    obj = new Object[numFils][numCols];
                    int j = 0;
                    rs.beforeFirst();
                    while (rs.next()) {
                        for (int i = 0; i < numCols; i++) {
                            obj[j][i] = rs.getObject(i + 1);
//                            System.out.println(rs.toString());
                        }
                        j++;
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public static String[] getColumnasPelisVistas() {
//        return new String[]{"ID Peli", "Título Peli","Fecha Vista"};
        return new String[]{"ID Peli", "Título Peli","Fecha Vista"};
    }

//publica primera fila pelils  Fichero
    public static String[] getColumnasPelisFichero() {
        return new String[]{"Título Peli", "Fecha Vista"};
    }
    
    //
    public static Object[][] getDatosPelisFichero() {

        Object[][] obj = null;

        //leer fichero csv las pelis del fichero csv
        //meterlo en el jtable
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Proyectos\\PelisSeries\\Datos Forms\\Pelivista.csv")); //abrimos fichero .csv para lectura
            try ( CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1) //que no lea la primera linea
                    .build();) { //construyo el CSVReader
                String[] fila;  //para leer cada fila, lo metemos en un campo
                int j = 0;  //iniciamos fila a 0 que luego usamos en el fori
                int numCols = 2; //nº de columnas
                obj = new Object[15][numCols]; //objeto de 15*4
                while ((fila = csvReader.readNext()) != null) {  //mientras haya lineas...
                    for (int i = 1; i < 3; i++) {
                        obj[j][i - 1] = fila[i]; //asignamos cada columna de la final al objeto
                    }
                    j++;
                }
                csvReader.close(); //cerramos el archivo
            }
        } catch (IOException | CsvException ex) {
            Logger.getLogger(GUISeriesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }   

//buscar peli por titulo
    public static boolean comprobarPelisPorTitulo(String tituloPeli) {

        boolean existe = false;

        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT * FROM peliculas WHERE titulo= '" + tituloPeli +"'";
                
                try ( Statement st = con.createStatement();) {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        if (tituloPeli.equals(rs.getString("titulo"))) {
//                            System.out.println("LA SERIE EXISTE");
                            existe = true;
                        } 
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }    
    
    //metodo para obtener peli seleccionada en PELISVISTAS de la BBDD
    public static String obtenerEstrenoPeli(String tituloPeli) {

        String estreno = "";

        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT titulo, estreno FROM peliculas WHERE titulo= '" + tituloPeli + "'";

                try ( Statement st = con.createStatement();) {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        if (tituloPeli.equals(rs.getString("titulo"))) {
                            estreno = rs.getString("estreno");
//                            System.out.println(estreno);
                        }
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estreno; //devolvemos la fecha de estreno.
    }   
    
    
    //borrar pelicula
    public static boolean peliculaBorrar(int codigo) {
        
        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "DELETE FROM peliculas where codigo = (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;        
    }

    
    //insertar nueva peli desde CSV
    public static boolean insertNuevaPeliCSV(peliculas peli) {

        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "INSERT INTO peliculas (titulo,fecha_pelivista) VALUES (?,?)";
//            System.out.println("Query: "+sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getFecha());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
}
