package com.w3wp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Scritto {
    public static enum period {SETTIMANALE,MENSILE,SEMESTRALE};
    @Enumerated(EnumType.STRING)
    @Column(name = "cadenza")
    public period period;

    public Rivista(String titolo,int annoUscita, int numeroPagine,  period period){
        super(titolo, annoUscita, numeroPagine);
        this.period = period;
        this.type = "rivista";
    }
  
    public Rivista(){};

    public void setPeriod(period period) {
        this.period = period;
    }
    public period getPeriod() {
        return period;
    }

}
