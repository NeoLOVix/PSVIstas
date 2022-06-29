/*
 * Clase que modela las películas
 */
package ddr.pelisseries.modelo;

/**
 *
 * @author Dany
 */
public class peliculas {
    
    String titulo;
    String fecha;
    String estreno;
    int codigo = 0;

    public peliculas(String titulo, String fecha, String estreno) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.estreno = estreno;
        this.codigo = codigo++;
    }
    
    public peliculas(int codigo, String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    public peliculas(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }    
    
    public peliculas (){        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    @Override
    public String toString() {
        return "peliculas{" + "titulo=" + titulo + ", fecha=" + fecha + '}';
    }
    
    
    
}
