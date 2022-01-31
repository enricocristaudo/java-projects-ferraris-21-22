
package ferraris.ivbi.bar;

public class Prodotto {
    private String tipo;
    private String nome;
    private double prezzo;
    
    public Prodotto(String tipo, String nome, double prezzo){
        this.tipo = tipo;
        this.nome = nome;
        this.prezzo = prezzo;
    }
    
    public Prodotto(Prodotto p){
        this.tipo = p.getTipo();
        this.nome = p.getNome();
        this.prezzo = p.getPrezzo();
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
}
