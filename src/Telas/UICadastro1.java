package Telas;

import Dal.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class UICadastro1 extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UICadastro1() {
        initComponents();
        conexao = ModuloConexao.conector();

    }

    private void Adicionar() {
 String sql = "insert into tbclientes(emailuser, nomeuser, senhauser, sexouser, RGuser) values (?,?,?,?,?)";
  
    try {
        pst=conexao.prepareStatement(sql);
       
            pst.setString(1, txtEmail.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtSenha.getText());
            pst.setString(4, cmbSexo.getSelectedItem().toString());
            pst.setString(5, txtRG.getText());
            
            if (txtEmail.getText().isEmpty() || txtNome.getText().isEmpty() || txtSenha.getText().isEmpty() || txtRG.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Preencha todos os *Campos Obrigatorios");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    
                    txtEmail.setText(null);
                    txtNome.setText(null);
                    txtSenha.setText(null);
                    cmbSexo.setSelectedItem(null);
                    txtRG.setText(null);
        UICadastro2 entrar = new UICadastro2();
        entrar.setVisible(true);
        this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtRG = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cmbSexo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRG.setBackground(new java.awt.Color(199, 208, 216));
        txtRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRG.setForeground(new java.awt.Color(0, 0, 0));
        txtRG.setToolTipText("");
        txtRG.setBorder(null);
        txtRG.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRGActionPerformed(evt);
            }
        });
        jPanel1.add(txtRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 220, 30));

        txtEmail.setBackground(new java.awt.Color(199, 208, 216));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setToolTipText("");
        txtEmail.setBorder(null);
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 220, 30));

        txtNome.setBackground(new java.awt.Color(199, 208, 216));
        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.setToolTipText("");
        txtNome.setBorder(null);
        txtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 220, 30));

        txtSenha.setBackground(new java.awt.Color(199, 208, 216));
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtSenha.setBorder(null);
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 220, 30));

        cmbSexo.setBackground(new java.awt.Color(199, 208, 216));
        cmbSexo.setForeground(new java.awt.Color(0, 0, 0));
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino", "Prefiro Não Dizer" }));
        cmbSexo.setBorder(null);
        jPanel1.add(cmbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 220, 30));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("*Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("*RG");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 30, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*Campos Obrigatorios");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*Nome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("*Senha");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("*Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tela - Cadastro (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        btnConfirmar.setText("jButton1");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 372, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(420, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Adicionar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRGActionPerformed

    }//GEN-LAST:event_txtRGActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(UICadastro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICadastro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICadastro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICadastro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICadastro1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRG;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
