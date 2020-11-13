package mk.finki.ukim.mk.wp.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class BalloonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String color =(String) request.getSession().getAttribute("color");

        String path = request.getServletPath();
//        boolean correctPath = !"/add-form".equals(path)
//                &&!"/add".equals(path)&&!"/orders".equals(path)
//                &&!path.contains("edit-form");
        if (!path.contains("/balloons")
                && !path.contains("/orders")
                && !path.equals("/selectBalloon")
                && (color==null || color.isEmpty())) {
            response.sendRedirect("/balloons");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
