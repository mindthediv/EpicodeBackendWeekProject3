package com.w3wp;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @SequenceGenerator(name = "utenti_seq", sequenceName="utenti_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utenti_seq")
    public long id_utente;
    @Column
    public String nome;
    @Column
    public String cognome;
    @Column
    public Date data_nascita;
    @SequenceGenerator(name = "tessere_seq", sequenceName="tessere_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tessere_seq")
    public int id_tessera;
    
    public Utente(){}
    public Utente(String nome, String cognome, Date data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }
    
    public long getId() {
        return id_utente;
    }
    public void setId(long id) {
        this.id_utente = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public Date getData_nascita() {
        return data_nascita;
    }
    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }
    public int getId_tessera() {
        return id_tessera;
    }
    public void setId_tessera(int id_tessera) {
        this.id_tessera = id_tessera;
    }
}
