package com.w3wp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro extends Scritto { 
    @Column   
    public String autore;
    @Column
    public String genere;

    public Libro(){}    

    public Libro(String titolo, int annoUscita, int numeroPagine, String autore, String genere) {
        super(titolo, annoUscita, numeroPagine);
        this.autore = autore;
        this.genere = genere;
        this.type = "libro";
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String getAutore() {
        return autore;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro [autore=" + autore + ", genere=" + genere + "]";
    }

}
