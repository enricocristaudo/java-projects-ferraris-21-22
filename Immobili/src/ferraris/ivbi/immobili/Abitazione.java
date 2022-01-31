public abstract class Abitazione{
    protected int numStanze;
    protected int superficie;
    protected String indirizzo;
    protected String citta;

    public Abitazione(int numStanze, int superficie, String indirizzo, String citta){
        this.numStanze = numStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public boolean equals(Abitazione temp){
        boolean x = true;
        if(this.getNumStanze() != temp.getNumStanze()) x = false;
        if(this.getSuperficie() != temp.getSuperficie()) x = false;
        return x;
    }
    @Override
    public String toString(){
        String s="";
        s = s + "Numero stanze: " + this.getNumStanze();
        s = s + "\nSuperficie: " + this.getSuperficie();
        s = s + "\nIndirizzo: " + this.getIndirizzo();
        s = s + "\nCitta': " + this.getCitta();
        return s;
    }

    public int getNumStanze(){
        return this.numStanze;
    }

    public int getSuperficie(){
        return this.superficie;
    }
    
    public String getIndirizzo(){
        return this.indirizzo;
    }
    
    public String getCitta(){
        return this.citta;
    }
}