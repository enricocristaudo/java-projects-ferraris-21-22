
package ferrairs.ivbi.torcia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOServices {
    private static BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    
    public static void mostraMessaggio(String msg)
    {
        System.out.println(msg);
    }
    
    public static int inserisciIntero(String msg)
    {
        int num = 0;
        mostraMessaggio(msg);
        try
        {
            num = Integer.parseInt(tastiera.readLine());
        }catch (Exception ex) 
        {
            mostraMessaggio("+++ Errore inserimento dati +++");
        }
        return num;
    }
}
