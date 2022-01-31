
package ferraris.ivbi.poker_console;

public class Carta {
    private char valore;
    private char seme;
    private boolean usata;

    public Carta(char valore, char seme) {
        this.valore = valore;
        this.seme = seme;
        this.usata = false;
    }

    public char getValore() {
        return valore;
    }

    public char getSeme() {
        return seme;
    }

    public boolean isUsata() {
        return usata;
    }

    public void setUsata(boolean usata) {
        this.usata = usata;
    }
    
    
    
}

