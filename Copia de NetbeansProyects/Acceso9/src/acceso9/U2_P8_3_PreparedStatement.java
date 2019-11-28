/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DAM 6N
 */
public class U2_P8_3_PreparedStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
// Empezamos por cargar el driver
Class.forName("org.sqlite.JDBC");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/Users/DAM 6N/Documents/RepositoriO/Acceso/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
int sueldo=900;

String sql="SELECT * FROM profesores WHERE sueldo > ?;";
PreparedStatement sentencia=micon.prepareStatement(sql);
sentencia.setInt(1, sueldo);


sentencia.executeUpdate();
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
    }
    
}
