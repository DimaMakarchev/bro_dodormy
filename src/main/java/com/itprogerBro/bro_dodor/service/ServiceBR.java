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

    public void methodSave() {
        Dodor dodor = new Dodor();
        dodor.setAnons("Bro_1")
                .setFull_text("Bro_2")
                .setTitle("Bro_3")
                .setViews("Bro_4");
        repoBRDodor.save(dodor);
    }

    public List<Dodor> methodGetAll() {
        return repoBRDodor.findAll();
    }
}
