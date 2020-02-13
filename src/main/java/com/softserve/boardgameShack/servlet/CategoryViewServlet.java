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

@WebServlet("/categoryView")
public class CategoryViewServlet extends HttpServlet {

    private GameService gameService = new GameServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = categoryService.getByName(req.getParameter("name"));
        List<Game> games = gameService.getByCategory(category);

        if (games.size() == 0){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/homepage.jsp");
            requestDispatcher.forward(req, resp);
        }else if ((games.size() == 1)) {
            Game view = games.get(0);
            req.setAttribute("model", view);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameView.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            req.setAttribute("games", games);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gameList.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
