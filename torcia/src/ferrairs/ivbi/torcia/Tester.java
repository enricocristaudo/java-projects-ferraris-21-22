
package ferrairs.ivbi.torcia;

public class Tester {

    public static void main(String[] args) {
        Torcia t1 = new Torcia(100);
        
        IOServices.mostraMessaggio(t1.toString());
        
        t1.click();
        t1.setRosso();
        t1.setRaggio(1);
        
        IOServices.mostraMessaggio(t1.toString());
        IOServices.mostraMessaggio(t1.getVita() + " prima dello spegnimento.");
        
        t1.click();
        t1.click();
        t1.click();
        t1.click();
        t1.click();
        
        IOServices.mostraMessaggio(t1.toString());
        IOServices.mostraMessaggio(t1.getVita() + " prima dello spegnimento.");
        
        Torcia t2 = new Torcia(t1);
        IOServices.mostraMessaggio(t2.toString());
    }
    
}
