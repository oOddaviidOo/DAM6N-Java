/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author David
 */
public class Acceso {

    /**
     * @param args the command line arguments
     */
//public static void main(String[] args) {
//        try {
//
//            Class.forName("org.sqlite.JDBC");
//
//            Connection miconexion = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");
//
//            DatabaseMetaData dbmd = miconexion.getMetaData();
//
//            System.out.println("Tablas y claves primarias para la base de datos Ejemplo");
//            System.out.println("---------------------------------------------------");
//            ResultSet resul = dbmd.getTables(null, "Ejemplo", null, null);
//            while (resul.next()) {
//            String tabla = resul.getString(3);
//            ResultSet pk = dbmd.getPrimaryKeys(null, "Ejemplo", tabla);
//            String pkdep = "", separador = " - ";
//            while (pk.next()) {
//                pkdep = pkdep + separador + pk.getString("COLUMN_NAME");
//            }
//                System.out.println(" Tabla: " + tabla + ". Clave primaria: " + pkdep);
//            }
//
//            miconexion.close();
//        } catch (ClassNotFoundException cn) {
//            cn.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//public static void main(String[] args) {
//        try {
//
//            Class.forName("org.sqlite.JDBC");
//            Connection miconexion = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");
//
//            Statement sentencia = miconexion.createStatement();
//
//            ResultSet resul = sentencia.executeQuery("SELECT apellido FROM empleados WHERE dir = 1 OR dir = 4");
//            ResultSet resul2 = sentencia.executeQuery("SELECT apellido FROM empleados WHERE dir = 1 OR dir = 4");
//
//            System.out.println(resul.getString(1));
//            System.out.println(resul2.getString(1));
//
//            miconexion.close();
//            sentencia.close();
//        } catch (ClassNotFoundException cn) {
//            cn.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
