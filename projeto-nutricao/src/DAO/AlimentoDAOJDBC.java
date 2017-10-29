package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Alimento;
import tools.DAOBaseJDBC;

/**
 *
 * @author alunodev02
 */
public class AlimentoDAOJDBC extends DAOBaseJDBC implements AlimentoDAO {

    PreparedStatement stmt = null;

    @Override
    public Collection obterTodos() {
        Set set = new HashSet<>();
        ResultSet rset = null;
        try {
            conn.prepareStatement("SELECT id, nome, descricao, tipo, nutriente, FROM Alimento");
            rset = stmt.executeQuery();
            while (rset.next()) {
                Alimento alimento = new Alimento();
                alimento.setId(new Long(rset.getLong("id")));
                alimento.setNome(new String(rset.getString("nome")));
                alimento.setDescricao(new String(rset.getString("descricao")));
                alimento.setTipo(new String(rset.getString("id")));
                alimento.setNutrientes(set);        //Ainda falta implementar
                set.add(alimento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
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

}
