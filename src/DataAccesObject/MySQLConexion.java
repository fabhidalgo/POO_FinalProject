package DataAccesObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;

public class MySQLConexion {
    String StrConxMySQL="jdbc:mysql://switchback.proxy.rlwy.net:20151/railway";
    String StrUserMySQL="root";
    String StrPassMySQL="uvwUsCMDErlYXvdHwnVkGzdsmZKxUHug";
    private Connection Conexion;

    public MySQLConexion() {
        System.out.println("Me estas llamando");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            DriverManager.setLoginTimeout(300);
            Conexion = DriverManager.getConnection(StrConxMySQL, StrUserMySQL, StrPassMySQL);
            if (Conexion != null){
                DatabaseMetaData dm = Conexion.getMetaData();
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product Version: " + dm.getDatabaseProductVersion());
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String [] args){
        MySQLConexion cm = new MySQLConexion();
        
    }

    public Connection getConexion() {
        return Conexion;
    }
    
}
