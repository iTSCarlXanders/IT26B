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
    // SQL joins the 'accounts' table with the 'shinobi_profiles' stats
    String sql = "SELECT p.user_id, a.username, p.clan, p.rank, p.village " +
                 "FROM shinobi_profiles p " +
                 "JOIN accounts a ON p.user_id = a.user_id";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        
        while (rs.next()) {
            players.add(new String[]{
                String.valueOf(rs.getInt("user_id")),                                    // Index 0: User ID
                rs.getString("username") != null ? rs.getString("username") : "Unknown", // Index 1: Shinobi Name
                rs.getString("clan") != null ? rs.getString("clan") : "No Clan",         // Index 2: Clan
                rs.getString("rank") != null ? rs.getString("rank") : "Unranked",       // Index 3: Rank
                rs.getString("village") != null ? rs.getString("village") : "Wanderer"   // Index 4: Village
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to load the Shinobi Scrolls! Error: " + e.getMessage());
    }
}

    // This method was missing in your previous version
    private void refreshTable() {
        updateTableContent(players);
    }

    private void updateTableContent(ArrayList<String[]> list) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    
    // Ensure these match the order in the while loop above!
    model.setColumnIdentifiers(new String[]{
        "User ID", "Shinobi Name", "Clan", "Rank", "Village"
    });

    for (String[] p : list) {
        model.addRow(p);
    }
}

    private void filterTable() {
        String query = search.getText().toLowerCase();
        ArrayList<String[]> filteredList = new ArrayList<>();
        for (String[] p : players) {
            // Checks all 5 columns: Name, ID, Clan, Rank, Village
            if (p[0].toLowerCase().contains(query) || 
                p[1].toLowerCase().contains(query) || 
                p[2].toLowerCase().contains(query) || 
                p[3].toLowerCase().contains(query) ||
                p[4].toLowerCase().contains(query)) {
                filteredList.add(p);
            }
        }
        updateTableContent(filteredList);
    }

    private void applySort() {
    int choice = sort.getSelectedIndex(); // 0 = ID, 1 = Name

    Collections.sort(players, (String[] s1, String[] s2) -> {
        // Option 0: Sort by ID (Numerical)
        if (choice == 0) {
            try {
                int id1 = Integer.parseInt(s1[0]);
                int id2 = Integer.parseInt(s2[0]);
                return Integer.compare(id1, id2);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        
        // Option 1: Sort by Name (Alphabetical)
        // We use Index 1 because 'username' is the second item in our data
        return s1[1].compareToIgnoreCase(s2[1]);
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
        sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name" }));
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });
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
        // Current Data from Table (ID=0, Name=1, Clan=2, Rank=3, Village=4)
        String targetId = (String) jTable1.getValueAt(row, 0); 
        String currentName = (String) jTable1.getValueAt(row, 1);
        String currentClan = (String) jTable1.getValueAt(row, 2);
        String currentRank = (String) jTable1.getValueAt(row, 3);
        String currentVillage = (String) jTable1.getValueAt(row, 4);

        // Input Dialogs
        String newName = JOptionPane.showInputDialog(this, "Update Shinobi Name:", currentName);
        if (newName == null || newName.trim().isEmpty()) return; // Cancel if empty

        String newClan = JOptionPane.showInputDialog(this, "Update Clan:", currentClan);
        String newRank = JOptionPane.showInputDialog(this, "Update Rank:", currentRank);
        String newVillage = JOptionPane.showInputDialog(this, "Update Village:", currentVillage);

        if (newClan != null && newRank != null && newVillage != null) {
            try (Connection conn = Database.getConnection()) {
                conn.setAutoCommit(false); // Start Transaction

                // 1. Update the Account Name
                String sqlAcc = "UPDATE accounts SET username = ? WHERE user_id = ?";
                try (PreparedStatement pstAcc = conn.prepareStatement(sqlAcc)) {
                    pstAcc.setString(1, newName);
                    pstAcc.setInt(2, Integer.parseInt(targetId));
                    pstAcc.executeUpdate();
                }

                // 2. Update the Profile Details
                String sqlProf = "UPDATE shinobi_profiles SET clan = ?, rank = ?, village = ? WHERE user_id = ?";
                try (PreparedStatement pstProf = conn.prepareStatement(sqlProf)) {
                    pstProf.setString(1, newClan);
                    pstProf.setString(2, newRank);
                    pstProf.setString(3, newVillage);
                    pstProf.setInt(4, Integer.parseInt(targetId));
                    pstProf.executeUpdate();
                }

                conn.commit(); // Save all changes
                
                loadInitialData();
                refreshTable();
                JOptionPane.showMessageDialog(this, "Scrolls updated: " + newName + " has been recorded.");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Select a row from the table first!");
    }
    }//GEN-LAST:event_updateActionPerformed

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
                                                                                                  
    int row = jTable1.getSelectedRow();
    if (row != -1) {
        String intel = " 🛡 TARGET CLASSIFIED DATA \n" +
                       "==========================\n" +
                       " ID        : " + jTable1.getValueAt(row, 0) + "\n" +
                       " NAME      : " + jTable1.getValueAt(row, 1) + "\n" +
                       " CLAN      : " + jTable1.getValueAt(row, 2) + "\n" +
                       " RANK      : " + jTable1.getValueAt(row, 3) + "\n" +
                       " VILLAGE   : " + jTable1.getValueAt(row, 4) + "\n" +
                       "==========================";
        JOptionPane.showMessageDialog(this, intel, "Intel Decrypted", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Select a target!");
    }
    }//GEN-LAST:event_readActionPerformed
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
                                      
        String newName = JOptionPane.showInputDialog(this, "Enter Shinobi Name:");
        if (newName == null || newName.trim().isEmpty()) return;
        
        String newPass = JOptionPane.showInputDialog(this, "Set Secret Password:");
        if (newPass == null || newPass.trim().isEmpty()) return;
        
        String newClan = JOptionPane.showInputDialog(this, "Assign Clan:");
        String newRank = JOptionPane.showInputDialog(this, "Assign Rank:");
        String newVillage = JOptionPane.showInputDialog(this, "Assign Village:");

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);
            String sqlAcc = "INSERT INTO accounts (username, password) VALUES (?, ?)";
            PreparedStatement pstAcc = conn.prepareStatement(sqlAcc, Statement.RETURN_GENERATED_KEYS);
            pstAcc.setString(1, newName);
            pstAcc.setString(2, newPass);
            pstAcc.executeUpdate();

            ResultSet rs = pstAcc.getGeneratedKeys();
            if (rs.next()) {
                int uid = rs.getInt(1);
                String sqlProf = "INSERT INTO shinobi_profiles (user_id, clan, rank, village) VALUES (?, ?, ?, ?)";
                PreparedStatement pstProf = conn.prepareStatement(sqlProf);
                pstProf.setInt(1, uid);
                pstProf.setString(2, newClan != null ? newClan : "Unknown");
                pstProf.setString(3, newRank != null ? newRank : "Genin");
                pstProf.setString(4, newVillage != null ? newVillage : "Wanderer");
                pstProf.executeUpdate();
            }
            conn.commit();
            loadInitialData();
            refreshTable();
            JOptionPane.showMessageDialog(this, "New Shinobi registered to the scrolls!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Registration Failed: " + e.getMessage());
        }           
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       int row = jTable1.getSelectedRow();
        if (row != -1) {
            String nameToDelete = (String) jTable1.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Permanently exile " + nameToDelete + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = Database.getConnection()) {
                    String sql = "DELETE FROM accounts WHERE username = ?";
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

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortActionPerformed

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
