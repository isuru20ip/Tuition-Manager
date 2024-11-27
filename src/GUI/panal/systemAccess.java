/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.panal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modal.DB;
import modal.LogCenter;
import modal.beans.Admin;
import modal.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.PreparedStatement;
import raven.toast.Notifications;

/**
 *
 * @author vihan
 */
public class systemAccess extends javax.swing.JPanel {

    private Admin admin;

    public systemAccess(Admin bean) {
        initComponents();
        this.admin = bean;
        loadEmployee();
    }

    private void loadEmployee() {

        try {

            String query = "SELECT * FROM `employee` "
                    + "INNER JOIN `emp_status` ON `employee`.`emp_status_id` = `emp_status`.`id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                    + "INNER JOIN `emp_type` ON `employee`.`emp_type_id` = `emp_type`.`id` "
                    + "LEFT JOIN `emp_access` ON `employee`.`id` = `emp_access`.`employee_id`";

            ResultSet resultSet = DB.search(query);

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            table1.setDefaultRenderer(Object.class, renderer);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("lname"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("join_date"));
                vector.add(resultSet.getString("emp_status.status"));
                vector.add(resultSet.getString("gender.name"));
                vector.add(resultSet.getString("emp_type.name"));
                vector.add(resultSet.getString("emp_access.user_name"));
                vector.add(resultSet.getString("emp_access.password"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            LogCenter.logger.log(Level.WARNING, "loadEmployeeSystemAccess", e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new RoundedPanel(20, new Color(250, 249, 246));
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        empname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        joineddate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        empstatus = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        empgender = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        emptype = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        updateclass = new javax.swing.JButton();
        addaccess = new javax.swing.JButton();
        deleteclass = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        clearall = new javax.swing.JButton();
        jPanel3 = new RoundedPanel(20, new Color(250, 249, 246));
        jPanel1 = new RoundedPanel(20, new Color(250, 249, 246));
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new RoundedPanel(20, new Color(250, 249, 246));
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(200, 200, 198));

        jTabbedPane1.setBackground(new java.awt.Color(200, 200, 198));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(200, 200, 198));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Mobile", "Joined Date", "Employee Status", "Gender", "Employee Type", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(3).setPreferredWidth(70);
            table1.getColumnModel().getColumn(4).setPreferredWidth(120);
            table1.getColumnModel().getColumn(5).setPreferredWidth(90);
            table1.getColumnModel().getColumn(6).setPreferredWidth(60);
            table1.getColumnModel().getColumn(7).setPreferredWidth(85);
            table1.getColumnModel().getColumn(8).setPreferredWidth(50);
            table1.getColumnModel().getColumn(9).setPreferredWidth(50);
        }

        jPanel6.setBackground(new java.awt.Color(250, 249, 246));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Meta", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel10.setText("Employee Name");

        empname.setEditable(false);
        empname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        empname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empnameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel11.setText("Employee Contact");

        contact.setEditable(false);
        contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel12.setText("Joined Date");

        joineddate.setEditable(false);
        joineddate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        joineddate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        joineddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joineddateActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel13.setText("Employee Status");

        empstatus.setEditable(false);
        empstatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empstatus.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        empstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empstatusActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel14.setText("Employee Gender");

        empgender.setEditable(false);
        empgender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empgender.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        empgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empgenderActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel15.setText("Employee Type");

        emptype.setEditable(false);
        emptype.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emptype.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emptype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joineddate)
                    .addComponent(empname)
                    .addComponent(contact)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emptype)
                    .addComponent(empstatus)
                    .addComponent(empgender)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empgender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(emptype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(joineddate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Access", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel7.setText("Employee ID");

        empid.setEditable(false);
        empid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });

        updateclass.setBackground(new java.awt.Color(255, 255, 102));
        updateclass.setFont(new java.awt.Font("Meta", 1, 14)); // NOI18N
        updateclass.setText("Update Access");
        updateclass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        updateclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateclassActionPerformed(evt);
            }
        });

        addaccess.setBackground(new java.awt.Color(51, 255, 51));
        addaccess.setFont(new java.awt.Font("Meta", 1, 14)); // NOI18N
        addaccess.setText("Add Access");
        addaccess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addaccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addaccessActionPerformed(evt);
            }
        });

        deleteclass.setBackground(new java.awt.Color(255, 51, 51));
        deleteclass.setFont(new java.awt.Font("Meta", 1, 14)); // NOI18N
        deleteclass.setText("Delete Access");
        deleteclass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        deleteclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteclassActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel9.setText("Password");

        password.setEditable(false);
        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel8.setText("Username");

        username.setEditable(false);
        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        clearall.setBackground(new java.awt.Color(255, 255, 255));
        clearall.setFont(new java.awt.Font("Meta", 1, 14)); // NOI18N
        clearall.setText("Clear All");
        clearall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        clearall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearallMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(empid)
                    .addComponent(username)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(141, 141, 141)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(deleteclass, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearall, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(updateclass, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addaccess, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addaccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(deleteclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(clearall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("System Access", jPanel2);

        jPanel3.setBackground(new java.awt.Color(200, 200, 198));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Search Access", jPanel3);

        jPanel1.setBackground(new java.awt.Color(200, 200, 198));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Login History", jPanel1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reports", jPanel5);

        jPanel4.setBackground(new java.awt.Color(200, 200, 198));

        jLabel1.setBackground(new java.awt.Color(250, 249, 246));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("System Access Management");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void empnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empnameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void joineddateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joineddateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joineddateActionPerformed

    private void empstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empstatusActionPerformed

    private void empgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empgenderActionPerformed

    private void emptypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emptypeActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

        if (evt.getClickCount() == 2) {
            buttonToggle();

        }

    }//GEN-LAST:event_table1MouseClicked

    private void addaccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addaccessActionPerformed

        try {

            Connection conn = DB.getConnection();
            // Check if the connection is valid before proceeding
            if (conn == null || conn.isClosed()) {
                throw new Exception("Database connection is closed. Re-establishing connection...");
            }
            String usern = username.getText();
            String passw = String.valueOf(password.getText());
            String empID = String.valueOf(empid.getText());

            int row = table1.getSelectedRow();

            if (row == -1) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please select a row to add Access");
            } else if (usern == null || usern.trim().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please enter Username");
            } else if (passw == null || passw.trim().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please enter Password");
            } else {

                // Validate if username and password already exist
                try (PreparedStatement pst = conn.prepareStatement(
                        "SELECT COUNT(*) FROM emp_access WHERE user_name = ? OR password = ?")) {

                    pst.setString(1, usern);
                    pst.setString(2, passw);

                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next() && rs.getInt(1) > 0) {
                            // Username and password already exist
                            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Username and password already exist. Please try different credentials.");
                        } else {

                            // If validation passes, insert the new access
                            DB.IUD("INSERT INTO `emp_access`(`user_name`, `password`, `employee_id`) VALUES ('" + usern + "','" + passw + "','" + empID + "')");
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Access added successfully");
                            loadEmployee();
                            reset();
                        }
                    }

                    // Validate after adding credentials
                    try (PreparedStatement validateStmt = conn.prepareStatement(
                            "SELECT COUNT(*) AS count FROM emp_access WHERE user_name = ? AND password = ?")) {

                        validateStmt.setString(1, usern);
                        validateStmt.setString(2, passw);

                        try (ResultSet rs = validateStmt.executeQuery()) {
                            if (rs.next() && rs.getInt("count") > 1) { // `> 1` because we just added these credentials
                                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                                        "Duplicate entry detected after addition. Please review your data integrity.");
                            }
                        }
                    }

                }

            }
        } catch (Exception e) {
            LogCenter.logger.log(Level.WARNING, "addAccess", e);
        }

    }//GEN-LAST:event_addaccessActionPerformed

    private void clearallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearallMouseClicked
        reset();
    }//GEN-LAST:event_clearallMouseClicked

    private void updateclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateclassActionPerformed

        String usern = username.getText();
        String passw = String.valueOf(password.getText());
        String empID = String.valueOf(empid.getText());

        int row = table1.getSelectedRow();
        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please select a row to update Access");
        } else {

            String selectedun = String.valueOf(table1.getValueAt(row, 8));
            String selectedpw = String.valueOf(table1.getValueAt(row, 9));

            try {
                Connection conn = DB.getConnection();
                // Check if the connection is valid before proceeding
                if (conn == null || conn.isClosed()) {
                    throw new Exception("Database connection is closed. Re-establishing connection...");
                }
            } catch (Exception e) {
            }

            if (usern == null || usern.trim().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please enter Username");
            } else if (passw == null || passw.trim().isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please enter Password");
            } else if (selectedun.equals(usern) && selectedpw.equals(passw)) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please change username or passsword to update");
            } else {

                try {

                    DB.IUD("UPDATE `emp_access` SET `user_name`='" + usern + "', `password` = '" + passw + "' WHERE `employee_id`='" + empID + "'");
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Access updated successfully");
                    loadEmployee();
                    reset();

                } catch (Exception e) {
                    LogCenter.logger.log(Level.WARNING, "updateMainAccess", e);
                }

            }

        }


    }//GEN-LAST:event_updateclassActionPerformed

    private void deleteclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteclassActionPerformed

        int row = table1.getSelectedRow();

        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please select employee access");
        } else {

            try {

                String un = String.valueOf(table1.getValueAt(row, 8));
                String pww = String.valueOf(table1.getValueAt(row, 9));
                String empID = String.valueOf(empid.getText());

                DB.IUD("DELETE FROM `emp_access` WHERE `employee_id` ='" + empID + "'");

                loadEmployee();
                reset();

                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Employee Access deleted successfully");

            } catch (Exception e) {
                LogCenter.logger.log(Level.WARNING, "deleteAccess", e);
            }
        }
    }//GEN-LAST:event_deleteclassActionPerformed

    private void setNotification(JFrame parent) {
        Notifications.getInstance().setJFrame(parent);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addaccess;
    private javax.swing.JButton clearall;
    private javax.swing.JTextField contact;
    private javax.swing.JButton deleteclass;
    private javax.swing.JTextField empgender;
    private javax.swing.JTextField empid;
    private javax.swing.JTextField empname;
    private javax.swing.JTextField empstatus;
    private javax.swing.JTextField emptype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField joineddate;
    private javax.swing.JTextField password;
    private javaswingdev.swing.table.Table table1;
    private javax.swing.JButton updateclass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        empname.setText("");
        contact.setText("");
        joineddate.setText("");
        empstatus.setText("");
        empgender.setText("");
        emptype.setText("");
        empid.setText("");
        username.setText("");
        password.setText("");
        table1.clearSelection();
        addaccess.setEnabled(true);
        updateclass.setEnabled(true);
        deleteclass.setEnabled(true);

    }

    private void buttonToggle() {

        int row = table1.getSelectedRow();

        

        String emp = String.valueOf(table1.getValueAt(row, 0));
        empid.setText(emp);
        empid.setEditable(false);

        String name = String.valueOf(table1.getValueAt(row, 1) + " " + table1.getValueAt(row, 2));
        empname.setText(name);
        empname.setEditable(false);

        String empc = String.valueOf(table1.getValueAt(row, 3));
        contact.setText(empc);
        contact.setEditable(false);

        String empjoineddate = String.valueOf(table1.getValueAt(row, 4));
        joineddate.setText(empjoineddate);
        joineddate.setEditable(false);

        String emps = String.valueOf(table1.getValueAt(row, 5));
        empstatus.setText(emps);
        empstatus.setEditable(false);

        String empg = String.valueOf(table1.getValueAt(row, 6));
        empgender.setText(empg);
        empgender.setEditable(false);

        String empt = String.valueOf(table1.getValueAt(row, 7));
        emptype.setText(empt);
        emptype.setEditable(false);

        String un = String.valueOf(table1.getValueAt(row, 8));
        if (un == "null") {
            username.setText(null);
            username.grabFocus();
        } else {
            username.setText(un);
        }
        username.setEditable(true);

        String pw = String.valueOf(table1.getValueAt(row, 9));
        if (pw == "null") {
            password.setText(null);
        } else {
            password.setText(pw);
        }
        password.setEditable(true);
        
        String usern = username.getText();
        String passw = String.valueOf(password.getText());

        if (usern.isEmpty() || passw.isEmpty()) {
            addaccess.setEnabled(true);
            updateclass.setEnabled(false);
            deleteclass.setEnabled(false);
        } else {
            addaccess.setEnabled(false);
            updateclass.setEnabled(true);
            deleteclass.setEnabled(true);
        }
    }

//rounded panel
    class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;
        private Color boarder;

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }

}
