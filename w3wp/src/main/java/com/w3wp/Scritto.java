package com.w3wp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "scritti")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Scritto {
    @Id
    @SequenceGenerator(name = "scritti_seq", sequenceName = "scritti_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scritti_seq")
    long isbn;
    @Column
    String titolo;
    @Column(name = "anno_uscita")
    int annoUscita;
    @Column(name = "numero_pagine")
    int numeroPagine;
    @Column
    String type = "scritto";

    public Scritto(String titolo, int annoUscita, int numeroPagine) {
    this.titolo = titolo;
    this.annoUscita = annoUscita;
    this.numeroPagine = numeroPagine;
    }
    public Scritto(){};

    public int getAnnoUscita() {
        return annoUscita;
    }
    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
    public long getisbn() {
        return isbn;
    }
    public void setisbn(long id) {
        isbn = id;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "[isbn=" + isbn + ", titolo=" + titolo + ", annoUscita=" + annoUscita + ", numeroPagine="
                + numeroPagine + "]";
    }
    
    
}
