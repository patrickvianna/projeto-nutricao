package DAO;

import java.util.Collection;
import Model.Pessoa;

public interface PessoaDAO {

    Collection obterTodos();

    void salvar(Pessoa pessoa);

    void excluir(Pessoa pessoa);
}
