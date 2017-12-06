package Controller;

import DAO.AlimentoDAOJDBC;
import Model.Alimento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AlimentoCtrl {
    
    public void preencherTabelaAlimento(DefaultTableModel modelo){
         AlimentoDAOJDBC alimentoDao = new AlimentoDAOJDBC();
        
        for(Alimento a: alimentoDao.obterTodos()){            
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getDescricao(),
                a.getTipo()
            });
        }
    }
}
