package com.itprogerBro.bro_dodor.service;

import com.itprogerBro.bro_dodor.controll.NaBro;
import com.itprogerBro.bro_dodor.modeldao.Dodor;
import com.itprogerBro.bro_dodor.repo.RepoBRDodor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ServiceBR {
    @Autowired
    private RepoBRDodor repoBRDodor;
    @Autowired
    private NaBro naBro;

    public ServiceBR(RepoBRDodor repoBRDodor, NaBro naBro) {
        this.repoBRDodor = repoBRDodor;
        this.naBro = naBro;
    }

    public Boolean methodHrenVAm(List<Boolean> ticket) {
        methodView(ticket);
        /**ticket */
        for (int x = 0; x < ticket.size(); x += 2) {
            /**
             * if false
             * */
            Boolean tisketFalse = ticket.get(x);
            if (!tisketFalse) {
                ticket.remove(x);
                ticket.add(x, true);
            }
        }
        methodView(ticket);

        return true;
    }

    void methodView(List<Boolean> ticket) {
        int x = 0;
        int y = 0;
        for (Boolean aBoolean : ticket) {
            if (aBoolean) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println("true :" + x + "******************bro****************false : " + y);

    }


    public void methodSave(String title, String anons, String full_text) {
        var dodor = Dodor.builder()
                .anons(anons)
                .full_text(full_text)
                .title(title)
                .build();

        log.debug("OK", dodor.toString());
        repoBRDodor.save(dodor);
    }

    public Optional<List<Dodor>> methodGetAll() {

        return Optional.of(repoBRDodor.findAll());
    }

    public Optional<Dodor> getDetelisId(Long id) {
        return Optional.of(repoBRDodor.getOne(id));
    }

    public boolean methodIf(Long id) {
        return repoBRDodor.existsById(id);
    }

    public void methodUpDate(Long id, String title, String anons, String full_text) {
        /*Dodor one = repoBRDodor.getOne(id);
             one.setTitle(title);
             one.setAnons(anons);
             one.setFull_text(full_text);
*/

        Dodor one = repoBRDodor.getOne(id).builder()
                .id(id)
                .title(title)
                .anons(anons)
                .full_text(full_text)
                .build();
        repoBRDodor.save(one);

    }


    public void methodRemove(Long id) {
        repoBRDodor.deleteById(id);
    }
}
