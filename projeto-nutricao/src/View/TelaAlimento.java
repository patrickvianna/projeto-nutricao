/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AlimentoCtrl;
import Controller.NutrientesCtrl;
import DAO.AlimentoDAOJDBC;
import DAO.NutrienteDAOJDBC;
import Model.Alimento;
import Model.Nutriente;
import Model.Pessoa;
import Model.SelecionarAlimentos;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaAlimento extends javax.swing.JInternalFrame {

    public TelaMontarRefeicao telaRefeicao;
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public TelaAlimento(final javax.swing.JDesktopPane jDesktopPane1, Long idUsuarioLogado) {
        initComponents();
        
        txIdUsuario.setVisible(false);
        txIdUsuario.setText(idUsuarioLogado.toString());
        DefaultTableModel modelo = (DefaultTableModel) jAlimentos.getModel();
        jAlimentos.setRowSorter(new TableRowSorter(modelo));
        
        readJTableAlimento();
        
         telaRefeicao = new TelaMontarRefeicao();
         jDesktopPane1.add(telaRefeicao);
    }
    // </editor-fold> 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jAlimentos = new javax.swing.JTable();
        txIdUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNutrientes = new javax.swing.JTable();
        selecionaAlimentosBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alimentos");
        setPreferredSize(new java.awt.Dimension(800, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 760));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Alimentos :");

        jAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrição", "Tipo", "Quantidade", "Selecionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jAlimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAlimentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jAlimentos);
        if (jAlimentos.getColumnModel().getColumnCount() > 0) {
            jAlimentos.getColumnModel().getColumn(0).setMinWidth(0);
            jAlimentos.getColumnModel().getColumn(0).setPreferredWidth(0);
            jAlimentos.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        txIdUsuario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txIdUsuario.setText("Nutrientes :");

        jTableNutrientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNutrientes);

        selecionaAlimentosBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        selecionaAlimentosBtn.setForeground(new java.awt.Color(0, 102, 204));
        selecionaAlimentosBtn.setText("Montar Refeição");
        selecionaAlimentosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaAlimentosBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txIdUsuario)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(selecionaAlimentosBtn)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionaAlimentosBtn)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txIdUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// <editor-fold defaultstate="collapsed" desc="getAlimentos">
    private void jAlimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAlimentosMouseClicked
        try{
            int k = jAlimentos.getSelectedRow();
            Long idAlimento = Long.parseLong(jAlimentos.getValueAt(k, 0).toString());
            
            readJTableNutriente(idAlimento);
        }catch(Exception e)
        {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    public void readJTableAlimento(){
       DefaultTableModel modelo = (DefaultTableModel) jAlimentos.getModel();
        
       AlimentoCtrl controllerAlimento = new AlimentoCtrl();
       controllerAlimento.preencherTabelaAlimento(modelo);
        
    }
// </editor-fold> 
// <editor-fold defaultstate="collapsed" desc="getNutrientes">
        //Colocar os dados do nutriente na tabelaNutriente
        public void readJTableNutriente(Long idAlimento){
            try{
                DefaultTableModel modelo1 = (DefaultTableModel) jTableNutrientes.getModel();
                NutrientesCtrl controllerNutriente = new NutrientesCtrl();
                controllerNutriente.preencherTabelaNutrientes(modelo1, idAlimento);
            }catch(Exception ex)
            {
                System.out.println("MENSAGEM DE ERRO" + ex.getMessage());
            }
    }//GEN-LAST:event_jAlimentosMouseClicked
// </editor-fold>        
// <editor-fold defaultstate="collapsed" desc="selecionarAlimentos">     
    private void selecionaAlimentosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaAlimentosBtnActionPerformed
        /*
            *Se o campo quantidade for diferente de nulo e a linha estiver selecionada, 
            *pegue a quantidade para fazer os calculos
        */       
        
        ArrayList<SelecionarAlimentos> listSa = new ArrayList<SelecionarAlimentos>();
        for(int i =0; i< jAlimentos.getRowCount(); i++)
        {
            if(jAlimentos.getValueAt(i, 4) != null && jAlimentos.getValueAt(i, 5).toString() == "true")
            {
                SelecionarAlimentos sa = new SelecionarAlimentos();
                sa.setAlimentoQtd(
                        Long.parseLong(jAlimentos.getValueAt(i, 0).toString()), 
                        Float.parseFloat(jAlimentos.getValueAt(i, 4).toString())
                );
                listSa.add(sa);
            }
        }                
        // PASSA UMA LIST COM O ID E QTD DO ALIMENTO
        telaRefeicao.initMontarRefeicao(listSa, Long.parseLong(txIdUsuario.getText()));
        telaRefeicao.show();                
        this.dispose(); 
        
    }//GEN-LAST:event_selecionaAlimentosBtnActionPerformed
// </editor-fold> 
    
    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0,0);
    }//GEN-LAST:event_formComponentMoved

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jAlimentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableNutrientes;
    public javax.swing.JButton selecionaAlimentosBtn;
    private javax.swing.JLabel txIdUsuario;
    // End of variables declaration//GEN-END:variables
}
