package EmpresaDeColectivo.Entidades;

import java.time.LocalTime;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Horario {
    private int idHorario;
    private int idRuta;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private boolean estado;

    public Horario() {
    }

    public Horario(int idRuta, LocalTime horaSalida, LocalTime horaLlegada, boolean estado) {
        this.idRuta = idRuta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
    }

    public Horario(int idRuta, LocalTime horaSalida, LocalTime horaLlegada) {
        this(idRuta, horaSalida, horaLlegada, true);
    }

    public int getIdHorario() {
        return idHorario;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
/*
Horarios
---------
ID_Horario (INT, PK)
ID_Ruta (INT, FK)
Hora_Salida (TIME)
Hora_Llegada (TIME)
Estado(TINYINT)
*/