package com.itprogerBro.bro_dodor.controll;

import com.itprogerBro.bro_dodor.modeldao.Br;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ControllerBR {

    /*@Autowired
   private RestTemplate restTemplate;
    @RequestMapping("/req")
    public ResponseEntity<?> methodRb(*//*@PathVariable("userId") String userId *//*){

       *//* Br forObject = null;
        try {
            forObject = restTemplate.getForObject("http://movie-info-service/movies/bro", Br.class);
        } catch (RestClientException e) {
            System.out.println("BR no find))))))00");
            forObject.setId(123);
            forObject.setName("BRooo");
        }
        Optional<Br> brOptional = Optional.ofNullable(forObject);*//*
       Br brOptional = new Br();
       brOptional.setId(123);
       brOptional.setName("broo");

        return new ResponseEntity<Br>(brOptional, HttpStatus.OK);
    }*/
}
