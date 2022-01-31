
package ferrairs.ivbi.torcia;

public class Torcia {
    private boolean accesa;
    private int vita;
    private String colore;
    private int raggio;
    
    public Torcia(int vita)
    {
        this.colore = "Bianco";
        this.raggio = 0;
        this.vita = vita;
        this.accesa = false;
    }
    
    public Torcia(Torcia rif)
    {
        this.accesa = rif.accesa;
        this.vita = rif.vita;
        this.colore = rif.colore;
        this.raggio = rif.raggio;
    }

    public void click()
    {
        if( this.vita > 0) 
        {
            this.accesa = this.accesa != true;
            this.vita--;
        }
    }
    
    public void setRaggio(int raggio) {
        if(raggio < 0 || raggio > 1) return;
        this.raggio = raggio;
    }
    
    public void setBianco(){
        this.colore = "Bianco";
    }
    
    public void setRosso(){
        this.colore = "Rosso";
    }
    
    public void setVerde(){
        this.colore = "Verde";
    }
    
    public void setBlu(){
        this.colore = "Blu";
    }

    public int getVita(){
        return vita;
    }

    @Override
    public String toString() {
        String r;
        if(this.raggio == 0) r = "corto";
        else r = "lungo";
        return "Torcia{" + "accesa=" + accesa + ", vita=" + vita + ", colore=" + colore + ", raggio=" + r + '}';
    }

}
