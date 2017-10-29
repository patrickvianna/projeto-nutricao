package DAO;

import java.util.Collection;
import Model.Alimento;
public interface AlimentoDAO {

    Collection obterTodos();

    void salvar(Alimento alimento);

    void excluir(Alimento alimento);
}
