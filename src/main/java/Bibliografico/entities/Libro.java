package Bibliografico.entities;

public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "\tLibro📖 [" +
                "Autore= " + autore +
                ", Genere= " + genere +
                ", ISBN= " + isbn +
                ", Titolo= " + titolo +
                ", Anno di Pubblicazione= " + annoPubblicazione +
                ", Numero di Pagine= " + numeroPagine +
                "]";
    }
}
