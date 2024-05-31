package Bibliografico;

import Bibliografico.entities.Libro;
import Bibliografico.entities.Rivista;

public class Application {

    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        //-----------------------Aggiunta di un elemento-----------------------
        System.out.println("\n\t⬇️Catalogo iniziale (vuoto)⬇️");
        catalogo.stampaCatalogo();

        //add elementi al catalogo
        catalogo.aggiungiElemento(new Libro("1234548", "Il Signore degli Anelli", 1954, 1000, "J.R.R. Tolkien", "fantasy"));
        catalogo.aggiungiElemento(new Libro("2564644", "La libreria dei gatti neri", 1996, 24, "Piergiorgio Pulixi", "horror"));
        catalogo.aggiungiElemento(new Libro("5414351", "io sono l'abisso", 2016, 367, "Donato Carrisi", "action"));

        catalogo.aggiungiElemento(new Rivista("56786544", "National Geographic", 1996, 100, Rivista.Periodicita.MENSILE));
        catalogo.aggiungiElemento(new Rivista("43168944", "Focus", 2024, 52, Rivista.Periodicita.SETTIMANALE));
        catalogo.aggiungiElemento(new Rivista("78941247", "COSMOPOLITAN", 2001, 27, Rivista.Periodicita.SEMESTRALE));

        System.out.println("\n\t⬇️Catalogo una volta aggiunti elementi⬇️");
        catalogo.stampaCatalogo();

        //-----------------------Rimuovi elemento dato un codice ISBN-----------------------

        System.out.println("\n\t⬇️Catalogo una volta rimosso un elemento️️⬇️");
        catalogo.rimuoviElemento("5414351");
        catalogo.stampaCatalogo();

        catalogo.rimuoviElemento("51654564165165464"); //inserito per mostrare avviso inesistente o errato

        //-----------------------Ricerca per ISBN-----------------------

        System.out.println("\n\t⬇️Elemento cercato per ISBN⬇️");
        catalogo.ricercaPerIsbn("56786544");

        //-----------------------Ricerca per Anno di Pubblicazione-----------------------
        System.out.println("\n\t⬇️Elemento cercato per Anno di Pubblicazione⬇️");
        catalogo.ricercaPerAnnoPubblicazione(1996).forEach(System.out::println);


        //-----------------------Ricerca per Autore-----------------------
        System.out.println("\n\t⬇️Elemento cercato per Autore⬇️");
        catalogo.ricercaPerAutore("Piergiorgio Pulixi").forEach(System.out::println);

        // -----------------------Salva su disco-----------------------

        System.out.println("\n\t⬇️💾Catalogo salvato sul disco💾⬇️");
        catalogo.salvaSuDisco();
        catalogo.stampaCatalogo();

        // -----------------------Carica dal disco-----------------------
        System.out.println("\n\t⬇️💽Catalogo caricato dal disco💽⬇️");
        catalogo.caricaDaDisco();
        catalogo.stampaCatalogo();


    }

}


