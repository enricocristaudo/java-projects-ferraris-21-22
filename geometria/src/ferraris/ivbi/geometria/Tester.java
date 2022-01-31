
package ferraris.ivbi.geometria;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tester {

    public static void main(String[] args) {
        
        Rettangolo r1=null;
        try {
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            double b, h;
            String col;
            System.out.println("Inserisci la base del rettangolo:");
            b = Double.parseDouble(tastiera.readLine());
            System.out.println("Inserisci l'altezza del rettangolo:");
            h = Double.parseDouble(tastiera.readLine());
            System.out.println("Inserisci il colore del rettangolo:");
            col = tastiera.readLine();
            
            r1 = new Rettangolo(b, h, col);
            System.out.println("Rettangolo r1:\n" + r1.getStato());
            
        } catch (Exception ex) {
            //Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("+++ Errore inserimento dati +++");
            System.exit(0);
        }
        Rettangolo r2 = new Rettangolo(8.5,12,"giallo");
        Rettangolo r3 = new Rettangolo(r2);
        
        System.out.println("Rettangolo r2:\n" + r2.getStato());
        System.out.println("Rettangolo r3:\n" + r3.getStato());
        /*
        if (r1!=null && r1.calcolaArea()==r2.calcolaArea()){
            System.out.println("Basi uguali");
        }*/ 
        boolean b = r1.stessaArea(r2);
        System.out.println(b);
    }
    
}


