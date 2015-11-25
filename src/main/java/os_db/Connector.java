package os_db; /**
 * Created by zfx on 15/11/11.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class Connector {
    private static  Connector conn;
    private Connection dbc;
    public static String url = "jdbc:mysql://localhost:3306/opst?user=root&password=zfx";
    private Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbc = (Connection)DriverManager.getConnection(Connector.url);
        }catch(ClassNotFoundException e){
            System.out.println("Error Driver");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Error Connection");
            e.printStackTrace();
        }


    }
    public Connection getDbc(){
        return dbc;
    }
    public static Connector getConn(){
        if(conn == null){
            conn = new Connector();
        }
        return conn;
    }
}
