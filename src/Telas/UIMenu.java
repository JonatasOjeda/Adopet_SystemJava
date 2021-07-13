/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

/**
 *
 * @author manut
 */
public class UIMenu extends javax.swing.JFrame {

    /**
     * Creates new form UIMenu
     */
    public UIMenu() {
        initComponents();
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
        btnCRUD = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnOng = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnFavoritos = new javax.swing.JButton();
        Produtos = new javax.swing.JButton();
        btnDestaques = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Fundo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 600));

        btnCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDActionPerformed(evt);
            }
        });
        jPanel1.add(btnCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 50, 50));
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 50, 50));

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 50));
        jPanel1.add(btnOng, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 50, 50));
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 50, 50));
        jPanel1.add(btnFavoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 50, 50));

        Produtos.setText("jButton1");
        Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutosActionPerformed(evt);
            }
        });
        jPanel1.add(Produtos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 50, 50));
        jPanel1.add(btnDestaques, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 50, 50));

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

        setSize(new java.awt.Dimension(420, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDActionPerformed
        UICRUD entrar = new UICRUD();
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCRUDActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        UILogin entrar = new UILogin();
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutosActionPerformed
        UIProdutos entrar = new UIProdutos();
        entrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(UIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Produtos;
    private javax.swing.JButton btnCRUD;
    private javax.swing.JButton btnDestaques;
    private javax.swing.JButton btnFavoritos;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnOng;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}