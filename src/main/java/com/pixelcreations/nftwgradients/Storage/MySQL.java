package com.pixelcreations.nftwgradients.Storage;

import com.pixelcreations.nftwgradients.Utils.ConfigManager;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL {
    String HOST = ConfigManager.getHost();
    int PORT = ConfigManager.getPort();
    String DATABASE = ConfigManager.getDatabase();
    String USER = ConfigManager.getUser();
    String PASSWORD = ConfigManager.getPass();
    private static HikariDataSource hikari;

    private Connection connection;

    public void connect() throws SQLException {
        hikari = new HikariDataSource();
        hikari.setConnectionTimeout(300000);
        hikari.setMaxLifetime(600000);
        hikari.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", HOST);
        hikari.addDataSourceProperty("port", PORT);
        hikari.addDataSourceProperty("databaseName", DATABASE);
        hikari.addDataSourceProperty("user", USER);
        hikari.addDataSourceProperty("password", PASSWORD);

        hikari.addDataSourceProperty("cachePrepStmts", "true");
        hikari.addDataSourceProperty("prepStmtCacheSize", "250");
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    public HikariDataSource getHikari() {
        return hikari;
    }

    public static Connection getConnection() throws SQLException {
        return hikari.getConnection();
    }

    public boolean isConnected() {return hikari != null;}

    public void disconnect() {
        if (isConnected()) {
            hikari.close();
        }
    }
}

