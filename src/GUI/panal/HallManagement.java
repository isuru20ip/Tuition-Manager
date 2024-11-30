package GUI.panal;

import GUI.SignIn;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import modal.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modal.HomeInfo;
import modal.IDGenarator;
import modal.LogCenter;
import modal.Reporting;
import modal.beans.Admin;
import modal.beans.Home;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

public class HallManagement extends javax.swing.JPanel {

    private static HashMap<String, String> hallTypeMap = new HashMap<>();
    Admin admin;
    public HallManagement(Admin admin) {
        initComponents();
        hallType();
        loadHall();
        this.admin = admin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(234, 238, 244));

        jPanel1.setBackground(new java.awt.Color(234, 238, 244));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel1.setText("Hall Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(234, 238, 244));

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel2.setText("Hall Type");

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel3.setText("Hall Capacity :");

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton1.setText("Add New Hall");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton2.setText("Update Hall");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N

        jTable1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hall Capacity", "Hall Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel4.setText("Search :");

        jTextField2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(234, 238, 244));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/icons8-print-48.png"))); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addHall();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateHall();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        viewRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        searchHall();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   
        print();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        save();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    //load Class Room type
    private void hallType() {

        try {

            ResultSet resultSet = DB.search("SELECT * FROM `room_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("type"));
                hallTypeMap.put(resultSet.getString("type"), resultSet.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);

        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    //load jTable
    private void loadHall() {

        try {

            ResultSet resultSet = DB.search("Select * From `class_room` "
                    + "INNER JOIN `room_type` ON `class_room`.`room_type_id` = `room_type`.`id` ");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("capacity"));
                vector.add(resultSet.getString("room_type.type"));

                model.addRow(vector);
            }

        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);

        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    //insert new Class room
    private void addHall() {
        try {

            String type = String.valueOf(jComboBox1.getSelectedItem());
            String capacity = jTextField1.getText();

            if (capacity.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Hall Capacity", "warning", JOptionPane.WARNING_MESSAGE);

            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Hall Type", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                String generatedID = IDGenarator.generateID("H", "class_room"); //Generate Student ID

                DB.IUD("INSERT INTO `class_room` (`id`, `capacity`, `room_type_id`) "
                        + "VALUES ('" + generatedID + "', '" + capacity + "', '" + hallTypeMap.get(type) + "') ");

                loadHall();
                reset();
            }

        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);

        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    //Update Class Rooms
    private void updateHall() {
        try {

            int row = jTable1.getSelectedRow();

            if (row >= 0) {
                String type = String.valueOf(jComboBox1.getSelectedItem());
                String capacity = jTextField1.getText();

                String hID = String.valueOf(jTable1.getValueAt(row, 0));

                if (capacity.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter Hall Capacity", "warning", JOptionPane.WARNING_MESSAGE);

                } else if (type.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please select Hall Type", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    DB.IUD("UPDATE `class_room` SET `capacity` = '" + capacity + "', "
                            + "`room_type_id` = '" + hallTypeMap.get(type) + "'"
                            + " WHERE `id` = '" + hID + "' ");

                    loadHall();
                    reset();

                }
            } else {
                JOptionPane.showMessageDialog(this, "Select a row", "warning", JOptionPane.WARNING_MESSAGE);

            }

        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);

        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }

    }

    //Search Class Room
    private void searchHall() {
        String value = jTextField2.getText();

        try {

            String query = ("Select * From `class_room` "
                    + "INNER JOIN `room_type` ON `class_room`.`room_type_id` = `room_type`.`id` ");

            if (value.matches("^H00000([1-9]|1[0-9]|20)$")) {
                query += "WHERE `class_room`.`id` LIKE '%" + value + "%' ";

            } else if (value.matches("^A\\/C|N|A|Normal$")) {
                query += " WHERE `room_type`.`type` LIKE '%" + value + "%'";

            } else {
                query += "WHERE `class_room`.`capacity` LIKE '%" + value + "%' ";
            }

            ResultSet resultSet = DB.search(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("capacity"));
                vector.add(resultSet.getString("room_type.type"));

                dtm.addRow(vector);
            }

        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);

        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    //Table row selected
    private void viewRow() {
        int row = jTable1.getSelectedRow();

        String capacity = String.valueOf(jTable1.getValueAt(row, 1));
        jTextField1.setText(capacity);

        String type = String.valueOf(jTable1.getValueAt(row, 2));
        jComboBox1.setSelectedItem(type);

        jButton1.setEnabled(false);
    }

    //clear all
    private void reset() {
        jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTable1.clearSelection();

        jButton1.setEnabled(true); //add new hall button enable
    }

    
    //save class room report as a pdf
    private void save() {

        try {

            // Parameters (empty in this case)
            HashMap<String, Object> params = new HashMap<>();

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            Reporting reporting = new Reporting();
            boolean isSaved = reporting.saveReport("Hall_Repo", params, dataSource, admin);

            if (isSaved) {
                JOptionPane.showMessageDialog(this, "Hall Report saved successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Hall Report saving was canceled");
            }

            
        }  catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage());
        }

    }
    
    

    //print class room reports
    private void print() {
        
        try {

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
            
            // Parameters (empty in this case)
            HashMap<String, Object> params = new HashMap<>();

            new Reporting().viewReport("Hall_Repo", params, dataSource, admin);

        } catch (IOException ex) {
            LogCenter.logger.log(Level.WARNING, "Error", ex);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(Level.WARNING, "Error", ex);
        } catch (JRException ex) {
            Logger.getLogger(PaymentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
