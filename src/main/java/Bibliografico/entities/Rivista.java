package Bibliografico.entities;

public class Rivista extends ElementoCatalogo {
    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }


    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "\tRivista📔 [" +
                "Periodicita= " + periodicita +
                ", ISBN= " + isbn +
                ", Titolo=" + titolo +
                ", Anno di Pubblicazione= " + annoPubblicazione +
                ", Numero di Pagine= " + numeroPagine +
                ']';
    }


    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }
}
