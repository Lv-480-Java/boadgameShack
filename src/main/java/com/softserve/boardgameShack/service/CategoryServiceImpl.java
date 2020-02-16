package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.dao.CategoryDao;
import com.softserve.boardgameShack.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDao();

    @Override
    public Category getById(final long id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category getByName(final String name) {
        return categoryDao.getByName(name);
    }

    @Override
    public List<Category> getByNameWildcard(final String name) {
        return categoryDao.getByNameWildcard(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
