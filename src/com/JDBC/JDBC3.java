package com.JDBC;

import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBC3 {
    public static int create_user (String name, String password, @NotNull Connection connection) throws Exception{
        String sql = "select * from login where name= ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return -1;
        preparedStatement.close();

        String create = "insert into login (name, password) values (?, ?)";
        preparedStatement = connection.prepareStatement(create);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        int num = preparedStatement.executeUpdate();
        preparedStatement.close();
        return  num;

    }
    public static int login(String name, String password, @NotNull Connection connection) throws Exception{
        String sql = "select * from login where name=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();

        if (!result.next()) return -1;
        preparedStatement.close();
        return 0;
    }

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/account";
        String name = "root";
        String password = "01*gbcfd&wzn";
        Connection connection = DriverManager.getConnection(url, name, password);
//        if (create_user("Frank", "' or '1' = '1", connection) == -1){
//            System.out.println("already exists");
//        }else{
//            System.out.println("success create account! ");
//        }
        if (login("Frank", "' or '1' = '1", connection) == -1){
            System.out.println("failed login");
        }else {
            System.out.println("login success!");
        }



    }
}
