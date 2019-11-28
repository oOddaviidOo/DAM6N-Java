/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaderby;

/**
 *
 * @author DAM 6N
 */
import java.sql.*;
public class Main {
public static void main(String[] args) {
    
try {
// Empezamos por cargar el driver
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon =
DriverManager.getConnection("jdbc:derby:C:/Users/DAM 6N/Downloads/db-derby-10.14.2.0-bin/bin/ejemplo");

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

