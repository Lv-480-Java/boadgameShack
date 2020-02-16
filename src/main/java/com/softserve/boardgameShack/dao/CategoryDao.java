package com.softserve.boardgameShack.dao;

import com.softserve.boardgameShack.entity.Category;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GenericDao<Category> {
    private static final String GET_BY_NAME = "select * from categories where name = ?";
    private static final String GET_BY_NAME_WILDCARD = "select * from categories where name like ?";
    private static final String GET_BY_ID = "select * from categories where id = ?";
    private static final String GET_ALL = "select * from categories";
    private static final String ADD_CATEGORY = "insert into categories (name, image) values (?, ?)";
    private static final String UPDATE_CATEGORY = "update categories set name = ?, image = ? where id = ?";
    private static final String DELETE_CATEGORY = "delete from categories where id = ?";
    private static final Logger logger = Logger.getLogger(CategoryDao.class.getName());

    public Category getByName(final String name) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)) {

            preparedStatement.setString(1, name);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Category category = new Category();
                category.setId(resultSet.getLong(1));
                category.setName(resultSet.getString(2));
                category.setImage(resultSet.getString(3));
                return category;
            }
        } catch (final SQLException e) {
            logger.error("Issue with getting category" +
                    " from database");
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> getByNameWildcard(final String name) {
        final List<Category> categories = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME_WILDCARD)) {

            final String wildcard = "%" + name + "%";
            preparedStatement.setString(1, wildcard);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Category category = new Category();
                category.setId(resultSet.getLong(1));
                category.setName(resultSet.getString(2));
                category.setImage(resultSet.getString(3));
                categories.add(category);
            }
        } catch (final SQLException e) {
            logger.error("Issue with getting category" +
                    " from database");
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(final long id) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Category category = new Category();
                category.setId(Long.valueOf(resultSet.getString(1)));
                category.setName(resultSet.getString(2));
                category.setImage(resultSet.getString(3));
                return category;
            }
        } catch (final SQLException e) {
            logger.error("Issue with getting category from database");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        final List<Category> categories = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final Statement statement = connection.createStatement()) {

            final ResultSet resultSet = statement.executeQuery(GET_ALL);

            while (resultSet.next()) {
                final Category category = new Category();
                category.setId(1);
                category.setName(resultSet.getString(2));
                category.setImage(resultSet.getString(3));
                categories.add(category);
            }
        } catch (final SQLException e) {
            logger.error("Issue with getting category" +
                    " from database");
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void add(final Category model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(ADD_CATEGORY)) {
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getImage());
            preparedStatement.execute();
        } catch (final SQLException e) {
            logger.error("Issue with adding new category" +
                    " to database");
            e.printStackTrace();
        }
    }

    @Override
    public void update(final Category model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY)) {

            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getImage());
            preparedStatement.setLong(3, model.getId());

            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with updating category" +
                    "");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Category model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY)) {

            preparedStatement.setLong(1, model.getId());

            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with deleting category" +
                    " from database");
            e.printStackTrace();
        }
    }
}
