package DAO;

import java.util.Collection;
import Model.Refeicao;


public interface RefeicaoDAO {

    Collection obterTodos();

    void salvar(Refeicao refeicao);

    void excluir(Refeicao refeicao);
}
