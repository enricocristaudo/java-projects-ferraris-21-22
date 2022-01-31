
package ferraris.ivbi.poker_console;

import java.util.Random;

public class Mazzo {
    private final int numCarte=52;
    private Carta mazzo[];

    public Mazzo() {
        this.mazzo = new Carta[numCarte];
        mazzo[0]= new Carta('A','♠');mazzo[1]= new Carta('2','♠');mazzo[2]= new Carta('3','♠');mazzo[3]= new Carta('4','♠');mazzo[4]= new Carta('5','♠');mazzo[5]= new Carta('6','♠');mazzo[6]= new Carta('7','♠');mazzo[7]= new Carta('8','♠');mazzo[8]= new Carta('9','♠');mazzo[9]= new Carta('1','♠');mazzo[10]= new Carta('J','♠');mazzo[11]= new Carta('Q','♠');mazzo[12]= new Carta('K','♠');
        mazzo[13]= new Carta('A','♥');mazzo[14]= new Carta('2','♥');mazzo[15]= new Carta('3','♥');mazzo[16]= new Carta('4','♥');mazzo[17]= new Carta('5','♥');mazzo[18]= new Carta('6','♥');mazzo[19]= new Carta('7','♥');mazzo[20]= new Carta('8','♥');mazzo[21]= new Carta('9','♥');mazzo[22]= new Carta('1','♥');mazzo[23]= new Carta('J','♥');mazzo[24]= new Carta('Q','♥');mazzo[25]= new Carta('K','♥');
        mazzo[26]= new Carta('A','♦');mazzo[27]= new Carta('2','♦');mazzo[28]= new Carta('3','♦');mazzo[29]= new Carta('4','♦');mazzo[30]= new Carta('5','♦');mazzo[31]= new Carta('6','♦');mazzo[32]= new Carta('7','♦');mazzo[33]= new Carta('8','♦');mazzo[34]= new Carta('9','♦');mazzo[35]= new Carta('1','♦');mazzo[36]= new Carta('J','♦');mazzo[37]= new Carta('Q','♦');mazzo[38]= new Carta('K','♦');
        mazzo[39]= new Carta('A','♣');mazzo[40]= new Carta('2','♣');mazzo[41]= new Carta('3','♣');mazzo[42]= new Carta('4','♣');mazzo[43]= new Carta('5','♣');mazzo[44]= new Carta('6','♣');mazzo[45]= new Carta('7','♣');mazzo[46]= new Carta('8','♣');mazzo[47]= new Carta('9','♣');mazzo[48]= new Carta('1','♣');mazzo[49]= new Carta('J','♣');mazzo[50]= new Carta('Q','♣');mazzo[51]= new Carta('K','♣');
        
    }

    public int getNumCarte() {
        return numCarte;
    }

    public Carta[] getMazzo() {
        return mazzo;
    }

    public void visuMazzo(){
        for(int i=0;i<52;i++){
            System.out.print(this.mazzo[i].getValore()+" "+this.mazzo[i].getSeme()+" ");
        }
    }
    
    public void distribuisciCarte(Giocatore g[]){
        Random r= new Random();
        int casuale,casuale1,casuale2,casuale3,casuale4;
        for(int i=0;i<Main.getNumGiocatori();i++){
            if(g[i].isAttivo()){
                do
                {
                    casuale=r.nextInt(numCarte);
                }while(this.mazzo[casuale].isUsata());
                this.mazzo[casuale].setUsata(true);
                do
                {
                    casuale1=r.nextInt(numCarte);
                }while(this.mazzo[casuale1].isUsata());
                this.mazzo[casuale1].setUsata(true);
                 do
                {
                    casuale2=r.nextInt(numCarte);
                }while(this.mazzo[casuale2].isUsata());
                 this.mazzo[casuale2].setUsata(true);
                do
                {
                    casuale3=r.nextInt(numCarte);
                }while(this.mazzo[casuale3].isUsata());
                this.mazzo[casuale3].setUsata(true);
                do
                {
                    casuale4=r.nextInt(numCarte);
                }while(this.mazzo[casuale4].isUsata());
                this.mazzo[casuale4].setUsata(true);
                g[i].prendiCarte(this.mazzo[casuale], this.mazzo[casuale1], this.mazzo[casuale2], this.mazzo[casuale3], this.mazzo[casuale4]);
            }
        }
        
    }
    
}

