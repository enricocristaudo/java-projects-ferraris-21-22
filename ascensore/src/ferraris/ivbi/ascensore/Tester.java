
package ferraris.ivbi.ascensore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tester {
    public static void main(String[] args) {

        /*
        STATIC: può  essere associata a metodi e attributi
        serve per far si che un membro diventi un cosiddetto "membro di classe"
        ovvero che non si riferisca più al singolo attributo ma all'intera classe
        
        */
        Ascensore a1 = null;
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));   
        try {          
            int maxPersone, pianoMin, pianoMax;
            
            System.out.println("Nuovo ascensore\n");
            System.out.print("Numero massimo persone: ");
            maxPersone = Integer.parseInt(tastiera.readLine());
            
            System.out.print("Piano minimo: ");
            pianoMin = Integer.parseInt(tastiera.readLine());
            
            System.out.print("Piano massimo: ");
            pianoMax = Integer.parseInt(tastiera.readLine());
            
            a1 = new Ascensore(maxPersone, pianoMin, pianoMax, 20);
        } catch (Exception ex) {
            System.out.println("+++ Errore inserimento dati +++");
            System.exit(0);
        }
        
        String s = null;
        do{
            try {
                int x = a1.menu();
                
                switch(x){
                    case 1:
                        System.out.print("Peso persona che sale: ");
                        double pesoSale = Double.parseDouble(tastiera.readLine());
                        a1.salePersona(pesoSale);
                        System.out.println(a1.mostraStato());
                        break;
                    case 2:
                        System.out.print("Peso persona che scende: ");
                        double pesoScende = Double.parseDouble(tastiera.readLine());
                        a1.scendePersona(pesoScende);
                        System.out.println(a1.mostraStato());
                        break;
                    case 3:
                        System.out.print("In quale piano vuoi andare? ");
                        int piano = Integer.parseInt(tastiera.readLine());
                        a1.vaiAlPiano(piano);
                        System.out.println(a1.mostraStato());
                        break;
                    case 4:
                        a1.saliUnPiano();
                        System.out.println(a1.mostraStato());
                        break;
                    case 5:
                        a1.scendiUnPiano();
                        System.out.println(a1.mostraStato());
                        break;
                    case 6:
                        a1.bloccaAscensore();
                        System.out.println(a1.mostraStato());
                        break;
                    default:
                        System.out.println(a1.mostraStato());
                        break;
                }
                
            } catch (Exception ex) {
               //Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("+++ Errore inserimento dati +++");
               System.exit(0);
            }
            
            System.out.print("Vuoi continuare? (si/no) ");
            try {
                s = tastiera.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("+++ Errore inserimento dati +++");
                System.exit(0);
            }
            
        }while(s.equals("si"));
        
    }
    
}
