/*
 * Clase que controla la obtencion/insercción/modificacion de series de la BBDD
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

/**
 *
 * @author Dany
 */
public class seriesBD {

    public static ConexionBD con;

    //insertar nueva serie
    public static boolean insertNuevaSerieBD(series serie) {

        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "INSERT INTO series (titulo,temporada,capitulo,fecha_serievista,estreno) VALUES (?,?,?,?,?)";
//            System.out.println("Query: "+sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, serie.getTitulo());
            ps.setInt(2, serie.getTemporada());
            ps.setInt(3, serie.getCapitulo());
            ps.setString(4, serie.getFecha());
            ps.setString(5, serie.getEstreno());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    //recuperar TODAS series vistas
    public static Object[][] getDatosSeriesVistas() {

        Object[][] obj = null;

        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT * FROM series ORDER BY titulo";
                try ( Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
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

    public static Object[][] getDatosSerieFichero() {

        Object[][] obj = null;

        //leer fichero csv las series del fichero csv
        //meterlo en el jtable
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Proyectos\\PelisSeries\\Datos Forms\\Serievista.csv")); //abrimos fichero datos.csv para lectura
            try ( CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1) //que no lea la primera linea
                    .build();) { //construyo el CSVReader
                String[] fila;  //para leer cada fila, lo metemos en un campo
                int j = 0;  //iniciamos fila a 0 que luego usamos en el fori
                int numCols = 4; //nº de columnas
                obj = new Object[15][numCols]; //objeto de 15*4
                while ((fila = csvReader.readNext()) != null) {  //mientras haya lineas...
                    for (int i = 1; i < 5; i++) {
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

//publica primera fila
    public static String[] getColumnasSeriesVistas() {
        return new String[]{"ID Serie", "Título Serie", "Temporada", "Capítulos", "Fecha Vista"};
    }

//publica primera fila series Fichero
    public static String[] getColumnasSeriesFichero() {
        return new String[]{"Título Serie", "Temporada", "Capítulos", "Fecha Vista"};
    }

    //buscar serie por titulo
    public static boolean getDatosSeriesPorTitulo(String tituloSerie) {

        boolean existe = false;

        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT * FROM series WHERE titulo= '" + tituloSerie +"'";
                
                try ( Statement st = con.createStatement();) {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        if (tituloSerie.equals(rs.getString("titulo"))) {
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

    //compara si la serie de la BD es menor que la serie del fichero
    public static boolean necesitaActualizarSerie(String tituloSerie, String tempSerie, String capiSerie){
        
        boolean menor = false;
        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con == null) {
                System.out.println("Error conexión");
            } else {
                String sql = "SELECT titulo, temporada, capitulo FROM series WHERE titulo= '" + tituloSerie +"'";
                
                try ( Statement st = con.createStatement();) {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        if (tituloSerie.equals(rs.getString("titulo"))) { //encontramos la serie
                            if (((tempSerie.compareTo(String.valueOf(rs.getInt("temporada")))) <= 0) &&
                               ((capiSerie.compareTo(String.valueOf(rs.getInt("capitulo")))) <= 0))
                            {
                                menor = true;                                
                            }
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
        
        return menor;
    }
    
    //actualiza serie
    public static boolean updateSerieBD(series serie) {

        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "UPDATE series SET temporada = '" + serie.getTemporada() +                    
                    "', capitulo = '" + serie.getCapitulo() + 
                    "', fecha_serievista = '" + serie.getFecha() + 
                    "' where titulo = '" + serie.getTitulo() +"'";

            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
    
    //insertar nueva serie desde CSV
    public static boolean insertNuevaSerieCSV(series serie) {

        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "INSERT INTO series (titulo,temporada,capitulo,fecha_serievista) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, serie.getTitulo());
            ps.setInt(2, serie.getTemporada());
            ps.setInt(3, serie.getCapitulo());
            ps.setString(4, serie.getFecha());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
    
    //borrar serie
    public static boolean serieBorrar(int codigo) {
        
        try ( Connection con = new ConexionBD().conectarBD();) {
            String sql = "DELETE FROM series where codigo = (?)";

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
}
