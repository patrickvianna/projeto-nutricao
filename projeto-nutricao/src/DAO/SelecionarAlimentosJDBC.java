package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.MontaRefeicao;
import Model.Nutriente;
import java.util.ArrayList;
import tools.DAOBaseJDBC;

public class SelecionarAlimentosJDBC extends DAOBaseJDBC implements SelecionarAlimentoDAO {
    
    PreparedStatement stmt = null;
    
    public ArrayList<Nutriente> obterNutrientesAimento(long idAlimento) {
        
        ArrayList<Nutriente> nutrientes = new ArrayList<>();
        ResultSet rset = null;
        try {
            PreparedStatement smt =
                conn.prepareStatement("SELECT L.TEXTO AS 'NUTRIENTE', N.QTD AS 'QUANTIDADE' \n" +
                                        " FROM tab_alimento A \n" +
                                        "		INNER JOIN tab_nutriente N ON A.ID = N.TAB_ALIMENTO_ID \n" +
                                        "        INNER JOIN lov_nutriente L ON N.LOV_NUTRIENTE_ID = L.ID \n" +
                                        "	WHERE A.ID = ?");
            smt.setLong(1, idAlimento);
            rset = smt.executeQuery();
            while (rset.next()) {
                Nutriente nutri = new Nutriente();
                nutri.setTipo(new String(rset.getString("NUTRIENTE")));                
                nutri.setQuantidade(new Float(rset.getFloat("QUANTIDADE")));
                nutrientes.add(nutri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MontaRefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return nutrientes;
    } 
}
