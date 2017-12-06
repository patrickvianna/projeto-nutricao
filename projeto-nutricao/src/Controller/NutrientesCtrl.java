/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AlimentoDAOJDBC;
import DAO.NutrienteDAOJDBC;
import Model.Nutriente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Humberto
 */
public class NutrientesCtrl {
    
    public void preencherTabelaNutrientes(DefaultTableModel modelo1, Long idAlimento){
         NutrienteDAOJDBC nutrienteDao = new NutrienteDAOJDBC();
                AlimentoDAOJDBC alimentoDao = new AlimentoDAOJDBC();

                while (modelo1.getRowCount() > 0) // se a tabela tinha alguma linha , essa linha é removida antes de criar novas linhas
                     modelo1.removeRow(0);

                for(Nutriente a: nutrienteDao.consultar(idAlimento)){
                    modelo1.addRow(new Object[]{
                        //a.getId(),
                        a.getTipo(),
                        a.getQuantidade(),
                        //a.getTipo()
                    });
                }
    }
}
