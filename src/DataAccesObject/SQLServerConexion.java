package DataAccesObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConexion {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL_CONNECTION = "jdbc:sqlserver://localhost:1433;databaseName=OperationSystem;user=sa;password=12345;encrypt=true;trustServerCertificate=true;";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL_CONNECTION);

        } catch (ClassNotFoundException ex) {
            System.err.println("Error: Driver de SQL Server no encontrado. " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Error de conexión a la base de datos: " + ex.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión correcta.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
