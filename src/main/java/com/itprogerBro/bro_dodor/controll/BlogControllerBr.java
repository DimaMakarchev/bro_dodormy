package com.itprogerBro.bro_dodor.controll;

import com.itprogerBro.bro_dodor.modeldao.Br;
import com.itprogerBro.bro_dodor.modeldao.Dodor;
import com.itprogerBro.bro_dodor.service.ServiceBR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogControllerBr {
    @Autowired
    private ServiceBR serviceBR;
    @Autowired
    EntityManager entityManager;

    @GetMapping("/blog")
    public ModelAndView methodGetAbout(ModelMap map) {
        entityManager
        //  serviceBR.methodSave();
        Optional<List<Dodor>> dodors = serviceBR.methodGetAll();

        map.addAttribute("dodor", dodors.get());
        map.addAttribute("title", "Blog");

        return new ModelAndView("redirect:/blog/add", map);
//        return new ModelAndView("forward:/blog/add", map);
    }
   /*  @RequestMapping("/cool")
    public @ResponseBody Br methodX(){
          return new Br(1,"Broooooo");
    }*/

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

    @GetMapping(value = "/blog/{id}")
    public ModelAndView methodDetelis(@PathVariable("id") Long id, ModelMap map) {
        if (!serviceBR.methodIf(id)) {
            return new ModelAndView("redirect:/blog");
        }
        Optional<Dodor> detelisId = serviceBR.getDetelisId(id);
        map.addAttribute("dodor", detelisId.get());

        return new ModelAndView("blog-detelis", map);
    }

    @GetMapping(value = "/blog/{id}/edit")

    public ModelAndView methodGetRedactor(@PathVariable("id") Long id, ModelMap modelMap) {

        Optional<Dodor> detelisId = serviceBR.getDetelisId(id);
        modelMap.addAttribute("dodor", detelisId.get());

        return new ModelAndView("blog-redactor", modelMap);
    }

    @PostMapping(value = "/blog/{id}/edit")
    public ModelAndView methodPostRedactor(@PathVariable("id") Long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, ModelMap modelMap) {

        serviceBR.methodUpDate(id, title, anons, full_text);

        return new ModelAndView("redirect:/blog");
    }

    @PostMapping(value = "/blog/{id}/remove")
    public ModelAndView methodPostRedactor(@PathVariable("id") Long id, ModelMap modelMap) {

        serviceBR.methodRemove(id);

        return new ModelAndView("redirect:/blog");
    }

}
