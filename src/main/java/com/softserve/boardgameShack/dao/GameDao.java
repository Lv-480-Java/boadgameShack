package com.softserve.boardgameShack.dao;

import com.softserve.boardgameShack.entity.Category;
import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.entity.PublishingHouse;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao implements GenericDao<Game> {

    private static final String GET_BY_NAME = "SELECT * FROM games WHERE name = ?";
    private static final String GET_BY_NAME_WILDCARD = "SELECT * FROM games WHERE name like ?";
    private static final String GET_BY_ID = "SELECT * FROM games WHERE id = ?";
    private static final String GET_BY_CATEGORY = "SELECT g.id, g.name, g.price, g.time_to_play, g.player_number, " +
            "g.description, g.language, g.publishing_house_id, g.image FROM games g JOIN " +
            "games_categories gc ON g.id = gc.game_id JOIN categories c ON gc.category_id = c.id WHERE c.id = ?";
    private static final String GET_BY_PUBLISHING_HOUSE = "SELECT * FROM games WHERE publishing_house_id = ?";
    private static final String GET_ALL = "SELECT * FROM games";
    private static final String CREATE_GAME = "INSERT INTO games (name, price, time_to_play, player_number," +
            " description, language, publishing_house_id, image) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_GAME = "UPDATE games set name = ?, price = ?, time_to_play = ?, " +
            "player_number = ?, description = ?, language = ?, publishing_house_id = ?, image = ? WHERE id = ?";
    private static final String DELETE_GAME = "DELETE FROM games WHERE id = ?";
    private static final String SET_CATEGORIES = "INSERT INTO games_categories (game_id, category_id) values (?, ?)";
    private static final String GET_CATEGORIES = "SELECT c.name FROM categories c JOIN games_categories gc " +
            "on c.id = gc.category_id WHERE gc.game_id = ?";

    private static final Logger logger = Logger.getLogger(GameDao.class.getName());
    private final PublishingHouseDao publishingHouseDao = new PublishingHouseDao();
    private final CategoryDao categoryDao = new CategoryDao();

    public List<Game> getByName(final String name) {
        final List<Game> games = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)) {

            preparedStatement.setString(1, name);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                games.add(convertToGame(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting games from database");
            e.printStackTrace();
        }

        return games;
    }

    public List<Game> getByNameWildcard(final String name) {
        final List<Game> games = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME_WILDCARD)) {

            final String wildcard = "%" + name + "%";
            preparedStatement.setString(1, wildcard);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                games.add(convertToGame(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting games from database");
            e.printStackTrace();
        }

        return games;
    }

    @Override
    public Game getById(final long id) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final Game game = convertToGame(resultSet);
                setCategoriesToGame(connection, resultSet, game);
                return game;
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting game from database");
            e.printStackTrace();
        }

        return null;
    }

    public List<Game> getByCategory(final Category category) {
        final List<Game> games = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CATEGORY)) {

            preparedStatement.setLong(1, category.getId());
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                games.add(convertToGame(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting games from database");
            e.printStackTrace();
        }

        return games;
    }

    public List<Game> getByPublishingHouse(final PublishingHouse ph) {
        final List<Game> games = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_PUBLISHING_HOUSE)) {

            preparedStatement.setLong(1, ph.getId());
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                games.add(convertToGame(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting games from database");
            e.printStackTrace();
        }

        return games;
    }

    @Override
    public List<Game> getAll() {
        final List<Game> games = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final Statement statement = connection.createStatement()) {

            final ResultSet resultSet = statement.executeQuery(GET_ALL);

            while (resultSet.next()) {
                games.add(convertToGame(resultSet));
            }

        } catch (final SQLException e) {
            logger.error("Issue with getting games from database");
            e.printStackTrace();
        }

        return games;
    }

    @Override
    public void add(final Game model) {

        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(CREATE_GAME)) {
            convertToStatement(model, preparedStatement);

            preparedStatement.execute();
            final Game game = getByName(model.getName()).get(0);
            if (model.getCategories() != null && !model.getCategories().isEmpty()) {
                for (final Category category : model.getCategories()) {
                    try (final PreparedStatement preparedStatement1 = connection.prepareStatement(SET_CATEGORIES)) {
                        preparedStatement1.setLong(1, game.getId());
                        preparedStatement1.setLong(2, category.getId());
                        preparedStatement1.execute();
                    }
                }
            }
        } catch (final SQLException e) {
            logger.error("Issue with adding new game to database");
            e.printStackTrace();
        }
    }

    @Override
    public void update(final Game model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GAME)) {
            convertToStatement(model, preparedStatement);

            preparedStatement.setLong(9, model.getId());

            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with updating game");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Game model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GAME)) {

            preparedStatement.setLong(1, model.getId());

            preparedStatement.execute();

        } catch (final SQLException e) {
            logger.error("Issue with deleting game from database");
            e.printStackTrace();
        }
    }

    private void convertToStatement(final Game model, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, model.getName());
        preparedStatement.setDouble(2, model.getPrice());
        preparedStatement.setString(3, model.getTimeToPlay().isEmpty() ? null : model.getTimeToPlay());
        preparedStatement.setString(4, model.getPlayerNumber().isEmpty() ? null : model.getPlayerNumber());
        preparedStatement.setString(5, model.getDescription().isEmpty() ? null : model.getDescription());
        preparedStatement.setString(6, model.getLanguage().isEmpty() ? null : model.getLanguage());
        if (model.getPublishingHouse() == null) {
            preparedStatement.setNull(7, Types.BIGINT);
        } else {
            preparedStatement.setLong(7, model.getPublishingHouse().getId());
        }
        preparedStatement.setString(8, model.getImage());
    }

    private Game convertToGame(final ResultSet resultSet) throws SQLException {
        final Game game = new Game();
        game.setId(resultSet.getLong(1));
        game.setName(resultSet.getString(2));
        game.setPrice(resultSet.getDouble(3));
        game.setTimeToPlay(resultSet.getString(4));
        game.setPlayerNumber(resultSet.getString(5));
        game.setDescription(resultSet.getString(6));
        game.setLanguage(resultSet.getString(7));
        game.setImage(resultSet.getString(9));
        final PublishingHouse house = publishingHouseDao.getById(resultSet.getLong(8));
        if (house != null) {
            game.setPublishingHouse(publishingHouseDao.getById(resultSet.getLong(8)));
        }
        return game;
    }

    private void setCategoriesToGame(final Connection connection, final ResultSet resultSet, final Game game) throws SQLException {
        try (final PreparedStatement preparedStatement1 = connection.prepareStatement(GET_CATEGORIES)) {
            preparedStatement1.setLong(1, game.getId());
            final ResultSet resultSet1 = preparedStatement1.executeQuery();
            final List<Category> categories = new ArrayList<>();
            while (resultSet1.next()) {
                categories.add(categoryDao.getByName(resultSet1.getString("name")));
            }
            if (!categories.isEmpty()) {
                game.setCategories(categories);
            }
        }
    }
}
