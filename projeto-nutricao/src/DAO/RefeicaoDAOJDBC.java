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
                refeicao.setQuantidade(new Integer(rset.getInt("quantidade")));
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
    public void salvar(Refeicao refeicao) {
        try {
            if (refeicao.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO Refeicao (nome,quantidade) VALUES(?,?)");
            } else {
                stmt = conn.prepareStatement("UPDATE Refeicao SET nome = ?, quantidade = ?, WHERE id = ?");
                stmt.setLong(4, refeicao.getId());
            }
            stmt.setString(1, refeicao.getNome());
            stmt.setInt(2, refeicao.getQuantidade());
        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
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

}
