package mk.finki.ukim.mk.wp.lab.web.servlet;

import mk.finki.ukim.mk.wp.lab.service.impl.BalloonServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/searchBalloon", name = "search-balloon-servlet")
public class SearchBalloonServlet extends HttpServlet {
    private  final SpringTemplateEngine springTemplateEngine;
    BalloonServiceImpl balloonService;

    public SearchBalloonServlet(SpringTemplateEngine springTemplateEngine, BalloonServiceImpl balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        String searchText = req.getParameter("search");
        webContext.setVariable("search", searchText);
        webContext.setVariable("balloons", balloonService.searchByNameOrDescription(searchText));
        springTemplateEngine.process("searchBalloons.html",webContext,resp.getWriter());
    }
}
