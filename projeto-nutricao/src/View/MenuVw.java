/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.PessoaDAOJDBC;
import Model.Pessoa;
import Model.SelecionarAlimentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author alunodev06
 */
public class MenuVw extends javax.swing.JFrame {

    private Pessoa usuarioLogado;
    
    public MenuVw() {
        initComponents();
        
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
        
        txtData.setText("    " + formato.format(data));
        
        Timer time = new Timer(1000, new hora());
        time.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        txtData = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        txIdUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Nutrição");
        setMinimumSize(new java.awt.Dimension(57, 33));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        txtData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNomeUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtHora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuBar1.setPreferredSize(new java.awt.Dimension(800, 21));

        jMenu1.setText("Alimentos ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Historico de Refeições");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Meus Dados");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu3.setText("Sair");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txIdUsuario)
                        .addGap(18, 18, 18)))
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNomeUsuario))
                    .addComponent(txIdUsuario))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(807, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //menu sair.Fecha a tela
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    //Menu Alimento. Abre a tela Alimentos
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       
       TelaAlimento telaAlimento = new TelaAlimento(jDesktopPane1, usuarioLogado.getId());
       jDesktopPane1.add(telaAlimento);
       telaAlimento.show();
      
    }//GEN-LAST:event_jMenu1MouseClicked
 
    //Menu meusDados. Abre a tela MeusDados
    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        
        PessoaDAOJDBC pessoa = new PessoaDAOJDBC();
        MeusDados telaMeusDados = new MeusDados(this, Long.parseLong(txIdUsuario.getText().toString()));
        telaMeusDados.DadosUsuario(pessoa.ConsultarUsuarioNome(txtNomeUsuario.getText()));
        jDesktopPane1.add(telaMeusDados);
        telaMeusDados.show();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       TelaHistorioRefeicao refeicao = new TelaHistorioRefeicao(Long.parseLong(txIdUsuario.getText()));
       jDesktopPane1.add(refeicao);
       refeicao.show();
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuVw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              MenuVw menu =  new MenuVw();
              menu.setVisible(true);
              menu.setResizable(false);       
            }
        });
        */       
    }
    //metodo para hora
    class hora implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent ae) {
            Calendar now = Calendar.getInstance();
           txtHora.setText(String.format("   " + "%1$tH:%1$tM:%1$tS", now));
        }
    }
    
    //metodo para colocar o nome do usuario logado na labe da tela menu
    public void Usuario(Pessoa usuario){
        this.usuarioLogado = usuario;
        txtNomeUsuario.setText(usuario.getNome());
        txIdUsuario.setText(usuario.getId().toString());
       txIdUsuario.setVisible(false);
    }   
    
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSlider jSlider1;
    public javax.swing.JLabel txIdUsuario;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
