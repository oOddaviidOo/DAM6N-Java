package practica8ad;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class U2_P8_6_Statement1 {

    public static void main(String[] args) {
        try {
            establecerConecion();
        } catch (SQLException ex) {
            Logger.getLogger(U2_P8_6_Statement1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
    public static void establecerConecion() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/DAM 6N/Downloads/sqlite-tools-win32-x86-3300100/sqlite-tools-win32-x86-3300100/examen.db");
            Statement s = c.createStatement();
            int filas=s.executeUpdate(insertarDep(3,"'a'","'b'"));
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

