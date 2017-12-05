package DAO;

import java.util.Collection;
import Model.Alimento;
import java.util.ArrayList;
public interface AlimentoDAO {

    //Collection obterTodos();
    //Collection Consultar();
    public ArrayList<Alimento> obterTodos();
    
    Alimento buscarAlimentoNome(String nome);
    
    Alimento buscarAlimentoID(Long idAlimento);
    
    void salvar(Alimento alimento);

    void excluir(Alimento alimento);
    
}
