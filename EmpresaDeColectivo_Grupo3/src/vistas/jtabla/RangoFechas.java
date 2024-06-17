package vistas.jtabla;

import java.util.Date;

/**
 *
 * @author adam
 */
public class RangoFechas {
    private Date fechaInicio;
    private Date fechaFin;

    public RangoFechas(Date startDate, Date endDate) {
        this.fechaInicio = startDate;
        this.fechaFin = endDate;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
}

