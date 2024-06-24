package vistas.jtabla;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;


public class FormularioData {
    private String nombreColumna;
    private Object campoGUI;
    private boolean habilitado;
    private String tipoCampo;
    private ArrayList<Object> listaValores;

    public FormularioData(String nombreColumna, Object campoGUI, boolean habilitado) {
        this.nombreColumna = nombreColumna;
        this.campoGUI = campoGUI;
        this.habilitado = habilitado;
        this.tipoCampo = campoGUI.getClass().getSimpleName(); // Get the type of the component
    }
    
    public FormularioData(
            String nombreColumna,
            Object campoGUI,
            boolean habilitado,
            List<Object> listaInicial
            ){
        this(nombreColumna, campoGUI, habilitado);
        this.listaValores = listaInicial;
    }
    
    public boolean tieneListaDeValores(){
        if(this.listaValores != null){
            return true;
        }
        return false;
    }
    
    public boolean listaContiene(Object valor){
        if(this.listaValores != null){
            if(this.listaValores.contains(valor)){
                return true;
            }
        }
        return false;
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
