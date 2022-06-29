/*
 * Clase extendida de la clase peliculas.java
 * Clase que modela las películas obtenidas del fichero de carga.
 */
package ddr.pelisseries.modelo;

/**
 *
 * @author Dany
 */
public class peliculasFichero extends peliculas{
        
    public peliculasFichero(String titulo, String fechaEstreno) {
        this.titulo = titulo;
        this.estreno = fechaEstreno;
        this.codigo = codigo++;
    }

    @Override
    public String toString() {
        return titulo + " - (Estreno: " + estreno + " )";
    }
    
    
    
}
