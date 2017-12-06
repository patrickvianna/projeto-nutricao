package DAO;

import Model.Alimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Nutriente;
import java.util.ArrayList;
import tools.DAOBaseJDBC;

public class NutrienteDAOJDBC extends DAOBaseJDBC implements NutrienteDAO {

    PreparedStatement stmt = null;
    
    private ArrayList<Nutriente> nutrientes = new ArrayList();
    
    public ArrayList<Nutriente> consultar(Long idAlimento){
       // Alimento alim = null;
            try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT n.ID as 'ID', ln.TEXTO as 'NOME', n.QTD as 'QTD' \n" +
                                                " FROM tab_nutriente n INNER JOIN lov_nutriente ln ON n.LOV_NUTRIENTE_ID = ln.ID \n" +
                                                " WHERE	n.TAB_ALIMENTO_ID = ?");
                        smt.setLong(1, idAlimento);
                ResultSet rset = smt.executeQuery();
                          
                while(rset.next()){
                    Nutriente nutriente = new Nutriente();
                    
                    nutriente.setId(rset.getLong("ID"));
                    nutriente.setTipo(rset.getString("NOME"));
                    nutriente.setQuantidade(rset.getFloat("QTD"));
                    nutrientes.add(nutriente);
                }
            }catch(SQLException e){
                Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("erro " + e);
            }
            
             return nutrientes;
    }

    @Override
    public void salvar(Nutriente nutriente) {
        try {
            if (nutriente.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO Nutriente (descricao,quantidade) VALUES(?,?)");
            } else {
                stmt = conn.prepareStatement("UPDATE Nutriente SET descricao = ?, quantidade = ?, WHERE id = ?");
                stmt.setLong(4, nutriente.getId());
            }
            stmt.setString(1, nutriente.getTipo());
            stmt.setFloat(2, nutriente.getQuantidade());
        } catch (SQLException ex) {
            Logger.getLogger(NutrienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void excluir(Nutriente nutriente) {
        if (nutriente.getTipo() != null) {
            try {
                stmt = conn.prepareStatement("DELETE FROM Nutriente WHERE descricao = ?");
                stmt.setString(1, nutriente.getTipo());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(NutrienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

        }
    }
 
    
    

}
