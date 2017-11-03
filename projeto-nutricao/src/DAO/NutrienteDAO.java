package DAO;

import Model.Alimento;
import java.util.Collection;
import Model.Nutriente;
import java.util.ArrayList;

public interface NutrienteDAO {

    //Collection obterTodos();
    //fnkdjklgjldjlçglçdng
    ArrayList<Nutriente> consultar(Alimento alimento);

    void salvar(Nutriente nutriente);

    void excluir(Nutriente nutriente);
    
     //dnmvnv,dsn,fnzsnf,a.dmgasdmglm,ms,.d
}
