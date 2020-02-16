package com.softserve.boardgameShack.servlet.admin;

import com.mysql.cj.util.StringUtils;
import com.softserve.boardgameShack.entity.Category;
import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.service.CategoryService;
import com.softserve.boardgameShack.service.CategoryServiceImpl;
import com.softserve.boardgameShack.service.GameService;
import com.softserve.boardgameShack.service.GameServiceImpl;
import com.sun.deploy.util.ArrayUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/admin/gameSave")
public class GameSaveServlet extends HttpServlet {

    private final GameService gameService = new GameServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final List<Category> categories = categoryService.getAll();
        req.setAttribute("categories", categories);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameSaveForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final Game game = new Game();
        game.setName(req.getParameter("name"));
        game.setPrice(Double.valueOf(req.getParameter("price")));
        game.setTimeToPlay(req.getParameter("timeToPlay"));
        game.setPlayerNumber(req.getParameter("playerNumber"));
        game.setDescription(req.getParameter("description"));
        game.setLanguage(req.getParameter("language"));
        game.setImage(req.getParameter("image"));
        final String publishingHouse = req.getParameter("publishingHouse");
        final String[] categoryArray = req.getParameterValues("categoryArray");
        final List<String> categoryNames = categoryArray != null && categoryArray.length > 0 ?
                Arrays.asList(categoryArray) : Collections.emptyList();

        gameService.add(game, publishingHouse, categoryNames);
        resp.sendRedirect("/homepage");
    }
}
