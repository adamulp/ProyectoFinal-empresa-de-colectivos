package accesoADatos;


import EmpresaDeColectivo.Entidades.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adam, enzo, alexis, nicolas
 */
public class HorarioData {
    
    private Connection con = null;

    public HorarioData() {
        con =  Conexion.getConexion(); 
    }

    public void guardarHorario(Horario Horario) {
        String sql = "INSERT INTO horarios (HoraSalida, HoraLlegada," 
                + " Estado) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS); 
            ps.setTime(1, Time.valueOf(Horario.getHoraSalida()));
            ps.setTime(2, Time.valueOf(Horario.getHoraLlegada()));
            ps.setBoolean(3, Horario.isEstado());
            ps.executeUpdate(); //Ejecucion de consulta

            ResultSet rs = ps.getGeneratedKeys();  
            if (rs.next()) {
                Horario.setIdHorario(rs.getInt(1));
                JOptionPane.showMessageDialog(null,
                        "Horario añadido con exito.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al acceder a la tabla Horario. Mensaje SQLException: "
                    + ex.getMessage());
        }
    }
    
    public Horario buscarHorario(int idHorario, int idRuta){
        Horario horario= null;
        String sql = "SELECT "
                + "HoraSalida, HoraLlegada, estado FROM horarios"
                + "WHERE idHorario= ? AND estado = 1";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHorario);
 	    ps.setInt(2, idRuta);
            rs = ps.executeQuery(); 
            if (rs.next()) {
                horario = new Horario();
                horario.setIdHorario(idHorario);
                horario.setHoraSalida(rs.getTime("HoraSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("HoraLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("Estado"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Horario");
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horario" + ex.getMessage());
        }
        return horario;
    }
    
    public void modificarHorario(Horario horario) {
        String sql = "UPDATE horarios SET ID_Horario = ? , ID_Ruta = ?, Hora_Salida = ?, "
                + "Hora_Llegada = ?, Estado = ?  WHERE ID_Horario = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, horario.getIdHorario());
	    ps.setInt(2, horario.getIdRuta());
            ps.setTime(3, Time.valueOf(horario.getHoraSalida()));
            ps.setTime(4, Time.valueOf(horario.getHoraLlegada()));
            ps.setBoolean(5, horario.isEstado());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El horario no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horario " + ex.getMessage());
        }
    }

    
    public List<Horario> listarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM horarios WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Horario horario = new Horario();
                horario = new Horario();
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setHoraSalida(rs.getTime("HoraSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("HoraLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("Estado"));
                horarios.add(horario);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Horario " + ex.getMessage());
        }
        return horarios;
    }
    
     public void eliminarHorario(int id) {
        try {
            String sql = "UPDATE horario SET estado = 0 WHERE idHorario = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el horario.");
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Horario");
        }
    }
}
