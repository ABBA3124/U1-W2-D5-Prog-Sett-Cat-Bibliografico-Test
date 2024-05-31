package Bibliografico.entities;

public class Libro extends ElementoCatalogo {
    private String autore;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }


}
