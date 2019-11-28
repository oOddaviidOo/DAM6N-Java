package practica9ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class U2_P8_5_PreparedStatement1 {

    public static void main(String[] args) {

        Boolean existe = true;
        String base, ruta;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Seleccione base de datos:\n"
                + "1. SQLITE\n"
                + "2. DERBY\n"
                + "3. HSQLDB\n"
                + "4. EXIT\n");

        int op = teclado.nextInt();

        switch (op) {
            case 1:
                base = "org.sqlite.JDBC";
                ruta = "jdbc:sqlite:C:/clase/bases/sqlite/ejemplo.db";
                break;
            case 2:
                base = "org.apache.derby.jdbc.EmbeddedDriver";
                ruta = "jdbc:derby:C:/clase/bases/derby/ejemplo";
                break;
            case 3:
                base = "org.hsqldb.jdbc.JDBCDriver";
                ruta = "jdbc:hsqldb:C:/clase/bases/hsqldb/hsqldb-2.5.0/DB/prueba";
                break;
            default:
                System.exit(0);
        }

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
