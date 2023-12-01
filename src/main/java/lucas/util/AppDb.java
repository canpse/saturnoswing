package lucas.util;

import java.sql.DriverManager;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class AppDb {
    
    final static String db_name = "mydb";
    
    public static java.sql.Connection startConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + db_name + "?useSSL=false&allowPublicKeyRetrieval=true";
            return DriverManager.getConnection(url, "root", "1743");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
