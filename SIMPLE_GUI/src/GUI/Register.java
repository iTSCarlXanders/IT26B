/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class Register extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Register.class.getName());

    public Register() {
        initComponents();
        this.setLocationRelativeTo(null); 

        // 1. Clean up Checkbox appearance
        jCheckBox1.setOpaque(false);
        jCheckBox1.setText(""); 
        jCheckBox2.setOpaque(false);
        jCheckBox2.setText("");

        // 2. Setup Placeholders
        setupField(username, "Shinobi Name: (Username)");
        setupField(clan, "Clan Lineage:");
        setupField(Rank, "Rank:");
        setupField(Origin, "Village Origin");
        setupField(password, "Chakra Key: (Password)");
        setupField(confirmpass, "Confirm Password:");

        // 3. Force checkboxes to the very front for Absolute Layout
        jPanel2.setComponentZOrder(jCheckBox1, 0);
        jPanel2.setComponentZOrder(jCheckBox2, 0);

        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void setupField(JTextField field, String hint) {
        field.setText(hint);
        field.setForeground(new Color(153, 153, 153));
        
        if (field instanceof JPasswordField jPasswordField) {
            jPasswordField.setEchoChar((char) 0);
        }
        
        setPlaceholder(field, hint);
    }

    private void setPlaceholder(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(new Color(46, 26, 5)); // Ink Brown
                    if (textField instanceof JPasswordField jPasswordField) {
                        if (!(textField == password && jCheckBox1.isSelected()) && 
                            !(textField == confirmpass && jCheckBox2.isSelected())) {
                            jPasswordField.setEchoChar('•');
                        }
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(new Color(153, 153, 153)); 
                    textField.setText(placeholder);
                    if (textField instanceof JPasswordField) {
                        ((JPasswordField) textField).setEchoChar((char) 0);
                    }
                }
            }
        });
    }

    private void togglePassword(JPasswordField field, javax.swing.JCheckBox check, String hint) {
        String currentText = field.getText();
        if (check.isSelected()) {
            field.setEchoChar((char) 0);
        } else {
            if (currentText.equals(hint) || currentText.isEmpty()) {
                field.setEchoChar((char) 0);
            } else {
                field.setEchoChar('•');
            }
        }
        field.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        username = new javax.swing.JTextField();
        clan = new javax.swing.JTextField();
        Rank = new javax.swing.JTextField();
        Origin = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirmpass = new javax.swing.JPasswordField();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));
        jCheckBox2.getAccessibleContext().setAccessibleParent(jCheckBox1);

        username.setBackground(new java.awt.Color(204, 204, 204));
        username.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        username.setText("Shinobi Name: (Username)");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 198, 34));

        clan.setBackground(new java.awt.Color(204, 204, 204));
        clan.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        clan.setText("Clan Lineage:");
        clan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clanActionPerformed(evt);
            }
        });
        jPanel2.add(clan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 198, 34));

        Rank.setBackground(new java.awt.Color(204, 204, 204));
        Rank.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        Rank.setText("Rank:");
        Rank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankActionPerformed(evt);
            }
        });
        jPanel2.add(Rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 200, 34));

        Origin.setBackground(new java.awt.Color(204, 204, 204));
        Origin.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        Origin.setText("Village Origin");
        Origin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OriginActionPerformed(evt);
            }
        });
        jPanel2.add(Origin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 198, 37));

        signup.setBackground(new java.awt.Color(51, 51, 51));
        signup.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Shinobi Enrollment");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, -1));

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        password.setText("jPasswordField1");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 30));

        confirmpass.setBackground(new java.awt.Color(204, 204, 204));
        confirmpass.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        confirmpass.setText("jPasswordField2");
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 200, 30));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe Print", 1, 15)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/BSCROLL.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 420, 500));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 270, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/BG3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1010, 550));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 190, 80));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void clanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clanActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void RankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RankActionPerformed

    private void OriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OriginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
    // 1. DATA EXTRACTION
    String user = username.getText().trim();
    String cln = clan.getText().trim(); 
    String rankLevel = Rank.getText().trim(); 
    String village = Origin.getText().trim();
    String pass1 = new String(password.getPassword());
    String pass2 = new String(confirmpass.getPassword());

    // 2. VALIDATION LOGIC 
    if (user.isEmpty() || user.equals("Shinobi Name: (Username)") ||
        cln.isEmpty() || cln.equals("Clan Name") ||
        rankLevel.isEmpty() || rankLevel.equals("Rank:") || 
        village.isEmpty() || village.equals("Village Origin") ||
        pass1.isEmpty() || pass1.equals("Chakra Key: (Password)")) {
        
        JOptionPane.showMessageDialog(this, "All scrolls must be filled! ⚠️", "Incomplete Jutsu", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!pass1.equals(pass2)) {
        JOptionPane.showMessageDialog(this, "The Forbidden Seals do not match! ❌", "Chakra Mismatch", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3. DATABASE RECORDING
    try (Connection conn = Database.getConnection()) {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "The Village Gates are closed. (DB Connection Failed)");
            return;
        }

        // Check if user already exists
        String checkSql = "SELECT username FROM users WHERE username = ?";
        PreparedStatement checkPst = conn.prepareStatement(checkSql);
        checkPst.setString(1, user);
        if (checkPst.executeQuery().next()) {
            JOptionPane.showMessageDialog(this, "That name is already in the registry!");
            return;
        }

        // INSERT statement - Explicitly mapping each attribute to its own column
        // Make sure your SQL table order is: username, password, village, rank, clan
        String sql = "INSERT INTO users (username, password, village, rank, clan) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, user);      // Saved to 'username' column
        pst.setString(2, pass1);     // Saved to 'password' column
        pst.setString(3, village);   // Saved to 'village' column
        pst.setString(4, rankLevel); // Saved to 'rank' column
        pst.setString(5, cln);       // Saved to 'clan' column (The fix!)

        pst.executeUpdate();
        
        // 4. THE FINAL WELCOME MESSAGE (Only shows the Username as requested)
        JOptionPane.showMessageDialog(this, "Welcome, " + user + "!");

        // Move to Login
        new Login().setVisible(true);
        this.dispose();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
    }
    }//GEN-LAST:event_signupActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

         togglePassword(confirmpass, jCheckBox2, "Confirm Password:");
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       togglePassword(password, jCheckBox1, "Forbidden Seal: (Password)");
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Register().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Origin;
    private javax.swing.JTextField Rank;
    private javax.swing.JButton back;
    private javax.swing.JTextField clan;
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
