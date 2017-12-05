package DAO;

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
    public Collection obterTodos() {
        Set set = new HashSet<>();
        ResultSet rset = null;
        try {
            conn.prepareStatement("SELECT id, nome, quantidade, FROM Refeicao");
            rset = stmt.executeQuery();
            while (rset.next()) {
                Refeicao refeicao = new Refeicao();

                refeicao.setId(new Long(rset.getLong("id")));
                refeicao.setNome(new String(rset.getString("nome")));
                //refeicao.setQuantidade(new Integer(rset.getInt("quantidade")));
                refeicao.setAlimentos(set);        //Ainda falta a inserção do banco na coleção do tipo Set
                set.add(refeicao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
    public void excluir(Refeicao refeicao) {
        if (refeicao.getNome() != null) {
            try {                
                stmt = conn.prepareStatement("DELETE FROM Refeicao WHERE nome = ?");
                stmt.setString(1, refeicao.getNome());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

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
                stmt = conn.prepareStatement("INSERT INTO tab_alimento_has_tab_refeicao"
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
    
}
