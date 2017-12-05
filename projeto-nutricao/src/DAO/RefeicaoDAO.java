package DAO;

import java.util.Collection;
import Model.Refeicao;
import Model.SelecionarAlimentos;
import java.util.ArrayList;


public interface RefeicaoDAO {

    Collection obterTodos();

    Boolean salvar(String nomeRefeicao, float preco, Long idPessoa);
    
    void salvarAlimentos(ArrayList<SelecionarAlimentos> sa, String nomeRefeicao, Long idPessoa);

    void excluir(Refeicao refeicao);
}
