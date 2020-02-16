package com.softserve.boardgameShack.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoimpl implements LoginDao {

    private static final String CHECK_LOGIN = "select * from users where name = ? and password = ?";
    private static final Logger logger = Logger.getLogger(LoginDaoimpl.class.getName());

    @Override
    public boolean checkUserProperties(final String name, final String password) {
        boolean status = false;
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            final ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (final SQLException e) {
            logger.error("Issue in username validation");
            e.printStackTrace();
        }
        return status;
    }
}