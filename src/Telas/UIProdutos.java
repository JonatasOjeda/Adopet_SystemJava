/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author manut
 */
public class UIProdutos extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public UIProdutos() {
        initComponents();
         conexao = ModuloConexao.conector();
    }
        private void consultar1() {
        String sql = "select *from produtos where idproduto=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtproId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {               
                txtFornecedor.setText(rs.getString(2));
                txtMarca.setText(rs.getString(3));
                txtNomepro.setText(rs.getString(4));
                txtPreço.setText(rs.getString(5));
                txtEmailFornecedor.setText(rs.getString(6));
                txtTellFornecedor.setText(rs.getString(7));
               
   

            } else {
                JOptionPane.showMessageDialog(null, "Produto Não Cadastrado.");
                //As linhas abaixo Limpa Os Campo de Texto
                    txtFornecedor.setText(null);
                    txtMarca.setText(null);
                     txtNomepro.setText(null);
                    txtPreço.setText(null);
                    txtEmailFornecedor.setText(null);
                    txtTellFornecedor.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      private void alterar1() {
        String sql = "update produtos set Fornecedor=?, Marca=?, Nome=?, Preço=?, EmailFornecedor=?,TelefoneFornecedor=? where idproduto=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtFornecedor.getText());
            pst.setString(2,  txtMarca.getText());           
            pst.setString(3, txtNomepro.getText());
            pst.setString(4, txtPreço.getText());
            pst.setString(5, txtEmailFornecedor.getText());
             pst.setString(6, txtTellFornecedor.getText());
             pst.setString(7, txtproId.getText());
            

            if ((txtFornecedor.getText().isEmpty()) || (txtMarca.getText().isEmpty()) || (txtNomepro.getText().isEmpty()) || (txtPreço.getText().isEmpty()) || (txtEmailFornecedor.getText().isEmpty()) || (txtTellFornecedor.getText().isEmpty())|| (txtproId.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                //A Estrutura abaixo é usada para confirmar a alteração
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Produto alterado com Sucesso.");
                    txtproId.setText(null);
                    txtFornecedor.setText(null);
                    txtMarca.setText(null);
                     txtNomepro.setText(null);
                    txtPreço.setText(null);
                    txtEmailFornecedor.setText(null);
                    txtTellFornecedor.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


//Método para Adicionar Usuarios no Banco de Dados
    private void adicionar1() {
        String sql = "insert into produtos(idproduto,Fornecedor,Marca,Nome,Preço,EmailFornecedor, TelefoneFornecedor) values (?,?,?,?,?,?,?)";
        try {
            //Preenchendo a tabela no Banco de dados           
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtproId.getText());
            pst.setString(2, txtFornecedor.getText());
            pst.setString(3,  txtMarca.getText());           
            pst.setString(4, txtNomepro.getText());
            pst.setString(5, txtPreço.getText());
            pst.setString(6, txtEmailFornecedor.getText());
            pst.setString(7, txtTellFornecedor.getText());

            // Validação dos Campos Obigatorios
            if ((txtFornecedor.getText().isEmpty()) || (txtMarca.getText().isEmpty()) || (txtNomepro.getText().isEmpty()) || (txtPreço.getText().isEmpty()) || (txtEmailFornecedor.getText().isEmpty()) || (txtTellFornecedor.getText().isEmpty())|| (txtproId.getText().isEmpty())){
                JOptionPane.showMessageDialog(
                        null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto adicionado com Sucesso.");

                }
            }
            // A Linha PST abaixo atualiza a tabela Usuarios com os Dados do Formulario.          
            //pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Criando o Metodo para Alterar os Dados do Usuario



    // Metodo Responsavel para Remover usuarios
    private void remover1() {
        // A Estrutura abaixo confirma a remoção do usuario
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Continuar ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from produtos where idproduto=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtproId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto Removido Com Sucesso.");
                          txtproId.setText(null);
                    txtFornecedor.setText(null);
                    txtMarca.setText(null);
                     txtNomepro.setText(null);
                    txtPreço.setText(null);
                    txtEmailFornecedor.setText(null);
                    txtTellFornecedor.setText(null);
   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        txtTellFornecedor = new javax.swing.JTextField();
        txtEmailFornecedor = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        Consultar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Adicionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNomepro = new javax.swing.JTextField();
        txtproId = new javax.swing.JTextField();
        txtPreço = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/TelaCrud.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/TelaCrud.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fornecedor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 20));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nome");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Marca");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 10));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("ID");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 20, 10));

        txtFornecedor.setBackground(new java.awt.Color(199, 208, 216));
        txtFornecedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFornecedor.setForeground(new java.awt.Color(0, 0, 0));
        txtFornecedor.setToolTipText("");
        txtFornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 220, 30));

        txtTellFornecedor.setBackground(new java.awt.Color(199, 208, 216));
        txtTellFornecedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTellFornecedor.setForeground(new java.awt.Color(0, 0, 0));
        txtTellFornecedor.setToolTipText("");
        txtTellFornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTellFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTellFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTellFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtTellFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 130, 30));

        txtEmailFornecedor.setBackground(new java.awt.Color(199, 208, 216));
        txtEmailFornecedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmailFornecedor.setForeground(new java.awt.Color(0, 0, 0));
        txtEmailFornecedor.setToolTipText("");
        txtEmailFornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmailFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmailFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmailFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 300, 30));

        txtMarca.setBackground(new java.awt.Color(199, 208, 216));
        txtMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));
        txtMarca.setToolTipText("");
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 120, 30));

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 90, -1));

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        jPanel1.add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 80, -1));

        Remover.setText("Remover");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });
        jPanel1.add(Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Email");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        txtNomepro.setBackground(new java.awt.Color(199, 208, 216));
        txtNomepro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomepro.setForeground(new java.awt.Color(0, 0, 0));
        txtNomepro.setToolTipText("");
        txtNomepro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNomepro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNomepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeproActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 30));

        txtproId.setBackground(new java.awt.Color(199, 208, 216));
        txtproId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtproId.setForeground(new java.awt.Color(0, 0, 0));
        txtproId.setToolTipText("");
        txtproId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtproId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtproId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtproId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 40, 20));

        txtPreço.setBackground(new java.awt.Color(199, 208, 216));
        txtPreço.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPreço.setForeground(new java.awt.Color(0, 0, 0));
        txtPreço.setToolTipText("");
        txtPreço.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPreço.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPreço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreçoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPreço, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 120, 30));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Preço");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 240, 40, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Telefone");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 50, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Fundo1.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 580));

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(420, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFornecedorActionPerformed

    private void txtTellFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTellFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTellFornecedorActionPerformed

    private void txtEmailFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailFornecedorActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
      
        consultar1();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
    
        alterar1();
    }//GEN-LAST:event_alterarActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed

        remover1();
    }//GEN-LAST:event_RemoverActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
    
        adicionar1();
    }//GEN-LAST:event_AdicionarActionPerformed

    private void txtNomeproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeproActionPerformed

    private void txtproIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproIdActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        UIMenu voltar = new UIMenu();
        voltar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtPreçoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreçoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreçoActionPerformed

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
            java.util.logging.Logger.getLogger(UIProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Remover;
    private javax.swing.JButton alterar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmailFornecedor;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNomepro;
    private javax.swing.JTextField txtPreço;
    private javax.swing.JTextField txtTellFornecedor;
    private javax.swing.JTextField txtproId;
    // End of variables declaration//GEN-END:variables
}
