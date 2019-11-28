package practica8ad;

import java.sql.*;
import java.util.*;

public class U2_P8_7_Statement_hsqldb {

    public static void main(String[] args) {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:C:/clase/bases/hsqldb/hsqldb-2.5.0/DB/prueba");

            int id = 6, salario = 1000, Departamento = 10;
            String nombre = "Victor", Apellidos = "Mañas Zarza", Email = "Micorreo@gmail.com";
            int ids = 0, departamentos = 0;

            String insert = "insert into profesores values(" + id + ",'" + nombre + "','" + Apellidos + "','" + Email + "','" + Departamento + "'," + salario + ")";

            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("select * from profesores");

            while (resultado.next()) {

                int num = resultado.getInt("nrp");

                if (num == id) {

                    System.exit(0);
                }

                int numa = resultado.getInt("dept_no");

                if (numa == Departamento) {
                    departamentos = 1;
                }

            }

            if (departamentos == 1) {
                s.executeUpdate(insert);

            }

            resultado.close();
            s.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException a) {
            a.printStackTrace();
        }

    }

}
