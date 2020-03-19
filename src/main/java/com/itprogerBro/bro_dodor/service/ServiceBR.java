package com.itprogerBro.bro_dodor.service;

import com.itprogerBro.bro_dodor.modeldao.Dodor;
import com.itprogerBro.bro_dodor.repo.RepoBRDodor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBR {
    @Autowired
    private RepoBRDodor repoBRDodor;

    public void methodSave(String title, String anons, String full_text) {
        Dodor dodor = new Dodor();
        dodor.setAnons(anons)
                .setFull_text(full_text)
                .setTitle(title);
        repoBRDodor.save(dodor);
    }

    public List<Dodor> methodGetAll() {
        return repoBRDodor.findAll();
    }
}
