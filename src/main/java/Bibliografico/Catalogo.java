package Bibliografico;

import Bibliografico.entities.ElementoCatalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // Ricerca per ISBN
    public Optional<ElementoCatalogo> ricercaPerIsbn(String isbn) {
        return catalogo.stream()
                .filter(elemento -> elemento.getIsbn().equals(isbn))
                .findFirst();
    }

}
