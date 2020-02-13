package com.softserve.boardgameShack.servlet.listener;

import com.softserve.boardgameShack.dao.CategoryDao;
import com.softserve.boardgameShack.entity.Category;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class BackgroundListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getAll();
        ServletContext context = sce.getServletContext();
        context.setAttribute("categories", categories);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
