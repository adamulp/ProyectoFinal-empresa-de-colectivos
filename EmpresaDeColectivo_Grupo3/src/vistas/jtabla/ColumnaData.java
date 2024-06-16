package vistas.jtabla;

/**
 *
 * @author adam
 */
import java.util.List;
import javax.swing.JButton;

public class ColumnaData {
    private String nombreColumna;
    private String tipoCampo;
    private boolean esEditable;
    private List<Object> valoresComboBox;
    private DateRange rangoFechas;
    private JButton boton;

    // Constructors
    public ColumnaData(String nombreColumna, String tipoCampo, boolean esEditable) {
        this.nombreColumna = nombreColumna;
        this.tipoCampo = tipoCampo;
        this.esEditable = esEditable;
    }

    public ColumnaData(String nombreColumna, List<Object> valoresComboBox) {
        this.nombreColumna = nombreColumna;
        this.tipoCampo = "cmb";
        this.valoresComboBox = valoresComboBox;
        this.esEditable = true;
    }

    public ColumnaData(String nombreColumna, DateRange rangoFechas) {
        this.nombreColumna = nombreColumna;
        this.tipoCampo = "JDateChooser";
        this.rangoFechas = rangoFechas;
        this.esEditable = true;
    }

    public ColumnaData(String nombreColumna, JButton boton, boolean esEditable) {
        this.nombreColumna = nombreColumna;
        this.tipoCampo = "btn";
        this.boton = boton;
        this.esEditable = esEditable;
    }

    // Getters and Setters
    public String getNombreColumna() {
        return nombreColumna;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public boolean esEditable() {
        return esEditable;
    }

    public List<Object> getValoresComboBox() {
        return valoresComboBox;
    }

    public DateRange getRangoFechas() {
        return rangoFechas;
    }

    public JButton getBoton() {
        return boton;
    }
}
