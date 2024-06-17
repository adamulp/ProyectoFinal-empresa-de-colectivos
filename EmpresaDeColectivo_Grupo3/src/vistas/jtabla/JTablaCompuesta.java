package vistas.jtabla;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JTablaCompuesta extends JTable {
    private ModeloTablaCompuesta modelo;

    public JTablaCompuesta(ModeloTablaCompuesta modelo) {
        super(modelo);
        this.modelo = modelo;
        addSelectionListener();
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

    public void actualizarCampos(int selectedRow) {
        for (SeccionTabla seccion : modelo.secciones) {
            for (FormularioData columna : seccion.getColumnasConfiguracion()) {
                int colIndex = seccion.getNombresColumnas().indexOf(columna.getNombreColumna());
                Object valor = modelo.getValueAt(selectedRow, seccion.getColumnaInicio() + colIndex);

                switch (columna.tipoCampo()) {
                    case "JDateChooser":
                        Date fecha = Date.from(((LocalDate)valor).atStartOfDay(ZoneId.systemDefault()).toInstant());
                        ((JDateChooser) columna.getCampoGUI()).setDate(fecha);
                        break;
                    case "JPanel":
                        System.out.println("JTablaCompuesta::JPanel Stub: Unsupported/future behavior");
                        break;
                    case "JInternalFrame":
                        System.out.println("JTablaCompuesta::JInternalFrame Stub: Unsupported/future behavior");
                        break;
                    case "JLabel":
                        ((JLabel) columna.getCampoGUI()).setText(valor.toString());
                        break;
                    case "JButton":
                        System.out.println("JTablaCompuesta::JButton Stub: Unsupported/future behavior");
                        break;
                    case "JCheckBox":
                        System.out.println("JTablaCompuesta::JCheckBox Stub: Unsupported/future behavior");
                        break;
                    case "JComboBox":
                        ((JComboBox<?>) columna.getCampoGUI()).setSelectedItem(valor);
                        break;
                    case "JList":
                        ((JList<?>) columna.getCampoGUI()).setSelectedValue(valor, true);
                        break;
                    case "JRadioButton":
                        System.out.println("JTablaCompuesta::JRadioButton Stub: Unsupported/future behavior");
                        break;
                    case "JScrollPane":
                        System.out.println("JTablaCompuesta::JScrollPane Stub: Unsupported/future behavior");
                        break;
                    case "JTextArea":
                        ((JTextArea) columna.getCampoGUI()).setText(valor.toString());
                        break;
                    case "JTextField":
                        ((JTextField) columna.getCampoGUI()).setText(valor.toString());
                        break;
                    case "JTree":
                        System.out.println("JTablaCompuesta::JTree Stub: Unsupported/future behavior");
                        break;
                    default:
                        System.out.println("JTablaCompuesta ---" + columna.tipoCampo() + ": Unplanned/unsupported behavior");
                        break;
                }
            }
        }
    }
}
