/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DAM 6N
 */
public class establecerConexion {
        public static void establecerConecion() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/DAM 6N/Downloads/sqlite-tools-win32-x86-3300100/sqlite-tools-win32-x86-3300100/examen.db");
            Statement s = c.createStatement();
            int filas=s.executeUpdate(insertarDep(4,"'a'","'b'"));
            System.out.println("Filas afectadas: "+filas);
            s.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException a) {
            a.printStackTrace();
        }
    }
    
    public static String insertarDep(int num, String nomb, String loc){
    String sql="INSERT INTO departamentos VALUES("+num+","+nomb+","+loc+");";
            
        return sql;
    }
}
