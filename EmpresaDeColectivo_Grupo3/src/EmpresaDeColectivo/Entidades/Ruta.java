package EmpresaDeColectivo.Entidades;

import java.time.Duration;


/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Ruta {
    private int idRuta;
    private String origen;
    private String destino;
    private Duration duracionEstimada;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(String origen, String destino, Duration duracionEstimada, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
    }

    public Ruta(String origen, String destino, Duration duracionEstimada) {
        this(origen, destino, duracionEstimada, true);
    }

    public int getIdRuta() {
        return idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Duration getDuracionEstimada() {
        return duracionEstimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDuracionEstimada(Duration duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return origen + " a " + destino;
    }
    
    
    
    
    
    
}
/*
Rutas
------
ID_Ruta (INT, PK)
Origen (VARCHAR)
Destino (VARCHAR)
Duración_Estimada (TIME)
Estado(BOOLEAN)
*/