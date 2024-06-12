package EmpresaDeColectivo.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Pasaje {
    private int idPasaje;
    private Pasajero pasajero;
    private Colectivo colectivo;
    private Ruta ruta;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }
    
    public Pasaje(Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
    }

    public Pasaje(int idPasaje, Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }
  
    public int getIdPasaje() {
        return idPasaje;
    }
    // Getters de Pasajeros --------------------------------------------------------
    public Pasajero getPasajero() {
        return pasajero;
    }
    public int getIdPasajero() {
        return pasajero.getIdPasajero();
    }
    // Getters de Colectivo --------------------------------------------------------
    public Colectivo getColectivo() {
        return colectivo;
    }
    public int getIdColectivo() {
        return colectivo.getIdColectivo();
    }
    // Getters de Ruta --------------------------------------------------------
    public Ruta getRuta() {
        return ruta;
    }
    public int getIdRuta() {
        return ruta.getIdRuta();
    }


// Getters de Pasaje --------------------------------------------------------
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
// Setters --------------------------------------------------------

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
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

    @Override
    public String toString() {
        return fechaViaje + " " + horaViaje + " " + asiento + " " + precio;
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
