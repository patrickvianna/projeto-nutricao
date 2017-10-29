package Model;

import java.util.HashSet;
import java.util.Set;

public class Alimento {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private Set<Nutriente> nutrientes;
    
    
    public Alimento() {
        this.nutrientes = new HashSet<Nutriente>();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Nutriente> getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(Set<Nutriente> nutrientes) {
        this.nutrientes = nutrientes;
    }
}
