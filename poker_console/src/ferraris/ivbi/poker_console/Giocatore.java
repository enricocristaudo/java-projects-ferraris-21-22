
package ferraris.ivbi.poker_console;

import java.util.Random;

public class Giocatore {
    
    public static final String RESET = "\033[0m";  
    public static final String BLACK = "\033[0;30m";   
    public static final String RED = "\033[0;31m";     
    public static final String GREEN = "\033[0;32m";   
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m";    
    public static final String PURPLE = "\033[0;35m";  
    public static final String CYAN = "\033[0;36m";    
    public static final String WHITE = "\033[0;37m";   
    
    private String nome;
    private int denaro;
    private boolean attivo;
    private boolean passato;
    private int fortuna;
    private int coraggio;
    private Carta mano[];
    private Carta manoCopia[];
    private int miaPuntata;

    public Giocatore(String nome, int denaro) {
        Random r= new Random();
        this.nome = nome;
        this.denaro = denaro;
        this.attivo = true;
        this.passato = false;
        this.fortuna = 0;
        this.coraggio = r.nextInt(101);
        this.mano = new Carta[5];
        this.manoCopia = new Carta[5];
        this.miaPuntata = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getDenaro() {
        return denaro;
    }

    public boolean isAttivo(){
        return attivo;
    }
    
    public int getFortuna() {
        return fortuna;
    }

    public void setFortuna(int fortuna) {
        this.fortuna = fortuna;
    }
    
    public int getCoraggio() {
        return coraggio;
    }

    public Carta[] getMano() {
        return mano;
    }

    public Carta[] getManoCopia() {
        return manoCopia;
    }
    
    public int getMiaPuntata() {
        return miaPuntata;
    }

    public void setMiaPuntata(int miaPuntata) {
        this.miaPuntata = miaPuntata;
    }

    public boolean isPassato() {
        return passato;
    }

    public void setPassato(boolean passato) {
        this.passato = passato;
    }
    
    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
    
    public void prendiCarte(Carta c,Carta c1,Carta c2,Carta c3,Carta c4){
        this.mano[0]=c;
        this.mano[1]=c1;
        this.mano[2]=c2;
        this.mano[3]=c3;
        this.mano[4]=c4;
    }
    
    public void puntataIniziale(Piatto p){
        this.denaro-=10;
        p.riceviPuntata(10);
        p.setMaxPuntata(10);
    }
    
    public void visuMano(){
        for(int i=0;i<5;i++){
            if(mano[i].getSeme()=='♥'||mano[i].getSeme()=='♦'){
                if(mano[i].getValore()!='1'){
                    System.out.print(RED + mano[i].getValore()+""+mano[i].getSeme()+" "+ RESET);
                }else System.out.print(RED + mano[i].getValore()+"0"+""+mano[i].getSeme()+" "+ RESET);
            }else{
                if(mano[i].getValore()!='1'){
                    System.out.print(mano[i].getValore()+""+mano[i].getSeme()+" ");
                }else System.out.print(mano[i].getValore()+"0"+""+mano[i].getSeme()+" ");
            }
            
        }
    }
    
    public void visuManoCopia(){
        for(int i=0;i<5;i++){
            IOSERVIZIO.stampaMessaggio(manoCopia[i].getValore()+manoCopia[i].getSeme()+" ");
        }
    }
    
    public void ordinaVet(Carta vet[]){
        for(int i=0;i<5-1;i++){
            for(int j=i+1;j<5;j++){
                if(vet[i].getValore()>vet[j].getValore()) {
                    Carta app=vet[i];
                    vet[i]=vet[j];
                    vet[j]=app;
                }
            }
        }
    }
    
    public void combinazioniMano(){
        if(isScalaReale()==true){
            setFortuna(100);
        }else if(isPoker()==true){
            setFortuna(90);
        }else if(isFull()==true){
            setFortuna(80);
        }else if(isColore()==true){
            setFortuna(70);
        }else if(isScala()==true){
            setFortuna(60);
        }else if(isTris()==true){
            setFortuna(50);
        }else if(isDoppiaCoppia()==true){
            setFortuna(40);
        }else if(isCoppia()==true){
            setFortuna(30);
        }else {
            setFortuna(20);
        }
    }
    public boolean isScalaReale(){
        return isScala()==true&&isColore()==true;
    }
    
    public boolean isPoker(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[1].getValore()==manoCopia[2].getValore()&&manoCopia[2].getValore()==manoCopia[3].getValore()||manoCopia[1].getValore()==manoCopia[2].getValore()&&manoCopia[2].getValore()==manoCopia[3].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[2].getValore()==manoCopia[3].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()||manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[1].getValore()==manoCopia[2].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()){
            return true;
        }
        return false;
    }
    
    public boolean isColore(){
        if(mano[0].getSeme()==mano[1].getSeme()&&mano[1].getSeme()==mano[2].getSeme()&&mano[2].getSeme()==mano[3].getSeme()&&mano[3].getSeme()==mano[4].getSeme()){
            return true;
        }
        return false;
    }
    
    public boolean isScala(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()-1&&manoCopia[1].getValore()==manoCopia[2].getValore()-1&&manoCopia[2].getValore()==manoCopia[3].getValore()-1&&manoCopia[3].getValore()==manoCopia[4].getValore()-1){
            return true;
        }
        return false;
    }
    
    public boolean isTris(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[1].getValore()==manoCopia[2].getValore()||manoCopia[2].getValore()==manoCopia[3].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()){
            return true;
        }
        return false;
    }
    
    public boolean isDoppiaCoppia(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[2].getValore()==manoCopia[3].getValore()||manoCopia[0].getValore()==manoCopia[1].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()||manoCopia[1].getValore()==manoCopia[2].getValore()&&manoCopia[3].getValore()==manoCopia[4].getValore()){
            return true;
        }
        return false;
    }
    
    public boolean isCoppia(){
        for(int i=0;i<5;i++){
            manoCopia[i]=mano[i];
        }
        ordinaVet(manoCopia);
        if(manoCopia[0].getValore()==manoCopia[1].getValore()||manoCopia[1].getValore()==manoCopia[2].getValore()||manoCopia[2].getValore()==manoCopia[3].getValore()||manoCopia[3].getValore()==manoCopia[4].getValore()){
            return true;
        }
        return false;
    }
    
    public int veduta(Piatto p){
        int x=p.getMaxPuntata()-this.miaPuntata;
        this.denaro-=x;
        this.miaPuntata+=x;
        p.riceviPuntata(x);
        return x;
    }
    
    public int rilancio(Piatto p){
        int x=0;
        switch(getFortuna()){
            case 80:
                if(this.getDenaro()+this.getMiaPuntata()>=p.getMaxPuntata()+30){
                    x=(p.getMaxPuntata()+30)-this.getMiaPuntata();
                    p.riceviPuntata(x);
                    this.denaro-=x;
                    p.setMaxPuntata(p.getMaxPuntata()+30);
                    this.miaPuntata+=x;
                    return x;
                }else{
                    x=this.getDenaro();
                    p.riceviPuntata(x);
                    p.setMaxPuntata(x+this.miaPuntata);
                    this.denaro-=x;
                    this.miaPuntata+=x;
                    break;
                }
            case 90:
                if(this.getDenaro()+this.getMiaPuntata()>=p.getMaxPuntata()+60){
                    x=(p.getMaxPuntata()+60)-this.getMiaPuntata();
                    p.riceviPuntata(x);
                    this.denaro-=x;
                    p.setMaxPuntata(p.getMaxPuntata()+60);
                    this.miaPuntata+=x;
                    break;
                }else{
                    x=this.getDenaro();
                    p.riceviPuntata(x);
                    p.setMaxPuntata(x+this.miaPuntata);
                    this.denaro-=x;
                    this.miaPuntata+=x;
                    break;
                }
            case 100:
                if(this.getDenaro()+this.getMiaPuntata()>=p.getMaxPuntata()+90){
                    x=(p.getMaxPuntata()+90)-this.getMiaPuntata();
                    p.riceviPuntata(x);
                    this.denaro-=x;
                    p.setMaxPuntata(p.getMaxPuntata()+90);
                    this.miaPuntata+=x;
                    break;
                }else{
                    x=this.getDenaro();
                    p.riceviPuntata(x);
                    p.setMaxPuntata(x+this.miaPuntata);
                    this.denaro-=x;
                    this.miaPuntata+=x;
                    break;
                }
        }
        return x;
    }
    /*  
    PASSO: 
        se non ho almeno i soldi per vedere, 
        se la mia fortuna è <= 20,
        se non ho abbastanza coraggio, 
        se la differenza tra i mio denaro e la mia puntata e troppo poco.
    VEDO:
        se ho i soldi per vedere,
        se ho abbastanza coraggio e la differenza tra il mio denaro e la mia puntata non è troppo poco,
        se la mia fortuna è > 50 e <= 70,
        se non ho i soldi per rilanciare ma quelli per vedere.
    RILANCIO:
        se ho i soldi per rilanciare,
        se la mia fortuna è > 70.
    */    
    public int giocata(Piatto p,int i){
        if(this.denaro<(p.getMaxPuntata()-this.miaPuntata)) {
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" passa.");
            return 0;
        }else if(this.getFortuna()<=20){
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" passa.");
            return 0;
        }else if(this.getFortuna()<=50){
            Random x=new Random();
            int z=x.nextInt(101);
            if(z<=coraggio &&(this.getDenaro()-(p.getMaxPuntata()-this.getMiaPuntata()))>=20) {
                IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" vede.");
                return 1;
            }
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" passa.");
            return 0;
        }else if(this.getFortuna()<=70){
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" vede.");
            return 1;
        }else if(this.denaro>(p.getMaxPuntata()-this.miaPuntata)){
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" rilancia.");
            return 2;
        }else {
            IOSERVIZIO.stampaMessaggio("Il giocatore "+(i+1)+" vede.");
            return 1;
        }
    }

    @Override
    public String toString() {
        return "{" + "nome=" + nome + ", denaro=" + denaro + ", attivo=" + attivo + ", passato=" + passato + ", fortuna=" + fortuna + ", coraggio=" + coraggio + ", miaPuntata=" + miaPuntata + '}';
    }

    public void riceviVincita(int x){
        this.denaro+=x;
    }
}
