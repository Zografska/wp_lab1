package mk.finki.ukim.mk.wp.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("color")==null)
            resp.sendRedirect("/*");
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        webContext.setVariable("color", req.getSession().getAttribute("color"));
        webContext.setVariable("size", req.getSession().getAttribute("size"));
        webContext.setVariable("clientName", req.getParameter("clientName"));
        webContext.setVariable("clientAddress", req.getParameter("clientAddress"));
        webContext.setVariable("ipAddress",req.getRemoteHost());
        webContext.setVariable("agent",req.getHeader("User-Agent"));
        req.getSession().invalidate();
        springTemplateEngine.process("confirmationInfo.html",webContext,resp.getWriter());
    }
}
