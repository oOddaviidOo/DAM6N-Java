package practica9ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class U2_P8_4_PreparedStatement {

    public static void main(String[] args) {

        Boolean existe = true;

        try {
            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:F:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");
            try {

                int depart = 10;
                int conta = 0;
                int sueldo = 0;
                String texto = "", nombre = "";

                String cont = "select * from profesores where dept_no=" + depart + "";
                String cont2 = "select * from departamentos where dept_no=" + depart + "";

                java.sql.Statement s2 = con.createStatement();
                ResultSet resultado2 = s2.executeQuery(cont2);

                while (resultado2.next()) {
                    nombre = resultado2.getString("dnombre");
                }

                java.sql.Statement s = con.createStatement();
                ResultSet resultado = s.executeQuery(cont);

                while (resultado.next()) {

                    conta++;

                    if (Integer.valueOf(resultado.getString("salario")) > sueldo) {
                        sueldo = Integer.valueOf(resultado.getString("salario"));
                    }

                }

                if (conta > 0) {
                    texto += "El departamento" + nombre + "tiene" + conta + "profesores con un sueldo máximo de" + sueldo + "\n";
                } else {
                    texto += "El departamento" + nombre + "no tiene profesores\n";
                }

                if (nombre == "") {
                    texto += "El departamento no existe";
                }
                
                System.out.println(texto);

                con.close();
                resultado.close();

            } catch (SQLException sqle) {
                System.out.println("Error en la ejecución: "
                        + sqle.getErrorCode() + " " + sqle.getMessage());
            }

        } catch (Exception e) {
        }

    }

}
