package practica9ad;

import java.beans.Statement;
import java.sql.*;

public class U2_P8_2_PreparedStatement {

    public static void main(String[] args) {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:G:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");

            try {

                int salario = 1000, departamento = 10;

                PreparedStatement stmt = con.prepareStatement("UPDATE TABLE profesores SET salario= salario+? where departamento= ?");

                stmt.setInt(1, salario);
                stmt.setInt(2, departamento);

                stmt.execute();
                stmt.close();

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución: "
                        + sqle.getErrorCode() + " " + sqle.getMessage());
            }

        } catch (Exception e) {
        }

    }

}
