package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.MontaRefeicao;
import tools.DAOBaseJDBC;

public class MontaRefeicaoDAOJDBC extends DAOBaseJDBC implements MontarRefeicaoDAO {

    PreparedStatement stmt = null;

    @Override
    public Collection obterTodos() {
        Set set = new HashSet<>();
        ResultSet rset = null;
        try {
            conn.prepareStatement("SELECT id, dataEmissao, preco, FROM MontarRefeicao");
            rset = stmt.executeQuery();
            while (rset.next()) {
                MontaRefeicao montarRefeicao = new MontaRefeicao();
                montarRefeicao.setId(new Long(rset.getLong("id")));
                //montarRefeicao.setDataEmissao(dataEmissao);                       Ainda falta implementar
                montarRefeicao.setPreco(new Float(rset.getFloat("preco")));
                //montarRefeicao.setNome(new String(rset.getString("nome")));
                //montarRefeicao.setPessoa(pessoa);                                 Ainda falta implementar
                //montarRefeicao.setRefeicao(refeicao);                             Ainda falta implementar      
                //set.add(montarRefeicao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MontaRefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
    }

    @Override
    public void salvar(MontaRefeicao montarRefeicao) {
        try {
            if (montarRefeicao.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO MontarRefeicao (dataEmissao,preco,nome,pessoa,refeicao) VALUES(?,?,?,?,?)");
            } else {
                stmt = conn.prepareStatement("UPDATE MontarRefeicao SET dataEmissao = ?, preco = ?, nome = ?, pessoa = ?, refeicao = ? , WHERE id = ?");
                stmt.setLong(4, montarRefeicao.getId());
            }
            stmt.setDate(1, (java.sql.Date) montarRefeicao.getDataEmissao());
            stmt.setFloat(2, montarRefeicao.getPreco());
            stmt.setObject(3, montarRefeicao.getPessoa());
            stmt.setObject(4, montarRefeicao.getRefeicao());
        } catch (SQLException ex) {
            Logger.getLogger(MontaRefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
    }

    /*@Override
    public void excluir(MontaRefeicao montarRefeicao) {
        if (montarRefeicao.getNome() != null) {
            try {
                stmt = conn.prepareStatement("DELETE FROM MontarRefeicao WHERE nome = ?");
                stmt.setString(1, montarRefeicao.getNome());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MontarRefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

        }
    }*/

}
