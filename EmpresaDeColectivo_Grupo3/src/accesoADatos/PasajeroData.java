package accesoADatos;

import EmpresaDeColectivo.Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
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
    
   public void modificarPasajero(Pasajero pasajero){
       String sql = "UPDATE pasajeros SET ID_Pasajero = ? , Nombre = ?, Apellido = ?, DNI = ?, Correo = ?,"
               + "Telefono = ?, Estado = ? WHERE ID_Pasajero = ? ";
       PreparedStatement ps = null;
       try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, pasajero.getIdPasajero());
           ps.setString(2, pasajero.getNombre());
           ps.setString(3, pasajero.getApellido());
           ps.setString(4, pasajero.getDni());
           ps.setString(5, pasajero.getCorreo());
           ps.setString(6, pasajero.getTelefono());
           ps.setBoolean(7, pasajero.isEstado());
           int exito = ps.executeUpdate();
           if (exito == 1){
               JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
           }else{
               JOptionPane.showMessageDialog(null, "el pasajero no existe.");
           }
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla de pasajeros" + ex.getMessage());
       }
   }
   
    public void eliminarPasajero(int id) {
        try {
            String sql = "UPDATE pasajeros SET Estado = 0 WHERE  ID_Pasajero = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó al pasajero correctamente.");
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajeros");
        }
    }
    
    public Pasajero buscarPasajeroPorDNI(int dni) {
        Pasajero pasajero = null;
        String sql = "SELECT ID_Pasajero, Nombre, Apellido, Correo, Telefono, Estado  "
                + "FROM pasajeros WHERE DNI = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID_Pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));
                pasajero.setEstado(rs.getBoolean("Estado"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Pasajero");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }
        return pasajero;
    }
    
     public Pasajero buscarPasajeroPorNomApe(String nomOApe) {
        Pasajero pasajero = null;
        String sql = "SELECT ID_Pasajero, Nombre, Apellido, DNI, Correo, Telefono, Estado  "
                + "FROM pasajeros WHERE Nombre = ? OR Apellido = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nomOApe);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID_Pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setDni(rs.getString("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));
                pasajero.setEstado(rs.getBoolean("Estado"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Pasajero");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }
        return pasajero;
    }
    
     public List<Pasajero> listarPasajeros() {
        List<Pasajero> pasajeros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Pasajeros WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("ID_Pasajero"));
                pasajero.setNombre(rs.getString("Nombre"));
                pasajero.setApellido(rs.getString("Apellido"));
                pasajero.setDni(rs.getString("DNI"));
                pasajero.setCorreo(rs.getString("Correo"));
                pasajero.setTelefono(rs.getString("Telefono"));
                pasajeros.add(pasajero);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajeros " + ex.getMessage());
        }
        return pasajeros;

    }
    
}
