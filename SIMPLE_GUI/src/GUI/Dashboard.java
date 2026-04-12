/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class Dashboard extends javax.swing.JFrame {

    private ArrayList<String[]> players = new ArrayList<>();
    private ArrayList<String[]> undoStack = new ArrayList<>();
    private String loggedInUser;
    
    public Dashboard(String username) {
        this.loggedInUser = username; 
        initComponents();
        stylizeInterface();
        this.setLocationRelativeTo(null);
        
        loadInitialData(); 
        refreshTable();
    }

    private void loadInitialData() {
        String village = "Unknown Village"; // Default if not found
        
        // READ registry.txt to find the specific user's village
        try (BufferedReader br = new BufferedReader(new FileReader("registry.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                // Assuming format: Username,Password,Village
                if (details.length >= 3 && details[0].equalsIgnoreCase(loggedInUser)) {
                    village = details[2];
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading registry: " + e.getMessage());
        }

        // Automatically adds the person who logged in with their actual village
        players.add(new String[]{loggedInUser, "1000", "Genin", village});
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        for (String[] p : players) {
            model.addRow(p);
        }
    }

    private void stylizeInterface() {
        jPanel2.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jTable1.setOpaque(false);
        
        JButton[] btns = {undo, create, read, delete, Logout};
        for (JButton b : btns) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        undo = new javax.swing.JButton();
        create = new javax.swing.JButton();
        read = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(44, 44, 46, 180));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Chakra Power", "Mastery", "Origin" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 90, 20));

        undo.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        undo.setText("UNDO");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jPanel2.add(undo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 80, 40));

        create.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        create.setText("CREATE");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel2.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 143, -1, 40));

        read.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        read.setText("READ");
        read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readActionPerformed(evt);
            }
        });
        jPanel2.add(read, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 203, 80, 50));

        delete.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 100, 50));

        Logout.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        Logout.setText("LOG OUT");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 110, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Chakra Power", "Jutsu Mastery", "Village(Affiliation)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 450, 310));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/AAA.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 901, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(63, 40, 900, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/dashboard BG.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1010, 557);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        if (!undoStack.isEmpty()) {
            players.add(undoStack.remove(undoStack.size() - 1));
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Nothing to undo!");
        }
    }//GEN-LAST:event_undoActionPerformed

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
       int row = jTable1.getSelectedRow();
        if (row != -1) {
            String[] p = players.get(row);
            String info = "Name: " + p[0] + "\nChakra: " + p[1] + "\nMastery: " + p[2] + "\nVillage: " + p[3];
            JOptionPane.showMessageDialog(this, info, "Shinobi Intel", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Select a Shinobi first.");
        }
    }//GEN-LAST:event_readActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        String name = JOptionPane.showInputDialog(this, "Enter Shinobi Name:");
        if (name != null && !name.trim().isEmpty()) {
            String chakra = JOptionPane.showInputDialog(this, "Chakra Level:");
            String mastery = JOptionPane.showInputDialog(this, "Jutsu Mastery:");
            String village = JOptionPane.showInputDialog(this, "Village:");
            
            players.add(new String[]{name, chakra, mastery, village});
            refreshTable();
        }
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       int row = jTable1.getSelectedRow();
        if (row != -1) {
            undoStack.add(players.get(row)); 
            players.remove(row);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select an entry to delete.");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
    int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this, 
        "Are you sure you want to exit the application?", 
        "Confirm Exit", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE
    );

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        // This shuts down the Java Virtual Machine (JVM) immediately
        System.exit(0); 
    }
    }//GEN-LAST:event_LogoutActionPerformed

    public static void main(String args[]) {
        // Main now passes a placeholder "Guest" so it doesn't crash
        java.awt.EventQueue.invokeLater(() -> new Dashboard("Guest").setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton read;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}
