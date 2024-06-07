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
    
    private Connection con = null;// Conexión a la base de datos.

    public HorarioData() {
        con =  Conexion.getConexion(); //Inicializamos la conexión a la base de datos
    }

    public void guardarHorario(Horario Horario) {
        String sql = "INSERT INTO Horario (HoraSalida, HoraLlegada," // insertar un nuevo registro en la tabla Horario.
                + " Estado) "
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS); //Prepara la consulta SQL con RETURN_GENERATED_KEYS para obtener la clave generada automáticamente.
            ps.setTime(1, Time.valueOf(Horario.getHoraSalida()));
            ps.setTime(2, Time.valueOf(Horario.getHoraLlegada()));
            ps.setBoolean(3, Horario.isEstado());
            ps.executeUpdate(); //Ejecucion de consulta

            ResultSet rs = ps.getGeneratedKeys();  //Recuperamos la clave generada automáticamente para el nuevo registro y la asigna al objeto Horario.
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
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHorario);
 	    ps.setInt(2, idRuta);
            rs = ps.executeQuery(); //Si se encuentra un registro, crea un nuevo objeto Horario y asigna los valores de HoraSalida, HoraLlegada y Estado.
            if (rs.next()) {
                horario = new Horario();
                horario.setIdHorario(idHorario);
		horario.setIdRuta(idRuta);//Es necesaria la ruta? 
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
        String sql = "UPDATE Horario SET ID_Horario = ? , ID_Ruta = ?, Hora_Salida = ?, "
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
    //QUEDARIA AGREGAR ELIMINAR HORARIO Y LISTAR LOS HORARIOS.
    
    public List<Horario> listarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM horario WHERE estado = 1 ";
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
