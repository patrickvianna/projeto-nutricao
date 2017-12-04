package Controller;

import DAO.RefeicaoDAOJDBC;
import DAO.SelecionarAlimentoDAO;
import Model.Nutriente;
import Model.SelecionarAlimentos;
import DAO.SelecionarAlimentosJDBC;
import java.util.ArrayList;

public class RefeicaoCtrl {

    public RefeicaoCtrl() {
    }
    
    public void selecionarAlimento()
    {
        
    }
    
    public void  verificarBaalanceamento()
    {
        
    }
    
    public Boolean salvarRefeicao(String nomeRefeicao, float precoRefeicao, ArrayList<SelecionarAlimentos> sa, Long idUsuario)
    {
        RefeicaoDAOJDBC refeicaoDAO = new RefeicaoDAOJDBC();
        
        // SALVAR REFEICAO
        Boolean resultadoRefeicao = refeicaoDAO.salvar(nomeRefeicao, precoRefeicao, idUsuario);
        // SALVAR ALIMENTOS
        // SE NAO CONSEGUIU INSERIR A REFEICAO, NÃO IRÁ INSERIR OS ALIMENTOS
        if(resultadoRefeicao)
        {            
            refeicaoDAO.salvarAlimentos(sa, nomeRefeicao, idUsuario);
            return true;
        }else            
            return false;
        
    }
    
   public ArrayList<Nutriente> calculoNutrientes(ArrayList<SelecionarAlimentos> sa)
   {
       ArrayList<Nutriente> nutrientes = new ArrayList<>();
       float calorias = 0.0f;
       Boolean isListNutriente;
       SelecionarAlimentosJDBC saDao = new SelecionarAlimentosJDBC();
       
       for(SelecionarAlimentos a : sa)
       {
           ArrayList<Nutriente> ns = new ArrayList<>();
           // OBTEM OS NUTRIENTES DAQUELE ALIMENTO
           ns = saDao.obterNutrientesAimento(a.getIdAlimento());
           
           for(Nutriente n : ns)
           {
               // CALCULO DA QUANTIDADE DO NUTRIENTE EM UMA PORÇÃO DE 100G
               n.setQuantidade(((a.getQtd()* n.getQuantidade())/100)); 
               isListNutriente = false;
               
               for(Nutriente m: nutrientes)
               {       
                   if(m.getTipo().equals(n.getTipo()))
                   {
                       m.setQuantidade(n.getQuantidade() + m.getQuantidade());
                       isListNutriente = true;
                       break;
                   }
               }
               if(!isListNutriente)
               {
                   nutrientes.add(n);
               }
           }
       }
       return nutrientes;
   }
}
