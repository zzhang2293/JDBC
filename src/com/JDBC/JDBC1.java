package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC1 {
    public static void main(String[] args) throws Exception {
        // get driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // get connection
        String url = "jdbc:mysql://127.0.0.1:3306/account";
        String username = "root";
        String password = "01*gbcfd&wzn";
        Connection connection = DriverManager.getConnection(url, username, password);
        //String sql = "insert into account.account (name, money) values ('Frank', 2134)";

        // get sql object
        Statement statement = connection.createStatement();
        //int count = statement.executeUpdate(sql);
        // rollback, commit,
        String sql2 = "update account.account set money = 3000 where user_id = 1";
        String sql3 = "update account.account set money = 5000 where user_id = 3";
        try {
            // start the affairs
            connection.setAutoCommit(false);
            // execute sql
            // count is the num of tuples that is influenced
            int count2 = statement.executeUpdate(sql2);
            System.out.println(count2);
            // ddl may return 0
            int count3 = statement.executeUpdate(sql3);
            System.out.println(count3);
            // commit the sql
            connection.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            //rollback
            connection.rollback();
        }

    }
}