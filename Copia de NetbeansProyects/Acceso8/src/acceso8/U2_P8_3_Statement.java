/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso8;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DAM 6N
 */
public class U2_P8_3_Statement {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // TODO code application logic here
        try {
// Empezamos por cargar el driver
Class.forName("org.sqlite.JDBC");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
String sql="UPDATE PROFESORES SET sueldo = 1000 WHERE dept_no=10";
Statement sentencia=micon.createStatement();
int filas=sentencia.executeUpdate(sql);
            System.out.println("Nº de filas afectadas: "+filas);
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
    }
    
}
