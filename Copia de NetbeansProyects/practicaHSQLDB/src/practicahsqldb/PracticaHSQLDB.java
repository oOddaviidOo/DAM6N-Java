/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicahsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM 6N
 */
public class PracticaHSQLDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try {
// Empezamos por cargar el driver
Class.forName("org.hsqldb.jdbc.JDBCDriver");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon =
DriverManager.getConnection("jdbc:hsqldb:C:/clases/bases/hsqldb/ejemplo");

// getConnection(url [, nombre de usuario, contraseña])
    
// una vez la conexión establecida podemos ejecutar las instrucciones que
//queramos contra la base de datos a través de la conexión.
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
micon.close();
 }
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
} // fin de main
} // fin de la clase
