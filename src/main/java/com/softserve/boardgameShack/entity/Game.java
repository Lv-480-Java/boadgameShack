package com.softserve.boardgameShack.entity;

import java.util.List;

public class Game {

    private long id;

    private String name;

    private double price;

    private String timeToPlay;

    private String playerNumber;

    private String description;

    private String language;

    private PublishingHouse publishingHouse;

    private List<Category> categories;

    private String image;

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getTimeToPlay() {
        return timeToPlay;
    }

    public void setTimeToPlay(final String timeToPlay) {
        this.timeToPlay = timeToPlay;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(final String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(final PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(final List<Category> categories) {
        this.categories = categories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", timeToPlay='" + timeToPlay + '\'' +
                ", playerNumber='" + playerNumber + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", publishingHouse=" + publishingHouse +
                '}';
    }
}
