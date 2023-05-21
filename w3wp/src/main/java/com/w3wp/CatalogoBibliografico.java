package com.w3wp;

import java.io.*;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.w3wp.Rivista.period;

public final class CatalogoBibliografico extends Archivi {
    public static File txtFile = new File("EpicStorage/archivio.txt");
    public static Logger log = LoggerFactory.getLogger(CatalogoBibliografico.class);  
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //!!!Hibernate in drop-and-create auto mode (= create-drop) 
        Utente mario = new Utente("Mario", "Rossi", dateUtil.parseDate("2000-05-28"));
        Libro libro = new Libro("Il vecchio e il mare", 2012, 235, "Ernest Hemingway", "romanzo breve");
        Rivista rivista = new Rivista("La settimana enigmistica", 2023, 47, period.SETTIMANALE);
        Prestito prestito = new Prestito(mario, rivista, dateUtil.parseDate("2023-01-01"));
    
        UtenteDAO.save(mario);
        ScrittoDAO.save(libro);
        ScrittoDAO.save(rivista);
        PrestitoDao.save(prestito);

       cercaIsbn(2);
       cercaAnno(2023);
       cercaAutore("Ernest Hemingway");
       cercaTitolo("vecchio");
       cercaPrestato(0);
       cercaScaduti();

    }
}
