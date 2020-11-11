package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import mk.finki.ukim.mk.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if (error!=null && error.isEmpty() )
        {
           model.addAttribute("hasError", true);
           model.addAttribute("error",error);
        }
        model.addAttribute("balloons",balloonService.listAll());
        return "listBalloons";
    }
    @GetMapping("/add")
    public String addBalloon(Model model){
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("balloon",null);
        return "add-balloon";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long manuId){
        try{
            balloonService.saveOrUpdate(name,description,manuId);
        }catch (RuntimeException e){
            return "redirect:/listBalloons?error="+e.getMessage();
        }
        return "redirect:/balloons";
    }
    @PostMapping("/edit-form/{id}")
    public String saveBalloon(@PathVariable long id, Model model){
        Optional<Balloon> optionalBalloon = balloonService.getBalloonById(id);
        if(optionalBalloon.isEmpty())
            return "redirect:/listBalloons?=error"+"BalloonNotFound";
        Balloon balloon = optionalBalloon.get();
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("balloon",balloon);
        return "add-balloon";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

}
