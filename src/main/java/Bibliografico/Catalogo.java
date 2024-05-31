package Bibliografico;

import Bibliografico.entities.ElementoCatalogo;
import Bibliografico.entities.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Catalogo {
    private List<ElementoCatalogo> catalogo;

    public Catalogo() {
        this.catalogo = new ArrayList<>();
    }

    //aggiunta di un elemento
    public void aggiungiElemento(ElementoCatalogo elemento) {
        catalogo.add(elemento);
    }

    //stampa catalogo
    public void stampaCatalogo() {
        System.out.println("🗒️Lista catalogo🗒️");
        catalogo.forEach(System.out::println);
    }

    //rimuovi elemento tramite il codice ISBN
    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(elemento -> elemento.getIsbn().equals(isbn));
    }

    //ricerca per ISBN
    public Optional<ElementoCatalogo> ricercaPerIsbn(String isbn) {
        return catalogo.stream()
                .filter(elemento -> elemento.getIsbn().equals(isbn))
                .findFirst();
    }

    //ricerca per anno pubblicazione
    public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    //ricerca per autore
    public List<Libro> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elemento -> elemento instanceof Libro)
                .map(elemento -> (Libro) elemento)
                .filter(libro -> libro.getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    
}
