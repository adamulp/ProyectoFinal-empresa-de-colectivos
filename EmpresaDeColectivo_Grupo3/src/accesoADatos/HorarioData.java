package accesoADatos;


import EmpresaDeColectivo.Entidades.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vistas.Horarios;
import java.sql.Time;
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
        String sql = "INSERT INTO Horario (HoraSalida, HoraLlegada,"
                + " Estado) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setTime(1, Time.valueOf(Horario.getHoraSalida()));
            ps.setTime(1, Time.valueOf(Horario.getHoraLlegada()));
            ps.setBoolean(3, Horario.isEstado());
            ps.executeUpdate();

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
                + "HoraSalida, HoraLlegada, estado FROM Horario"
                + "WHERE idHorario= ? AND idRuta = ? AND estado = 1";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHorario);
 	    ps.setInt(2, idRuta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                horario = new Horario();
                horario.setIdHorario(idHorario);
		horario.setIdRuta(idRuta);//Es necesaria la ruta? 
                horario.setHoraSalida(rs.getTime("HoraSalida").toLocalTime());
                horario.setHoraLlegada(rs.getTime("HoraLlegada").toLocalTime());
                horario.setEstado(rs.getBoolean("Estado"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Horario");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horario" + ex.getMessage());
        }
        return horario;
    }
    
}
