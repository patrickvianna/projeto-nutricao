package View;

import Controller.AlimentoCtrl;
import Controller.RefeicaoCtrl;
import DAO.AlimentoDAOJDBC;
import DAO.RefeicaoDAOJDBC;
import Model.Alimento;
import Model.Nutriente;
import Model.Refeicao;
import Model.SelecionarAlimentos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaHistorioRefeicao extends javax.swing.JInternalFrame {

    public TelaHistorioRefeicao(Long idUsuario) {
        initComponents();
        RefeicaoCtrl rf = new RefeicaoCtrl();
        ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();
        
        txIdUsuario.setVisible(false);
        txIdUsuario.setText(idUsuario.toString());
        
        refeicoes = rf.obterRefeicoes(idUsuario);
        preencherTableRefeicoes(refeicoes);
    }
    
    public void preencherTableRefeicoes(ArrayList<Refeicao> refeicoes)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabRefeicao.getModel();
        
        for(Refeicao r: refeicoes){                        
             modelo.addRow(new Object[]{
                r.getId(),
                r.getNome(),
                r.getPreco()
            });
        }
    }
    
    public void preencherTableAlimentos(Long idRefeicao)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabAlimento.getModel();
        AlimentoCtrl al = new AlimentoCtrl();
        RefeicaoCtrl rf = new RefeicaoCtrl();
        ArrayList<SelecionarAlimentos> sa = new ArrayList<SelecionarAlimentos>();
        
        while (modelo.getRowCount() > 0) // se a tabela tinha alguma linha , essa linha é removida antes de criar novas linhas
                     modelo.removeRow(0);
        
        sa =  rf.obterAlimentosRefeicao(idRefeicao);
        
        for(SelecionarAlimentos a: sa){            
            Alimento alimento = al.preencherTabelaAlimento(a.getIdAlimento());
             modelo.addRow(new Object[]{
                alimento.getId(),
                alimento.getNome(),
                alimento.getDescricao(),
                alimento.getTipo(),
                a.getQtd()
            });
        }
         
        preencherTableNutrientes(sa);
         
    }
    
    public void preencherTableNutrientes(ArrayList<SelecionarAlimentos> sa)
    {
        RefeicaoCtrl rf =  new RefeicaoCtrl();
        ArrayList<Nutriente> nutrientes = new ArrayList<>();
        //OBTEM OS NUTRIENTES DESSES ALIMENTOS, JÁ CALCULADOS    
        nutrientes = rf.calculoNutrientes(sa);
        
        DefaultTableModel modelo = (DefaultTableModel) tabNutrientes.getModel();
        
        while (modelo.getRowCount() > 0) // se a tabela tinha alguma linha , essa linha é removida antes de criar novas linhas
                     modelo.removeRow(0);
        
        for(Nutriente n: nutrientes)
        {
            modelo.addRow(new Object[]{
                n.getTipo(),
                n.getQuantidade()
            });
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabRefeicao = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlimento = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabNutrientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        txIdUsuario = new javax.swing.JLabel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(80, 33));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabRefeicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "PRECO", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRefeicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabRefeicaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabRefeicao);
        if (tabRefeicao.getColumnModel().getColumnCount() > 0) {
            tabRefeicao.getColumnModel().getColumn(0).setMinWidth(0);
            tabRefeicao.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabRefeicao.getColumnModel().getColumn(0).setMaxWidth(0);
            tabRefeicao.getColumnModel().getColumn(3).setMaxWidth(35);
        }

        tabAlimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrição", "Tipo", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabAlimento);
        if (tabAlimento.getColumnModel().getColumnCount() > 0) {
            tabAlimento.getColumnModel().getColumn(0).setMinWidth(0);
            tabAlimento.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabAlimento.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        tabNutrientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade"
            }
        ));
        jScrollPane3.setViewportView(tabNutrientes);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Refeições:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Lista de Alimentos:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Lista de Nutrientes:");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(184, 184, 184)
                        .addComponent(txIdUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txIdUsuario))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabRefeicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabRefeicaoMouseClicked
        try{
            int k = tabRefeicao.getSelectedRow();
            Long idRefeicao = Long.parseLong(tabRefeicao.getValueAt(k, 0).toString());
            
            preencherTableAlimentos(idRefeicao);
        }catch(Exception e)
        {
            System.out.println("ERRO: 10" + e.getMessage());
        }
    }//GEN-LAST:event_tabRefeicaoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        RefeicaoCtrl rf = new RefeicaoCtrl();
        ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();
        Boolean resultado = null;
        DefaultTableModel modelo = (DefaultTableModel) tabRefeicao.getModel();
        
        try{
            for(int i =0; i< tabRefeicao.getRowCount(); i++)
            {
                if(tabRefeicao.getValueAt(i, 3).toString() == "true")
                {
                   resultado = rf.excluirRefeicao(Long.parseLong(tabRefeicao.getValueAt(i, 0).toString() ));
                   
                   if(resultado){
                    JOptionPane.showMessageDialog(null,"Refeição excluida com sucesso!\n\n");
                    //this.dispose();
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Refeição não foi Excluida!\n\n");
                    }
                   break;
                }
            }
        }catch(Exception e)
        {
            System.out.println("ERRO : 30"  +e.getMessage());
        }
        
        while (modelo.getRowCount() > 0) // se a tabela tinha alguma linha , essa linha é removida antes de criar novas linhas
                     modelo.removeRow(0);
        refeicoes = rf.obterRefeicoes(Long.parseLong(txIdUsuario.getText().toString()));
        preencherTableRefeicoes(refeicoes);
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabAlimento;
    private javax.swing.JTable tabNutrientes;
    private javax.swing.JTable tabRefeicao;
    private javax.swing.JLabel txIdUsuario;
    // End of variables declaration//GEN-END:variables
}
