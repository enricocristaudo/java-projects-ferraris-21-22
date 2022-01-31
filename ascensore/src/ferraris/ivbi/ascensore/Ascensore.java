
package ferraris.ivbi.ascensore;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ascensore {
    private int numMassimoPersone = 0;
    private double pesoMassimo = 0;
    private int numPersone = 0;
    private double pesoAttuale = 0;
    private int pianoMinimo = 0;
    private int pianoMassimo = 0;
    private int pianoAttuale = 0;
    private boolean fuoriUso = false;
    private static int durataAnni;

    public Ascensore(int numMassimoPersone, int pianoMinimo, int pianoMassimo, int durataAnni)
    {
        if (numMassimoPersone > 0) this.numMassimoPersone = numMassimoPersone;
        this.pesoMassimo = this.numMassimoPersone * 80;
        this.pianoMinimo = pianoMinimo;
        if (pianoMassimo > this.pianoMinimo) this.pianoMassimo = pianoMassimo;
        this.fuoriUso = false;
        Ascensore.durataAnni = durataAnni;
    }
    public Ascensore(int numMassimoPersone, int pianoMinimo, int pianoMassimo)
    {
        if (numMassimoPersone > 0) this.numMassimoPersone = numMassimoPersone;
        this.pesoMassimo = this.numMassimoPersone * 80;
        this.pianoMinimo = pianoMinimo;
        if (pianoMassimo > this.pianoMinimo) this.pianoMassimo = pianoMassimo;
        this.fuoriUso = false;
    }
    //costruttore copia
    public Ascensore(Ascensore rif)
    {
        this.numMassimoPersone = rif.getNumMassimoPersone();
        this.pesoMassimo = rif.getPesoMassimo();
        this.numPersone = rif.getNumPersone();
        this.pesoAttuale = rif.getPesoAttuale();
        this.pianoMinimo = rif.getPianoMinimo();
        this.pianoMassimo = rif.getPianoMassimo();
        this.pianoAttuale = rif.getPianoAttuale();
        this.fuoriUso = rif.isFuoriUso();
    }
    
    public int vaiAlPiano(int piano)
    {
        if (this.isFuoriUso() == true) return -2;
        if (piano > this.pianoMassimo || piano < this.pianoMinimo) return -1;
        this.pianoAttuale = piano;
        return 1;
    }
    
    public int saliUnPiano()
    {
        if (this.isFuoriUso() == true) return -2;
        if (this.pianoAttuale == this.pianoMassimo) return -1;
        this.pianoAttuale++;
        return 1;
    }
    
    public int scendiUnPiano()
    {
        if (this.isFuoriUso() == true) return -2;
        if (this.pianoAttuale == this.pianoMinimo) return -1;
        this.pianoAttuale--;
        return 1;
    }
    /**
     * Mi permette di far salire una persona nell'ascensore
     * @param peso è il peso della persona che sta per salire
     * @return -2 = ascensore fuori uso; 
     * -3 = peso massimo raggiunto; 
     * -4 = numero massimo di persone raggiunto; 
     * 1 =  persona salita
     */
    public int salePersona(double peso)
    {
        if (this.isFuoriUso() == true) return -2;
        if (this.pesoAttuale + peso > this.pesoMassimo) return -3;
        if (this.numPersone == this.numMassimoPersone) return -4;
        this.pesoAttuale = this.pesoAttuale + peso;
        this.numPersone++;
        return 1;
    }
    
    public int scendePersona(double peso)
    {
        if (this.isFuoriUso() == true) return -2;
        if (this.pesoAttuale < peso) return -3;
        if (this.numPersone == 0) return -4;
        this.pesoAttuale = this.pesoAttuale - peso;
        this.numPersone--;
        return 1;
    }
    
    public void bloccaAscensore(){
        this.fuoriUso = this.fuoriUso != true;
    }
   
    public double pesoMedioAttuale()
    {
        if (this.numPersone == 0) return 0;
        return this.pesoAttuale / this.numPersone; 
    }
    
    public String mostraStato()
    {
        String s;
        s ="\nNumero massimo persone: " + this.getNumMassimoPersone() + "\n";
        s = s + "Peso massimo: " + this.getPesoMassimo() + "\n";
        s = s + "Persone a bordo: " + this.getNumPersone() + "\n";
        s = s + "Peso attuale: " + this.getPesoAttuale() + "\n";
        s = s + "Peso medio: " + this.pesoMedioAttuale() + "\n";
        s = s + "Piano minimo: " + this.getPianoMinimo() + "\n";
        s = s + "Piamo massimo: " + this.getPianoMassimo() + "\n";
        s = s + "Paino attuale: " + this.getPianoAttuale() + "\n";
        s = s + "Fuoriuso: " + this.isFuoriUso() + "\n";
        return s;
    }
    
    public int getNumMassimoPersone(){
        return numMassimoPersone;
    }
    public double getPesoMassimo(){
        return pesoMassimo;
    }
    public int getNumPersone(){
        return numPersone;
    }
    public double getPesoAttuale(){
        return pesoAttuale;
    }
    public int getPianoMinimo(){
        return pianoMinimo;
    }
    public int getPianoMassimo(){
        return pianoMassimo;
    }
    public int getPianoAttuale(){
        return pianoAttuale;
    }
    public boolean isFuoriUso(){
        return fuoriUso;
    }
    public static int getDurataAnni() {
        return durataAnni;
    }
    
    public static void setDurataAnni(int durataAnni) {
        Ascensore.durataAnni = durataAnni;
    }
    
    public void setPianoMinimo(int pianoMinimo) 
    {
        if (pianoMinimo >= this.pianoMassimo) return;
        this.pianoMinimo = pianoMinimo;
    }

    public void setPianoMassimo(int pianoMassimo) 
    {
        if (pianoMassimo <= this.pianoMinimo) return;
        this.pianoMassimo = pianoMassimo;
    }

    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    public int menu(){
        int x = -1;
        try {
            String m;
            
            m = "Scegli un'opzione:\n";
            m = m + "1 - Fai salire una persona\n";
            m = m + "2 - Fai scendere una persona\n";
            m = m + "3 - Vai ad un piano specifico\n";
            m = m + "4 - Sali di un piano\n";
            m = m + "5 - Scendi di un piano\n";
            m = m + "6 - Blocca/sblocca ascensore\n";
            m = m + "scelta: ";
            System.out.print(m);
            
            x = Integer.parseInt(tastiera.readLine());
        } catch (Exception ex) {
            //Logger.getLogger(Ascensore.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("+++ Errore inserimento dati +++");
            System.exit(0);
        }
        return x;
    }
}
