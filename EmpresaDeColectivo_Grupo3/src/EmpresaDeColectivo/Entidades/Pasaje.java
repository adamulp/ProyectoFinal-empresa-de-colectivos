package EmpresaDeColectivo.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Pasaje {
    private int idPasaje;
    private int idPasajero;
    private int idColectivo;
    private int idRuta;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }

    public Pasaje(int idPasajero, int idColectivo, int idRuta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.idPasajero = idPasajero;
        this.idColectivo = idColectivo;
        this.idRuta = idRuta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public int getIdColectivo() {
        return idColectivo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public LocalTime getHoraViaje() {
        return horaViaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public void setHoraViaje(LocalTime horaViaje) {
        this.horaViaje = horaViaje;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
}
/*
Pasajes
--------
ID_Pasaje (INT, PK)
ID_Pasajero (INT, FK)
ID_Colectivo (INT, FK)
ID_Ruta (INT, FK)
Fecha_Viaje (DATE)
Hora_Viaje (TIME)
Asiento (INT)
Precio (DECIMAL)
*/
