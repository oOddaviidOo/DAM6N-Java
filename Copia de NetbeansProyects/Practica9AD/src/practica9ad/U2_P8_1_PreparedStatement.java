package practica9ad;

import java.beans.Statement;
import java.sql.*;

public class U2_P8_1_PreparedStatement {

    public static void main(String[] args) {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db");

            try {
                
                int id=10;
                String asig = "Matematicas";
                String loc = "Despa9";

                PreparedStatement stmt = con.prepareStatement("INSERT INTO departamentos VALUES(?,'?','?')");
                
                stmt.setInt(1,id);
                stmt.setString(2,asig);
                stmt.setString(3,loc);
                
                stmt.executeUpdate();
               
                stmt.close();
                con.close();

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución: "
                        + sqle.getErrorCode() + " " + sqle.getMessage());
            }

        } catch (Exception e) {
        }

    }

}
