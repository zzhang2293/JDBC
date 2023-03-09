import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        String sql1 = "select * from account";
        ResultSet resultSet = statement.executeQuery(sql1);
        List<Account> user_set = new ArrayList<>();
        while (resultSet.next()){
            user_set.add(new Account(resultSet.getInt(1), resultSet.getString(2),
                                                                        resultSet.getInt(3)));
        }
        for (Account account : user_set)
        {
            System.out.println("id: " + account.getId() + "name: " + account.getName() + "money: " + account.getMoney());
        }

    }


}
