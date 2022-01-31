
package ferraris.ivbi.poker_console;

public class Piatto {
    
    public static final String RESET = "\033[0m";  
    public static final String BLACK = "\033[0;30m";   
    public static final String RED = "\033[0;31m";     
    public static final String GREEN = "\033[0;32m";   
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m";    
    public static final String PURPLE = "\033[0;35m";  
    public static final String CYAN = "\033[0;36m";    
    public static final String WHITE = "\033[0;37m"; 
    
    private int denaro;
    private int numMani;
    private int maxPuntata;

    public Piatto() {
        this.denaro = 0;
        this.numMani = 0;
        this.maxPuntata = 0;
    }

    public void aumentaNumeroMani(){
        numMani++;
    }
    
    public int getDenaro() {
        return denaro;
    }

    public int getNumMani() {
        return numMani;
    }

    public int getMaxPuntata() {
        return maxPuntata;
    }

    public void setMaxPuntata(int maxPuntata) {
        this.maxPuntata = maxPuntata;
    }
    
    public void riceviPuntata(int x){
        this.denaro+=x;
    }

    @Override
    public String toString() {
        return "Piatto{" + "denaro=" + denaro + ", numMani=" + numMani + ", maxPuntata=" + maxPuntata + '}';
    }
    
    public void vincitore(Giocatore g[],int z,int v){
        System.out.println("");
        if(z==0){
           System.out.println("VINCE QUESTA MANO IL PIATTO"); 
           System.out.println("");
           return;
        }
        for(int i=0;i<Main.getNumGiocatori();i++){
            if(!g[i].isAttivo()||g[i].isPassato()) continue;
            switch(z){
                case 1 -> {
                    if(g[i].getFortuna()==v){
                        System.out.println("VINCE QUESTA MANO IL GIOCATORE "+(i+1));
                        g[i].riceviVincita(this.getDenaro());
                    }
                }
                case 2 -> {
                    if(g[i].getFortuna()==v){
                        System.out.println("VINCE QUESTA MANO IL GIOCATORE "+(i+1));
                        g[i].riceviVincita(this.getDenaro()/2);
                    }
                }
                case 3 -> {
                    if(g[i].getFortuna()==v){
                        System.out.println("VINCE QUESTA MANO IL GIOCATORE "+(i+1));
                        g[i].riceviVincita(this.getDenaro()/3);
                    }
                }
                case 4 -> {
                    if(g[i].getFortuna()==v){
                        System.out.println("VINCE QUESTA MANO IL GIOCATORE "+(i+1));
                        g[i].riceviVincita(this.getDenaro()/4);
                    }
                }
            } 
        }
        System.out.println("");
        if(z!=0) this.denaro=0;
        
    }
}



