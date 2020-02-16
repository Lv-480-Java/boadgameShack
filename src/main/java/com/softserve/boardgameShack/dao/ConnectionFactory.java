package com.softserve.boardgameShack.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;
    private Connection connection;
    private static final String USER = "mike";
    private static final String PASS = "mike";
    private static final String URL = "jdbc:mysql://localhost:3306/boardgameshack";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    private ConnectionFactory() throws SQLException{
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
            logger.info("Connection OK");

        } catch (final ClassNotFoundException e) {
            logger.error("Unable to connect with database");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        } else if (instance.connection.isClosed()) {
            instance = new ConnectionFactory();
        }

        return instance.connection;
    }
}