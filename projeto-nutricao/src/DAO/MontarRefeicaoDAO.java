package DAO;

import java.util.Collection;
import Model.MontaRefeicao;

public interface MontarRefeicaoDAO {

    Collection obterTodos();

    void salvar(MontaRefeicao montarRefeicao);

    void excluir(MontaRefeicao montarRefeicao);
}
