package com.w3wp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.w3wp.Rivista.period;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Archivi {
    private static EntityManager em =  JpaUtil.getEntityManagerFactory().createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();
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
    // ISBN
    static public Scritto cercaIsbn(long isbn){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.isbn = "+isbn);
        Scritto scritto = (Scritto) q.getResultList().get(0);
        System.out.println("Risultato ricerca: " + scritto.toString());
        return scritto;
    }
    // Anno pubblicazione
    static public  Collection<Scritto> cercaAnno(int annoUscita){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.annoUscita = "+annoUscita);
        List<Scritto> dellAnno = q.getResultList();
        System.out.println("Risultato ricerca: " + dellAnno.toString());
        return dellAnno;
    }
    // Autore
    static public List<Scritto> cercaAutore(String autore){
        Query q = em.createQuery("SELECT s FROM Scritto s WHERE s.getAutore() = "+autore);
        List<Scritto> dellAutore  = q.getResultList();
        System.out.println("Risultato ricerca: " + dellAutore.toString());
    
        return dellAutore;
    }
    // Metodo di salvataggio su disco (.txt)
    static public  void salvaArchivio() throws IOException {
		FileUtils.write(libriFile,archivioLibri.toString(),"UTF-8");
		FileUtils.write(rivisteFile,archivioRiviste.toString(),"UTF-8");
        System.out.println("");
		System.out.println("Archivio salvato");
        System.out.println("");
	}

  
}

