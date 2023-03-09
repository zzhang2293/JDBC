package com.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class JDBC_Druid {
    public static void main(String[] args) throws Exception{
        // load in jar
        Properties prop = new Properties();
        prop.load(new FileReader(System.getProperty("user.dir") + "/src/druid.properties"));
        // get the connection object
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        // read everything from the properties file
        System.out.println(connection);
        // this line get user.dir
        //System.out.println(System.getProperty("user.dir"));

    }
}
