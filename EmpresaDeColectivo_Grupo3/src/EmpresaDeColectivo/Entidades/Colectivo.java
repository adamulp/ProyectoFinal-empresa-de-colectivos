package EmpresaDeColectivo.Entidades;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Colectivo {
    private int idColectivo;
    private String matricula;
    private String marca;
    private String modelo;
    private int capacidad;
    private boolean estado;

    public Colectivo() {
    }

    public Colectivo(String matricula, String marca, String modelo, int capacidad, boolean estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdColectivo() {
        return idColectivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean estaActivo() {
        return estado;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void venderPasaje(){
        this.capacidad--;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return marca + " " +  modelo + " " + matricula;
    }
    
    
    
}
/*
Colectivos
----------
ID_Colectivo (INT, PK)
Matrícula (VARCHAR)
Marca (VARCHAR)
Modelo (VARCHAR)
Capacidad (INT)
Estado(TinyInt)
*/