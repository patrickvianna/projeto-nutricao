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

    /*@Override
    public Collection obterTodos() {
        Set set = new HashSet<>();
        ResultSet rset = null;
        try {
            conn.prepareStatement("SELECT id, descricao, quantidade, FROM Nutriente");
            rset = stmt.executeQuery();
            while (rset.next()) {
                Nutriente nutriente = new Nutriente();
                nutriente.setId(new Long(rset.getString("id")));
                nutriente.setTipo(new String(rset.getString("descricao")));
                nutriente.setQuantidade(new Integer(rset.getInt("quantidade")));
                set.add(nutriente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NutrienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
    }*/
    
    public ArrayList<Nutriente> consultar(Alimento alimento){
       // Alimento alim = null;
            try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT * FROM tab_nutriente WHERE tab_alimento_id = ?");
                        smt.setLong(1, alimento.getId());
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
//fnkdjklgjldjlçglçdng
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
 //dnmvnv,dsn,fnzsnf,a.dmgasdmglm,ms,.d
    
    /*@Override
    public ArrayList<Nutriente> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
