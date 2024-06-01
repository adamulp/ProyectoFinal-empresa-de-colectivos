/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpresaDeColectivo.Entidades;

/**
 *
 * @author Allendez, Casalengo, Hollmann, Rigg
 */
public class Pasajero {
    private int idPasajero;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    private boolean estado;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String dni, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}

/*
Pasajeros
----------
ID_Pasajero : (INT, PK)
Nombre: (VARCHAR)
Apellido : (VARCHAR)
DNI: (VARCHAR)
Correo: (VARCHAR)
Teléfono: (VARCHAR)
Estado: (TinyInt)
*/
