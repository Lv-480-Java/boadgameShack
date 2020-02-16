package com.softserve.boardgameShack.servlet.admin;

import com.softserve.boardgameShack.entity.Game;
import com.softserve.boardgameShack.service.GameService;
import com.softserve.boardgameShack.service.GameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/gameDelete")
public class GameDeleteServlet extends HttpServlet {

    private final GameService gameService = new GameServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final long id = Long.parseLong(req.getParameter("id"));
        final Game game = gameService.getById(id);
        req.setAttribute("game", game);
        gameService.delete(game);
        resp.sendRedirect("/gameList");
    }
}
