/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.JOptionPane;

    public class Login extends javax.swing.JFrame { 
    
    private static final Logger logger = Logger.getLogger(Login.class.getName());   
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);

        // 1. Setup Placeholders
        setupPlaceholders();

        // 2. Style Register button to be transparent
        styleTransparentButton(jButton2);

        // 3. Fix Layering for Absolute Layout
        if (jPanel3.getComponentCount() > 0) {
            jPanel3.setComponentZOrder(jLabel8, jPanel3.getComponentCount() - 1);
        }

        jPanel3.revalidate();
        jPanel3.repaint();
    }

    private void styleTransparentButton(javax.swing.JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn.setForeground(new java.awt.Color(84, 46, 20)); 
    }

    private void setupPlaceholders() {
        // Username Placeholder Logic
        Username.setText("Username");
        Username.setForeground(Color.GRAY);
        Username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Username.getText().equals("Username")) {
                    Username.setText("");
                    Username.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (Username.getText().isEmpty()) {
                    Username.setText("Username");
                    Username.setForeground(Color.GRAY);
                }
            }
        });

        // Password Placeholder Logic
        password.setEchoChar((char) 0); 
        password.setText("Chakra Key");
        password.setForeground(Color.GRAY);
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String pass = new String(password.getPassword());
                if (pass.equals("Chakra Key")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                    if (!showpass.isSelected()) {
                        password.setEchoChar('•');
                    }
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                String pass = new String(password.getPassword());
                if (pass.isEmpty()) {
                    password.setText("Chakra Key");
                    password.setForeground(Color.GRAY);
                    password.setEchoChar((char) 0);
                }
            }
        });
    }

    private void togglePassword() {
        String pass = new String(password.getPassword());
        if (showpass.isSelected()) {
            password.setEchoChar((char) 0);
        } else {
            // Only set echo char if it's not the placeholder
            if (!pass.equals("Chakra Key") && !pass.isEmpty()) {
                password.setEchoChar('•');
            } else {
                password.setEchoChar((char) 0);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showpass = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        Username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        accessportal = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, 20));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        Username.setText("Username");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel3.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 36));

        password.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        password.setText("jPasswordField1");
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, 200, 30));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setText("LOG IN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 56, 36));

        accessportal.setBackground(new java.awt.Color(153, 0, 0));
        accessportal.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        accessportal.setForeground(new java.awt.Color(255, 255, 255));
        accessportal.setLabel("ACCESS PORTAL");
        accessportal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessportalActionPerformed(evt);
            }
        });
        jPanel3.add(accessportal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 35));

        jButton2.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 14)); // NOI18N
        jLabel2.setText("Start your journey?");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 150, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/scroll s (8).png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 450, 260));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 240, 260));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel4.setText("SHINOBI ACCESS PORTAL");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 260, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/s1.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -10, 40, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/scroll p.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -20, 380, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 330, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/BACKGROUND LOGIN.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accessportalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessportalActionPerformed
       String typedUser = Username.getText().trim();
        String typedPass = new String(password.getPassword());
        
        if (typedUser.equals("Username") || typedPass.equals("Chakra Key") || typedUser.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The scroll is empty. Enter your credentials.");
            return;
        }

        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "The Shinobi registry is unreachable.");
                return;
            }

            // UPDATED: Check 'account_credentials' table instead of 'users'
            String sql = "SELECT username FROM account_credentials WHERE username = ? AND password = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, typedUser);
                pst.setString(2, typedPass);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Access Granted, Ninja!");
                        // Pass the username to the Dashboard if needed
                        new Dashboard(typedUser).setVisible(true);
                        this.dispose();
                    } else {
                        // Admin fallback
                        if (typedUser.equals("Admin") && typedPass.equals("1234")) {
                            JOptionPane.showMessageDialog(this, "Admin Access Granted!");
                            new Dashboard(typedUser).setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid credentials! Your jutsu is weak.", "Denied", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    }//GEN-LAST:event_accessportalActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
       togglePassword();
    }//GEN-LAST:event_showpassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Username;
    private javax.swing.JButton accessportal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showpass;
    // End of variables declaration//GEN-END:variables
}
