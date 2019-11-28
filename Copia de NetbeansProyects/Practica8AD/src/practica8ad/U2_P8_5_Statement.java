package practica8ad;

import java.sql.*;

public class U2_P8_5_Statement {

    public static void main(String[] args) {
        
        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/DAM 6N/Documents/Repositorio/Acceso/clases/bases/sqlite/ejemplo/ejemplo.db");

             String sql = "select  from dep";

                java.sql.Statement s = con.createStatement();
                ResultSet r = s.executeQuery(sql);

                con.close();
        

        } catch (Exception e) {
        }

    }

}
