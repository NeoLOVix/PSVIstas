/*
 * Clase extendida de la clase peliculas.java
 * Clase que modela las películas encontradas en la BBDD de TMDB api.
 * Se usa para obtener una pelicula buscada en la BBDD de TMDB api en la vista GUISBuscarPeli
 */
package ddr.pelisseries.modelo;

/**
 *
 * @author Dany
 */
public class peliculasEncontradas extends peliculas{
    
    int idPeli;
    String urlPoster = "https://image.tmdb.org/t/p/w500";
        
    public peliculasEncontradas(String titulo, String fechaEstreno, int idPeli) {
        this.idPeli = idPeli;
        this.titulo = titulo;
        this.estreno = fechaEstreno;
        this.codigo = codigo++;
    }

    public int getIdPeli() {
        return idPeli;
    }

    public void setIdPeli(int idPeli) {
        this.idPeli = idPeli;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = this.urlPoster.concat(urlPoster);
    }

    @Override
    public String toString() {
        return titulo + " - (Estreno: " + estreno + " )";
    }
    
    
    
}
