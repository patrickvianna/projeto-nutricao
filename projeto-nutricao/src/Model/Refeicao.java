package Model;

import java.util.Set;

public class Refeicao {
    private int id;
    private String nome;
    private Set<Alimento> alimentos;

    public Refeicao() {
    }

    public Refeicao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    
}
