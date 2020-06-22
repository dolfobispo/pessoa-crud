package connection;
import java.sql.Connection;
// conexão SQL para Java
import java.sql.DriverManager;
// driver de conexão SQL para Java
import java.sql.SQLException;
// classe para tratamento de exceções

public class Connect{
    private Connect() {

    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/pessoa_crud","root","");
        }
        catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
