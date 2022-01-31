
package ferraris.ivbi.bar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Prodotto[] vetProdotti;
    private static List<Prodotto> ordinazioni;
    
    public static void main(String[] args) {
       
        ordinazioni = new ArrayList<>();
        
        String prodLetti[] = FileIO.readFromFile();
        vetProdotti = new Prodotto[prodLetti.length];

        try{
            for(int i=0; i<prodLetti.length; i++){
            String[] line = prodLetti[i].split("#");
            vetProdotti[i] = new Prodotto(line[0], line[1], Double.parseDouble(line[2]));
            }
        }catch(NumberFormatException e){
            System.out.println(e);
            System.exit(0);
        }
        
        
        ordinaVet(vetProdotti);
        //printVet(vetProdotti);
        
        menu();
        ordinazioni();
        
    }
    
    private static void ordinaVet(Prodotto[] p){
        
        for(int i=0; i<p.length-1; i++){
            for(int j=i+1; j<p.length; j++){
                if(p[i].getTipo().compareTo(p[j].getTipo())>0) scambia(i, j);
            }
        }
    }
    
    private static void scambia(int i, int j){
        Prodotto temp = new Prodotto(vetProdotti[i]);
        vetProdotti[i] = new Prodotto(vetProdotti[j]);
        vetProdotti[j] = new Prodotto(temp);
    }
    
    private static void printVet(Prodotto[] p){
        for(Prodotto p1 : p){
            System.out.println(p1.getTipo()+" "+p1.getNome()+" "+p1.getPrezzo());
        }
    }
    
    private static void menu(){
        String s="\nBevande";
        System.out.println("MENU'");
        
        String leftAlignFormat = "| %-15s      | %-15s |%n";

        System.out.format("+----------------------+----------+%n");
        System.out.format("| Nome                 | Prezzo   |%n");
        System.out.format("+----------------------+----------+%n");
        for (Prodotto vetProdotti1 : vetProdotti) {
            System.out.format(leftAlignFormat, vetProdotti1.getNome(), vetProdotti1.getPrezzo());
        }
        System.out.format("+----------------------+----------+%n");
        

        /*for(int i=0; i<vetProdotti.length; i++){
            if(i==0) System.out.println(s+" -------");
            System.out.println((i+1)+"] "+vetProdotti[i].getNome()+" "+vetProdotti[i].getPrezzo());
            if(i+1 == vetProdotti.length) break;
            if(!vetProdotti[i].getTipo().equals(vetProdotti[i+1].getTipo())){
                if(vetProdotti[i+1].getTipo().equals("D")) s = "\nDolci";
                if(vetProdotti[i+1].getTipo().equals("S")) s = "\nSalati";
                System.out.println(s+" --------");
            }
        }*/
    }
    
    private static void ordinazioni(){
        BufferedReader t = new BufferedReader(new InputStreamReader(System.in));
        int scelta=0;
        do{
            try {
                System.out.println("Cosa vuoi comprare? ");
                scelta = Integer.parseInt(t.readLine());
                ordinazioni.add(vetProdotti[scelta-1]);
            } catch (IOException ex) {
                System.out.println(ex);
                System.exit(0);
            }
            if(scelta==12) break;
        }while(scelta>0&&scelta<vetProdotti.length);
    }
}


