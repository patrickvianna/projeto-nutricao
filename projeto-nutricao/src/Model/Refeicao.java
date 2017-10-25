package Model;

import java.util.*;

public class Refeicao {
    private int id;
    private String nome;
    private ArrayList<Alimento> alimentos;
    private ArrayList<Float> qtdAlimento;

    public Refeicao() {
    }

    public Refeicao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    
}
