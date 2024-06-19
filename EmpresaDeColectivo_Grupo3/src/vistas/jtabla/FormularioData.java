package vistas.jtabla;


import javax.swing.JComponent;


public class FormularioData {
    private String nombreColumna;
    private Object campoGUI;
    private boolean habilitado;
    private String tipoCampo;

    public FormularioData(String nombreColumna, Object campoGUI, boolean habilitado) {
        this.nombreColumna = nombreColumna;
        this.campoGUI = campoGUI;
        this.habilitado = habilitado;
        this.tipoCampo = campoGUI.getClass().getSimpleName(); // Get the type of the component
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public Object getCampoGUI() {
        return campoGUI;
    }

    public boolean esEditable() {
        return habilitado;
    }
    
    public String tipoCampo(){
        return tipoCampo;
    }
    
    public static String tipoCampo(JComponent campo){
        return campo.getClass().getSimpleName();
    }
}
