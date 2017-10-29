package DAO;

import java.util.Collection;
import Model.Nutriente;

public interface NutrienteDAO {

    Collection obterTodos();

    void salvar(Nutriente nutriente);

    void excluir(Nutriente nutriente);
}
