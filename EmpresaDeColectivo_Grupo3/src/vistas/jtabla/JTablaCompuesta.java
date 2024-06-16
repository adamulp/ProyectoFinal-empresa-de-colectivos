package vistas.jtabla;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class JTablaCompuesta extends JTable {
    private ModeloTablaCompuesta modelo;
    private Map<String, Object[]> camposSeccion;
    private Map<String, Integer> columnasInicioSeccion;

    public JTablaCompuesta(ModeloTablaCompuesta modelo) {
        super(modelo);
        this.modelo = modelo;
        camposSeccion = new HashMap<>();
        columnasInicioSeccion = new HashMap<>();

        // Add selection listener to respond to table selection changes
        ListSelectionModel selectionModel = getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = getSelectedRow();
                    if (selectedRow != -1) {
                        actualizarCampos(selectedRow);
                    }
                }
            }
        });
    }

    public void agregarCamposSeccion(JPanel panel, SeccionTabla seccion, Object[] campos) {
        panel.add(new JLabel(seccion.getNombreSeccion())); // Etiqueta de la sección
        panel.add(new JLabel("")); // Espacio vacío
        for (int i = 0; i < campos.length; i++) {
            panel.add(new JLabel(seccion.getNombresColumnas().get(i)));
            ColumnaData columna = seccion.getColumnasConfiguracion().get(i);
            String tipoCampo = columna.getTipoCampo();
            switch (tipoCampo) {
                case "txt":
                    JTextField textField = new JTextField();
                    textField.setEditable(columna.esEditable());
                    campos[i] = textField;
                    break;
                case "btn":
                    JButton button = columna.getBoton();
                    button.setEnabled(columna.esEditable());
                    campos[i] = button;
                    break;
                case "JDateChooser":
                    JDateChooser dateChooser = new JDateChooser();
                    dateChooser.setSelectableDateRange(
                        columna.getRangoFechas().getStartDate(), 
                        columna.getRangoFechas().getEndDate()
                    );
                    campos[i] = dateChooser;
                    break;
                case "cmb":
                    JComboBox<Object> comboBox = new JComboBox<>(columna.getValoresComboBox().toArray());
                    comboBox.setEnabled(columna.esEditable());
                    campos[i] = comboBox;
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de campo no soportado: " + tipoCampo);
            }
            panel.add((JComponent) campos[i]);
        }
        camposSeccion.put(seccion.getNombreSeccion(), campos);
        columnasInicioSeccion.put(seccion.getNombreSeccion(), seccion.getColumnaInicio());
    }

    public void setCamposSeccion(Map<String, Object[]> camposSeccion, Map<String, Integer> columnasInicioSeccion) {
        this.camposSeccion = camposSeccion;
        this.columnasInicioSeccion = columnasInicioSeccion;

        // Notify the table that data has changed
        modelo.fireTableDataChanged();
    }

    private void actualizarCampos(int selectedRow) {
        for (SeccionTabla seccion : modelo.secciones) {
            Object[] campos = camposSeccion.get(seccion.getNombreSeccion());
            if (campos != null) {
                for (int i = 0; i < campos.length; i++) {
                    Object valor = modelo.getValueAt(selectedRow, seccion.getColumnaInicio() + i);
                    if (campos[i] instanceof JTextField) {
                        ((JTextField) campos[i]).setText(valor != null ? valor.toString() : "");
                    } else if (campos[i] instanceof JDateChooser) {
                        ((JDateChooser) campos[i]).setDate((Date) valor);
                    } else if (campos[i] instanceof JComboBox) {
                        ((JComboBox<Object>) campos[i]).setSelectedItem(valor);
                    } else if (campos[i] instanceof JButton) {
                        ((JButton) campos[i]).setEnabled(valor != null && valor.toString().equals("Expired"));
                    }
                }
            }
        }
    }
}
