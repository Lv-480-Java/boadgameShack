package com.softserve.boardgameShack.dao;

import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.entity.Order;
import com.softserve.boardgameShack.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements GenericDao<Order> {

    private static final String GET_BY_ID = "select * from orders where id = ?";
    private static final String GET_ALL = "select * from orders";
    private static final String ADD_ORDER = "insert into orders (datetime, order_details, game_id, user_id) " +
            "values (?, ?, ?, ?)";
    private static final Logger logger = Logger.getLogger(OrderDao.class.getName());
    private static final GameDao gameDao = new GameDao();
    private static final UserDao userDao = new UserDao();
//    private static final String UPDATE_ORDER = "update orders set datetime = ?, order_details = ?, game_id = ?, " +
//            "user_id = ? where id = ?";
//    private static final String DELETE_ORDER = "delete from orders where id = ?";

    @Override
    public Order getById(final long id) {
        Order order = null;
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = convertToModel(resultSet);

            }

        } catch (final SQLException e) {
            logger.error("Issue with getting order from database");
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getAll() {
        final List<Order> orders = new ArrayList<>();
        try (final Connection connection = ConnectionFactory.getConnection();
             final Statement statement = connection.createStatement()) {

            final ResultSet resultSet = statement.executeQuery(GET_ALL);

            while (resultSet.next()) {
                orders.add(convertToModel(resultSet));
            }
        } catch (final SQLException e) {
            logger.error("Issue with getting order from database");
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void add(final Order model) {
        try (final Connection connection = ConnectionFactory.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER)) {
            convertToStatement(model, preparedStatement);

        } catch (final SQLException e) {
            logger.error("Issue with adding new order to database");
            e.printStackTrace();
        }
    }

    @Override
    public void update(final Order model) {
//        try (Connection connection = ConnectionFactory.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER)) {
//
//            convertToStatement(model, preparedStatement);
//            preparedStatement.setLong(5, model.getId());
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            logger.error("Issue with updating order");
//            e.printStackTrace();
//        }
        throw new UnsupportedOperationException("Update operation for order does not support");
    }

    @Override
    public void delete(final Order model) {
//        try (Connection connection = ConnectionFactory.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER)){
//
//            preparedStatement.setLong(1, model.getId());
//
//            preparedStatement.execute();
//
//        }catch (SQLException e){
//            logger.error("Issue with deleting order from database");
//            e.printStackTrace();
//        }
        throw new UnsupportedOperationException("Delete operation for order does not support");
    }

    private Order convertToModel(final ResultSet resultSet) throws SQLException {
        final Order order = new Order();
        order.setId(resultSet.getLong(1));
        order.setDateTime(resultSet.getObject(2, LocalDateTime.class));
        order.setOrderDetails(resultSet.getString(3));
        final Game game = gameDao.getById(resultSet.getLong(4));
        if (game != null) {
            order.setGame(game);
        }
        final User user = userDao.getById(resultSet.getLong(5));
        if (user != null) {
            order.setUser(user);
        }
        return order;
    }

    private void convertToStatement(final Order model, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setObject(1, model.getDateTime());
        preparedStatement.setString(2, model.getOrderDetails());
        preparedStatement.setLong(3, model.getGame().getId());
        preparedStatement.setLong(4, model.getUser().getId());

        preparedStatement.execute();
    }
}
