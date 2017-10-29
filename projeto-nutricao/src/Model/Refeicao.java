package Model;

import java.util.HashSet;
import java.util.Set;

public class Refeicao {
    private Long id;
    private String nome;
    private Set<Alimento> alimentos;

    public Refeicao() {
        this.alimentos = new HashSet<Alimento>();
    }

    public Refeicao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(Set<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    
}
