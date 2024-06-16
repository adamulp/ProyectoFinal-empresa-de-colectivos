package vistas.jtabla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeccionTabla {
    protected String nombreSeccion;
    protected String nombreTabla;
    protected List<String> nombresColumnas = new ArrayList<>();
    protected List<ColumnaData> columnasConfiguracion = new ArrayList<>();
    protected List<FilaSeccion> filas = new ArrayList<>();
    protected int columnaInicio;

    public SeccionTabla(String nombreSeccion, String nombreTabla) {
        this.nombreSeccion = nombreSeccion;
        this.nombreTabla = nombreTabla;
    }

    public void agregarColumna(ColumnaData columna) {
        nombresColumnas.add(columna.getNombreColumna());
        columnasConfiguracion.add(columna);
    }

    public void agregarFila(int clavePrimaria, Object[] filaDatos) {
        FilaSeccion fila = new FilaSeccion(clavePrimaria, filaDatos);
        filas.add(fila);
    }

    public List<String> getNombresColumnas() {
        return nombresColumnas;
    }

    public List<ColumnaData> getColumnasConfiguracion() {
        return columnasConfiguracion;
    }

    public List<FilaSeccion> getFilas() {
        return filas;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public int getColumnaInicio() {
        return columnaInicio;
    }

    public void setColumnaInicio(int columnaInicio) {
        this.columnaInicio = columnaInicio;
    }
}
