package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Nutriente;
import tools.DAOBaseJDBC;

public class NutrienteDAOJDBC extends DAOBaseJDBC implements NutrienteDAO {

    PreparedStatement stmt = null;

    @Override
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
