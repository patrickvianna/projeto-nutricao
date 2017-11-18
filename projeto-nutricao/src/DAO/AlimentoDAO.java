package DAO;

import java.util.Collection;
import Model.Alimento;
import java.util.ArrayList;
public interface AlimentoDAO {

    //Collection obterTodos();
    //Collection Consultar();
    public ArrayList<Alimento> consultar();
    
    Alimento buscarAlimentoNome(String nome);
    
    void salvar(Alimento alimento);

    void excluir(Alimento alimento);
    
}
