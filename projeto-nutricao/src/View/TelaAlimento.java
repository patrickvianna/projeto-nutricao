/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.AlimentoDAOJDBC;
import DAO.NutrienteDAOJDBC;
import Model.Alimento;
import Model.Nutriente;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Humberto
 */
public class TelaAlimento extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAlimento
     */
    public TelaAlimento() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jAlimentos.getModel();
        jAlimentos.setRowSorter(new TableRowSorter(modelo));
        
        readJTableAlimento();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jAlimentos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNutrientes = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1024, 760));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 760));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Alimentos :");

        jAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Tipo", "Quantidade", "Selecionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Nutrientes :");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAlimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAlimentosMouseClicked

        int k = jAlimentos.getSelectedRow();
        String nome = (String) jAlimentos.getValueAt(k, 0);

        readJTableNutriente(nome);

        }
    public void readJTableAlimento(){
        DefaultTableModel modelo = (DefaultTableModel) jAlimentos.getModel();
        
        AlimentoDAOJDBC alimentoDao = new AlimentoDAOJDBC();
        
        for(Alimento a: alimentoDao.consultar()){            
            modelo.addRow(new Object[]{
                //a.getId(),
                a.getNome(),
                a.getDescricao(),
                a.getTipo()
            });
        }
        //dnmvnv,dsn,fnzsnf,a.dmgasdmglm,ms,.d
    }

        //Colocar os dados do nutriente na tabelaNutriente
        public void readJTableNutriente(String nome){

            DefaultTableModel modelo1 = (DefaultTableModel) jTableNutrientes.getModel();

            NutrienteDAOJDBC nutrienteDao = new NutrienteDAOJDBC();
            AlimentoDAOJDBC alimentoDao = new AlimentoDAOJDBC();

            while (modelo1.getRowCount() > 0) // se a tabela tinha alguma linha , essa linha é removida antes de criar novas linhas
                 modelo1.removeRow(0);

            for(Nutriente a: nutrienteDao.consultar(alimentoDao.buscarAlimentoNome(nome))){
                modelo1.addRow(new Object[]{
                    //a.getId(),
                    a.getTipo(),
                    a.getQuantidade(),
                    //a.getTipo()
                });
            }

    }//GEN-LAST:event_jAlimentosMouseClicked

        //fnkdjklgjldjlçglçdng

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jAlimentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableNutrientes;
    // End of variables declaration//GEN-END:variables
}
