package DAO;

import java.util.Collection;
import Model.Refeicao;
import Model.SelecionarAlimentos;
import java.util.ArrayList;


public interface RefeicaoDAO {

    ArrayList<Refeicao> obterTodos(Long idUsuario);
    
    ArrayList<SelecionarAlimentos> obterAlimentosRefeicao(Long idRefeicao);

    Boolean salvar(String nomeRefeicao, float preco, Long idPessoa);
    
    void salvarAlimentos(ArrayList<SelecionarAlimentos> sa, String nomeRefeicao, Long idPessoa);

    Boolean excluir(Long idRefeicao);
}
