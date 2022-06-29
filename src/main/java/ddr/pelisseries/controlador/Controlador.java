package ddr.pelisseries.controlador;

import ddr.pelisseries.modelo.ConexionBD;
import ddr.pelisseries.modelo.peliculasBD;
import ddr.pelisseries.modelo.seriesBD;
import java.sql.Connection;

public class Controlador {

//recuperar listado pelis
    public static Object[][] getDatosPelisVistas() {
        Object[][] datos = peliculasBD.getDatosPelisVistas();
        
        return datos;
    }
    
//recuperar listado series
    public static Object[][] getDatosSeriesVistas() {
        Object[][] datos = seriesBD.getDatosSeriesVistas();
        
        return datos;
    }

//recuperar listado series de fichero
    public static Object[][] getDatosSerieFichero() {
        Object[][] datos = seriesBD.getDatosSerieFichero();
        
        return datos;
    }

//recuperar listado pelis de fichero
    public static Object[][] getDatosPelisFichero() {
        Object[][] datos = peliculasBD.getDatosPelisFichero();
        
        return datos;
    }    
    
//publica fila1 con el titulo de las columnas  
    public static String[] getColumnasPelisVistas() {
        String [] columnas;
        columnas=peliculasBD.getColumnasPelisVistas();
        return columnas;
    }

//publica fila1 con el titulo de las columnas  
    public static String[] getColumnasSeriesVistas() {
        String [] columnas;
        columnas=seriesBD.getColumnasSeriesVistas();
        return columnas;
    }   
    
//publica fila1 con el titulo de las columnas Series Fichero 
    public static String[] getColumnasSeriesFichero() {
        String [] columnas;
        columnas=seriesBD.getColumnasSeriesFichero();
        return columnas;
    }    

//publica fila1 con el titulo de las columnas Pelis Fichero 
    public static String[] getColumnasPelisFichero() {
        String [] columnas;
        columnas=peliculasBD.getColumnasPelisFichero();
        return columnas;
    }      
    
    //controlar insercción de nueva peli
    public static boolean insertNuevaPeliBD(ddr.pelisseries.modelo.peliculas pelicula) {

        boolean response = false;

        response = peliculasBD.insertNuevaPeliBD(pelicula);

        return response;
    }
    
    //controlar insercción de nueva serie
    public static boolean insertNuevaSerieBD(ddr.pelisseries.modelo.series serie) {

        boolean response = false;

        response = seriesBD.insertNuevaSerieBD(serie);

        return response;
    }
    
    //controlar actualización de serie desde fichero
    public static boolean updateSerieBD(ddr.pelisseries.modelo.series serie) {

        boolean response = false;

        response = seriesBD.updateSerieBD(serie);

        return response;
    }
    
    //controlar insercción de nueva serie desde CSV
    public static boolean insertNuevaSerieCSV(ddr.pelisseries.modelo.series serie) {

        boolean response = false;

        response = seriesBD.insertNuevaSerieCSV(serie);

        return response;
    }

    //controlar insercción de nueva peli desde CSV
    public static boolean insertNuevaPeliCSV(ddr.pelisseries.modelo.peliculas peli) {

        boolean response = false;

        response = peliculasBD.insertNuevaPeliCSV(peli);

        return response;
    }    
    
    //controlar seleccion de serie
    public static boolean serieBorrar(int codigo) {

        boolean response = false;

        response = seriesBD.serieBorrar(codigo);

        return response;
    }   
    
    //controlar seleccion de pelicula
    public static boolean peliculaBorrar(int codigo) {

        boolean response = false;

        response = peliculasBD.peliculaBorrar(codigo);

        return response;
    }   

    public static boolean validarConexiónBBDD() {

        try ( Connection con = new ConexionBD().conectarBD();) {
            if (con != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }

    }

}
