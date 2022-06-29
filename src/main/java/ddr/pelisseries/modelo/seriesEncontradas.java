/*
 * Clase extendida de la clase series.java
 * Clase que modela las series encontradas en la BBDD de TMDB api.
 * Se usa para obtener una series buscada en la BBDD de TMDB api en la vista GUISBuscarPeli
 */
package ddr.pelisseries.modelo;

/**
 *
 * @author Dany
 */
public class seriesEncontradas extends series {
    
    int idSerie;
    String urlPoster = "https://image.tmdb.org/t/p/w500";
    
    public seriesEncontradas(String titulo, String fechaestreno, int idSerie) {
        this.idSerie = idSerie;
        this.titulo = titulo;
        this.estreno = fechaestreno;
        this.codigo = codigo++ ;
    }

    public seriesEncontradas() {
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
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
