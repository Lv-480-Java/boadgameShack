package com.softserve.boardgameShack.servlet;

import com.softserve.boardgameShack.entity.Category;
import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.service.CategoryService;
import com.softserve.boardgameShack.service.CategoryServiceImpl;
import com.softserve.boardgameShack.service.GameService;
import com.softserve.boardgameShack.service.GameServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private final GameService gameService = new GameServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final List<Game> games;
        games = gameService.getByNameWildcard(req.getParameter("name"));
        req.setAttribute("games", games);
        final List<Category> categories;
        categories = categoryService.getByNameWildcard(req.getParameter("name"));
        req.setAttribute("categories", categories);
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/searchResult.jsp");
        requestDispatcher.forward(req, resp);

//        if (games.size() == 0) {
//            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/homepage.jsp");
//            requestDispatcher.forward(req, resp);
//        } else if ((games.size() == 1)) {
//            final Game view = games.get(0);
//            req.setAttribute("model", view);
//            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameView.jsp");
//            requestDispatcher.forward(req, resp);
//        } else {
//            req.setAttribute("games", games);
//            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameList.jsp");
//            requestDispatcher.forward(req, resp);
//        }
    }
}
