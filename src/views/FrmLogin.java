/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import dao.DaoUtilizador;
import model.Utilizador;

/**
 *
 * @author jbila
 */
public class FrmLogin extends javax.swing.JFrame {

    private final DaoUtilizador daoUtilizador;

    public FrmLogin() {
        initComponents();
        daoUtilizador = new DaoUtilizador();
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
        txtPassword = new javax.swing.JTextField();
        txtUsernme = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.default.borderColor"));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        jLabel2.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel2.setText("username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 3, 18)); // NOI18N
        jLabel3.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel3.setText("password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txtPassword.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        txtPassword.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 310, 40));

        txtUsernme.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        txtUsernme.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtUsernme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtUsernme, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 310, 40));

        btnLogin.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnLogin.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, 30));

        lblInfo.setFont(new java.awt.Font("Liberation Sans", 2, 15)); // NOI18N
        lblInfo.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        lblInfo.setText("info");
        jPanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsernme.getText();
        String password = txtPassword.getText();
        if (!username.isEmpty() && !password.isEmpty()) {
            Utilizador utilizador = daoUtilizador.findByUserName(username);
            if (utilizador != null) {

                if (utilizador.getPassword().equals(password)) {
                  callMenu();
                dispose();
                }
                else
                {
                    lblInfo.setText("Password Incorrento!");
                }
            }
            else
            {
                  lblInfo.setText("User Inexistente!");
            }
        }
        else
  lblInfo.setText("Preencha os campos");

    }//GEN-LAST:event_btnLoginActionPerformed

    private void callMenu() {
        FrmMenu frame = new FrmMenu();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
           FrmLogin frame=new FrmLogin();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsernme;
    // End of variables declaration//GEN-END:variables
}
