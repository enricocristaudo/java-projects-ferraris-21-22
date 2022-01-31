
package ferraris.ivbi.slot;

public class Giocatore {
    private String nome;
    private String cognome;
    private double denaro;
    private int num_partite;
    private double buoni;

    public Giocatore(String nome, String cognome, double denaro) {
        this.nome = nome;
        this.cognome = cognome;
        this.denaro = denaro;
        this.num_partite = 0;
        this.buoni = 0;
    }

    public String getStato() {
        String s = "";
        s = s + "\nNome: " + this.getNome() + "\n";
        s = s + "Cognome: " + this.getCognome() + "\n";
        s = s + "Denaro: " + this.getDenaro() + "\n";
        s = s + "Partite giocate: " + this.getNum_partite() + "\n";
        s = s + "Buoni: " + this.getBuoni() + "\n";
        return s;
    }

    public void scambiaBuoni() {
        this.denaro += this.buoni;
        this.buoni = 0;
    }

    public void setDenaro(double amount) {
        this.denaro = amount;
    }

    public void ricaricaDenaro(double amount) {
        this.denaro += amount;
    }

    public void setBuoni(double amount) {
        this.buoni += amount;
    }

    public void setNumPartite(int num) {
        this.num_partite = num;
    }

    public String getNome() {
        return nome;
    }

    public double getBuoni() {
        return buoni;
    }

    public String getCognome() {
        return cognome;
    }

    public double getDenaro() {
        return denaro;
    }

    public int getNum_partite() {
        return num_partite;
    }
}