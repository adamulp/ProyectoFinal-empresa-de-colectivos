package accesoADatos;

import EmpresaDeColectivo.Entidades.Ruta;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public void guardarRuta(Ruta ruta){
        String sql = " INSERT INTO Rutas (ID_Ruta, Origin, Destino, "
                + " Duracion_Estimada, Estado "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(RutaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
