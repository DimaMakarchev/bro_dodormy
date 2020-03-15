package com.itprogerBro.bro_dodor.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteControllerBr {

    @GetMapping("/site")
    public ModelAndView methodGetSite(ModelMap modelMap){
        modelMap.addAttribute("title","Site");
        return new ModelAndView("site",modelMap);
    }
}
