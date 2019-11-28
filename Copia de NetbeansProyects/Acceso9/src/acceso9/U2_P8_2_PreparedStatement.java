/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DAM 6N
 */
public class U2_P8_2_PreparedStatement {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // TODO code application logic here
        try {
// Empezamos por cargar el driver
Class.forName("org.sqlite.JDBC");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/Users/DAM 6N/Documents/RepositoriO/Acceso/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
String sql="UPDATE PROFESORES SET sueldo =? WHERE dept_no=?";
PreparedStatement sentencia=micon.prepareStatement(sql);
int dept_no=60;
int sueldo=1000;
sentencia.setInt(1, dept_no);
sentencia.setInt(2, sueldo);
sentencia.executeQuery();
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
    }
    
}
