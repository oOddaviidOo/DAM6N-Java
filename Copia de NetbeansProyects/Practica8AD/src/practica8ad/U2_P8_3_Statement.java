package practica8ad;

import java.beans.Statement;
import java.sql.*;

public class U2_P8_3_Statement {

    public static void main(String[] args) {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:G:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");

             String sql = "ALTER TABLE profesores set salario="+args[0]+" where dpt_no = (select dpt_no from departamentos where dnombre = "+args[1]+")";

                java.sql.Statement s = con.createStatement();
                ResultSet r = s.executeQuery(sql);

                con.close();
        

        } catch (Exception e) {
        }

    }

}
