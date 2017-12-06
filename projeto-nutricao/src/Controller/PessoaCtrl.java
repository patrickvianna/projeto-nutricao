package Controller;

import DAO.PessoaDAOJDBC;
import DAO.RefeicaoDAOJDBC;
import Model.Pessoa;
import Model.Refeicao;
import View.MenuVw;
import java.util.ArrayList;
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
    
    public boolean excluirUsuario(Pessoa pessoa, Long idUsuario){
        PessoaDAOJDBC pessoaDAOJDBC = new PessoaDAOJDBC();
        
        RefeicaoDAOJDBC refeicaoDAOJDBC = new RefeicaoDAOJDBC();
        
        ArrayList<Refeicao> refeicao = null;
        
        refeicao = refeicaoDAOJDBC.buscarRefeicao(idUsuario);
        if(!refeicao.isEmpty()){
            for(Refeicao r: refeicao){            
                refeicaoDAOJDBC.excluir(r.getId());
            }
        }
        
        if(pessoaDAOJDBC.excluir(pessoa)){
            return true;
        }else{
            return false;
        }
    }
    
}
