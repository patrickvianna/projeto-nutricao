package DAO;

import Model.Alimento;
import java.util.Collection;
import Model.Nutriente;
import java.util.ArrayList;

public interface NutrienteDAO {

    //Collection obterTodos();
    
    ArrayList<Nutriente> consultar(Long idAlimento);

    void salvar(Nutriente nutriente);

    void excluir(Nutriente nutriente);
    
   
    
}
