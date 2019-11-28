package practica9ad;

import java.beans.Statement;
import java.sql.*;

public class U2_P8_3_PreparedStatement {

    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:F:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");

            try {
                String sql = "select * from profesores where salario > " + args[0] + " and departamento = '" + args[1] + "' order by nombre ASC";
                //String sql = "select * from profesores where dept_no = 10 order by nombre ASC";
               
                PreparedStatement sentencia = con.prepareStatement(sql);

                ResultSet resultado = sentencia.executeQuery();

                while (resultado.next()) {
                    System.out.println("Numero :" + resultado.getString("nrp"));
                    System.out.println("Nombre :" + resultado.getString("nombre"));
                    System.out.println("Apellidos :" + resultado.getString("apellidos"));
                    System.out.println("Email :" + resultado.getString("email"));
                    System.out.println("Fecha de Alta :" + resultado.getString("fecha_alta"));
                    System.out.println("Departamento :" + resultado.getString("dept_no"));
                    System.out.println("Salario :" + resultado.getString("salario"));
                }

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
