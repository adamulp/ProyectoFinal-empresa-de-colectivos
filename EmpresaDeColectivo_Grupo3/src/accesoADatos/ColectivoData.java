package accesoADatos;

import EmpresaDeColectivo.Entidades.Colectivo;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.Date;
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
public class ColectivoData {

    private Connection con = null;

    public ColectivoData() {
        con = Conexion.getConexion();
    }

    public void guardarColectivo(Colectivo Colectivo) {
        String sql = "INSERT INTO Colectivos (Matricula, Marca, Modelo, Capacidad, "
                + " Estado) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Colectivo.getMatricula());
            ps.setString(2, Colectivo.getMarca());
            ps.setString(3, Colectivo.getModelo());
            ps.setInt(4, Colectivo.getCapacidad());
            ps.setBoolean(5, Colectivo.estaActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                Colectivo.setIdColectivo(rs.getInt(1));
                JOptionPane.showMessageDialog(null,
                        "Colectivo añadido con exito.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder a la tabla Colectivo. Mensaje SQLException: "
                    + ex.getMessage());
        }
    }

    public Colectivo buscarColectivo(int idColectivo) {
        Colectivo colectivo = null;
        String sql = "SELECT "
                + "Matricula, Marca, modelo, capacidad FROM Colectivos "
                + "WHERE idColectivo = ? AND estado = 1";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idColectivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setIdColectivo(idColectivo);
                colectivo.setMatricula(rs.getString("Matricula"));
                colectivo.setMarca(rs.getString("Marca"));
                colectivo.setModelo(rs.getString("Modelo"));
                colectivo.setCapacidad(rs.getInt("Capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Colectivo");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivo " + ex.getMessage());
        }
        return colectivo;
    }

    public Colectivo buscarColectivoPorMatricula(int matricula) {
        Colectivo colectivo = null;
        String sql = "SELECT idColectivo, Matricula, Marca, Modelo, Capacidad, Estado  "
                + "FROM colectivos WHERE matricula=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setIdColectivo(rs.getInt("idColectivo"));
                colectivo.setMatricula(rs.getString("Matricula"));
                colectivo.setMarca(rs.getString("Marca"));
                colectivo.setModelo(rs.getString("Modelo"));
                colectivo.setCapacidad(rs.getInt("Capacidad"));
                colectivo.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el colectivo");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivo " + ex.getMessage());
        }
        return colectivo;
    }

    public List<Colectivo> listarColectivos() {
        List<Colectivo> colectivos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM colectivos WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colectivo colectivo = new Colectivo();
                colectivo = new Colectivo();
                colectivo.setIdColectivo(rs.getInt("ID_Colectivo"));
                colectivo.setMatricula(rs.getString("Matricula"));
                colectivo.setMarca(rs.getString("Marca"));
                colectivo.setModelo(rs.getString("Modelo"));
                colectivo.setCapacidad(rs.getInt("Capacidad"));
                colectivos.add(colectivo);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Colectivo " + ex.getMessage());
        }
        return colectivos;

    }

    public void modificarColectivo(Colectivo colectivo) {
        String sql = "UPDATE Colectivos SET ID_Colectivo = ? , Matricula = ?, Marca = ?, "
                + "Modelo = ? WHERE ID_Colectivo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, colectivo.getIdColectivo());
            ps.setString(2, colectivo.getMatricula());
            ps.setString(3, colectivo.getMarca());
            ps.setDate(4, Date.valueOf(colectivo.getModelo()));
            ps.setInt(5, colectivo.getCapacidad());
            ps.setBoolean(6, colectivo.estaActivo());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El colectivo no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivo " + ex.getMessage());
        }
    }

    public void eliminarColectivo(int id) {
        try {
            String sql = "UPDATE colectivos SET estado = 0 WHERE ID_Colectivo = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el colectivo.");
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Colectivo");
        }
    }
}
