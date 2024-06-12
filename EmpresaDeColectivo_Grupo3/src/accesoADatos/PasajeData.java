package accesoADatos;

import EmpresaDeColectivo.Entidades.Colectivo;
import EmpresaDeColectivo.Entidades.Pasaje;
import EmpresaDeColectivo.Entidades.Pasajero;
import EmpresaDeColectivo.Entidades.Ruta;
import java.sql.Connection;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PasajeData {
    
    private Connection con = null;

    public PasajeData() {
        con = Conexion.getConexion();
    }
     public void guardarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO pasajes (fecha_Viaje, hora_Viaje, asiento, precio) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(2, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(3, pasaje.getAsiento());
            ps.setDouble(4, pasaje.getPrecio());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pasaje.setIdPasaje(rs.getInt(1));
                JOptionPane.showMessageDialog(null,
                        "Pasaje añadido con exito.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder a la tabla Pasaje. Mensaje SQLException: "
                    + ex.getMessage());
        }
    }


     
   public Pasaje buscarPasaje(int idPasaje) {
    Pasaje pasaje = null;
    String sql = "SELECT ID_Pasajero, ID_Colectivo, ID_Ruta, Fecha_Viaje, Hora_Viaje, Asiento, Precio "
            + "FROM pasajes "
            + "WHERE idPasaje = ?";
    PasajeroData pasajeroData = new PasajeroData();
    ColectivoData colectivoData = new ColectivoData();
    RutaData rutaData = new RutaData();
    
    Pasajero pasajero = null;
    Ruta ruta = null;
    Colectivo colectivo = null;
    

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPasaje);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
           pasaje.setIdPasaje(idPasaje);
           
           pasajero = pasajeroData.buscarPasajero(rs.getInt("ID_Pasajero"));
           colectivo = colectivoData.buscarColectivo(rs.getInt("ID_Colectivo"));
           ruta = rutaData.buscarRuta(rs.getInt("ID_Ruta"));
           
           pasaje.setPasajero(pasajero);
           pasaje.setColectivo(colectivo);
           pasaje.setRuta(ruta);
           
           pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
           pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
           pasaje.setAsiento(rs.getInt("asiento"));
           pasaje.setPrecio(rs.getDouble("precio"));
           
        }else{
         JOptionPane.showMessageDialog(null, "No existe el pasaje");
        ps.close();
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
                "Error al acceder a la tabla Pasajes. Mensaje SQLException: "
                + ex.getMessage());
    }

    return pasaje;
   }
   
   
   public List<Pasaje> listarPasajes() {
        PasajeroData pasajeroData = new PasajeroData();
        ColectivoData colectivoData = new ColectivoData();
        RutaData rutaData = new RutaData();
         
        List<Pasaje> pasajes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pasajes ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = pasajeroData.buscarPasajero(rs.getInt("ID_Pasajero"));
                Ruta ruta = rutaData.buscarRuta(rs.getInt("ID_Ruta"));
                Colectivo colectivo = colectivoData.buscarColectivo(rs.getInt("ID_Colectivo"));

                
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("idPasaje"));
                
                pasaje.setPasajero(pasajero);
                pasaje.setRuta(ruta);
                pasaje.setColectivo(colectivo);
                
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));
                pasajes.add(pasaje);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasaje " + ex.getMessage());
        }
        return pasajes;

    }
   
   
   
    public void modificarPasaje(Pasaje pasaje) {
        String sql = "UPDATE pasajes SET idPasajero = ? , idColectivo = ?, idRuta = ?,"
                + "fechaViaje = ?,horaViaje = ?,asiento = ?,precio = ? "
                + " WHERE idpasaje = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, pasaje.getIdPasajero());
            ps.setInt(2, pasaje.getIdColectivo());
            ps.setInt(3, pasaje.getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El pasaje no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasaje " + ex.getMessage());
        }
    }
    
     public void eliminarPasaje(int idPasaje) {
    String sql = "DELETE FROM pasajes WHERE idPasaje = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPasaje);
        
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Pasaje eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un pasaje con el ID especificado.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
                "Error al acceder a la tabla Pasaje. Mensaje SQLException: "
                + ex.getMessage());
    }
}

   
}