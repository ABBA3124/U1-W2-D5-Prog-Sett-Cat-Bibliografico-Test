package Bibliografico;

import Bibliografico.entities.ElementoCatalogo;

import java.util.ArrayList;
import java.util.List;

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
    public void stampaCatalogoDebug() {
        catalogo.forEach(System.out::println);
    }

}
