
package ferraris.ivbi.poker_console;

import java.util.concurrent.TimeUnit;

public class Main {

    public static final String RESET = "\033[0m";  
    public static final String BLACK = "\033[0;30m";   
    public static final String RED = "\033[0;31m";     
    public static final String GREEN = "\033[0;32m";   
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m";    
    public static final String PURPLE = "\033[0;35m";  
    public static final String CYAN = "\033[0;36m";    
    public static final String WHITE = "\033[0;37m";

    
    private static int numGiocatori;
    private static int numGiocatoriAttuali=0;
    private static Giocatore[] players;

    public static int getNumGiocatori() {
        return numGiocatori;
    }
    
    public static void diminuisciGiocatoriAttuali(){
        numGiocatoriAttuali--;
    }

    public static int getNumGiocatoriAttuali() {
        return numGiocatoriAttuali;
    }
    
    public static void creaGiocatori(int n){
        String nome;
        int denaro;
        for(int i=0;i<n;i++){
            IOSERVIZIO.stampaMessaggio("***** Giocatore "+(i+1)+" *****");
            nome=IOSERVIZIO.inserisciString("Inserisci il nome del Giocatore ");
            denaro=IOSERVIZIO.inserisciIntero("Inserisci il denaro iniziale del Giocatore ");
            players[i]=new Giocatore(nome,denaro);
            numGiocatoriAttuali++;
        }
    }
     
    public static void puntataInizio(int n,Piatto p){
        for(int i=0;i<n;i++){
            if(players[i].isAttivo()==true && players[i].getDenaro()>10){
                players[i].puntataIniziale(p);
            }else players[i].setAttivo(false);
        }
    }
    
    public static void round(Piatto p,Mazzo m) throws InterruptedException{
        //PUNTATA INIZIALE
        for(int i=0;i<numGiocatori;i++){
            if(!players[i].isAttivo()) continue;
            else if(players[i].getDenaro()<11){
                players[i].setAttivo(false);
                Main.diminuisciGiocatoriAttuali();
                continue;
            }
            players[i].puntataIniziale(p);
        }
        p.aumentaNumeroMani();
        
        m.distribuisciCarte(players);
        
        for(int i=0;i<numGiocatori;i++){
            if(!players[i].isAttivo()) continue;
            players[i].combinazioniMano();
        }
       
        int app;
        do{
            app=p.getMaxPuntata();
            for(int i=0;i<numGiocatori;i++){
                if(!players[i].isAttivo()) {
                    String s="Giocatore "+(i+1);
                    System.out.println(s+players[i].toString());
                    players[i].visuMano();
                    System.out.println("");
                    continue;
                }
                switch(players[i].giocata(p,i)){
                    case 0 -> players[i].setPassato(true);
                    case 1 -> players[i].veduta(p);
                    case 2 -> players[i].rilancio(p);
                }
                String s="Giocatore "+(i+1);
                System.out.println(s+players[i].toString());
                players[i].visuMano();
                System.out.println("");
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println(p.toString());
        }while(app!=p.getMaxPuntata());
        
        int v=-1;
        for(int i=0;i<numGiocatori;i++){
            if(!players[i].isAttivo() || players[i].isAttivo() && players[i].isPassato()) continue;
            if(v<players[i].getFortuna()) v=players[i].getFortuna();
        }
        
        int z=0;
        for(int i=0;i<numGiocatori;i++){
            if(!players[i].isAttivo() || players[i].isAttivo() && players[i].isPassato()) continue;
            if(players[i].getFortuna()==v) z++;
        }
        
        p.vincitore(players, z, v);
        
        reset(p, m);
    }
    
    public static void reset(Piatto p,Mazzo m){
        for(int i=0;i<52;i++){
            m.getMazzo()[i].setUsata(false);
        }
        Carta c=new Carta('/', '/');
        for(int i=0;i<numGiocatori;i++){
            players[i].setMiaPuntata(0);
            players[i].setPassato(false);
            players[i].prendiCarte(c, c, c, c, c);
        }
        p.setMaxPuntata(0);
    }
    
    public static void main(String args[]) throws InterruptedException{
        do
        {
            numGiocatori=IOSERVIZIO.inserisciIntero("Quanti giocatori? (2-10)");
        }while(numGiocatori<2||numGiocatori>10);
        players=new Giocatore[numGiocatori];
        creaGiocatori(numGiocatori);
        Mazzo mazzo= new Mazzo();
        Piatto piatto= new Piatto();
        System.out.println("");
        do{
            round(piatto, mazzo);
        }while(numGiocatoriAttuali>1);
        for(int i=0;i<numGiocatori;i++){
            if(players[i].isAttivo()) 
                IOSERVIZIO.stampaMessaggio("IL VINCITORE E': Giocatore "+(i+1)+players[i].toString());
        }
    }
}

