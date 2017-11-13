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

    

    /*@Override
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
    }*/
    
    @Override
    public Pessoa ValidarUsuario(String login, String senha){
            Pessoa pessoa = null;
            try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT * FROM tab_pessoa WHERE login = ? and senha = ?");
                smt.setString(1, login);
                smt.setString(2, senha);
                ResultSet rset = smt.executeQuery();
                          
                if(rset.next()){
                   pessoa = new Pessoa();
                    
                    pessoa.setId(rset.getLong("ID"));
                    pessoa.setNome(rset.getString("NOME"));
                    pessoa.setIdade(rset.getInt("IDADE"));
                    pessoa.setEmail(rset.getString("EMAIL"));
                    pessoa.setLogin(rset.getString("LOGIN"));
                    pessoa.setSenha(rset.getString("SENHA"));
                    smt.close();
                    
                }
            }catch(SQLException e){
                Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("erro " + e);
            }
            
             return pessoa;
    }

    @Override
    public boolean salvar(Pessoa pessoa) {
        PreparedStatement stmt;
        boolean certo = false;
        try {
            if (pessoa.getId() == null) {
                stmt = conn.prepareStatement("INSERT INTO tab_pessoa (nome,idade,email,login,senha) VALUES(?, ?, ?, ? ,?)");
                certo = true;
            } else {
                stmt = conn.prepareStatement("UPDATE tab_pessoa SET  nome = ?, idade = ?, email = ?, login = ?, senha = ? WHERE id = ?");
                stmt.setLong(6, pessoa.getId());
                certo = true;
            }
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4,pessoa.getLogin());
            stmt.setString(5,pessoa.getSenha());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL: " + ex.getMessage());
            System.exit(1);
        }
        return certo;
    }

    @Override
    public boolean excluir(Pessoa pessoa) {
        PreparedStatement stmt;
        boolean certo = false;
        if (pessoa.getId() != null) {
            try {
                stmt = conn.prepareStatement("DELETE FROM tab_pessoa WHERE id = ?");
                stmt.setLong(1, pessoa.getId());
                stmt.executeUpdate();
                certo = true;
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro SQL: " + ex.getMessage());
                System.exit(1);
            }

        }
        return certo;
    }
    
    @Override
    public Pessoa ConsultarUsuarioNome(String nome){
            Pessoa pessoa = null;
        
        try {
                PreparedStatement smt =
                        conn.prepareStatement("SELECT * FROM tab_pessoa WHERE nome = ?");
                        smt.setString(1, nome);
                ResultSet rset = smt.executeQuery();
                          
                if(rset.next()){
                   
                    pessoa = new Pessoa();
        
                    pessoa.setId(rset.getLong("ID"));
                    pessoa.setNome(rset.getString("NOME"));
                    pessoa.setIdade(rset.getInt("IDADE"));
                    pessoa.setEmail(rset.getString("EMAIL"));
                    pessoa.setLogin(rset.getString("LOGIN"));
                    pessoa.setSenha(rset.getString("SENHA"));
                     
                }else{
                    return null;
                }
            }catch(SQLException e){
                
                System.out.println("Falha na consulta " + e.getMessage());
                return null;
            }
            
            return pessoa;
    }


}
