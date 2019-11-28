/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso9;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Magnus
 */
public class U2_P8_4y5_PreparedStatement {

    public static void main(String[] args){
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
// Cargar el driver
            Class.forName("org.sqlite.JDBC");
// Establecemos la conexión con la base de datos
            Connection miconexion = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");
            System.out.println(args.length);
            String dept_no = args[0];

            String sql = "SELECT d.dnombre, p.count(nrp), max(p.salario) from profesores natural join departamentos ";

            PreparedStatement sentencia = miconexion.prepareStatement(sql);
           
            sentencia.setInt(2, Integer.parseInt(dept_no));
            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (resultado.getString("dnombre:") == "") {
                    System.out.println("El departamento no existe");
                }
                if (resultado.getInt("nrp:") == 0) {
                    System.out.println("El departamento " + resultado.getString("dnombre: ") + "no tiene profesores");
                }
                System.out.println("El departamento " + resultado.getString("dnombre: ") + " tiene " + resultado.getInt("nrp: ") 
                        + " profesores con un sueldo maximo " + resultado.getDouble("Salario: "));
            }
            sentencia.close();
            miconexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        };break;
                    case 2:
                try {
// Cargar el driver
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
// Establecemos la conexión con la base de datos
            Connection miconexion = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");
            System.out.println(args.length);
            String dept_no = args[0];

            String sql = "SELECT d.dnombre, p.count(nrp), max(p.salario) from profesores natural join departamentos ";

            PreparedStatement sentencia = miconexion.prepareStatement(sql);
           
            sentencia.setInt(2, Integer.parseInt(dept_no));
            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (resultado.getString("dnombre:") == "") {
                    System.out.println("El departamento no existe");
                }
                if (resultado.getInt("nrp:") == 0) {
                    System.out.println("El departamento " + resultado.getString("dnombre: ") + "no tiene profesores");
                }
                System.out.println("El departamento " + resultado.getString("dnombre: ") + " tiene " + resultado.getInt("nrp: ") 
                        + " profesores con un sueldo maximo " + resultado.getDouble("Salario: "));
            }
            sentencia.close();
            miconexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        };break;
                    case 3:
                try {
// Cargar el driver
Class.forName("org.hsqldb.jdbc.JDBCDriver");
// Establecemos la conexión con la base de datos
            Connection miconexion = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");
            System.out.println(args.length);
            String dept_no = args[0];

            String sql = "SELECT d.dnombre, p.count(nrp), max(p.salario) from profesores natural join departamentos ";

            PreparedStatement sentencia = miconexion.prepareStatement(sql);
           
            sentencia.setInt(2, Integer.parseInt(dept_no));
            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                if (resultado.getString("dnombre:") == "") {
                    System.out.println("El departamento no existe");
                }
                if (resultado.getInt("nrp:") == 0) {
                    System.out.println("El departamento " + resultado.getString("dnombre: ") + "no tiene profesores");
                }
                System.out.println("El departamento " + resultado.getString("dnombre: ") + " tiene " + resultado.getInt("nrp: ") 
                        + " profesores con un sueldo maximo " + resultado.getDouble("Salario: "));
            }
            sentencia.close();
            miconexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        };break;
        }
    }
}
        