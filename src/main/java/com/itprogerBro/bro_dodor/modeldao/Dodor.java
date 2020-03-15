package com.itprogerBro.bro_dodor.modeldao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dodor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String anons;
    private String full_text;
    private String views;

    public Dodor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public Dodor setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAnons() {
        return anons;
    }

    public Dodor setAnons(String anons) {
        this.anons = anons;
        return this;
    }

    public String getFull_text() {
        return full_text;
    }

    public Dodor setFull_text(String full_text) {
        this.full_text = full_text;
        return this;
    }

    public String getViews() {
        return views;
    }

    public Dodor setViews(String views) {
        this.views = views;
        return this;
    }
}
