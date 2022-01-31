public class Appartamento extends Abitazione{
    private int piano;
    private boolean ascensore;
    private int numTerrazzi;

    public Appartamento(int numStanze, int superficie, String indirizzo, String citta, int piano, boolean ascensore, int numTerrazzi){
        super(numStanze, superficie, indirizzo, citta);
        this.piano = piano;
        this.ascensore = ascensore;
        this.numTerrazzi = numTerrazzi;
    }

    public boolean equals(Appartamento temp){
        boolean x = true;
        if(this.getPiano() != temp.getPiano()) x = false;
        if(this.getNumTerrazzi() != temp.getNumTerrazzi()) x = false;
        return super.equals(temp) && x;
    }

    public String toString(){
        return super.toString() + "\nPiano: " + this.getPiano() 
        + "\nAscensore: " + this.hasAscensore() 
        + "\nNumero terrazzi: " + this.getNumTerrazzi();
    }


    public int getPiano(){
        return this.piano;
    }

    public boolean hasAscensore(){
        return this.ascensore;
    }

    public int getNumTerrazzi(){
        return this.numTerrazzi;
    }
}