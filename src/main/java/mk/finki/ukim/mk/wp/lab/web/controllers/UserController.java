package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.model.exceptions.LoginFailException;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
import mk.finki.ukim.mk.wp.lab.service.impl.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    private String getLoginPage(){
        return "login";
    }
    @PostMapping
    public String checkUser(HttpServletRequest request, Model model){
        User user = null;
        try{
            user = this.authService.successfulLogin(request.getParameter("username")
                    ,request.getParameter("password"))
                    .orElseThrow(()-> new LoginFailException("Password or username is wrong"));
            request.getSession().setAttribute("user",user);
            return "/bravo";
        }catch (Exception e){
        model.addAttribute("hasError", true);
        model.addAttribute("error", "Login Error");
        return "/login";
        }

    }
}