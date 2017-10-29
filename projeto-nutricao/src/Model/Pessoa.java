package Model;

import java.util.*;

public class Pessoa {
    private Long id;
    private int idade;
    private String nome;
    private String email;
    private Set<Refeicao> refeicoes;

    public Pessoa() {
        this.refeicoes = new HashSet<Refeicao>();
    }

    public Pessoa(Long id, int idade, String nome, String email) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.email = email;
    }  
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Set<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
}
