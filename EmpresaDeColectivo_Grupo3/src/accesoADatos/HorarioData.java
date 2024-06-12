package accesoADatos;


import EmpresaDeColectivo.Entidades.Horario;
import EmpresaDeColectivo.Entidades.Ruta;
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
        String sql = "INSERT INTO Horarios (Hora_Salida, Hora_Llegada," 
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
                + "Hora_Salida, Hora_Llegada, Estado FROM Horarios"
                + "WHERE ID_Horario= ? AND Estado = 1";

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
                horario.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
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
    
    
    
    public List<Horario> listarHorariosPorRuta(int idRuta, Boolean activo){
        List<Horario> horarios = new ArrayList<>();
        String sql = "SELECT * FROM Horarios "
                    + " WHERE ID_Ruta = ?";
            if(activo != null){
                if(activo){
                    sql += "AND Estado = 1 ";
                }else{
                    sql += "AND Estado = 0 ";
                }
            }
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Horario horario = new Horario();
                horario.setIdHorario(rs.getInt("ID_Horario"));
                
                RutaData rutaData = new RutaData();
                Ruta ruta = rutaData.buscarRuta(idRuta);
                horario.setRuta(ruta);
                
                horario.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
                horario.setEstado(rs.getBoolean("Estado"));
                horarios.add(horario);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Horario " + ex.getMessage());
        }
        return horarios;
    }
    public List<Horario> listarHorariosPorRuta(int idRuta){
        return listarHorariosPorRuta(idRuta, null);
    }
    public List<Horario> listarHorariosPorRuta(int idRuta, boolean activo){
        return listarHorariosPorRuta(idRuta, activo);
    }
    public List<Horario> listarHorariosPorRuta(Ruta ruta){
        
        return listarHorariosPorRuta(ruta.getIdRuta(), null);
    }
    public List<Horario> listarHorariosPorRuta(Ruta ruta, boolean activo){
        
        return listarHorariosPorRuta(ruta.getIdRuta(), activo);
    }
    
    public void modificarHorario(Horario horario) {
        String sql = "UPDATE Horarios SET ID_Horario = ? , ID_Ruta = ?, Hora_Salida = ?, "
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
            String sql = "SELECT * FROM Horarios WHERE Estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Horario horario = new Horario();
                horario = new Horario();
                horario.setIdHorario(rs.getInt("ID_Horario"));
                
                int idRuta = rs.getInt("ID_Ruta");
                RutaData rutaData = new RutaData();
                Ruta ruta = rutaData.buscarRuta(idRuta);
                horario.setRuta(ruta);
                
                horario.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
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
            String sql = "UPDATE Horarios SET Estado = 0 WHERE ID_Horario = ? ";
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
