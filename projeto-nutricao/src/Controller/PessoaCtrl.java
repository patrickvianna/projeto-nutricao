package Controller;

import DAO.PessoaDAOJDBC;
import Model.Pessoa;
import View.MenuVw;
import javax.swing.JOptionPane;

public class PessoaCtrl {
    
    public boolean validarUsuario(String login, String senha){
        
         PessoaDAOJDBC pessoaDAOJDBC = new PessoaDAOJDBC();
        
        if(pessoaDAOJDBC.ValidarUsuario(login,senha) != null){
            MenuVw menu =  new MenuVw();
            menu.setVisible(true);
            menu.setResizable(false);
            Pessoa usuario = Pessoa.getInstance();
            usuario= pessoaDAOJDBC.ValidarUsuario(login,senha); 
            menu.Usuario(usuario);
            
            return true;       
        }else{
            return false;
        }   
    }
    
    public boolean salvarUsuario(Pessoa pessoa){
        PessoaDAOJDBC pessoaDAOJDBC = new PessoaDAOJDBC();
        
        if(pessoaDAOJDBC.salvar(pessoa)){
            return true;
        }else{
            return false;
        }
    }
    
}
