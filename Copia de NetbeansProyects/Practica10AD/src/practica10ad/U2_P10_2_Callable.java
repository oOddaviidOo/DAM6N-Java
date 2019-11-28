package practica10ad;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class U2_P10_2_Callable {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection con = DriverManager.getConnection("jdbc:hsqldb:F:/ProyectosAD/Directorio con las Bases/clase/bases/hsqldb/hsqldb-2.5.0/DB/prueba", "SA", "");

            CallableStatement sentencia = con.prepareCall("call proc_cin(?,?)");
            sentencia.setInt(1, 10);
            sentencia.registerOutParameter(2,Types.VARCHAR);
            sentencia.executeUpdate();

            System.out.println("El nombre del departamentos es: " + sentencia.getString(2));

            sentencia.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
