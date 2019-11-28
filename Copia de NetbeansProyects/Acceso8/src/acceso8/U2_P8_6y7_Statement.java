/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso8;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM 6N
 */
public class U2_P8_6y7_Statement {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // TODO code application logic here
        Date date=new Date();
        Scanner t=new Scanner(System.in);
        int op=0;
        System.out.println("Elije una BBDD");
        System.out.println("1.  SQLITE");
        System.out.println("2.  DERBY");
        System.out.println("3.  HSQLDB");
        op=t.nextInt();
        switch(op){
            case 1:
                        try {
// Empezamos por cargar el driver
Class.forName("org.sqlite.JDBC");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
DateFormat formato=new SimpleDateFormat("mm/dd/yyyy");
String nrp=args[0];
String nom=args[1];
String ape=args[2];
String mail=args[3];
String alta=args[4];
alta=date.toString();
String dept=args[5];
String salario=args[6];

String sql="INSERT INTO profesores VALUES("+nrp+",'"+nom+"','"+ape+"',"+mail+",'"+alta+"',"+dept+","+ salario+");";
Statement sentencia=micon.createStatement();
int filas=sentencia.executeUpdate(sql);
            System.out.println("Nº de filas afectadas: "+filas);
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
                break;
            case 2: 
                        try {
// Empezamos por cargar el driver
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
DateFormat formato=new SimpleDateFormat("mm/dd/yyyy");
String nrp=args[0];
String nom=args[1];
String ape=args[2];
String mail=args[3];
String alta=args[4];
alta=date.toString();
String dept=args[5];
String salario=args[6];

String sql="INSERT INTO profesores VALUES("+nrp+",'"+nom+"','"+ape+"',"+mail+",'"+alta+"',"+dept+","+ salario+");";
Statement sentencia=micon.createStatement();
int filas=sentencia.executeUpdate(sql);
            System.out.println("Nº de filas afectadas: "+filas);
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
                break;
            case 3:         try {
// Empezamos por cargar el driver
Class.forName("org.hsqldb.jdbc.JDBCDriver");
// Ahora podemos establecer la conexión mediante el DriverManager
Connection micon = DriverManager.getConnection("jdbc:sqlite:C:/clases/bases/sqlite/ejemplo/ejemplo.db");
//getConnection(url [, nombre de usuario, contraseña])
// una vez la conexión establecida podemos ejecutar las instrucciones que queramos contra la base de datos a través de la conexión.
DateFormat formato=new SimpleDateFormat("mm/dd/yyyy");
String nrp=args[0];
String nom=args[1];
String ape=args[2];
String mail=args[3];
String alta=args[4];
alta=date.toString();
String dept=args[5];
String salario=args[6];

String sql="INSERT INTO profesores VALUES("+nrp+",'"+nom+"','"+ape+"',"+mail+",'"+alta+"',"+dept+","+ salario+");";
Statement sentencia=micon.createStatement();
int filas=sentencia.executeUpdate(sql);
            System.out.println("Nº de filas afectadas: "+filas);
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
sentencia.close();
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
                break;
        }

    }
    
}
