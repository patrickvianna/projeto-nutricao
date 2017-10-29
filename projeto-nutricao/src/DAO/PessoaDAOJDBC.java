package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Pessoa;
import tools.DAOBaseJDBC;

public class PessoaDAOJDBC extends DAOBaseJDBC implements PessoaDAO {

    PreparedStatement stmt = null;

    @Override
    public Collection obterTodos() {
        Set set = new HashSet<>();
        ResultSet rset = null;
        try {
            conn.prepareStatement("SELECT id, idade, nome, email, FROM Pessoa");
            rset = stmt.executeQuery();
            while (rset.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(new Long(rset.getLong("id")));
                pessoa.setIdade(new Integer(rset.getInt("idade")));
                pessoa.setNome(new String(rset.getString("nome")));
                pessoa.setEmail(new String(rset.getString("email")));
                pessoa.setRefeicoes(set);       //Ainda falta a inserção do banco na coleção do tipo Set
                set.add(pessoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return set;
    }

    @Override
    public void salvar(Pessoa pessoa) {
        try {
            if (pessoa.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO Pessoa (idade,nome,email) VALUES(?,?,?)");
            } else {
                stmt = conn.prepareStatement("UPDATE Pessoa SET idade = ?, nome = ?, email = ?, WHERE id = ?");
                stmt.setLong(4, pessoa.getId());
            }
            stmt.setInt(1, pessoa.getIdade());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void excluir(Pessoa pessoa) {
        if (pessoa.getNome() != null) {
            try {
                stmt = conn.prepareStatement("DELETE FROM Alimento WHERE NOME = ?");
                stmt.setString(1, pessoa.getNome());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

        }
    }

}
