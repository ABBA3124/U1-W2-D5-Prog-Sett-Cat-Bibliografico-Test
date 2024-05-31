package Bibliografico;

import Bibliografico.entities.ElementoCatalogo;
import Bibliografico.entities.Libro;
import Bibliografico.entities.Rivista;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
        boolean rimosso = catalogo.removeIf(elemento -> elemento.getIsbn().equals(isbn));
        if (rimosso) {
            System.out.println("Elemento con ISBN " + isbn + " è stato rimosso.");
        } else {
            System.out.println("RIMOZIONE" + "L'ISBN: " + isbn + " Risulta Errato o Inesistente." + " Verifica L'ISBN Inserito e/o Riprova");
        }
    }


    //ricerca per ISBN
    public void ricercaPerIsbn(String isbn) {
        Optional<ElementoCatalogo> risultato = catalogo.stream()
                .filter(elemento -> elemento.getIsbn().equals(isbn))
                .findFirst();

        if (risultato.isPresent()) {
            System.out.println("Elemento trovato: " + risultato.get());
        } else {
            System.out.println("RICERCA" + "L'ISBN: " + isbn + " Risulta Errato o Inesistente." + " Verifica L'ISBN Inserito e/o Riprova");
        }
    }


    //ricerca per anno pubblicazione
    public void ricercaPerAnnoPubblicazione(int anno) {
        List<ElementoCatalogo> risultati = catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());

        if (!risultati.isEmpty()) {
            System.out.println("Elementi trovati per l'anno " + anno + ":");
            risultati.forEach(System.out::println);
        } else {
            System.out.println("Nessun elemento trovato per l'anno " + anno);
        }
    }


    //ricerca per autore
    public List<Libro> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elemento -> elemento instanceof Libro)
                .map(elemento -> (Libro) elemento)
                .filter(libro -> libro.getAutore().equals(autore))
                .collect(Collectors.toList());
    }


    //salva su disco archivio
    public void salvaSuDisco() {
        List<String> lines = new ArrayList<>();
        for (ElementoCatalogo elemento : catalogo) {
            if (elemento instanceof Libro) {
                Libro libro = (Libro) elemento;
                lines.add("Libro-" + libro.getIsbn() + "-" + libro.getTitolo() + "-" +
                        libro.getAnnoPubblicazione() + "-" + libro.getNumeroPagine() + "-" +
                        libro.getAutore() + "-" +
                        libro.getGenere());
            } else if (elemento instanceof Rivista) {
                Rivista rivista = (Rivista) elemento;
                lines.add("Rivista-" + rivista.getIsbn() + "-" + rivista.getTitolo() + "-" +
                        rivista.getAnnoPubblicazione() + "-" + rivista.getNumeroPagine() + "-" +
                        rivista.getPeriodicita());
            }
        }
        try {
            File file = new File("src/main/java/Bibliografico/Archivio.txt");
            FileUtils.writeLines(file, lines);
            System.out.println("Archivio salvato con successo su disco.");
        } catch (IOException err) {
            System.err.println("Errore durante il salvataggio dell'archivio: " + err.getMessage());
        }
    }

    //carica dal disco archivio
    public void caricaDaDisco() {
        try {
            File file = new File("src/main/java/Bibliografico/Archivio.txt");
            List<String> linee = FileUtils.readLines(file, "UTF-8");
            catalogo.clear();
            for (String stringa : linee) {
                String[] partiDaCaricare = stringa.split("-");
                if (partiDaCaricare[0].equals("Libro")) {
                    catalogo.add(new Libro(partiDaCaricare[1], partiDaCaricare[2], Integer.parseInt(partiDaCaricare[3]), Integer.parseInt(partiDaCaricare[4]), partiDaCaricare[5], partiDaCaricare[6]));
                } else if (partiDaCaricare[0].equals("Rivista")) {
                    catalogo.add(new Rivista(partiDaCaricare[1], partiDaCaricare[2], Integer.parseInt(partiDaCaricare[3]), Integer.parseInt(partiDaCaricare[4]), Rivista.Periodicita.valueOf(partiDaCaricare[5])));
                }
            }
            System.out.println("Archivio caricato dal disco con successo.");
        } catch (IOException err) {
            System.err.println("Errore durante il caricamento dell'Archivio.txt: " + err.getMessage());
        }
    }


}
