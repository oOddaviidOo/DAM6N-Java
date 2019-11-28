package practica8ad;

import java.sql.*;


public class U2_P8_1_Statement {
    
 

    public static void main(String[] args) {

        try {

            Class.forName("org.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:sqlite:G:/ProyectosAD/Directorio con las Bases/clase/bases/sqlite/ejemplo.db");

            String dep=args[0];
            String nombre=args[1];
            String loc=args[2];
            
            String sql= "INSERT INTO departamentos VALUES ("+dep+",'"+nombre+"','"+loc+"')";
            
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(sql);
            

           
            
           
           con.close();
           

        } catch (Exception e) {
        }

    }

}
