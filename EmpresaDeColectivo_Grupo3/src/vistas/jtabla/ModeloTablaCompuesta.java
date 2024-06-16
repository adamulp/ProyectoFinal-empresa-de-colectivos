package vistas.jtabla;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaCompuesta extends AbstractTableModel {
    protected List<SeccionTabla> secciones = new ArrayList<>();
    protected int totalColumnas = 0;
    protected int totalFilas = 0;

    public void agregarSeccion(SeccionTabla seccion) {
        seccion.setColumnaInicio(totalColumnas);
        secciones.add(seccion);
        totalColumnas += seccion.getNombresColumnas().size();
        totalFilas = Math.max(totalFilas, seccion.getFilas().size());
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return totalFilas;
    }

    @Override
    public int getColumnCount() {
        return totalColumnas;
    }

    @Override
    public String getColumnName(int column) {
        for (SeccionTabla seccion : secciones) {
            if (column >= seccion.getColumnaInicio()
                    && column < seccion.getColumnaInicio() + seccion.getNombresColumnas().size()) {
                int sectionColumnIndex = column - seccion.getColumnaInicio();
                return seccion.getNombresColumnas().get(sectionColumnIndex);
            }
        }
        return super.getColumnName(column);
    }

    @Override
    public Object getValueAt(int indiceFila, int indiceColumna) {
        for (SeccionTabla seccion : secciones) {
            int columnStart = seccion.getColumnaInicio();
            int columnEnd = columnStart + seccion.getNombresColumnas().size();
            if (indiceColumna >= columnStart && indiceColumna < columnEnd) {
                List<FilaSeccion> filas = seccion.getFilas();
                if (indiceFila < filas.size()) {
                    FilaSeccion fila = filas.get(indiceFila);
                    int sectionColumnIndex = indiceColumna - columnStart;
                    return fila.datosFila[sectionColumnIndex];
                }
            }
        }
        return null;
    }
}
