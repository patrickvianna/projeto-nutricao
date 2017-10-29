package Model;

import java.util.Set;

public class Nutriente {
    
    private Long id;
    private String tipo;
    private float qtd;
    //private Alimento alimento;
    
    
    public Nutriente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getQuantidade() {
        return qtd;
    }

    public void setQuantidade(int quantidade) {
        this.qtd = quantidade;
    }
    
}
