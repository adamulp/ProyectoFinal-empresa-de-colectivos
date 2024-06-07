package accesoADatos;

import EmpresaDeColectivo.Entidades.Pasajero;
import java.beans.Statement;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adam, enzo, alexis, nicolas
 */
public class PasajeroData {
    private Connection con = null;

    public PasajeroData() {
        con = (Connection) Conexion.getConexion();
    }
    
    public void guardarPasajero(Pasajero pasajero){
        String sql = "INSERT INTO  pasajeros (Nombre, Apellido, DNI, Correo, Telefono, Estado)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, pasajero.isEstado());
            
            ResultSet rs =ps.getGeneratedKeys();
            if(rs.next()) {
                pasajero.setIdPasajero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasajero añadido con éxito.");
            }
             
            ps.close();
 
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder a la tabla Pasajero. Mensaje SQLException: "
                    + ex.getMessage());
        }
    }
    
}
