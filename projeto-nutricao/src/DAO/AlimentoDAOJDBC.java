package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Alimento;
import java.util.ArrayList;
import tools.DAOBaseJDBC;

public class AlimentoDAOJDBC extends DAOBaseJDBC implements AlimentoDAO {

    PreparedStatement stmt = null;
    private ArrayList<Alimento> alimentos = new ArrayList();

    public ArrayList<Alimento> obterTodos(){
       // Alimento alim = null;
            try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT ID, NOME, DESCRICAO, TIPO FROM tab_alimento");
                ResultSet rset = smt.executeQuery();
                          
                while(rset.next()){
                    Alimento alimento = new Alimento();
                    
                    alimento.setId(rset.getLong("ID"));
                    alimento.setNome(rset.getString("NOME"));
                    alimento.setDescricao(rset.getString("DESCRICAO"));
                    alimento.setTipo(rset.getString("TIPO"));
                    alimentos.add(alimento);
                }
            }catch(SQLException e){
                Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("erro " + e);
            }
            
             return alimentos;
    }

    @Override
    public void salvar(Alimento alimento) {
        try {
            if (alimento.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO Alimento (nome,descricao,tipo,nutriente) VALUES(?,?,?,?)");
            } else {
                stmt = conn.prepareStatement("UPDATE Alimento SET nome = ?, descricao = ?, tipo = ?, nutriente = ?, WHERE id = ?");
                stmt.setLong(4, alimento.getId());
            }
            stmt.setString(1, alimento.getNome());
            stmt.setString(2, alimento.getDescricao());
            stmt.setString(3, alimento.getTipo());
            stmt.setObject(4, alimento.getNutrientes());
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void excluir(Alimento alimento) {
        if (alimento.getNome() != null) {
            try {
                stmt = conn.prepareStatement("DELETE FROM Alimento WHERE NOME = ?");
                stmt.setString(1, alimento.getNome());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

        }
    }
   
    @Override
    public Alimento buscarAlimentoNome(String nome){
        Alimento alimento = null;
        
        try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT ID, NOME, DESCRICAO, TIPO FROM tab_alimento WHERE nome = ?");
                        smt.setString(1, nome);
                ResultSet rset = smt.executeQuery();
                          
                if(rset.next()){
                   
                    alimento = new Alimento();
        
                    alimento.setId(rset.getLong("ID"));
                    alimento.setNome(rset.getString("NOME"));
                    alimento.setDescricao(rset.getString("DESCRICAO"));
                    alimento.setTipo(rset.getString("TIPO"));
                     
                }else{
                    return null;
                }
            }catch(SQLException e){
                
                System.out.println("Falha na consulta " + e.getMessage());
                return null;
            }
            
            return alimento;
    }
    
    @Override
    public Alimento buscarAlimentoID(Long idAlimento){
        Alimento alimento = null;
        
        try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT ID, NOME, DESCRICAO, TIPO FROM tab_alimento WHERE ID = ?");
                        smt.setLong(1, idAlimento);
                ResultSet rset = smt.executeQuery();
                          
                if(rset.next()){
                   
                    alimento = new Alimento();
        
                    alimento.setId(rset.getLong("ID"));
                    alimento.setNome(rset.getString("NOME"));
                    alimento.setDescricao(rset.getString("DESCRICAO"));
                    alimento.setTipo(rset.getString("TIPO"));
                     
                }else{
                    return null;
                }
            }catch(SQLException e){
                
                System.out.println("Falha na consulta " + e.getMessage());
                return null;
            }
            
            return alimento;
    }
    
   

}
