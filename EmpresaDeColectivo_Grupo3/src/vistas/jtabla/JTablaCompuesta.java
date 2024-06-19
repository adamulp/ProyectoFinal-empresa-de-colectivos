package vistas.jtabla;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class JTablaCompuesta extends JTable {

    private ModeloTablaCompuesta modelo;
    private MouseListener suprimirMouse;
    private Color fondoCampoDeshabilitado;
    private Color textoCampoDeshabilitado;
    
    public JTablaCompuesta(ModeloTablaCompuesta modelo) {
        super(modelo);
        this.modelo = modelo;
        this.fondoCampoDeshabilitado = Color.decode("#E0E0E0");
        this.textoCampoDeshabilitado = Color.decode("#0F0F0F");
        
        this.suprimirMouse = new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    e.consume();
                                }

                                @Override
                                public void mousePressed(MouseEvent e) {
                                    e.consume();
                                }
                            };
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
                        Date fecha = Date.from(((LocalDate) valor).atStartOfDay(ZoneId.systemDefault()).toInstant());
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
                        ((JButton) columna.getCampoGUI()).setEnabled(columna.esEditable());
                        break;
                    case "JCheckBox":
                        System.out.println("JTablaCompuesta::JCheckBox Stub: Unsupported/future behavior");
                        break;
                    case "JComboBox":
                        ((JComboBox<?>) columna.getCampoGUI()).setSelectedItem(valor);
                        ((JComboBox<?>) columna.getCampoGUI()).setEnabled(columna.esEditable());
                        break;
                    case "JList":
                        ((JList<?>) columna.getCampoGUI()).setSelectedValue(valor, true);
                        ((JList<?>) columna.getCampoGUI()).setEnabled(columna.esEditable());
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
                        JTextField textField = ((JTextField) columna.getCampoGUI());
                        textField.setText(valor.toString());
                        if (!columna.esEditable()) {
                            textField.setBackground(fondoCampoDeshabilitado);
                            textField.setForeground(textoCampoDeshabilitado);
                            textField.setHighlighter(null);
                            textField.setCaretColor(fondoCampoDeshabilitado);
                            textField.setCaretPosition(textField.getText().length());
                            textField.addMouseListener(suprimirMouse);
                        } else {
                            textField.setBackground(null);
                            textField.setForeground(null);
                            Highlighter highlighter = new DefaultHighlighter();
                            textField.setHighlighter(highlighter);
                            Highlighter.HighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                            textField.setCaretPosition(0);
                            textField.setCaretColor(null);
                            textField.removeMouseListener(suprimirMouse);
                        }
                        textField.setEditable(columna.esEditable());

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

    public void setFondoCampoDeshabilitado(Color fondoCampoDeshabilitado) {
        this.fondoCampoDeshabilitado = fondoCampoDeshabilitado;
    }

    public void setTextoCampoDeshabilitado(Color textoCampoDeshabilitado) {
        this.textoCampoDeshabilitado = textoCampoDeshabilitado;
    }
    
}
