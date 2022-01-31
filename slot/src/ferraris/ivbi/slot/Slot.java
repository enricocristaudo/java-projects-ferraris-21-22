package ferraris.ivbi.slot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Slot {
    private double cassa;
    private final char[] simboli = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O' };
    private char display[] = { 'X', 'X', 'X' };
    private int TRE_UGUALI;
    private int DUE_ADIACENTI;
    private int DUE_NON_ADIACENTI;
    private int partite;
    /**
     * 
     * @param puntata Soldi puntati dall'utente
     * @param index Indice giocatore che gioca
     * @return Vettore di due celle: in caso di vittoria,
     * la prima cella conterrà la somma vinta, in caso di vincita superiore al denaro 
     * in cassa della slot machine, la prima conterrà tutto il denaro in cassa 
     * e la seconda conterrà la differenza
     * tra la vincita totale e il denaro rimasto in cassa
     * @throws Exception
     */
    public double[] gioca(double puntata, int index) throws Exception {

        double risultato[] = new double[2];

        this.cassa += puntata;

        switch (index) {
        case 0:
            for (int i = 0; i < 3; i++) {
                int x = (int) (Math.random() * 5);
                this.display[i] = simboli[x];
            }
            TRE_UGUALI = 4;
            DUE_ADIACENTI = 3;
            DUE_NON_ADIACENTI = 2;
            break;
        case 1:
            for (int i = 0; i < 3; i++) {
                int x = (int) (Math.random() * 9);
                this.display[i] = simboli[x];
            }
            TRE_UGUALI = 6;
            DUE_ADIACENTI = 4;
            DUE_NON_ADIACENTI = 3;
            break;
        case 2:
            for (int i = 0; i < 3; i++) {
                int x = (int) (Math.random() * simboli.length);
                this.display[i] = simboli[x];
            }
            TRE_UGUALI = 20;
            DUE_ADIACENTI = 10;
            DUE_NON_ADIACENTI = 7;
            break;
        }

        IO.sout("\nEstraendo...\n\n");
        TimeUnit.SECONDS.sleep(1);

        String r = "| " + this.display[0] + " | " + this.display[1] + " | " + this.display[2] + " |";

        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(r, ASCIIArtGenerator.ART_SIZE_SMALL);

        // tutti uguali
        if (this.display[0] == this.display[1] && this.display[0] == this.display[2]) {
            if (puntata * TRE_UGUALI > this.cassa) {
                risultato[0] = this.cassa;
                risultato[1] = (puntata * TRE_UGUALI) - this.cassa;
                this.cassa = 0;
                return risultato;
            }
            risultato[0] = puntata * TRE_UGUALI;
            this.cassa = this.cassa - (puntata * TRE_UGUALI);
            return risultato;
        }
        // due non adiacenti
        if (this.display[0] == this.display[2]) {
            if (puntata * DUE_NON_ADIACENTI > this.cassa) {
                risultato[0] = this.cassa;
                risultato[1] = (puntata * DUE_NON_ADIACENTI) - this.cassa;
                this.cassa = 0;
                return risultato;
            }
            risultato[0] = puntata * DUE_NON_ADIACENTI;
            this.cassa = this.cassa - (puntata * DUE_NON_ADIACENTI);
            return risultato;
        }
        // due adiacenti
        if (this.display[0] == this.display[1] || this.display[1] == this.display[2]) {
            if (puntata * DUE_ADIACENTI > cassa) {
                risultato[0] = this.cassa;
                risultato[1] = (puntata * DUE_ADIACENTI) - this.cassa;
                this.cassa = 0;
                return risultato;
            }
            risultato[0] = puntata * DUE_ADIACENTI;
            this.cassa = this.cassa - (puntata * DUE_ADIACENTI);
            return risultato;
        }

        risultato[0] = 0;
        risultato[1] = 0;
        return risultato;

    }

    public Slot(double cassa) {
        this.cassa = cassa;
    }

    public double getCassa() {
        return this.cassa;
    }

    public void setCassa(double c) {
        this.cassa = c;
    }

    public int getPartite() {
        return this.partite;
    }

    public void setPartite(int i) {
        this.partite = i;
    }

    public String getStato() {
        String s = "";
        s = s + "\nDenaro in cassa: " + this.getCassa() + "\n";
        s = s + "Partite giocate: " + this.getPartite() + "\n";
        return s;
    }

    public static int menuSlot() throws NumberFormatException, IOException {
        int s;
        do {
            IO.sout("\nSlot 1\t\tSlot 2\t\tSlot 3\n");
            IO.sout("-----\t\t-----\t\t-----\n");
            IO.sout("lvl. Facile\tlvl. Medio\tlvl. Difficile\n");
            IO.sout("200€ min.\t100€ min.\t20€ min.\n");
            IO.sout("-----\t\t-----\t\t-----\n");
            s = IO.inInt("Scelta: ");
        } while (s < 0 || s > 3);
        return s;
    }
}
