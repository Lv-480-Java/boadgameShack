package com.softserve.boardgameShack.entity;

import java.time.LocalDateTime;

public class Order {

    private long id;

    private LocalDateTime dateTime;

    private String orderDetails;

    private Game game;

    private User user;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(final LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(final String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", orderDetails='" + orderDetails + '\'' +
                ", games=" + game +
                ", user=" + user +
                '}';
    }
}
