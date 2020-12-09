package mk.finki.ukim.mk.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order-servlet", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        String size = req.getParameter("size");
        webContext.setVariable("size", size);
        webContext.setVariable("color",req.getSession().getAttribute("color"));
        req.getSession().setAttribute("size",size);

        springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }
}
