package vistas.jtabla;

/**
 *
 * @author adam
 */
public class FilaSeccion {
    protected int clavePrimaria;
    protected Object[] datosFila;

    public FilaSeccion(int clavePrimaria, Object[] datosFila) {
        this.clavePrimaria = clavePrimaria;
        this.datosFila = datosFila;
    }

    public int getClavePrimaria() {
        return clavePrimaria;
    }

    public Object[] getDatosFila() {
        return datosFila;
    }
}

