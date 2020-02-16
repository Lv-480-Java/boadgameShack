package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.dao.CategoryDao;
import com.softserve.boardgameShack.dao.GameDao;
import com.softserve.boardgameShack.dao.PublishingHouseDao;
import com.softserve.boardgameShack.entity.Category;
import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.entity.PublishingHouse;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    private final GameDao gameDao = new GameDao();
    private final CategoryDao categoryDao = new CategoryDao();
    private final PublishingHouseDao publishingHouseDao = new PublishingHouseDao();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public List<Game> getByName(final String name) {
        return gameDao.getGamesByName(name);
    }

    @Override
    public List<Game> getByNameWildcard(final String name) {
        return gameDao.getGamesByNameWildcard(name);
    }

    @Override
    public Game getById(final long id) {
        final Game game = gameDao.getById(id);
        game.setCategories(categoryDao.getCategoriesForGame(game.getId()));
        return game;
    }

    @Override
    public List<Game> getByCategory(final Category category) {
        return gameDao.getGamesByCategory(category);
    }

    @Override
    public List<Game> getByPublishingHouse(final PublishingHouse publishingHouse) {
        return gameDao.getGamesByPublishingHouse(publishingHouse);
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }

    @Override
    public void add(final Game model, final String houseName, final List<String> categoryNames) {
        setCategoriesToGame(model, categoryNames);
        setPublishingHouseToGame(model, houseName);
        gameDao.add(model);
    }

    @Override
    public void update(final Game model, final String houseName, final List<String> categoryNames) {
        setCategoriesToGame(model, categoryNames);
        setPublishingHouseToGame(model, houseName);
        gameDao.update(model);
    }

    @Override
    public void delete(final Game model) {
        gameDao.delete(model);
    }

    private void setPublishingHouseToGame(final Game model, final String houseName) {
        if (houseName.equals("")) {
            return;
        }
        final List<PublishingHouse> publishingHouseList = publishingHouseDao.getByName(houseName);
        if (publishingHouseList.size() != 0) {
            model.setPublishingHouse(publishingHouseList.get(0));
        } else {
            final PublishingHouse publishingHouse = new PublishingHouse();
            publishingHouse.setName(houseName);
            publishingHouseDao.add(publishingHouse);
            model.setPublishingHouse(publishingHouseDao.getByName(houseName).get(0));
        }
    }

    private void setCategoriesToGame(final Game model, final List<String> categoryNames) {
        if (categoryNames.size() != 0) {
            final List<Category> categories = new ArrayList<>();
            for (final String categoryName : categoryNames) {
                categories.add(categoryService.getByName(categoryName));
            }
            model.setCategories(categories);
        }
    }
}
