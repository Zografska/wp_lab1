package mk.finki.ukim.mk.wp.lab.web;

import mk.finki.ukim.mk.wp.lab.service.impl.BalloonServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet(name = "select-balloon-servlet",urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {

        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        String color = req.getParameter("color");
        if (color==null || color.isEmpty())
            resp.sendRedirect("/servlet");
        req.getSession().setAttribute("color",color);
        webContext.setVariable("color", color);
        springTemplateEngine.process("selectBalloonSize.html",webContext,resp.getWriter());
    }
}
