package com.jjx.db;

/**
 * Created by TandTV on 2016/12/16.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接池参数设置
 */
public class DbcpConnection {

    private static DataSource dataSource;
    private static Connection connection;

    public static void initDataSource() {

        FileInputStream is = null;
        Properties properties = new Properties();

        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;
        String serverTimezone = null;

        int initialSize = 0;
        int minIdle = 0;
        int maxIdle = 0;
        int maxWait = 0;
        int maxActive = 0;

        driverClassName = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/sakila?&serverTimezone=GMT";
        username = "root";
        password = "123456";
        initialSize = 30;
        minIdle = 10;
        maxIdle = 10;
        maxWait = 1000;
        maxActive = 30;

        BasicDataSource bds = new BasicDataSource();

        bds.setUrl(url);
        bds.setDriverClassName(driverClassName);
        bds.setUsername(username);
        bds.setPassword(password);
        bds.setInitialSize(initialSize);
        bds.setMaxActive(maxActive);
        bds.setMinIdle(minIdle);
        bds.setMaxIdle(maxIdle);
        bds.setMaxWait(maxWait);

        dataSource = bds;
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            initDataSource();
        }
        Connection conn = null;
        if (dataSource != null) {
            conn = dataSource.getConnection();
        }
        return conn;
    }
}
