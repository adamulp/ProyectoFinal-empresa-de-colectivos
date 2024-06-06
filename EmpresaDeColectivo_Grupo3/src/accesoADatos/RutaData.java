package accesoADatos;

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
public class RutaData {
    private Connection con = null;

    public RutaData() {
        con = Conexion.getConexion();
    } 
}
