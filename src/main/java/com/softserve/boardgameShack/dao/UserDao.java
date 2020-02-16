package com.softserve.boardgameShack.dao;

import com.softserve.boardgameShack.entity.User;
import com.softserve.boardgameShack.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GenericDao<User> {

    private static final String GET_BY_NAME = "select * from users where name = ?";
    private static final String GET_BY_EMAIL = "select * from users where email = ?";
    private static final String GET_BY_ID = "select * from users where id = ?";
    private static final String GET_ALL = "select * from users";
    private static final String CREATE_USER = "insert into users (name, password, email, phone, user_role) " +
            "values (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "update users set name = ?, password = ?, email = ?, " +
            "phone = ?, user_role = ? where id = ?";
    private static final String DELETE_USER = "delete from users where id = ?";
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());

    public List<User> getByName(final String name) {
        final List<User> users = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)) {

            preparedStatement.setString(1, name);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(convertToUser(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting users from database");
            e.printStackTrace();
        }

        return users;
    }

    public User getByEmail(final String email) {
        User user = null;
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user = convertToUser(resultSet);
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting users from database");
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getById(final long id) {
        User user = new User();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = convertToUser(resultSet);

        } catch (final SQLException e) {
            logger.error("Issue with getting user from database");
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        final List<User> users = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final Statement statement = connection.createStatement()) {

            final ResultSet resultSet = statement.executeQuery(GET_ALL);

            while (resultSet.next()) {
                users.add(convertToUser(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting users from database");
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void add(final User model) {
        if (model.getUserRole() == null) {
            model.setUserRole(UserRole.USER);
        }
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {
            convertToStatement(model, preparedStatement);

            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with adding new user to database");
            e.printStackTrace();
        }
    }

    @Override
    public void update(final User model) {
        if (model.getUserRole() == null) {
            model.setUserRole(UserRole.USER);
        }
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            convertToStatement(model, preparedStatement);

            preparedStatement.setLong(6, model.getId());
            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with updating user");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final User model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setLong(1, model.getId());
            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with deleting user");
            e.printStackTrace();
        }
    }

    private void convertToStatement(final User model, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getPassword());
        preparedStatement.setString(3, model.getEmail());
        preparedStatement.setString(4, model.getPhone());
        preparedStatement.setString(5, model.getUserRole().name());
    }

    private User convertToUser(final ResultSet resultSet) throws SQLException {
        final User user = new User();
        user.setId(resultSet.getLong(1));
        user.setName(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        user.setPhone(resultSet.getString(5));
        user.setUserRole(UserRole.valueOf(resultSet.getString(6)));
        return user;
    }
}
