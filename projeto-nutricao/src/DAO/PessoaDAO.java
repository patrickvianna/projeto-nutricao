package DAO;

import java.util.Collection;
import Model.Pessoa;

public interface PessoaDAO {

   /* Collection obterTodos();*/
    Pessoa ValidarUsuario(String login, String senha);
    
    Pessoa ConsultarUsuarioNome(String nome);

    boolean salvar(Pessoa pessoa);

    boolean excluir(Pessoa pessoa);
}
