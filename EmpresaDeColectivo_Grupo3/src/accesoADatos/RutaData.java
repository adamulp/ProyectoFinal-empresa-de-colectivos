
package accesoADatos;

import EmpresaDeColectivo.Entidades.Ruta;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adam, enzo, alexis, nicolas
 */

public class RutaData {

    private Connection con = null;

    public RutaData() {
        con = Conexion.getConexion();
    }

    public Time mariaDbTime(Duration duration) {
        long ms = duration.toMillis();
        return new Time(ms);
    }

    public void guardarRuta(Ruta ruta) {
        String sql = " INSERT INTO Rutas (ID_Ruta, Origen, Destino, "
                + " Duracion_Estimada, Estado) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ruta.getIdRuta());
            ps.setString(2, ruta.getOrigen());
            ps.setString(3, ruta.getDestino());

            Time sqlTime = mariaDbTime(ruta.getDuracionEstimada());
            ps.setTime(4, sqlTime);

            ps.setBoolean(5, ruta.estaActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ruta.setIdRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null,
                        "Ruta agregado con éxito");
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder a la tabla de Rutas. Mensaje SQLException: "
                    + ex.getMessage());
        }
    }

    public Duration duracion(Time sqlTime) {
        long ms = sqlTime.getTime();
        Duration duration = Duration.ofMillis(ms);
        return duration;
    }

    public Ruta buscarRuta(int idRuta) {
        Ruta ruta = null;
        String sql = " SELECT "
                + "Origen, Destino, Duracion_Estimada, Estado FROM Rutas "
                + "WHERE ID_Ruta = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt((1), idRuta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ruta = new Ruta();
                ruta.setIdRuta(idRuta);
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

               Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = duracion(sqlTime);
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encuentra la ruta con el id " + idRuta + ", "
                        + "¿está activo?");
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ruta;
    }

     public Ruta buscRutaInactiva(int idRuta) {
        Ruta ruta = null;
        String sql = " SELECT "
                + "Origen, Destino, Duracion_Estimada, Estado FROM Rutas "
                + "WHERE ID_Ruta = ? AND estado = 0";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt((1), idRuta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ruta = new Ruta();
                ruta.setIdRuta(idRuta);
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

               Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = duracion(sqlTime);
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encuentra la ruta con el id " + idRuta + ", "
                        + "¿está activo?");
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ruta;
    }
    
    public Boolean modificarRuta(Ruta ruta) {
     int success = -1;
    String sql = "UPDATE Rutas SET "
            + " Origen = ?, "
            + " Destino = ?, "
            + " Duracion_Estimada = ?, "
            + " Estado = ? "
            + " WHERE ID_Ruta = ?";
    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, ruta.getOrigen());
        ps.setString(2, ruta.getDestino());

        Duration duracionEstimada = ruta.getDuracionEstimada();
        Time sqlTime = null;
        if (duracionEstimada != null) {
            sqlTime = mariaDbTime(duracionEstimada);
        }
        ps.setTime(3, sqlTime);
        
        ps.setBoolean(4, ruta.estaActivo()); // Asegúrate de setear correctamente el estado
        ps.setInt(5, ruta.getIdRuta());
        
        success = ps.executeUpdate();

        if (success == 1) {
            JOptionPane.showMessageDialog(null, "Ruta modificada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la ruta para modificar.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta de actualización: " + ex.getMessage());
        ex.printStackTrace(); 
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar PreparedStatement: " + ex.getMessage());
        }
    }
    
    return success == 1;

    }
    
    public boolean darAltaRuta(Ruta ruta) {
    ruta.setEstado(true); 

    int fila = -1;
    String sql = "UPDATE Rutas SET Estado = ? WHERE ID_Ruta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ps.setInt(2, ruta.getIdRuta());

            int success = ps.executeUpdate();

            if (success == 1) {
                JOptionPane.showMessageDialog(null, "Ruta activada correctamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al activar la ruta.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al activar la ruta: " + ex.getMessage());
            return false;
        }
}
    
    
    
    public boolean borrarRuta(Ruta ruta){
        ruta.setEstado(false);
        int fila = -1;
        
        String sql = "UPDATE Rutas SET "
                + " Estado = ? "
                + " WHERE ID_Ruta = ?";

            PreparedStatement ps;
            try{
                ps = con.prepareStatement(sql);
                ps.setBoolean(1, ruta.estaActivo());
                ps.setInt(2, ruta.getIdRuta());

                fila = ps.executeUpdate();

                if (fila == 1) {
                    JOptionPane.showMessageDialog(null,
                        " Se eliminó la ruta.");
                }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
            " Error al acceder a la tabla Ruta: borrarRuta(Ruta ruta)");
        }
        return fila == 1;
        
    }
    
    

    public List<Ruta> listarRutasxOrigen(String origen) {
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas WHERE Origen = ? AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
            
        }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "Error al acceder la bd desde listarRutasxOrigen(String origen)"
                        + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDestino(String destino) {
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas WHERE Destino = ? AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "Error al acceder la bd desde "
                        + "listarRutasxOrigen(String origen)"
                        + " " + ex.getMessage());
        }

        return rutas;
    }

     public List<Ruta> listarRutas(){
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarRutasxOrigen(String origen)"
                  + " " + ex.getMessage());
        }

        return rutas;
    }
    public List<Ruta> listarRutasInactivas(){
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Estado = 0";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarRutasxOrigen(String origen)"
                  + " " + ex.getMessage());
        }

        return rutas;
    }
    
    public List<String> listarOrigenesPorDestinos(String destino, Boolean activo){
        List<String> origenes = new ArrayList<>();

        String sql = " SELECT DISTINCT Origen "
                + " FROM Rutas "
                + " WHERE Destino = ?";
        if(activo != null){
            if(activo){
                sql += " AND Estado = 1";
            }else if(!activo){
                sql += " AND Estado = 0";
            }
        }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String origen = rs.getString("Origen");
                origenes.add(origen);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarOrigenesPorDestinos(String destino, Boolean activo)"
                  + " " + ex.getMessage());
        }

        return origenes;
    }
    
    public List<String> listarDestinosPorOrigen(String origen, Boolean activo){
        List<String> destinos = new ArrayList<>();

        String sql = " SELECT DISTINCT Destino "
                + " FROM Rutas "
                + " WHERE Origen = ?";
        if(activo != null){
            if(activo){
                sql += " AND Estado = 1";
            }else if(!activo){
                sql += " AND Estado = 0";
            }
        }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, origen);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String destino = rs.getString("Destino");
                destinos.add(destino);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarDestinosPorOrigen(String origen, Boolean activo)"
                  + " " + ex.getMessage());
        }

        return destinos;
    }

    public List<Ruta> listarRutas(String origen, String destino) {
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Origen = ? "
                + " AND Destino = ?"
                + " AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ps.setString(2, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));

                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarRutasxOrigen(String origen)"
                  + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDuracionMin(Duration duracion) {
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Duracion_Estimada >= ? "
                + " AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            Time sqlTime = mariaDbTime(duracion);
            ps.setTime(1, sqlTime);
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                
                sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                    + "listarRutasxDuracionMin(Duration duracion)"
                    + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDuracionMax(Duration duracion) {
        List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Duracion_Estimada <= ? "
                + " AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            Time sqlTime = mariaDbTime(duracion);
            ps.setTime(1, sqlTime);
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                
                sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Error al acceder la bd desde "
                + "listarRutasxDuracionMin(Duration duracion)"
                + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDuracion(Duration min, Duration max) {
//        + " WHERE Duracion_Estimada IS BETWEEN ? AND ? "
      List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Duracion_Estimada IS BETWEEN ? AND ? "
                + " AND Estado = 1";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            Time sqlTime1 = mariaDbTime(min);
            ps.setTime(1, sqlTime1);
            Time sqlTime2 = mariaDbTime(max);
            ps.setTime(2, sqlTime2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("ID_Ruta"));
                ruta.setOrigen(rs.getString("Origen"));
                ruta.setDestino(rs.getString("Destino"));
                
                Time sqlTime = rs.getTime("Duracion_Estimada");
                Duration duracionEstimada = null;
                if (sqlTime != null) {
                    duracionEstimada = duracion(sqlTime);
                }
                ruta.setDuracionEstimada(duracionEstimada);
                ruta.setEstado(rs.getBoolean("Estado"));

                rutas.add(ruta);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Error al acceder la bd desde "
                + "listarRutasxDuracionMin(Duration duracion)"
                + " " + ex.getMessage());
        }

        return rutas;
    }

   public List<Ruta> listarRutasxDuracion(Duration duracion) {
    List<Ruta> rutas = new ArrayList<>();

    String sql = "SELECT ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + "FROM Rutas "
                + "WHERE Duracion_Estimada = ? AND Estado = 1";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        Time sqlTime = mariaDbTime(duracion);
        ps.setTime(1, sqlTime);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Ruta ruta = new Ruta();
            ruta.setIdRuta(rs.getInt("ID_Ruta"));
            ruta.setOrigen(rs.getString("Origen"));
            ruta.setDestino(rs.getString("Destino"));

            sqlTime = rs.getTime("Duracion_Estimada");
            Duration duracionEstimada = null;
            if (sqlTime != null) {
                duracionEstimada = duracion(sqlTime);
            }
            ruta.setDuracionEstimada(duracionEstimada);
            ruta.setEstado(rs.getBoolean("Estado"));

            rutas.add(ruta);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,
                "Error al acceder la base de datos desde listarRutasxDuracion: " + ex.getMessage());
    }

    return rutas;

    }

   public List<String> listarOrigenesUnicos(Boolean activo){
        List<String> origenes = new ArrayList<>();

        String sql = " SELECT DISTINCT Origen "
                + " FROM Rutas ";
        if(activo != null){
          
            if(activo){
                sql += " WHERE Estado = 1";
            }else if(!activo){
                sql += " WHERE Estado = 0";
            }
        }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String origen = rs.getString("Origen");
                origenes.add(origen);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarOrigenesUnicos(Boolean activo)"
                  + " " + ex.getMessage());
        }

        return origenes;
    }
    
    public List<String> listarDestinosUnicos(Boolean activo){
        List<String> destinos = new ArrayList<>();

        String sql = " SELECT DISTINCT Destino "
                + " FROM Rutas ";
        if(activo != null){
            if(activo){
                sql += " WHERE Estado = 1";
            }else if(!activo){
                sql += " WHERE Estado = 0";
            }
        }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String destino = rs.getString("Destino");
                destinos.add(destino);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarDestinosPorOrigen(String origen, Boolean activo)"
                  + " " + ex.getMessage());
        }

        return destinos;
    }
   
}


