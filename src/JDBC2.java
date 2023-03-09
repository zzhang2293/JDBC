import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC2 {
    // test result set
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/account";
        String name = "root";
        String password = "01*gbcfd&wzn";
        Connection connection = DriverManager.getConnection(url, name, password);
        Statement statement = connection.createStatement();

        // DQL query
        String sql1 = "select money from account";
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()){
            int money = resultSet.getInt(1);
            System.out.println(money);
        }

    }


}
