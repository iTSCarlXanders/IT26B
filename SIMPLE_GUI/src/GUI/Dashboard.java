/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class Dashboard extends javax.swing.JFrame {

    private ArrayList<String[]> players = new ArrayList<>();
    private String loggedInUser;
    
    public Dashboard(String username) {
        this.loggedInUser = username; 
        initComponents();
        stylizeInterface();
        this.setLocationRelativeTo(null);
        
        // --- LISTENERS ---
        sort.addActionListener(evt -> applySort());

        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { filterTable(); }
            @Override
            public void removeUpdate(DocumentEvent e) { filterTable(); }
            @Override
            public void changedUpdate(DocumentEvent e) { filterTable(); }
        });
        
        loadInitialData(); 
        refreshTable();
    }

   private void loadInitialData() {
    players.clear();
    
    // Updated SQL: We pull username from credentials, and everything else from profiles
    String sql = "SELECT c.username, p.clan, p.rank, p.village " +
                 "FROM account_credentials c " +
                 "JOIN shinobi_profiles p ON c.user_id = p.user_id";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        
        while (rs.next()) {
            // Get values from the Result Set
            String name = rs.getString("username");
            String clan = rs.getString("clan");
            String rank = rs.getString("rank");
            String village = rs.getString("village");

            // Validation: If data is missing in DB, show a placeholder instead of "null"
            players.add(new String[]{
                name != null ? name : "Unknown",
                clan != null ? clan : "No Clan",
                rank != null ? rank : "Unranked", // This fixes the 'Unranked' text issue
                village != null ? village : "Wanderer"
            });
        }
    } catch (SQLException e) {
        System.out.println("Dashboard Load Error: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Failed to load the Shinobi Scrolls!");
    }
}

    private void refreshTable() {
        updateTableContent(players);
    }

    private void updateTableContent(ArrayList<String[]> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        for (String[] p : list) {
            model.addRow(p);
        }
    }

   private void filterTable() {
    String query = search.getText().toLowerCase();
    ArrayList<String[]> filteredList = new ArrayList<>();
    for (String[] p : players) {
        // Added p[1] here so the search bar actually looks at the Clan column
        if (p[0].toLowerCase().contains(query) || 
            p[1].toLowerCase().contains(query) || 
            p[2].toLowerCase().contains(query) || 
            p[3].toLowerCase().contains(query)) {
            filteredList.add(p);
        }
    }
    updateTableContent(filteredList);
}

   private void applySort() {
    int choice = sort.getSelectedIndex();
    Collections.sort(players, (String[] s1, String[] s2) -> {
        switch (choice) {
            case 0: return s1[0].compareToIgnoreCase(s2[0]); // Name
            case 1: return s1[1].compareToIgnoreCase(s2[1]); // Clan 
            case 2: return s1[2].compareToIgnoreCase(s2[2]); // Rank
            case 3: return s1[3].compareToIgnoreCase(s2[3]); // Village
            default: return 0;
        }
    });
    filterTable(); 
}

    private void stylizeInterface() {
        jPanel2.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jTable1.setOpaque(false);
            
        search.setBackground(new Color(30, 30, 30));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        sort.setBackground(new Color(44, 44, 46));
        sort.setForeground(Color.WHITE);
              
        JButton[] btns = {update, create, read, delete, Logout};
        for (JButton b : btns) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setForeground(Color.WHITE); 
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sort = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        create = new javax.swing.JButton();
        read = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(44, 44, 46, 180));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sort.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Clan", "Rank", "Origin" }));
        jPanel2.add(sort, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 90, 20));

        update.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 100, 40));

        create.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        create.setText("CREATE");
        create.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel2.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 143, -1, 40));

        read.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        read.setText("READ");
        read.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readActionPerformed(evt);
            }
        });
        jPanel2.add(read, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 203, 80, 50));

        delete.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 100, 50));

        Logout.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        Logout.setText("LOG OUT");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 110, 40));

        jTable1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Clan", "Rank", "Village(Affiliation)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 450, 310));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 200, -1));

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

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            int row = jTable1.getSelectedRow();
        if (row != -1) {
            String targetUser = (String) jTable1.getValueAt(row, 0);
            
            String newClan = JOptionPane.showInputDialog(this, "Update Clan:", jTable1.getValueAt(row, 1));
            String newRank = JOptionPane.showInputDialog(this, "Update Rank:", jTable1.getValueAt(row, 2));
            String newVillage = JOptionPane.showInputDialog(this, "Update Village:", jTable1.getValueAt(row, 3));

            if (newClan != null && newRank != null && newVillage != null) {
                try (Connection conn = Database.getConnection()) {
                    // Update 'shinobi_profiles' by joining with 'account_credentials'
                    String sql = "UPDATE shinobi_profiles p " +
                                 "JOIN account_credentials c ON p.user_id = c.user_id " +
                                 "SET p.clan = ?, p.rank = ?, p.village = ? " +
                                 "WHERE c.username = ?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, newClan);
                    pst.setString(2, newRank);
                    pst.setString(3, newVillage);
                    pst.setString(4, targetUser);
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Archives Updated!");
                    loadInitialData();
                    refreshTable();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a Shinobi from the table first!");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
                                                                  
    String[] options = {"Read Selected \uD83E\uDD77", "Read All Codex \uD83D\uDCDC", "Cancel"};
    
    int choice = JOptionPane.showOptionDialog(this, 
        "Decrypting the Midnight Archives...", 
        "Shinobi Intelligence Access", 
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, options, options[0]);

    if (choice == 0) { // --- READ SELECTED ---
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            // Fixed: Changed "CHAKRA" and "POWER" to "CLAN"
            var intel = " \uD83D\uDEE1  TARGET CLASSIFIED DATA \n" +
                           "==========================\n" +
                           " NAME    : " + model.getValueAt(row, 0) + "\n" +
                           " CLAN    : " + model.getValueAt(row, 1) + "\n" + // Fixed label
                           " RANK    : " + model.getValueAt(row, 2) + "\n" +
                           " VILLAGE : " + model.getValueAt(row, 3) + "\n" +
                           "==========================";
            
            JOptionPane.showMessageDialog(this, intel, "Target Decrypted", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No target identified in the shadows! \u26A0\uFE0F");
        }
        
    } else if (choice == 1) { // --- READ ALL ---
        if (players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The archives are empty.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(" \uD83D\uDCDC GLOBAL SHINOBI CODEX SUMMARY \n");
        sb.append("====================================\n\n");
        
        for (int i = 0; i < players.size(); i++) {
            String[] p = players.get(i);
            sb.append(" SHINOBI UNIT #").append(i + 1).append("\n");
            sb.append(" [NAME]    : ").append(p[0]).append("\n");
            sb.append(" [CLAN]    : ").append(p[1]).append("\n"); // Fixed label
            sb.append(" [RANK]    : ").append(p[2]).append("\n");
            sb.append(" [ORIGIN]  : ").append(p[3]).append("\n");
            sb.append("------------------------------------\n");
        }
        
        javax.swing.JTextArea textArea = new javax.swing.JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(380, 400));
        
        JOptionPane.showMessageDialog(this, scrollPane, "Full Intel Report", JOptionPane.PLAIN_MESSAGE);
    }
    }//GEN-LAST:event_readActionPerformed
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
                                      
         String newName = JOptionPane.showInputDialog(this, "Enter Username:");
        if (newName == null || newName.trim().isEmpty()) return;

        String newPass = JOptionPane.showInputDialog(this, "Set Password:");
        String newClan = JOptionPane.showInputDialog(this, "Enter Clan:");
        String newRank = JOptionPane.showInputDialog(this, "Set Rank:");
        String newVillage = JOptionPane.showInputDialog(this, "Set Village:");

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false); // Start Transaction

            // 1. Insert into account_credentials
            String sqlAcc = "INSERT INTO account_credentials (username, password) VALUES (?, ?)";
            PreparedStatement pstAcc = conn.prepareStatement(sqlAcc, Statement.RETURN_GENERATED_KEYS);
            pstAcc.setString(1, newName);
            pstAcc.setString(2, newPass);
            pstAcc.executeUpdate();

            ResultSet rs = pstAcc.getGeneratedKeys();
            if (rs.next()) {
                int uid = rs.getInt(1);
                // 2. Insert into shinobi_profiles
                String sqlProf = "INSERT INTO shinobi_profiles (user_id, clan, rank, village) VALUES (?, ?, ?, ?)";
                PreparedStatement pstProf = conn.prepareStatement(sqlProf);
                pstProf.setInt(1, uid);
                pstProf.setString(2, newClan);
                pstProf.setString(3, newRank);
                pstProf.setString(4, newVillage);
                pstProf.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "New Shinobi Registered!");
            loadInitialData();
            refreshTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Creation Failed: " + e.getMessage());
        }                                 
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       int row = jTable1.getSelectedRow();
        if (row != -1) {
            String nameToDelete = (String) jTable1.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Permanently exile " + nameToDelete + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = Database.getConnection()) {
                    // This will delete from both tables if Foreign Key ON DELETE CASCADE is set
                    String sql = "DELETE FROM account_credentials WHERE username = ?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, nameToDelete);
                    pst.executeUpdate();
                    
                    loadInitialData();
                    refreshTable();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Delete Failed: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
    int confirm = JOptionPane.showConfirmDialog(this, "Exit Codex?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) { System.exit(0); }
    }//GEN-LAST:event_LogoutActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Dashboard("Guest").setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton read;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> sort;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
