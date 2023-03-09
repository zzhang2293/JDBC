package user;
import Shop.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserFunc {
    public static Properties prop = new Properties();
    public static DataSource dataSource;
    public static Connection connection;
    public static PreparedStatement statement;
    public static FileReader reader;
    public static ResultSet resultSet;
    public static void initialize() throws Exception{
        reader = new FileReader(System.getProperty("user.dir")+ "/src/tb.properties");
        prop.load(reader);
        dataSource = DruidDataSourceFactory.createDataSource(prop);
        connection = dataSource.getConnection();
        reader.close();

    }
    public static void closeAll() throws Exception {

        statement.close();
        connection.close();
    }
    public static List<Brand> SelectAll() throws Exception{
        // user current directory
        initialize();
        List<Brand> res = new ArrayList<>();
        String sql = "select * from tb_brand;";
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            res.add(new Brand(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4),
                    resultSet.getString(5), resultSet.getInt(6)));
        }
        resultSet.close();
        closeAll();
        return res;
    }
    public static int modify(String sql) throws Exception{
        initialize();
        statement = connection.prepareStatement(sql);
        int num = statement.executeUpdate();
        closeAll();
        return num;

    }
}
