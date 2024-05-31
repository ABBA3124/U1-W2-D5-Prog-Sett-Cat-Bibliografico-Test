package Bibliografico;

import Bibliografico.entities.Libro;
import Bibliografico.entities.Rivista;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Catalogo catalogo = new Catalogo();

        //add elementi al catalogo
        catalogo.aggiungiElemento(new Libro("1234", "Il Signore degli Anelli", 1954, 1000, "J.R.R. Tolkien"));
        catalogo.aggiungiElemento(new Rivista("5678", "National Geographic", 2020, 100, Rivista.Periodicita.MENSILE));
        //prova verifico il catalogo
        System.out.println("--------------------------------------");
        catalogo.stampaCatalogoDebug();

    }
}
