/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import dao.DaoUtilizador;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Utilizador;

/**
 *
 * @author jbila
 */
public class FrmUtilizador extends javax.swing.JFrame {

    private final DaoUtilizador daoUtilizador;

    /**
     * Creates new form FrmCliente
     */
    public FrmUtilizador() {
        initComponents();
        daoUtilizador = new DaoUtilizador();
        preencherTabela();
        fillPerfil();
        fillStatus();
         btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox<>();
        cboStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 70, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTO DE UTILIZADOR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, 40));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel3.setText("Status");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 50, 30));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 20));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 290, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 320, 30));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 320, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 320, 30));

        btnSave.setBackground(new java.awt.Color(0, 0, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(80, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "Perfil", "Status"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 790, 280));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel5.setText("ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 50, 30));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 25));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setActionCommand("");
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel6.setText("Nome");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, 50, 30));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel7.setText("Perfil");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 50, 30));

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAIXA", "ADMIN", "NORMAL" }));
        jPanel1.add(cboPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 290, 30));

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jPanel1.add(cboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        Utilizador utilizador = new Utilizador();
        utilizador.setNome(txtNome.getText());
        utilizador.setEmail(txtEmail.getText());
        utilizador.setPassword(txtPassword.getText());
        utilizador.setPerfil(cboPerfil.getSelectedItem().toString());
        utilizador.setStatus(cboStatus.getSelectedItem().toString());

        try {

            if (!txtPassword.getText().isEmpty() && !txtEmail.getText().isEmpty()) {
                daoUtilizador.save(utilizador);
                limpar();
                preencherTabela();
                actionButton();
            } else {
                JOptionPane.showMessageDialog(btnSave, "Preencha os campos");
            }

        } catch (HeadlessException ex) {
            // TODO Auto-generated catch block

        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        selection();
    }//GEN-LAST:event_tableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!txtId.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            Utilizador utilizador = new Utilizador();
            utilizador.setNome(txtNome.getText());
            utilizador.setEmail(txtEmail.getText());
            utilizador.setPassword(txtPassword.getText());
            utilizador.setPerfil(cboPerfil.getSelectedItem().toString());
            utilizador.setStatus(cboStatus.getSelectedItem().toString());
            utilizador.setId(Integer.parseInt(txtId.getText()));

            daoUtilizador.update(utilizador); // TODO Auto-generated catch block
            preencherTabela();
            actionButton();
            limpar();
        } else {
            JOptionPane.showMessageDialog(btnUpdate, "Selecione a linha na Tabela");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmUtilizador frame = new FrmUtilizador();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

            }
        });
    }

    /*FOR DEVELOPER*/
    private void delete() {
        if (!txtId.getText().isEmpty()) {
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                daoUtilizador.delete(Integer.parseInt(txtId.getText()));
                preencherTabela();
                limpar();
                actionButton();
            } else {

                JOptionPane.showMessageDialog(table, "Selecione a linha na tabela");
            }

        }

    }
    //END OF DELETE

    /*---------limpar campos----------*/
    private void limpar() {
        txtNome.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
        txtId.setText("");

    }

    private void actionButton() {
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    // preecher tabela
    private void preencherTabela() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[5];
        model.setRowCount(0);// limpar a tabela
        List<Utilizador> u = daoUtilizador.findAll();
        for (int i = 0; i < u.size(); i++) {
            row[0] = u.get(i).getId();
            row[1] = u.get(i).getNome();
            row[2] = u.get(i).getEmail();
            row[3] = u.get(i).getPerfil();
            row[4] = u.get(i).getStatus();
            model.addRow(row);
        }

    }

    private void fillStatus() {

    }

    private void fillPerfil() {
    }

    private void selection() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                Object id = table.getValueAt(selectedRow, 0);
                Object nome = table.getValueAt(selectedRow, 1);
                Object email = table.getValueAt(selectedRow, 2);
                Object perfil = table.getValueAt(selectedRow, 3);
                Object status = table.getValueAt(selectedRow, 4);

                txtId.setText(id.toString());
                txtNome.setText(nome.toString());
                txtEmail.setText(email.toString());
                cboPerfil.addItem(perfil.toString());
                cboStatus.addItem(status.toString());
         btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);

            }
        } catch (NullPointerException ex) {

        }

    }
    //END 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
