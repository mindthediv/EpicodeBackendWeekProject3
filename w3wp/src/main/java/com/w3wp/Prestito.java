package com.w3wp;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @SequenceGenerator(name = "prestiti_seq", sequenceName = "prestiti_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestiti_seq")
    long id_prestito;
    @OneToOne
    Utente utente;
    @OneToOne
    Scritto scritto_prestato;
    @Column
    Date data_inizio = dateUtil.parseDate("2023-01-01");
    @Column
    Date data_rest_prevista = Date.valueOf(this.data_inizio.toLocalDate().plusDays(30));
    @Column(nullable = true)
    Date data_rest_effettiva;

    
    public Prestito(Utente utente, Scritto scritto_prestato, Date data_inizio) {
        this.utente = utente;
        this.scritto_prestato = scritto_prestato;
        this.data_inizio = data_inizio;
    }
    public long getId() {
        return id_prestito;
    }
    public void setId(long id) {
        this.id_prestito = id;
    }
    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public Scritto getScritto_prestato() {
        return scritto_prestato;
    }
    public void setScritto_prestato(Scritto scritto_prestato) {
        this.scritto_prestato = scritto_prestato;
    }
    public Date getData_inizio() {
        return data_inizio;
    }
    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }
    public Date getData_restituzione() {
        return data_rest_prevista;
    }
    public void setData_restituzione(Date data_restituzione) {
        this.data_rest_prevista = data_restituzione;
    }
    public Date getData_rest_effettiva() {
        return data_rest_effettiva;
    }
    public void setData_rest_effettiva(Date data_rest_effettiva) {
        this.data_rest_effettiva = data_rest_effettiva;
    }
}
