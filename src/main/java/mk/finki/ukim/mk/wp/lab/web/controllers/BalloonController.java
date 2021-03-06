package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import mk.finki.ukim.mk.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error,
                                  @RequestParam(required = false) String search,
                                  Model model){
        if (error!=null && !error.isEmpty() )
        {
           model.addAttribute("hasError", true);
           model.addAttribute("error",error);
        }
        if(search!=null && !search.isEmpty())
        {
            model.addAttribute("balloons",balloonService.searchByNameOrDescription(search));
            return "listBalloons";
        }
        model.addAttribute("bodyContent","listBalloons");
        model.addAttribute("balloons",balloonService.listAll());
        return "master-template";
    }
    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("bodyContent","add-balloon");
        model.addAttribute("balloon",null);
        return "master-template";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long manuId){
            balloonService.saveOrUpdate(name,description,manuId);
        return "redirect:/balloons";
    }
    @PostMapping("/edit-form/{id}")
    public String saveBalloon(@PathVariable long id, Model model){
        Balloon balloon = balloonService.getBalloonById(id);
        if(balloon==null)
            return "redirect:/balloons?=error"+"BalloonNotFound";

        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("balloon",balloon);
        return "add-balloon";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }
    @PostMapping("/select-balloon")
    public String selectBalloon(@RequestParam String color, HttpServletRequest request, Model model){
        request.getSession().setAttribute("color", color);
        return "selectBalloonSize";
    }
//    @GetMapping("/search-balloon")
//    public String searchBalloon(@RequestParam String searchQuery, Model model){
//        model.addAttribute("balloons", balloonService.searchByNameOrDescription("searchQuery"));
//        return "listBalloons";
//    }
    @PostMapping("/confirm-info")
    public String ConfirmInfo(@RequestParam String size,HttpServletRequest request, Model model)
    {
        model.addAttribute("ipAddress",request.getRemoteHost());
        model.addAttribute("agent",request.getHeader("User-Agent"));
        request.getSession().setAttribute("size",size);
        return "confirmationInfo";
    }


}
