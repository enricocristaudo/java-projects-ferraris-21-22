
package ferraris.ivbi.bar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileIO 
{
    /**
     * Legge da un file scelto dalla finestra di filechooser
     * e restituisce tutte le righe all'interno di un vettore
     * @return Vettore di stringhe contenente una riga 
     * in ogni cella
     */
    public static String[] readFromFile()
    {
        
        String  righe[]=null;
        JFrame fff = new JFrame();
        JFileChooser fd = new JFileChooser("."); //JFileChooser() parte da i documenti
        int n = fd.showOpenDialog(fff);
        if (n!=JFileChooser.APPROVE_OPTION) return null;

        File f = fd.getSelectedFile();

        try{
            FileReader fr = new FileReader(f);
            BufferedReader in = new BufferedReader(fr);
            String line;
            int cont=0;
            while((line = in.readLine()) != null)
                cont++;
        
            righe=new String[cont];
            
            fr.close();
            //Riapro il file
            fr = new FileReader(f);
            in = new BufferedReader(fr);
            cont=0;
            while((line = in.readLine()) != null)
            {
               righe[cont]=line;
               cont++;
            }
           }catch(Exception ex)
             {
                System.out.println("File inesistente oppure non leggibile");
                return null;
             }
       
    return righe;
    }
    
    /**
     * Scrive tutte le righe di testo presenti nel vettore
     * all'interno di un file scelto tramite filechooser
     * @param righe Il vettore contenente una riga in ogni 
     * cella
     */
    public static void writeToFile(String righe[])
    {
        try
        {
            JFrame fff = new JFrame();
            JFileChooser fd = new JFileChooser("."); //JFileChooser() parte da i documenti
            int n = fd.showSaveDialog(fff);
            if (n!=JFileChooser.APPROVE_OPTION) return;

            File f = fd.getSelectedFile();
            
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
                
            for(String riga:righe)
            {
                pw.println(riga);
            }
            
            fw.close();
        }catch(Exception xx)
        {
            System.out.println("Errore nella scrittura del file");
            return;
        }


    }
}
  