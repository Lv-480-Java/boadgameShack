package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.entity.Category;
import com.softserve.boardgameShack.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> getByName(String name);

    List<Game> getByNameWildcard(String name);

    Game getById(long id);

    List<Game> getByCategory(Category category);

    List<Game> getAll();

    void add(Game model, String houseName, List<String> categoryNames);

    void update(Game model, String houseName, List<String> categoryNames);

    void delete(Game model);
}
