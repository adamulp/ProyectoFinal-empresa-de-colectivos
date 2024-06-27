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
                + "Matricula, Marca, Modelo, Capacidad FROM Colectivos "
                + "WHERE ID_Colectivo = ? AND Estado = 1";

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

    public Colectivo buscarColectivoPorMatricula(String matricula) {
        Colectivo colectivo = null;
        String sql = "SELECT ID_Colectivo, Matricula, Marca, Modelo, Capacidad, Estado  "
                + "FROM Colectivos WHERE Matricula=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setIdColectivo(rs.getInt("ID_Colectivo"));
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
    
    public List<Colectivo> listarColectivos(boolean activo) {
        List<Colectivo> colectivos = new ArrayList<>();
        String sql;
        if(!activo){
            sql = "SELECT * FROM Colectivos WHERE Estado = 0 ";
        }else{
            sql = "SELECT * FROM Colectivos WHERE Estado = 1 ";
        }
        
        try {
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
    
    public List<Colectivo> listarColectivos() {
        return listarColectivos(true);
    }

    public void modificarColectivo(Colectivo colectivo) {
        String sql = "UPDATE Colectivos SET ID_Colectivo = ? , Matricula = ?, Marca = ?, "
                + "Modelo = ?, Capacidad = ?, Estado = ? "
                + " WHERE ID_Colectivo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, colectivo.getIdColectivo());
            ps.setString(2, colectivo.getMatricula());
            ps.setString(3, colectivo.getMarca());
            ps.setString(4, colectivo.getModelo());
            ps.setInt(5, colectivo.getCapacidad());
            ps.setBoolean(6, colectivo.estaActivo());
            ps.setInt(7, colectivo.getIdColectivo());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el colectivo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivo " + ex.getMessage());
        }
    }

    public void eliminarColectivo(int id) {
        try {
            String sql = "UPDATE Colectivos SET Estado = 0 WHERE ID_Colectivo = ? ";
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
    
    public List<String> listarMarcas() {
        List<String> marcas = new ArrayList<>();
        String sql;
        sql = " SELECT DISTINCT Marca "
                + " FROM Colectivos";
       
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String marca = rs.getString("Marca");
                marcas.add(marca);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarMarcas()"
                  + " " + ex.getMessage());
        }

        return marcas;
    }
    
    public List<String> listarModelos(String marca) {
        List<String> modelos = new ArrayList<>();
        String sql;
        sql = " SELECT DISTINCT Modelo "
                + " FROM Colectivos "
                + " WHERE marca = ? ";
       
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, marca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String modelo = rs.getString("Modelo");
                modelos.add(modelo);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarMarcas()"
                  + " " + ex.getMessage());
        }

        return modelos;
    }
    
    public List<String> listarModelos() {
        List<String> modelos = new ArrayList<>();
        String sql;
        sql = " SELECT DISTINCT Modelo "
                + " FROM Colectivos ";
       
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String modelo = rs.getString("Modelo");
                modelos.add(modelo);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error al acceder la bd desde "
                  + "listarMarcas()"
                  + " " + ex.getMessage());
        }

        return modelos;
    }
    
    
}
