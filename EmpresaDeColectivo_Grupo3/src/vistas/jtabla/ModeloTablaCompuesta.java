package vistas.jtabla;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaCompuesta extends AbstractTableModel {

    protected List<SeccionTabla> secciones = new ArrayList<>();
    private int rowCount = 0;

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        int columnCount = 0;
        for (SeccionTabla seccion : secciones) {
            columnCount += seccion.getColumnasConfiguracion().size();
        }
        return columnCount;
    }

    @Override
    public String getColumnName(int columna) {
        for (SeccionTabla seccion : secciones) {
            if (columna >= seccion.columnaInicio
                    && columna < seccion.columnaInicio + seccion.getColumnasConfiguracion().size()) {
                return seccion.getColumnasConfiguracion().get(columna - seccion.columnaInicio).getNombreColumna();
            }
        }
        return "Desconocido";
    }

    @Override
    public Object getValueAt(int indiceFila, int indiceColumna) {
        for (SeccionTabla seccion : secciones) {
            if (indiceColumna >= seccion.getColumnaInicio()
                    && indiceColumna < seccion.getColumnaInicio() + seccion.getNombresColumnas().size()) {
                FilaSeccion fila = seccion.getFilas().get(indiceFila);
                int sectionColumnIndex = indiceColumna - seccion.getColumnaInicio();
                return fila.datosFila[sectionColumnIndex];
            }
        }
        return null;
    }

    public void agregarSeccion(SeccionTabla seccion) {
        seccion.columnaInicio = getColumnCount();
        secciones.add(seccion);
        if (!seccion.getFilas().isEmpty()) {
            rowCount = seccion.getFilas().size();
        }
        fireTableStructureChanged();
    }
}
