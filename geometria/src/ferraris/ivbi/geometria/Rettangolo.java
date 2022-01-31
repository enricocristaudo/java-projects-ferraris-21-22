
package ferraris.ivbi.geometria;

public class Rettangolo {
    private double base;
    private double altezza;
    private String colore;
    
    //costruttore
    public Rettangolo(double base, double altezza, String colore){
        this.base = 1;
        this.altezza= 1;
        this.colore = "Nessun colore";
        if (base > 0) this.base = base;
        if (altezza > 0) this.altezza = altezza;
        if (colore.length() > 2) this.colore = colore;
    }
    
    //cotruttore copia
    public Rettangolo(Rettangolo rif){
        this.base = rif.getBase();
        this.altezza = rif.getAltezza();
        this.colore = rif.getColore();
    }
    
    //getter
    public double getBase(){
        return this.base;
    }
    public double getAltezza(){
        return this.altezza;
    }
    public String getColore(){
        return this.colore;
    }
    
    //setter
    public void setBase(double base){
        if (base > 0) this.base = base;
    }
    public void setAltezza(double altezza){
        if (altezza > 0) this.altezza = altezza;
    }
    public void setColore(String colore){
        if (colore.length() > 2) this.colore = colore;
    }
    
    //metodi specifici
    public double calcolaPerimetro(){
        return (this.base + this.altezza) * 2;
    }
    
    public double calcolaArea(){
        return this.base * this.altezza;
    }
    
    public boolean stessaArea(Rettangolo r){
        return this.calcolaArea()==r.calcolaArea();
    }
    
    //mostra stato
    public String getStato(){
        String stato = "";
        stato = stato + "Base: " + this.getBase() + "\n";
        stato = stato + "Altezza: " + this.getAltezza() + "\n";
        stato = stato + "Colore: " + this.getColore() + "\n";
        stato = stato + "Perimetro: " + this.calcolaPerimetro() + "\n";
        stato = stato + "Area: " + this.calcolaArea();
        return stato;
    }
    
}
