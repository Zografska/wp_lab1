package mk.finki.ukim.mk.wp.lab.web;

import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import mk.finki.ukim.mk.wp.lab.service.impl.BalloonServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloon-servlet", urlPatterns = "/*")
public class BalloonServlet extends HttpServlet {

     BalloonServiceImpl balloonService;
     private final SpringTemplateEngine springTemplateEngine;

    public BalloonServlet(BalloonServiceImpl balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        webContext.setVariable("balloons",balloonService.listAll());
        springTemplateEngine.process("listBalloons.html",webContext,resp.getWriter());
    }
}
