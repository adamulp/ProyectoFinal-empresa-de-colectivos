package vistas.jtabla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeccionTabla {
    protected String nombreSeccion;
    protected String nombreTabla;
    protected List<String> nombresColumnas = new ArrayList<>();
    protected List<FormularioData> columnasConfiguracion = new ArrayList<>();
    protected List<FilaSeccion> filas = new ArrayList<>();
    protected int columnaInicio;
    

    public SeccionTabla(String nombreSeccion, String nombreTabla) {
        this.nombreSeccion = nombreSeccion;
        this.nombreTabla = nombreTabla;
    }
    
    public void agregarColumna(FormularioData columna) {
        nombresColumnas.add(columna.getNombreColumna());
        columnasConfiguracion.add(columna);
    }
    
    public void agregarColumna(String nombreColumna){
        agregarColumna(new FormularioData(nombreColumna));
    }
    
    public void agregarColumna(String nombreColumna, Object campoGUI, boolean editable){
        agregarColumna(new FormularioData(nombreColumna, campoGUI, editable));
    }
    
    public void agregarColumna(String nombreColumna, Object campoGUI,
            boolean editable, List<Object> listaInicial){
        agregarColumna(new FormularioData(
                nombreColumna,
                campoGUI, 
                editable,
                listaInicial
        ));
    }
    
    public FormularioData getFormularioData(Object campoGUI){
        for(FormularioData columna : this.columnasConfiguracion){
            if(columna.getCampoGUI().equals(campoGUI)){
                return columna;
            }
        }
        return null;
    }
    
    public void agregarFila(int clavePrimaria, Object[] filaDatos) {
        FilaSeccion fila = new FilaSeccion(clavePrimaria, filaDatos);
        filas.add(fila);
    }

    public List<String> getNombresColumnas() {
        return nombresColumnas;
    }

    public List<FormularioData> getColumnasConfiguracion() {
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
