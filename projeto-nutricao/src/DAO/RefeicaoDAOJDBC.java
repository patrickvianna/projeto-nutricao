package DAO;

import Model.Alimento;
import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Refeicao;
import Model.SelecionarAlimentos;
import java.util.ArrayList;
import tools.DAOBaseJDBC;


public class RefeicaoDAOJDBC extends DAOBaseJDBC implements RefeicaoDAO {

    PreparedStatement stmt = null;
    

    @Override
    public ArrayList<Refeicao> obterTodos(Long idUsuario) {
        ArrayList<Refeicao> set = new ArrayList<>();
        ResultSet rset = null;
        try {
            stmt = conn.prepareStatement("SELECT ID, NOME, PRECO FROM TAB_REFEICAO WHERE TAB_PESSOA_ID = ?");
            
            stmt.setInt(1, Integer.parseInt(idUsuario.toString()));
            
            rset = stmt.executeQuery();
            while (rset.next()) {
                Refeicao refeicao = new Refeicao();

                refeicao.setId(new Long(rset.getLong("id")));
                refeicao.setNome(new String(rset.getString("nome")));
                refeicao.setPreco(rset.getFloat("preco"));
                set.add(refeicao);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
    }
    
    @Override
    public ArrayList<SelecionarAlimentos> obterAlimentosRefeicao(Long idRefeicao) {
        ArrayList<SelecionarAlimentos> set = new ArrayList<>();
        ResultSet rset = null;
        try {
            stmt = conn.prepareStatement("SELECT TAB_ALIMENTO_ID, QTD_ALIMENTO "
                                            //+ "FROM TAB_ALIMENTO_HAS_TAB_REFEICAO WHERE TAB_REFEICAO_ID = ?");
                                            + "FROM TAB_REFEICAO_HAS_TAB_ALIMENTO WHERE TAB_REFEICAO_ID = ?");
            stmt.setInt(1, Integer.parseInt(idRefeicao.toString()));
            rset = stmt.executeQuery();
            while (rset.next()) {
                SelecionarAlimentos sa = new SelecionarAlimentos();

                sa.setIdAlimento(new Long(rset.getLong("TAB_ALIMENTO_ID")));
                sa.setQtd(rset.getFloat("QTD_ALIMENTO"));
                set.add(sa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelecionarAlimentosJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
    }

    @Override
    public Boolean salvar(String nomeRefeicao, float preco, Long idPessoa) {
        ResultSet rset = null;
        String verificaRefeicao;
        Boolean isRefeicao = false;
        try {
            // VERIFICAR SE EXISTE REFEICAO COM ESSE NOME
            stmt = conn.prepareStatement("SELECT nome FROM tab_refeicao WHERE tab_pessoa_id = ?");
                stmt.setInt(1, Integer.parseInt(idPessoa.toString()));
                rset = stmt.executeQuery();
                while (rset.next()) {
                    verificaRefeicao = rset.getString("nome");
                    if(nomeRefeicao.equals(verificaRefeicao))
                    {                        
                        isRefeicao = true;
                        break;
                    }
                }
            if(isRefeicao)
            {
                // IMPRIMIR MENSAGEM QUE JA EXISTE REFEICAO COM ESSE NOME
                System.out.println("JA EXISTE ESSA REFEICAO");
                return false;
            }else
            {
                stmt = conn.prepareStatement("INSERT INTO TAB_REFEICAO (nome, preco, tab_pessoa_id) VALUES(?,?,?)");

                stmt.setString(1, nomeRefeicao);
                stmt.setFloat(2, preco);
                stmt.setFloat(3, idPessoa);
                stmt.executeUpdate();
                System.out.println("SALVOU A REFEICAO");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
            return false;
        }
    }

    @Override
    public void salvarAlimentos(ArrayList<SelecionarAlimentos> sa, String nomeRefeicao, Long idPessoa) {
        ResultSet rset = null;
        Long idRefeicao = null;
        try{
            stmt = conn.prepareStatement("SELECT ID FROM tab_refeicao WHERE NOME = ?");
                stmt.setString(1, nomeRefeicao);
                rset = stmt.executeQuery();
                while (rset.next()) {
                    idRefeicao = rset.getLong("id");
                }
            for(SelecionarAlimentos a: sa)
            {   
                    stmt = conn.prepareStatement("INSERT INTO TAB_REFEICAO_HAS_TAB_ALIMENTO"
                //stmt = conn.prepareStatement("INSERT INTO tab_alimento_has_tab_refeicao"
                                            + " (TAB_REFEICAO_ID, TAB_REFEICAO_TAB_PESSOA_ID, TAB_ALIMENTO_ID, QTD_ALIMENTO) "
                                            + " VALUES(?,?,?,?)");
                stmt.setInt(1, Integer.parseInt(idRefeicao.toString()));
                stmt.setInt(2, Integer.parseInt(idPessoa.toString()));
                Long idAlimento = a.getIdAlimento();
                stmt.setInt(3, Integer.parseInt(idAlimento.toString()));
                stmt.setFloat(4, a.getQtd());
                stmt.executeUpdate();
                System.out.println("SALVOU O ALIMENTO");
            }
        }catch(SQLException e)
        {
            System.out.println("ERRO SQL : " + e.getMessage());            
        }
    }
    
    @Override
    public Boolean excluir(Long idRefeicao) {        
        try {                
            stmt = conn.prepareStatement("DELETE FROM tab_refeicao_has_tab_alimento where TAB_REFEICAO_ID = ?");
            stmt.setInt(1, Integer.parseInt(idRefeicao.toString()));
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM tab_refeicao WHERE ID = ?");
            stmt.setInt(1, Integer.parseInt(idRefeicao.toString()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
            return false;
        }
        
    }
    //busca todos as refeicoes de um usuario
    public ArrayList<Refeicao> buscarRefeicao(Long idUsuario){
        
        ArrayList<Refeicao> refeicoes = null;
        try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT ID, NOME, PRECO FROM tab_refeicao WHERE TAB_PESSOA_ID = ?");
                smt.setInt(1, Integer.parseInt(idUsuario.toString()));
                ResultSet rset = smt.executeQuery();
                refeicoes = new ArrayList<>();
                
                while(rset.next()){
                    Refeicao refeicao = new Refeicao();
                    
                    refeicao.setId(rset.getLong("ID"));
                    refeicao.setNome(rset.getString("NOME"));
                    refeicao.setPreco(rset.getFloat("PRECO"));
                    
                    refeicoes.add(refeicao);
                }
            }catch(SQLException e){
                Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("erro " + e);
            }
            
             return refeicoes;
    }
    
    //deleta refeicao de determinado usuario
    public boolean excluirRefeicao(Pessoa pessoa){
        try {                
           
            stmt = conn.prepareStatement("DELETE FROM tab_refeicao WHERE tab_pessoa_id = ?");
            stmt.setLong(1,pessoa.getId());
            stmt.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
            return false;
        }
    }
    
}
