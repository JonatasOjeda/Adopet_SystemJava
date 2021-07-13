/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;
import java.sql.*;
import Dal.ModuloConexao;
import javax.swing.JOptionPane;

public class UICRUD extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public UICRUD() {
        initComponents();
      conexao = ModuloConexao.conector();
    }

    private void consultar() {
        String sql = "select *from tbclientes where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                
                txtEmail.setText(rs.getString(2));
                txtUsuNome.setText(rs.getString(3));
                txtUsuPass.setText(rs.getString(4));
                cmbSexo.setSelectedItem(rs.getString(5));
                txtRG.setText(rs.getString(6));
               
   

            } else {
                //As linhas abaixo Limpa Os Campo de Texto
                txtEmail.setText(null);
                txtUsuNome.setText(null);
                txtUsuPass.setText(null);
                txtRG.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      private void alterar() {
        String sql = "update tbclientes set emailuser=?, nomeuser=?, senhauser=?, sexouser=?, RGuser=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtEmail.getText());
            pst.setString(2, txtUsuNome.getText());           
            pst.setString(3, txtUsuPass.getText());
            pst.setString(4, cmbSexo.getSelectedItem().toString());
            pst.setString(5, txtRG.getText());
            pst.setString(6, txtUsuId.getText());
            

            if ((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuPass.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                //A Estrutura abaixo é usada para confirmar a alteração
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    txtEmail.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuPass.setText(null);
                    txtRG.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


//Método para Adicionar Usuarios no Banco de Dados
    private void adicionar() {
        String sql = "insert into tbclientes(iduser,emailuser, nomeuser, senhauser, sexouser, RGuser) values (?,?,?,?,?,?)";
        try {
            //Preenchendo a tabela no Banco de dados
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, txtUsuNome.getText());           
            pst.setString(4, txtUsuPass.getText());
            pst.setString(5, cmbSexo.getSelectedItem().toString());
            pst.setString(6, txtRG.getText());

            // Validação dos Campos Obigatorios
            if ((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtEmail.getText().isEmpty()) || (txtUsuPass.getText().isEmpty()) || (txtRG.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    txtEmail.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuPass.setText(null);
                    txtRG.setText(null);
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
    private void remover() {
        // A Estrutura abaixo confirma a remoção do usuario
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover este Usuario?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbclientes where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsuId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    txtEmail.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuPass.setText(null);
                    txtRG.setText(null);
   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    private void consultar1() {
        String sql = "select *from tbclientes1 where iduser1=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {               
                txtCpf.setText(rs.getString(2));
                txtCep.setText(rs.getString(3));
                txtCidade.setText(rs.getString(4));
                txtData.setText(rs.getString(5));
               
   

            } else {
                JOptionPane.showMessageDialog(null, "Usuario Não Cadastrado.");
                //As linhas abaixo Limpa Os Campo de Texto
                    txtCpf.setText(null);
                    txtCep.setText(null);
                    txtData.setText(null);
                    txtCidade.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      private void alterar1() {
        String sql = "update tbclientes1 set Cpfuser=?, CEPuser=?, Cidadeuser=?, data_nasc_user=? where iduser1=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCpf.getText());
            pst.setString(2, txtCep.getText());           
            pst.setString(3, txtCidade.getText());
            pst.setString(4, txtData.getText());
            pst.setString(5, txtUsuId.getText());
            

            if ((txtCpf.getText().isEmpty()) || (txtCep.getText().isEmpty()) || (txtCidade.getText().isEmpty()) || (txtData.getText().isEmpty()) || (txtUsuId.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                //A Estrutura abaixo é usada para confirmar a alteração
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Usuario alterado com Sucesso.");
                    txtUsuId.setText(null);
                    txtCpf.setText(null);
                    txtCep.setText(null);
                    txtData.setText(null);
                    txtCidade.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


//Método para Adicionar Usuarios no Banco de Dados
    private void adicionar1() {
        String sql = "insert into tbclientes1(iduser1,Cpfuser, CEPuser, Cidadeuser, data_nasc_user) values (?,?,?,?,?)";
        try {
            //Preenchendo a tabela no Banco de dados
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtCpf.getText());
            pst.setString(3, txtCep.getText());
            pst.setString(4, txtCidade.getText());           
            pst.setString(5, txtData.getText());

            // Validação dos Campos Obigatorios
            if ((txtCep.getText().isEmpty()) || (txtCpf.getText().isEmpty()) || (txtCidade.getText().isEmpty()) || (txtData.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos Obrigatorios.");
            } else {
                // A Linha abaixo é usada para Confirmar a inserção Dos dados na tabela e atualizar 
                int adicionado = pst.executeUpdate();
                // A linha SOUT abaixo serve para entender a logica 
                //System.out.println(adicionado);           
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario adicionado com Sucesso.");
                    txtUsuId.setText(null);
                    txtCpf.setText(null);
                    txtCep.setText(null);
                    txtData.setText(null);
                    txtCidade.setText(null);
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
            String sql = "delete from tbclientes1 where iduser1=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsuId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Removido Com Sucesso.");
                    txtUsuId.setText(null);
                    txtCpf.setText(null);
                    txtCep.setText(null);
                    txtData.setText(null);
                    txtCidade.setText(null);
   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox();
        Consultar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Adicionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsuPass = new javax.swing.JTextField();
        txtUsuId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, 20));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Senha");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Sexo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 10));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Data");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("ID");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 20, 10));

        txtUsuNome.setBackground(new java.awt.Color(199, 208, 216));
        txtUsuNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuNome.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuNome.setToolTipText("");
        txtUsuNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, 30));

        txtCep.setBackground(new java.awt.Color(199, 208, 216));
        txtCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCep.setForeground(new java.awt.Color(0, 0, 0));
        txtCep.setToolTipText("");
        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCep.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        jPanel1.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 130, 30));

        txtEmail.setBackground(new java.awt.Color(199, 208, 216));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setToolTipText("");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 300, 30));

        txtRG.setBackground(new java.awt.Color(199, 208, 216));
        txtRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRG.setForeground(new java.awt.Color(0, 0, 0));
        txtRG.setToolTipText("");
        txtRG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRG.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRGActionPerformed(evt);
            }
        });
        jPanel1.add(txtRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 130, 30));

        cmbSexo.setBackground(new java.awt.Color(199, 208, 216));
        cmbSexo.setForeground(new java.awt.Color(0, 0, 0));
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino", "Prefiro Não Dizer" }));
        cmbSexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 120, -1));

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

        txtUsuPass.setBackground(new java.awt.Color(199, 208, 216));
        txtUsuPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuPass.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuPass.setToolTipText("");
        txtUsuPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuPassActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, 30));

        txtUsuId.setBackground(new java.awt.Color(199, 208, 216));
        txtUsuId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuId.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuId.setToolTipText("");
        txtUsuId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 40, 20));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cidade");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 40, 10));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("RG");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        txtCidade.setBackground(new java.awt.Color(199, 208, 216));
        txtCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(0, 0, 0));
        txtCidade.setToolTipText("");
        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 130, 30));

        txtData.setBackground(new java.awt.Color(199, 208, 216));
        txtData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtData.setForeground(new java.awt.Color(0, 0, 0));
        txtData.setToolTipText("");
        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 130, 30));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("CEP");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        txtCpf.setBackground(new java.awt.Color(199, 208, 216));
        txtCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCpf.setForeground(new java.awt.Color(0, 0, 0));
        txtCpf.setToolTipText("");
        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 130, 30));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("CPF");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Fundo1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 580));

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

    private void txtUsuNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuNomeActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRGActionPerformed

    private void txtUsuPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuPassActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
       adicionar();
       adicionar1();
    }//GEN-LAST:event_AdicionarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
       consultar();
       consultar1();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
       alterar();
       alterar1();
    }//GEN-LAST:event_alterarActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
       remover();
       remover1();
    }//GEN-LAST:event_RemoverActionPerformed

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSexoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        UIMenu voltar = new UIMenu();
        voltar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtUsuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuIdActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

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
            java.util.logging.Logger.getLogger(UICRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Remover;
    private javax.swing.JButton alterar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuPass;
    // End of variables declaration//GEN-END:variables
}
