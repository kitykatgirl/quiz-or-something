package ph.me.myapplication;

public class Pytanie {
    private int idObrazek;
    private String trescPytania;
    private boolean odpowiedz; // true - tak   false - nie
    private String podpowiedzi;
    private boolean czyOdpOK = false;

    public Pytanie(String trescPytania, int idObrazek, boolean odpowiedz, String podpowiedzi) {
        this.trescPytania = trescPytania;
        this.idObrazek = idObrazek;
        this.odpowiedz = odpowiedz;
        this.podpowiedzi = podpowiedzi;
    }

    public int getIdObrazek() {
        return idObrazek;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public String getPodpowiedzi() {
        return podpowiedzi;
    }
    public boolean getOdpowiedz() {
        return odpowiedz;
    }

    public boolean isCzyOdpOK() {
        return czyOdpOK;
    }

    public void setCzyOdpOK(boolean czyOdpOK) {
        this.czyOdpOK = czyOdpOK;
    }
}
