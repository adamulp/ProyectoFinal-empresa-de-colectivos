package vistas.jtabla;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JButton;

public class JTablaCompuesta extends JTable {

    private ModeloTablaCompuesta modelo;
    private Map<String, Object[]> camposSeccion;
    private Map<String, Integer> columnasInicioSeccion;

    public JTablaCompuesta(ModeloTablaCompuesta modelo) {
        super(modelo);
        this.modelo = modelo;
        camposSeccion = new HashMap<>();
        columnasInicioSeccion = new HashMap<>();
        addSelectionListener();
    }

    public void setCamposSeccion(Map<String, Object[]> camposSeccion, Map<String, Integer> columnasInicioSeccion) {
        this.camposSeccion = camposSeccion;
        this.columnasInicioSeccion = columnasInicioSeccion;
        modelo.fireTableDataChanged();
    }

     public void actualizarCampos(int selectedRow) {
        for (SeccionTabla seccion : modelo.secciones) {
            for (FormularioData columna : seccion.getColumnasConfiguracion()) {
                JComponent campo = columna.getCampo();
                Object valor = modelo.getValueAt(selectedRow, seccion.getColumnaInicio() + seccion.getNombresColumnas().indexOf(columna.getNombreColumna()));

                switch (columna.getTipoCampo()) {
                    case "JDateChooser":
                        if (campo instanceof JDateChooser) {
                            ((JDateChooser) campo).setDate((Date) valor);
                        }
                        break;
                    case "JPanel":
                        System.out.println("JTablaCompuesta::JPanel Stub: Unsupported/future behavior");
                        break;
                    case "JInternalFrame":
                        System.out.println("JTablaCompuesta::JInternalFrame Stub: Unsupported/future behavior");
                        break;
                    case "JLabel":
                        if (campo instanceof JLabel) {
                            ((JLabel) campo).setText(valor != null ? valor.toString() : "");
                        }
                        break;
                    case "JButton":
                        System.out.println("JTablaCompuesta::JButton Stub: Unsupported/future behavior");
                        break;
                    case "JCheckBox":
                        System.out.println("JTablaCompuesta::JCheckBox Stub: Unsupported/future behavior");
                        break;
                    case "JComboBox":
                        if (campo instanceof JComboBox) {
                            ((JComboBox<Object>) campo).setSelectedItem(valor);
                        }
                        break;
                    case "JList":
                        if (campo instanceof JList) {
                            ((JList<Object>) campo).setSelectedValue(valor, true);
                        }
                        break;
                    case "JRadioButton":
                        System.out.println("JTablaCompuesta::JRadioButton Stub: Unsupported/future behavior");
                        break;
                    case "JScrollPane":
                        System.out.println("JTablaCompuesta::JScrollPane Stub: Unsupported/future behavior");
                        break;
                    case "JTextField":
                        if (campo instanceof JTextArea) {
                            ((JTextArea) campo).setText(valor != null ? valor.toString() : "");
                        }
                        break;
                    case "JTextArea":
                        if (campo instanceof JTextArea) {
                            ((JTextArea) campo).setText(valor != null ? valor.toString() : "");
                        }
                        break;
                    case "JTree":
                        System.out.println("JTablaCompuesta::JTree Stub: Unsupported/future behavior");
                        break;
                    default:
                        System.out.println("JTablaCompuesta --- " + columna.getTipoCampo() + ": Unplanned/unsupported behavior");
                        break;
                }
            }
        }
    }
     
    private void addSelectionListener() {
        this.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = getSelectedRow();
                    if (selectedRow >= 0) {
                        actualizarCampos(selectedRow);
                    }
                }
            }
        });
    }


}
