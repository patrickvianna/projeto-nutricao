package Model;

import java.util.*;

public class Pessoa {
    private int id;
    private int idade;
    private String nome;
    private String email;
    private Set<Refeicao> refeicoes;

    public Pessoa() {
    }

    public Pessoa(int id, int idade, String nome, String email) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.email = email;
    }
    
    
}
