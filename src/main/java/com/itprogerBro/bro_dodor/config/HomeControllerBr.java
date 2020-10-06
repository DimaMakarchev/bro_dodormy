package com.itprogerBro.bro_dodor.config;

import com.itprogerBro.bro_dodor.modeldao.Br;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomeControllerBr {

    private RestTemplate restTemplate;

    @Autowired
    public HomeControllerBr(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //  @Autowired


    @GetMapping("/")
    public ModelAndView methodHomeGet(ModelMap model) {
//        new FileStorageProperties();
        model.addAttribute("title", "Important article");
        return new ModelAndView("home", model);
    }

    @PostMapping("/")
    public ModelAndView methodPost(@RequestParam String name, @RequestParam int number, ModelMap map) {
        try {
            Br forObject = restTemplate.getForObject("http://localhost:9092/" + name + "/" + number, Br.class);
            if (forObject != null) {

                map.addAttribute("name", forObject.getName());
                map.addAttribute("number", forObject.getId());
            } else {
                map.addAttribute("name", "Mo bro");
                map.addAttribute("number", 000);
            }
        } catch (RestClientException e) {

            System.out.println(e);
            map.addAttribute("name", "Mo bro");
            map.addAttribute("number", 000);
            log.info("NO do");
        }
        log.info("Bro Do it!!!");

        return new ModelAndView("home", map);
    }



/*
    @RequestMapping(value = "/req",method = RequestMethod.GET)
    public ResponseEntity<?> methodRb(*//*@PathVariable("userId") String userId *//*){

        Br forObject = restTemplate.getForObject("http://localhost:9092/", Br.class);
        return new ResponseEntity<Br>(forObject, HttpStatus.OK);
    }*/

}
