package com.itprogerBro.bro_dodor.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerBr {
    @GetMapping("/")
    public ModelAndView methodHomeGet(ModelMap model) {
        model.addAttribute("title", "Important article");
        return new ModelAndView("home", model);
    }
}