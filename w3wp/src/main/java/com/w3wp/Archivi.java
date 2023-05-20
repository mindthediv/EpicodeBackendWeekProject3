package com.w3wp;

import java.io.File;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Archivi {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    static Logger log = LoggerFactory.getLogger(Archivi.class);
    // ---------------- Dati ------------------------------------------
  
    // Tutti gli scritti
    static Map< Long, Scritto > archivioScritti = new HashMap<>();
    public static Map<Long, Scritto> getArchivioScritti() {
        return archivioScritti;
    }
    public static void setArchivioScritti(Map<Long, Scritto> archivioScritti) {
        Archivi.archivioScritti = archivioScritti;
    }
    // Tutti i Libri
    static Map< Long, Libro > archivioLibri = new HashMap<>();
    public static Map<Long, Libro> getArchivioLibri() {
        return archivioLibri;
    }
    public static void setArchivioLibri(Map<Long, Libro> archivioLibri) {
        Archivi.archivioLibri = archivioLibri;
    }
    // Tutte le Riviste
    static Map< Long, Rivista > archivioRiviste = new HashMap<>();
    public static Map<Long, Rivista> getArchivioRiviste() {
        return archivioRiviste;
    }
    public static void setArchivioRiviste(Map<Long, Rivista> archivioRiviste) {
        Archivi.archivioRiviste = archivioRiviste;
    }
    // File su disco ---------------------------------------------------------------------------
    public static File libriFile = new File("EpicStorage/archivioLibri.txt");
    public static File rivisteFile = new File("EpicStorage/archivioRiviste.txt");
    // ----------------------------------------------------------------------------
    // ---------------- Metodi di ricerca ----------------------------------------
    // x ISBN
    static public Scritto cercaIsbn(long isbn){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.isbn = :isbn");
        q.setParameter("isbn", isbn);
        Scritto scritto = (Scritto) q.getSingleResult();
        System.out.println("Risultato ricerca: " + scritto.toString());
        return scritto;
    }
    // x Anno pubblicazione
    static public  Collection<Scritto> cercaAnno(int annoUscita){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.annoUscita = :annoUscita");
        q.setParameter("annoUscita", annoUscita);
        List<Scritto> dellAnno = q.getResultList();
        System.out.println("Risultato ricerca: " + dellAnno.toString());
        return dellAnno;
    }
    // x Autore
    static public List<Libro> cercaAutore(String autore){
        Query q = em.createQuery("SELECT l FROM Scritto l WHERE l.autore = :autore");
        q.setParameter("autore", autore);
        List<Libro> dellAutore  = q.getResultList();
        System.out.println("Risultato ricerca: " + dellAutore.toString());
    
        return dellAutore;
    }
    // x Titolo
    static public List<Libro> cercaTitolo(String titolo){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.titolo LIKE :titolo");
        q.setParameter("titolo","%"+ titolo+"%");
        List<Libro> intitolato  = q.getResultList();
        System.out.println("Risultato ricerca: " + intitolato.toString());
        return intitolato;
    }
    // Scritti in prestito x idTessera
    static public List<Scritto> cercaPrestato(int idTessera){
        Query q = em.createQuery("SELECT p.scritto_prestato FROM Prestito p  WHERE  p.utente.id_tessera = :idTessera");
        q.setParameter("idTessera",idTessera);
        List<Scritto> prestati  = q.getResultList();
        System.out.println("Risultato ricerca: " + prestati.toString());
        return prestati;
    }
    // Prestiti scaduti
    static Date today = Date.valueOf(LocalDate.now(ZoneId.of("Europe/Paris")));
    static public List<Prestito> cercaScaduti(){
        Query q = em.createQuery("SELECT p.id_prestito FROM Prestito p WHERE ((p.data_rest_prevista < :today) AND (p.data_rest_effettiva = null))");
        q.setParameter("today",today);
        List<Prestito> scaduti  = q.getResultList();
        System.out.println("Risultato ricerca: " + "prestiti scaduti [id] = " +scaduti.toString());
        return scaduti;
    }  
}

