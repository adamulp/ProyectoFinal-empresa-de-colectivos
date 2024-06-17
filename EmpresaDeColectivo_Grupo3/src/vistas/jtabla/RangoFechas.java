package vistas.jtabla;

import java.util.Date;

/**
 *
 * @author adam
 */
public class RangoFechas {
    private Date fechaInicio;
    private Date fechaFin;

    public RangoFechas(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
}

