package principalpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private Connection conectar = null;
    private final String usuario = "root";
    private final String contrasenia = ""; // Cambia si tienes una contraseña para MySQL
    private final String ip = "localhost";
    private final String puerto = "3306";
    private final String basedeDatos = "bdplanilla"; // Asegúrate de que el nombre sea correcto
    private final String url = "jdbc:mysql://localhost:3306/bdplanilla?zeroDateTimeBehavior=convertToNull";
    private final String driver = "com.mysql.jdbc.Driver";
    
    private Statement st;
    private ResultSet rs;
    
    public Connection establecerConexion() {
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, usuario, contrasenia);
          //  JOptionPane.showMessageDialog(null, "¡La Base de Datos se Conectó Correctamente!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el driver de MySQL.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conectar;
    }


    public void desconectar() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
               // JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", ex);
        }
    }
    
}