package practica8ad;

import java.sql.*;

public class U2_P8_2_Statement {

    public static void main(String[] args) {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:G:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");

            try {

                String sql = "ALTER TABLE profesores ADD salario int(5)";

                Statement s = con.createStatement();
                ResultSet r = s.executeQuery(sql);

                con.close();

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución: "
                        + sqle.getErrorCode() + " " + sqle.getMessage());
            }

        } catch (Exception e) {
        }

    }

}
