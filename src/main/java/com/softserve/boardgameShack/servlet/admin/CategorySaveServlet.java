package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.dao.CategoryDao;
import com.softserve.boardgameShack.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/categorySave")
public class CategorySaveServlet extends HttpServlet {

    private final CategoryDao categoryDao = new CategoryDao();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/categorySaveForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final Category category = new Category();
        category.setName(req.getParameter("name"));
        category.setImage(req.getParameter("image"));
        categoryDao.add(category);
        resp.sendRedirect("/admin/adminPage");
    }
}
