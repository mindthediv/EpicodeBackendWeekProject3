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
        // archiviInit();
        // scanInit();
        // salvaArchivio();  
         Utente mario = new Utente("Mario", "Rossi", dateUtil.parseDate("2000-05-28"));
         Libro libro = new Libro("wowow", 2012, 235, "jimmy", "avventura");
         Rivista rivista = new Rivista("La settimana enigmistica", 2023, 47, period.SETTIMANALE);
         Prestito prestito = new Prestito(mario, rivista, dateUtil.parseDate("2023-01-01"));
       
         UtenteDAO.save(mario);
         ScrittoDAO.save(libro);
         ScrittoDAO.save(rivista);
         PrestitoDao.save(prestito);

        cercaIsbn(2);
        cercaAnno(2023);
        cercaAutore("jimmy");
        cercaTitolo("wow");
        cercaPrestato(0);
        cercaScaduti();

    }
    static public void scanInit() throws IOException{
        System.out.println("[Digita]");
        System.out.println("[aggiungi] -> Aggiungi un libro o una rivista all'archivio");
        System.out.println("[rimuovi] -> Rimuovi un libro o una rivista dall'archivio");
        System.out.println("[cerca] -> Cerca un libro o una rivista nell'archivio");
        System.out.println("[leggi archivio] -> Ottieni la lista di tutti gli scritti");
        System.out.println("[salva archivio] -> Salva l'archivio");
        System.out.println("[esci] -> Salva ed esci dal catalogo (Bug: Nel caso il comando non funzionasse, ripeterlo fino all'uscita)");
        switch (scan.nextLine()) {
            case "aggiungi":
                scanAggiungi();
                scanInit();
                break;
            case "rimuovi":
                scanRimuovi();
                scanInit();
                break;
            case "cerca":
                scanCerca();
                scanInit();
                break;
            case "leggi archivio":
                System.out.println("");
                archivioScritti.entrySet()
                .forEach(scritto -> System.out.println(scritto.toString()));
                System.out.println("");
                scanInit();
                break;
            case "salva archivio":
                System.out.println("");
               
                scanInit();
                break;
            case "esci":
                break;
            default:
                System.out.println("Attenzione - errore, riprova");
                scanInit();
                break;
        }
    }
    static public void scanAggiungi() throws IOException {
        System.out.println("[Digita]");
        System.out.println("[libro, numeroPagine, titolo, anno, autore, genere] -> Aggiungi libro");
        System.out.println("[rivista, numeroPagine, titolo, anno, period (SETTIMANALE/MENSILE/SEMESTRALE)] -> Aggiungi rivista");
        String[] split = scan.nextLine().split(",");
        switch (split[0]) {
            case "libro":
                //
                scanInit();
                break;
            case "rivista":
                //
                scanInit();
                break;
            default:
                System.out.println("Attenzione - errore, riprova");
                scanAggiungi();
                break;
        }
    }
    static public void scanRimuovi() {
        System.out.println("Cosa? [libro/rivista]");
        switch (scan.nextLine()) {
            case "libro":
            System.out.println("");
            archivioLibri.entrySet().forEach(el -> System.out.println(el.toString()));
            System.out.println("");
            System.out.println("Dalla lista qui in alto, identifica il numero del libro da rimuovere e digitalo");
            try{
                //
                } catch (Exception e) {
                    System.out.println("Attenzione - errore, riprova");
                    scanRimuovi();
                }
                break;
            case "rivista":
            System.out.println("");
            archivioRiviste.entrySet().forEach(el -> System.out.println(el.toString()));
            System.out.println("");
            System.out.println("Dalla lista qui in alto, identifica il numero della rivista da rimuovere e digitalo");
            try{
            //
            } catch (Exception e) {
                System.out.println("Attenzione - errore, riprova");
                scanRimuovi();
            }
                break;
            default:
            System.out.println("Attenzione - errore, riprova");
            scanRimuovi();
                break;
        }
    }
    static public void scanCerca() {
        System.out.println("Seleziona il criterio di ricerca [isbn/anno/autore]");
        String input = scan.nextLine();
        switch (input) {
            case "isbn":
            System.out.println("");
            System.out.print("Digita il numero isbn: ");
            Long isbn = Long.parseLong(scan.nextLine());
            try{
            cercaIsbn(isbn);
            } catch (Exception e) {
                System.out.println("Attenzione - errore, riprova");
                scanCerca();
            }
                break;
            case "anno":
            System.out.println("");
            System.out.print("Digita l'anno richiesto:");
            String anno = scan.nextLine();
            try{
            cercaAnno(Integer.parseInt(anno));
            } catch (Exception e) {
            System.out.println("Attenzione - errore, riprova");
            scanCerca();
            }
                break;
            case "autore":
            System.out.println("");
            System.out.print("Digita l'autore richiesto:");
            String autore = scan.nextLine();
            try{
            cercaAutore(autore);
            } catch (Exception e) {
            System.out.println("Attenzione - errore, riprova");
            scanCerca();
            }
                break;
            default:
            System.out.println("Attenzione - errore, riprova");
            scanCerca();
                break;
        }
    }
}
