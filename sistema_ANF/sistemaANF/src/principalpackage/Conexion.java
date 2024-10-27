/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principalpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Claudia Maria AC
 */
public class Conexion {
    Connection conectar = null;
    
    String usuario = "root";
    //String url = "jdbc:mysql://localhost:3306/";
    String contrasenia = "12345";
    String BasedeDatos = "dbplanilla";
    String ip = "localhost";
   // String driver = "com.mysql.cj.jdbc.Driver";
    String Puerto = "3306";
    
    Statement st;
    ResultSet rs;
    int idc; 
    
    String cadena = "jdbc:mysql://" + ip + ":" + Puerto + "/" + BasedeDatos;


    public Connection establecerConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar= DriverManager.getConnection(cadena,usuario,contrasenia);
        JOptionPane.showMessageDialog(null,"¡La Base de Datos se Conecto Correctamente!");
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null,"NO se conecto correctamente");
    }
        return conectar;
    }
    
    public void desconectar(){
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

