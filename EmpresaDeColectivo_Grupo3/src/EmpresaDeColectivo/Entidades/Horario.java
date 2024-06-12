package EmpresaDeColectivo.Entidades;

import java.time.LocalTime;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Horario {
    private int idHorario;
    private Ruta ruta;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private boolean estado;

    public Horario() {
    }
    
    public Horario(Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada, boolean estado) {
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
    }
   
    public Horario(Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada) {
        this(ruta, horaSalida, horaLlegada, true);
    }

    public int getIdHorario() {
        return idHorario;
    }
    
    public Ruta getRuta(){
        return this.ruta;
    }

    public int getIdRuta() {
        return this.ruta.getIdRuta();
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

    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
    public void setIdRuta(int idRuta) {
        this.ruta.setIdRuta(idRuta);
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

    @Override
    public String toString() {
        if(horaSalida == null && horaLlegada == null){
            return "Indeterminado";
        }
        if(horaSalida != null){
            if(horaLlegada == null){
                return horaSalida + "";
            }
        }
        if(horaLlegada != null){
            if(horaSalida == null){
                return horaLlegada + "";
            }
        }
        return horaSalida + " a " + horaLlegada;

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