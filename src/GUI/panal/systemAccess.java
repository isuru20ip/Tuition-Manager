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
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modal.LogCenter;
import modal.beans.Admin;
import modal.DB;
import java.sql.ResultSet;
import modal.HomeInfo;
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
        employeeAccessSearch();
        loadLoging();

        txtEmployeeID.setEditable(true);
        txtFirstName.setEditable(true);
        txtLastName.setEditable(true);
    }

    private void loadEmployee() {

        try {
            // Queries
            String query = "SELECT * FROM `employee` "
                    + "INNER JOIN `emp_status` ON `employee`.`emp_status_id` = `emp_status`.`id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                    + "INNER JOIN `emp_type` ON `employee`.`emp_type_id` = `emp_type`.`id` "
                    + "LEFT JOIN `emp_access` ON `employee`.`id` = `emp_access`.`employee_id`";

            // Fetch data for table1
            try (ResultSet resultSet = DB.search(query)) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0); // Clear existing data

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
            }

            // Center alignment for table cells
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            table1.setDefaultRenderer(Object.class, renderer);

        } catch (Exception e) {
            LogCenter.logger.log(Level.WARNING, "Error loading employee data", e);
        }

    }

    private void employeeAccessSearch() {

        try {
            String query = "SELECT "
                    + "    `employee`.id AS Employee_ID, "
                    + "    `employee`.fname AS First_Name, "
                    + "    `employee`.lname AS Last_Name, "
                    + "    `emp_type`.name AS Type, "
                    + "    `emp_access`.user_name AS Username, "
                    + "    `emp_access`.password AS Password "
                    + "FROM "
                    + "    `employee` "
                    + "JOIN "
                    + "    `emp_access` ON `employee`.id = `emp_access`.employee_id "
                    + "JOIN "
                    + "    `emp_type` ON `employee`.emp_type_id = `emp_type`.id";

            // Fetch data for table2
            try (ResultSet resultSet = DB.search(query)) {
                DefaultTableModel dmodel = (DefaultTableModel) table2.getModel();
                dmodel.setRowCount(0); // Clear existing data

                while (resultSet.next()) {
                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("Employee_ID")); // Matches the alias
                    vector.add(resultSet.getString("First_Name"));  // Matches the alias
                    vector.add(resultSet.getString("Last_Name"));   // Matches the alias
                    vector.add(resultSet.getString("Type"));        // Matches the alias
                    vector.add(resultSet.getString("Username"));    // Matches the alias
                    vector.add(resultSet.getString("Password"));    // Matches the alias

                    dmodel.addRow(vector);
                }
            }

            // Center alignment for table cells
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            table2.setDefaultRenderer(Object.class, renderer);

        } catch (Exception e) {
            LogCenter.logger.log(Level.WARNING, "employeeAccessSearch", e);
        }
    }

    private void searchAccess() {

        // Get input from fields
        String employeeID = txtEmployeeID.getText().trim();
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String employeeType = cmbEmployeeType.getSelectedItem().toString();

        // Validation: Ensure at least one search field is filled
        if (employeeID.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && employeeType.equals("Select")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                    "Please fill in at least one search field!");
            return;
        }

        // Build SQL query dynamically based on user input
        String query = "SELECT `employee`.id, `employee`.fname, `employee`.lname, `emp_type`.name AS emp_type, `emp_access`.user_name, `emp_access`.password "
                + "FROM employee INNER JOIN emp_access ON `employee`.id = `emp_access`.employee_id "
                + "INNER JOIN emp_type ON `employee`.emp_type_id = `emp_type`.id WHERE 1=1 "; // Base query

        if (!employeeID.isEmpty()) {
            query += " AND `employee`.id = '" + employeeID + "'";
        }
        if (!firstName.isEmpty()) {
            query += " AND `employee`.fname LIKE '%" + firstName + "%'";
        }
        if (!lastName.isEmpty()) {
            query += " AND `employee`.lname LIKE '%" + lastName + "%'";
        }
        if (!employeeType.equals("Select")) {
            query += " AND `emp_type`.name = '" + employeeType + "'";
        }

        // Execute query using your custom DB class
        try {
            ResultSet rs = DB.search(query);

            // If no results are found
            if (!rs.isBeforeFirst()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                        "No search results found!");
                employeeAccessSearch(); // Reload full table
                return;
            }

            // Populate the JTable with the results
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            model.setRowCount(0); // Clear the existing table data
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getString("emp_type"),
                    rs.getString("User_name"),
                    rs.getString("Password")
                });
            }
        } catch (Exception e) {
            LogCenter.logger.log(Level.WARNING, "searchAccess", e);
        }
    }

    private void clearFields() {
        txtEmployeeID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        cmbEmployeeType.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new RoundedPanel(20, new Color(234,238,244));
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
        jPanel3 = new RoundedPanel(20, new Color(234,238,244));
        jPanel9 = new RoundedPanel(20, Color.white);
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbEmployeeType = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel10 = new RoundedPanel(20, Color.white);
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javaswingdev.swing.table.Table();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new RoundedPanel(20, new Color(234,238,244));
        jScrollPane3 = new javax.swing.JScrollPane();
        logingDataTable = new javaswingdev.swing.table.Table();
        jPanel4 = new RoundedPanel(20, new Color(234,238,244));
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(200, 200, 198));

        jTabbedPane1.setBackground(new java.awt.Color(200, 200, 198));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

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
                        .addGap(0, 110, Short.MAX_VALUE)))
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
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empgender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(emptype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("System Access", jPanel2);

        jPanel3.setBackground(new java.awt.Color(200, 200, 198));

        jPanel9.setBackground(new java.awt.Color(250, 249, 246));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel16.setText("Employee ID");

        txtEmployeeID.setEditable(false);
        txtEmployeeID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmployeeID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIDActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel17.setText("Employee First Name");

        txtFirstName.setEditable(false);
        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        txtLastName.setEditable(false);
        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel18.setText("Employee Last Name");

        jLabel19.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel19.setText("Employee Type");

        cmbEmployeeType.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cmbEmployeeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Master Admin", "Admin", "Cashier", "Attendance Marker" }));
        cmbEmployeeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmployeeTypeActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(51, 255, 51));
        search.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        clear.setText("Clear All");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmployeeID)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstName)
                    .addComponent(txtLastName)
                    .addComponent(cmbEmployeeType, 0, 267, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEmployeeType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(250, 249, 246));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Type", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table2);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Search Access", jPanel3);

        jPanel1.setBackground(new java.awt.Color(200, 200, 198));

        logingDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "time", "name", "username", "type", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logingDataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(logingDataTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login History", jPanel1);

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
            // Retrieve user inputs
            String usern = username.getText().trim();
            String passw = password.getText().trim();
            String empID = empid.getText().trim();

            // Check if a row is selected in the table
            int row = table1.getSelectedRow();
            if (row == -1) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                        "Please select a row to add Access");
                return;
            }

            // Validate input fields
            if (usern.isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                        "Please enter Username");
                return;
            }
            if (passw.isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                        "Please enter Password");
                return;
            }

            // Check for duplicate username or password
            String queryCheck = "SELECT COUNT(*) FROM emp_access WHERE user_name = '" + usern + "' OR password = '" + passw + "'";
            try (ResultSet rs = DB.search(queryCheck)) {
                if (rs.next() && rs.getInt(1) > 0) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                            "Username or password already exists. Please try different credentials.");
                    return;
                }
            }

            // Insert the new access if validation passes
            String queryInsert = "INSERT INTO emp_access (user_name, password, employee_id) VALUES ('" + usern + "', '" + passw + "', '" + empID + "')";
            DB.IUD(queryInsert);

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                    "Access added successfully");

            // Reload employee table and reset input fields
            loadEmployee();
            reset();
        } catch (Exception e) {
            // Log and notify error
            LogCenter.logger.log(Level.WARNING, "Error adding access", e);
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER,
                    "Failed to add access. Please try again.");
        }

    }//GEN-LAST:event_addaccessActionPerformed

    private void clearallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearallMouseClicked
        reset();
    }//GEN-LAST:event_clearallMouseClicked

    private void updateclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateclassActionPerformed

        String usern = username.getText().trim();
        String passw = password.getText().trim();
        String empID = empid.getText().trim();

        // Get the selected row
        int row = table1.getSelectedRow();
        if (row == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                    "Please select a row to update Access");
            return;
        }

        // Get current username and password from the selected row
        String selectedun = String.valueOf(table1.getValueAt(row, 8));
        String selectedpw = String.valueOf(table1.getValueAt(row, 9));

        // Check for empty username
        if (usern.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                    "Please enter Username");
            return;
        }

        // Check for empty password
        if (passw.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                    "Please enter Password");
            return;
        }

        // Check if new username and password are the same as the current ones
        if (selectedun.equals(usern) && selectedpw.equals(passw)) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER,
                    "Please change username or password to update");
            return;
        }

        try {
            // Execute the update query using your DB class
            String query = "UPDATE emp_access SET user_name = '" + usern + "', password = '" + passw + "' WHERE employee_id = '" + empID + "'";
            DB.IUD(query);

            // Notify success
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                    "Access updated successfully");

            // Reload employee table and reset inputs
            loadEmployee();
            reset();
        } catch (Exception e) {
            // Log and notify error
            LogCenter.logger.log(Level.WARNING, "Error updating access", e);
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER,
                    "Failed to update access. Please try again.");
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

    private void txtEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIDActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void cmbEmployeeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmployeeTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmployeeTypeActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        searchAccess();
    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearFields();
        table2.clearSelection();
        employeeAccessSearch();
    }//GEN-LAST:event_clearActionPerformed

    private void setNotification(JFrame parent) {
        Notifications.getInstance().setJFrame(parent);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addaccess;
    private javax.swing.JButton clear;
    private javax.swing.JButton clearall;
    private javax.swing.JComboBox<String> cmbEmployeeType;
    private javax.swing.JTextField contact;
    private javax.swing.JButton deleteclass;
    private javax.swing.JTextField empgender;
    private javax.swing.JTextField empid;
    private javax.swing.JTextField empname;
    private javax.swing.JTextField empstatus;
    private javax.swing.JTextField emptype;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField joineddate;
    private javaswingdev.swing.table.Table logingDataTable;
    private javax.swing.JTextField password;
    private javax.swing.JButton search;
    private javaswingdev.swing.table.Table table1;
    private javaswingdev.swing.table.Table table2;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
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

    private void loadLoging() {
        try {
            DefaultTableModel defaultTableModel = (DefaultTableModel) logingDataTable.getModel();
            defaultTableModel.setRowCount(0);

            // Center alignment for table cells
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            logingDataTable.setDefaultRenderer(Object.class, renderer);

            Vector<String[]> vector = new HomeInfo().getlog();
            int row = 1;
            int vLength = vector.size();
            for (String[] log : vector) {

                if (row == vLength) {
                    break;
                }

                Vector<String> v = new Vector<>();
                v.add(String.valueOf(row)); // #
                v.add(log[0]); // time
                v.add(log[1]); // name
                v.add(log[2]); // userName
                v.add(log[3]); // type
                v.add(log[4]); // status
                defaultTableModel.addRow(v);
                row++;
            }
            logingDataTable.setModel(defaultTableModel);
        } catch (Exception e) {
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
