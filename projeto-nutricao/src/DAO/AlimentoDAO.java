package DAO;

import java.util.Collection;
import Model.Alimento;
import java.util.ArrayList;
public interface AlimentoDAO {
//fnkdjklgjldjlçglçdng
    //Collection obterTodos();
    //Collection Consultar();
    public ArrayList<Alimento> consultar();
    
    Alimento buscarAlimentoNome(String nome);
    
    void salvar(Alimento alimento);

    void excluir(Alimento alimento);
     //dnmvnv,dsn,fnzsnf,a.dmgasdmglm,ms,.d
}
