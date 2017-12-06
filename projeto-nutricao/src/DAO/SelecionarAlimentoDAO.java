package DAO;

import Model.Nutriente;
import java.util.ArrayList;

public interface SelecionarAlimentoDAO {
    
    ArrayList<Nutriente> obterNutrientesAimento(long idAlimento);
}
