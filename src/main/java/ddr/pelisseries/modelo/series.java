/*
 * Clase que modela las series
 */
package ddr.pelisseries.modelo;

import java.util.Objects;

/**
 *
 * @author Dany
 */
public class series implements Comparable<series> {
    
    String titulo;
    int temporada;
    int capitulo;
    String fecha;
    String estreno;
    int codigo = 0;

    public series(String titulo, int temporada, int capitulo, String fecha, String estreno) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.capitulo = capitulo;
        this.estreno = estreno;
        this.fecha = fecha;
        this.codigo = codigo++ ;
    }
    
    public series(String titulo, int temporada, int capitulo, String fecha) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.capitulo = capitulo;
        this.fecha = fecha;
        this.codigo = codigo++ ;
    }

    public series() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
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
        return "series{" + "titulo=" + titulo + ", temporada=" + temporada + ", capitulo=" + capitulo + ", fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object otraSerie) {
        if (this == otraSerie) {
            return true;
        }
        if (otraSerie == null) {
            return false;
        }
        if (getClass() != otraSerie.getClass()) {
            return false;
        }
        final series other = (series) otraSerie;
        if (this.temporada != other.temporada) {
            return false;
        }
        if (this.capitulo != other.capitulo) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }
    
    //comparamos por título --> orden natural
    @Override
    public int compareTo(series otra) {
        return this.titulo.compareTo(otra.titulo);
    }
    
}
