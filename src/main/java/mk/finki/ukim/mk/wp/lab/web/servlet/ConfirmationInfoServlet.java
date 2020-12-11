package mk.finki.ukim.mk.wp.lab.web.servlet;

import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
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
    private  final OrderService orderService;


    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("color")==null)
            resp.sendRedirect("/*");
        String clName = req.getParameter("clientName");
        String clAddr = req.getParameter("clientAddress");
        String clColor = (String)req.getSession().getAttribute("color");
        String clSize = (String)req.getSession().getAttribute("size");
        //User user= new User(clName,clAddr);
       // req.getSession().setAttribute("user",user);
        orderService.placeOrder(clColor,clSize,clName);
        WebContext webContext = new WebContext(req,resp, req.getServletContext());
        webContext.setVariable("color", clColor );
        webContext.setVariable("size", clSize);
        webContext.setVariable("clientName",clName );
        webContext.setVariable("clientAddress", clAddr);
        webContext.setVariable("ipAddress",req.getRemoteHost());
        webContext.setVariable("agent",req.getHeader("User-Agent"));
        req.getSession().setAttribute("clientName",clName);
        req.getSession().setAttribute("clientAddress", clAddr);
        springTemplateEngine.process("confirmationInfo.html",webContext,resp.getWriter());
    }
}
