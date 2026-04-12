/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

    import java.awt.Color;
    import java.awt.event.FocusEvent;
    import java.awt.event.FocusListener;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);

        // 1. Setup Placeholders for Clan ID and Chakra Key
        setupPlaceholders();

        // 2. Style buttons to be transparent "Ink" text
        styleTransparentButton(jButton2);
        
        // 3. Fix the Layering (Z-Order)
        // This keeps the scroll (jLabel8) in the background
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
        btn.setForeground(new java.awt.Color(84, 46, 20)); // Deep brown "Ink"
    }
    
        private void setupPlaceholders() {
        // --- Clan ID Logic ---
        jTextField1.setText("Clan ID");
        jTextField1.setForeground(Color.GRAY);
        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField1.getText().equals("Clan ID")) {
                    jTextField1.setText("");
                    jTextField1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField1.getText().isEmpty()) {
                    jTextField1.setText("Clan ID");
                    jTextField1.setForeground(Color.GRAY);
                }
            }
        });
        
    // --- Chakra Key Logic ---
        jPasswordField1.setEchoChar((char) 0); // Show text initially
        jPasswordField1.setText("Chakra Key");
        jPasswordField1.setForeground(Color.GRAY);
        jPasswordField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String pass = new String(jPasswordField1.getPassword());
                if (pass.equals("Chakra Key")) {
                    jPasswordField1.setText("");
                    jPasswordField1.setForeground(Color.BLACK);
                    if (!jCheckBox2.isSelected()) jPasswordField1.setEchoChar('•');
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                String pass = new String(jPasswordField1.getPassword());
                if (pass.isEmpty()) {
                    jPasswordField1.setText("Chakra Key");
                    jPasswordField1.setForeground(Color.GRAY);
                    jPasswordField1.setEchoChar((char) 0);
                }
            }
        });
    }

    private void togglePassword() {
        String pass = new String(jPasswordField1.getPassword());
        if (jCheckBox2.isSelected()) {
            jPasswordField1.setEchoChar((char) 0); 
        } else {
            // Mask only if it's NOT the placeholder
            if (!pass.equals("Chakra Key") && !pass.isEmpty()) {
                jPasswordField1.setEchoChar('•');
            } else {
                jPasswordField1.setEchoChar((char) 0);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, 20));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jTextField1.setText("Clan ID");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 36));

        jPasswordField1.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jPasswordField1.setText("jPasswordField1");
        jPanel3.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, 200, 30));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setText("LOG IN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 56, 36));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setLabel("ACCESS PORTAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 35));

        jButton2.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jButton2.setText("Not Registered?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 130, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String user = jTextField1.getText();
        String pass = new String(jPasswordField1.getPassword());
        if (user.equals("Admin") && pass.equals("1234")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Success!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
       togglePassword();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 1. Create an instance of your Register frame
    Register registerPage = new Register(); 
    
    // 2. Make the Register window appear
    registerPage.setVisible(true);
    
    // 3. Close the current Login window
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
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
