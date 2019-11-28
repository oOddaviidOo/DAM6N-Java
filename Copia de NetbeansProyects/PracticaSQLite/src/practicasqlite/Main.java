/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicasqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DAM 6N
 */
public class Main {

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
DatabaseMetaData dbmd=micon.getMetaData();
//Información general
String nombre = dbmd.getDatabaseProductName();
String driver = dbmd.getDriverName();
String url = dbmd.getURL();
String usuario = dbmd.getUserName();
System.out.println("INFORMACION SOBRE LA BASE DE DATOS");
System.out.println("----------------------------------");
System.out.println("Nombre: " + nombre);
System.out.println("Driver: " + driver);
System.out.println("URL: " + url);
System.out.println("User: " + usuario);
// Información sobre las tablas
ResultSet resul= dbmd.getTables(null, "Ejemplo",null, null);
while (resul.next())
{
String catalogo = resul.getString(1); // la primera columna devuelta
String esquema = resul.getString(2); // la columna 2
String tabla = resul.getString(3); // la columna 3
String tipo = resul.getString(4);
System.out.println("Catalogo: " + catalogo + " Esquema: " + esquema + " tipo: " + tipo + " Nombre tabla: " + tabla);
}
// Previamente iría el establecimiento de la conexión y se supone
// que en el DatabaseMetaData dbmd hemos cargado los metadatos.
// Recuperemos información sobre las columnas de la tabla departamentos:
ResultSet columnas = dbmd.getColumns(null, "Ejemplo", "departamentos", null);
System.out.println(" COLUMNAS TABLA DEPARTAMENTOS");
System.out.println("----------------------------------------------");
while (columnas.next())
{
String nombreCol = columnas.getString("COLUMN_NAME");
String tipoCol = columnas.getString("TYPE_NAME");
String tamCol = columnas.getString("COLUMN_SIZE");
String nula = columnas.getString("IS_NULLABLE");
System.out.println("Columna: " + nombreCol + " tipo: " + tipoCol + " tamaño: " + tamCol + " Admite null: " + nula);
}
ResultSet columnas1 = dbmd.getColumns(null, "Ejemplo", "profesores", null);
System.out.println(" COLUMNAS TABLA PROFESORES");
System.out.println("----------------------------------------------");
while (columnas.next())
{
String nombreCol = columnas.getString("COLUMN_NAME");
String tipoCol = columnas.getString("TYPE_NAME");
String tamCol = columnas.getString("COLUMN_SIZE");
String nula = columnas.getString("IS_NULLABLE");
System.out.println("Columna: " + nombreCol + " tipo: " + tipoCol + " tamaño: " + tamCol + " Admite null: " + nula);
}
// Información sobre la clave primaria de una tabla.
// Recuerda que solo hay una pero puede estar compuesta
ResultSet pk = dbmd.getPrimaryKeys(null, "Ejemplo", "departamentos");
System.out.println("COLUMNAS QUE FORMAN LA PK DE LA TABLA DEPARTAMENTOS");
System.out.println("---------------------------------------------------");
String pkdep = "", separador= " - ";
while (pk.next())
{
pkdep = pkdep + separador + pk.getString("COLUMN_NAME");
}
System.out.println("Clave primaria: " + pkdep);
// Información sobre las claves ajenas que apuntan a la clave primaria de una tabla.
ResultSet fk = dbmd.getExportedKeys(null, "Ejemplo", "departamentos");
System.out.println("COLUMNAS QUE APUNTAN A LA PK DE LA TABLA DEPARTAMENTOS");
// Cuando ya no necesitamos acceder a la base de datos cerramos la conexión:
System.out.println("------------------------------------------------------");
while (fk.next())
{
String fk_nombre = fk.getString("FKCOLUMN_NAME");
String pk_nombre = fk.getString("PKCOLUMN_NAME");
String fk_tabla = fk.getString("FKTABLE_NAME");
String pk_tabla = fk.getString("PKTABLE_NAME");
System.out.println("Tabla hija: " + fk_tabla + " Clave Ajena: " + fk_nombre);
System.out.println("Tabla padre: " + pk_tabla + " Clave Principal: " + pk_nombre);
}
micon.close();
}
catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch(SQLException e) { e.printStackTrace();}
    }
    
    
    
}
