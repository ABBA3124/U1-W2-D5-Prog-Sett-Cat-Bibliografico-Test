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
        catalogo.aggiungiElemento(new Libro("1234548", "Il Signore degli Anelli", 1954, 1000, "J.R.R. Tolkien"));
        catalogo.aggiungiElemento(new Libro("2564644", "La libreria dei gatti neri", 1990, 24, "Piergiorgio Pulixi"));
        catalogo.aggiungiElemento(new Libro("5414351", "io sono l'abisso", 2016, 367, "Donato Carrisi"));

        catalogo.aggiungiElemento(new Rivista("56786544", "National Geographic", 2020, 100, Rivista.Periodicita.MENSILE));
        catalogo.aggiungiElemento(new Rivista("43168944", "Focus", 2024, 52, Rivista.Periodicita.SETTIMANALE));
        catalogo.aggiungiElemento(new Rivista("78941247", "COSMOPOLITAN", 2001, 27, Rivista.Periodicita.SEMESTRALE));

        System.out.println("\n\t⬇️Catalogo una volta aggiunti elementi⬇️");
        catalogo.stampaCatalogo();

        //-----------------------Rimuovi elemento dato un codice ISBN-----------------------

        catalogo.rimuoviElemento("5414351");

        System.out.println("\n\t⬇️Catalogo una volta rimosso un elemento️️⬇️");
        catalogo.stampaCatalogo();


        //-----------------------Ricerca per ISBN-----------------------

        System.out.println("\n\t⬇️Elemento cercato per ISBN⬇️");
        catalogo.ricercaPerIsbn("56786544").ifPresent(System.out::println);

    }

}
