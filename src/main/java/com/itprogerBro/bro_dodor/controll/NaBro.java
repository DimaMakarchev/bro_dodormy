package com.itprogerBro.bro_dodor.controll;

import org.springframework.stereotype.Component;

@Component
public class NaBro {
  private Integer bdfs;

    public NaBro(Integer bdfs) {
        this.bdfs = bdfs;
    }

    public Integer getBdfs() {
        return bdfs;
    }

    public void setBdfs(Integer bdfs) {
        this.bdfs = bdfs;
    }

    public NaBro() {
    }
}
