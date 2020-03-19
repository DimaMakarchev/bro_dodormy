package com.itprogerBro.bro_dodor.controll;

import com.itprogerBro.bro_dodor.modeldao.Dodor;
import com.itprogerBro.bro_dodor.service.ServiceBR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogControllerBr {
    @Autowired
    private ServiceBR serviceBR;

    @GetMapping("/blog")
    public ModelAndView methodGetAbout(ModelMap map) {

        //  serviceBR.methodSave();
        List<Dodor> dodors = serviceBR.methodGetAll();

        map.addAttribute("dodor", dodors);
        map.addAttribute("title", "Blog");

        return new ModelAndView("blog", map);
    }

    @GetMapping(value = "/blog/add")
    public ModelAndView methodGetBlog(ModelMap map) {

        map.addAttribute("title", "Blog-add");

        return new ModelAndView("blog-add", map);
    }

    @PostMapping(value = "/blog/add")
    public ModelAndView methodPostBlog(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, ModelMap modelMap) {

        serviceBR.methodSave(title, anons, full_text);

        return new ModelAndView("redirect:/blog");
    }


}
