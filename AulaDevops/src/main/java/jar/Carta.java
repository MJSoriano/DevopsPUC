package jar;

public class Carta {
    private Integer peso;
    private String valor;
    private String naipe;

    public Carta(Integer peso, String valor, String naipe) {
        this.peso = peso;
        this.valor = valor;
        this.naipe = naipe;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return this.valor;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getNaipe() {
        return this.naipe;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPeso() {
        return this.peso;
    }

}