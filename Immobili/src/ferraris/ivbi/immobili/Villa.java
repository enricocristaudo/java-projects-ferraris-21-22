public class Villa extends Abitazione{
    private int numPiani;
    private int superficieGiardino;
    private boolean piscina;

    public Villa(int numStanze, int superficie, String indirizzo, String citta, int numPiani, int superficieGiardino, boolean piscina){
        super(numStanze, superficie, indirizzo, citta);
        this.numPiani = numPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }

    public boolean equals(Villa temp){
        boolean x = true;
        if(this.getNumPiani() != temp.getNumPiani()) x = false;
        if(this.getSuperficieGiardino() != temp.getSuperficieGiardino()) x = false;
        if(this.isPiscina() != temp.isPiscina()) x = false;
        return super.equals(temp) && x;
    }

    public String toString(){
        return super.toString() + "\nNumero piani: " + this.getNumPiani() 
        + "\nSuperficie giardino: " + this.getSuperficieGiardino() 
        + "\nPiscina: " + this.isPiscina();
    }

    public int getNumPiani(){
        return this.numPiani;
    }

    public int getSuperficieGiardino(){
        return this.superficieGiardino;
    }
    
    public boolean isPiscina(){
        return this.piscina;
    }
}