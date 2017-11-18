package Model;

import java.util.*;

public class Pessoa {
    private Long id;
    private int idade;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Set<Refeicao> refeicoes;

    public Pessoa() {
        this.refeicoes = new HashSet<Refeicao>();
    }

    public Pessoa(Long id,String nome,int idade, String email, String login, String senha) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }
    
     public Pessoa( String nome,int idade, String email,String login, String senha) {
        
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.login = login;
        this.senha = senha;     
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Set<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
    
    @Override
    public String toString(){
        return "Id: " + this.id + "\n"
                +"Nome: " + this.nome + "\n"
                + "Idade: " + this.idade + "\n"
                + "Email: " + this.email + "\n"
                + "Login: " + this.login + "\n"
                + "Senha: " + this.senha;
    }
}
