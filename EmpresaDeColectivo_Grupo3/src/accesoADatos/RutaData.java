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
        String sql = " INSERT INTO Rutas (ID_Ruta, Origin, Destino, "
                + " Duracion_Estimada, Estado "
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
                + "WHERE idRuta = ? AND estado = 1";
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

                Time sqlTime = null;
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde listarRutasxOrigen(String origen)"
                    + " " + ex.getMessage());
        }

        return rutas;
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde listarRutasxOrigen(String origen)"
                    + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDuracionMin(Duration duracion) {
         List<Ruta> rutas = new ArrayList<>();

        String sql = " SELECT "
                + " ID_Ruta, Origen, Destino, Duracion_Estimada, Estado "
                + " FROM Rutas "
                + " WHERE Duracion_Estimada <= ? "

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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde listarRutasxOrigen(String origen)"
                    + " " + ex.getMessage());
        }

        return rutas;
    }

    public List<Ruta> listarRutasxDuracionMax() {
        List<Ruta> rutas = null;

        return rutas;
    }

    public List<Ruta> listarRutasxDuracion(Duration min, Duration max) {
        List<Ruta> rutas = null;

        return rutas;
    }

    public List<Ruta> listarRutasxDuracion(Duration duracion) {
        List<Ruta> rutas = null;

        return rutas;
    }

}
