package vistas.jtabla;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
    
    public int getClavePrimariaDeFila(int indiceFila) {
        for (SeccionTabla seccion : secciones) {
            List<FilaSeccion> filas = seccion.getFilas();
            if (indiceFila < filas.size()) {
                FilaSeccion fila = filas.get(indiceFila);
                return fila.getClavePrimaria();
            }
        }
        return -1;
    }

    public void eliminarFila(int indiceFila) {
        for (SeccionTabla seccion : secciones) {
            List<FilaSeccion> filas = seccion.getFilas();
            if (indiceFila < filas.size()) {
                filas.remove(indiceFila);
            }
        }

        totalFilas = 0;
        for (SeccionTabla seccion : secciones) {
            totalFilas = Math.max(totalFilas, seccion.getFilas().size());
        }
        fireTableRowsDeleted(indiceFila, indiceFila);
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
