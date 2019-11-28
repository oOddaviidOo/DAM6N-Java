package practica10ad;

import java.sql.*;

public class U2_P10_1_Callable {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection con = DriverManager.getConnection("jdbc:hsqldb:F:/ProyectosAD/Directorio con las Bases/clase/bases/hsqldb/hsqldb-2.5.0/DB/prueba", "SA", "");

            String salario1000 = "call salario1000()";
            CallableStatement sentencia = con.prepareCall(salario1000);
            sentencia.executeUpdate();

            String subida_10 = "call subida_10()";
            sentencia = con.prepareCall(subida_10);
            sentencia.executeUpdate();

            String subida_por = "call subida_por(?)";
            sentencia = con.prepareCall(subida_por);
            sentencia.setInt(1, 20);
            sentencia.executeUpdate();

            String subida_pordep = "call subida_pordep(?,?)";
            sentencia.setFloat(1, 20);
            sentencia.setInt(2, 10);
            sentencia = con.prepareCall(subida_pordep);
            sentencia.executeUpdate();

            sentencia.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
