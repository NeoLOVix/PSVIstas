/*
 * Clase extendida de la clase series.java
 * Clase que modela las series obtenidas del fichero de carga.
 */
package ddr.pelisseries.modelo;

/**
 *
 * @author Dany
 */
public class seriesFichero extends series {
    
    private String marcaTemporal;
    
    private String tituloPrevio;
    
    private int temporadaPrevio;
    
    private int capituloPrevio;
    
    private String fechaPrevio;
        
    seriesFichero() {
        this.capituloPrevio = capituloPrevio;
        this.temporadaPrevio = temporadaPrevio;
        this.tituloPrevio = tituloPrevio;
        this.fechaPrevio = fechaPrevio;
               
    }
    public String getMarcaTemporal() {
        return marcaTemporal;
    }

    public void setMarcaTemporal(String marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public String getTituloPrevio() {
        return tituloPrevio;
    }

    public void setTituloPrevio(String tituloPrevio) {
        this.tituloPrevio = tituloPrevio;
    }

    public int getTemporadaPrevio() {
        return temporadaPrevio;
    }

    public void setTemporadaPrevio(int temporadaPrevio) {
        this.temporadaPrevio = temporadaPrevio;
    }

    public int getCapituloPrevio() {
        return capituloPrevio;
    }

    public void setCapituloPrevio(int capituloPrevio) {
        this.capituloPrevio = capituloPrevio;
    }

    public String getFechaPrevio() {
        return fechaPrevio;
    }

    public void setFechaPrevio(String fechaPrevio) {
        this.fechaPrevio = fechaPrevio;
    }

    @Override
    public String toString() {
        return "seriesFichero{" + "marcaTemporal=" + marcaTemporal + ", tituloPrevio=" + tituloPrevio + ", temporadaPrevio=" + temporadaPrevio + ", capituloPrevio=" + capituloPrevio + ", fechaPrevio=" + fechaPrevio + '}';
    }

    
    
    
}
