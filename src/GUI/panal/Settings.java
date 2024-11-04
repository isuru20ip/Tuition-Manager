package GUI.panal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.HashMap;
import modal.DB;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modal.LogCenter;
import modal.Validator;
import modal.WordFormat;
import modal.beans.Home;
import modal.systemData.HomeInfo;

/**
 *
 * @author isuru priyamntha
 */
public class Settings extends javax.swing.JPanel {

    // store hall fees <k:hallType,v:fee> 
    HashMap<String, String> hallMap = new HashMap<>();

    // store emp salary <k:empType,v:salary> 
    HashMap<String, String> empMap = new HashMap<>();

    // store Institute Service Charges <k:sevice,v:fee>
    HashMap<String, String> serviceMap = new HashMap<>();

    // store user selected new logo's path
    private String logopath;

    public Settings() {
        initComponents();
        loardHallType();
        loardEMPypes();
        loardserviceCharge();
        loardSubjects();
        loardGrades();
        loardCity();
        loardHome();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        empType = new javax.swing.JComboBox<>();
        empSalary = new javax.swing.JFormattedTextField();
        salaryBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        hallTypes = new javax.swing.JComboBox<>();
        hallFee = new javax.swing.JFormattedTextField();
        hallBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        sCharge = new javax.swing.JFormattedTextField();
        serviceBtn = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        clean = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        gradeCombo = new javax.swing.JComboBox<>();
        subjectName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gradeTable = new javax.swing.JTable();
        addGrade = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        homeName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        line01 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        line02 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        webLink = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phone01 = new javax.swing.JTextField();
        phone02 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        city = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        phone03 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fax = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();
        saveHome = new javax.swing.JButton();

        setBackground(new java.awt.Color(234, 238, 244));

        jLabel1.setFont(new java.awt.Font("SchulbuchNord", 0, 24)); // NOI18N
        jLabel1.setText("Settings");

        jTabbedPane1.setFont(new java.awt.Font("Meta", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(234, 238, 244));

        jLabel3.setFont(new java.awt.Font("Meta", 1, 18)); // NOI18N
        jLabel3.setText("Employee Salary ");

        empType.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        empType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMP Type" }));
        empType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empTypeItemStateChanged(evt);
            }
        });

        empSalary.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        empSalary.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N

        salaryBtn.setBackground(new java.awt.Color(0, 51, 204));
        salaryBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salaryBtn.setForeground(new java.awt.Color(255, 255, 255));
        salaryBtn.setText("Save");
        salaryBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        salaryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Meta", 1, 18)); // NOI18N
        jLabel4.setText("Hall Fee ");

        hallTypes.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        hallTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hall Fee" }));
        hallTypes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hallTypesItemStateChanged(evt);
            }
        });

        hallFee.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        hallFee.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N

        hallBtn.setBackground(new java.awt.Color(0, 51, 204));
        hallBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hallBtn.setForeground(new java.awt.Color(255, 255, 255));
        hallBtn.setText("Save");
        hallBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        hallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallBtnActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Meta", 1, 18)); // NOI18N
        jLabel5.setText("Institute Fee");

        sCharge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        sCharge.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N

        serviceBtn.setBackground(new java.awt.Color(0, 51, 204));
        serviceBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serviceBtn.setForeground(new java.awt.Color(255, 255, 255));
        serviceBtn.setText("Save");
        serviceBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        serviceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Class");
        jRadioButton1.setActionCommand("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Course");
        jRadioButton2.setActionCommand("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        clean.setBackground(new java.awt.Color(255, 102, 102));
        clean.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clean.setText("Clear All");
        clean.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hallFee, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hallTypes, javax.swing.GroupLayout.Alignment.LEADING, 0, 240, Short.MAX_VALUE)
                    .addComponent(hallBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(empType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empSalary)
                    .addComponent(salaryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(sCharge)
                    .addComponent(serviceBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hallTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hallFee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hallBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(empType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(empSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(salaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(53, 53, 53))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(serviceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53))
                                .addComponent(jLabel3)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Financial Control", jPanel2);

        jPanel1.setBackground(new java.awt.Color(234, 238, 244));

        jLabel2.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel2.setText("Add New Subject");

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.getTableHeader().setReorderingAllowed(false);
        subjectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(subjectTable);
        if (subjectTable.getColumnModel().getColumnCount() > 0) {
            subjectTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton5.setBackground(new java.awt.Color(193, 206, 255));
        jButton5.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N
        jButton5.setText("Add New Subject");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(193, 255, 193));
        jButton7.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N
        jButton7.setText("Update Subject");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel6.setText("Grades");

        gradeCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gradeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        subjectName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subjectNameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Meta", 0, 14)); // NOI18N
        jLabel7.setText("Subject Name");

        gradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeTable.getTableHeader().setReorderingAllowed(false);
        gradeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gradeTable);
        if (gradeTable.getColumnModel().getColumnCount() > 0) {
            gradeTable.getColumnModel().getColumn(0).setResizable(false);
        }

        addGrade.setBackground(new java.awt.Color(193, 206, 255));
        addGrade.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N
        addGrade.setText("Add Grade");
        addGrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGradeActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 193, 193));
        jButton9.setFont(new java.awt.Font("Advert", 0, 14)); // NOI18N
        jButton9.setText("Clear");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gradeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Subject Control", jPanel1);

        jPanel3.setBackground(new java.awt.Color(234, 238, 244));

        jLabel8.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel8.setText("Institute Name");

        jLabel9.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel9.setText("Address 01");

        jLabel10.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel10.setText("Address 02");

        jLabel11.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel11.setText("City");

        jLabel12.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel12.setText("Web link");

        jLabel13.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel13.setText("Phone-01");

        jLabel14.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel14.setText("Phone-02");

        city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel15.setText("Phone-03");

        jLabel16.setFont(new java.awt.Font("Advert", 0, 18)); // NOI18N
        jLabel16.setText("Fax");

        logo.setBackground(new java.awt.Color(0, 0, 0));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        saveHome.setBackground(new java.awt.Color(0, 0, 204));
        saveHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveHome.setForeground(new java.awt.Color(255, 255, 255));
        saveHome.setText("SAVE");
        saveHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeName, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(590, 590, 590))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(webLink, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phone01, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(line01, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fax)
                            .addComponent(line02)
                            .addComponent(phone02))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(city, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone03, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phone03, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(saveHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(line01, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(line02, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone01, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone02, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(webLink, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(132, 132, 132))
        );

        jTabbedPane1.addTab("Institute Data", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Hall Type ComboBox
    private void hallTypesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hallTypesItemStateChanged
        loardHallFee();
    }//GEN-LAST:event_hallTypesItemStateChanged

    // EMP ComboBox
    private void empTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_empTypeItemStateChanged
        loardSalary();
    }//GEN-LAST:event_empTypeItemStateChanged

    // Class Redio
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        loardServiceFee();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    // Course Redio
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        loardServiceFee();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    // Hall Fee Button
    private void hallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallBtnActionPerformed
        updateHallFee();
    }//GEN-LAST:event_hallBtnActionPerformed

    // Sallary Button
    private void salaryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryBtnActionPerformed
        updateEmpSalary();
    }//GEN-LAST:event_salaryBtnActionPerformed

    // Service Button
    private void serviceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceBtnActionPerformed
        updateServiseFee();
    }//GEN-LAST:event_serviceBtnActionPerformed

    // clear Button
    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        cleanAll();
    }//GEN-LAST:event_cleanActionPerformed

    //  subject Name Text Feild
    private void subjectNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectNameKeyReleased
        loardSubjects();
    }//GEN-LAST:event_subjectNameKeyReleased
    // jTbale Selection [subjectTable]
    private void subjectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTableMouseClicked
        if (evt.getClickCount() == 2) {
            selectSubject();
        }
    }//GEN-LAST:event_subjectTableMouseClicked

    // Clear Button of Subject Panal Data
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        clearSubject();
    }//GEN-LAST:event_jButton9ActionPerformed

    //addGrade Button
    private void addGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGradeActionPerformed
        addGrade();
    }//GEN-LAST:event_addGradeActionPerformed

    // Tbale click Remove Grade on jTable [gradeTbale]
    private void gradeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeTableMouseClicked
        if (evt.getClickCount() == 2) {
            dropGrade();
        }
    }//GEN-LAST:event_gradeTableMouseClicked

    //Update Subject Button
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        updateSubject();
    }//GEN-LAST:event_jButton7ActionPerformed

    // Add new Subject Button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        newSubject();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Click Logo
    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        pickLogo();
    }//GEN-LAST:event_logoMouseClicked

    // Home Data Save Button
    private void saveHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveHomeActionPerformed
        SaveHomeData();
    }//GEN-LAST:event_saveHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGrade;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> city;
    private javax.swing.JButton clean;
    private javax.swing.JFormattedTextField empSalary;
    private javax.swing.JComboBox<String> empType;
    private javax.swing.JTextField fax;
    private javax.swing.JComboBox<String> gradeCombo;
    private javax.swing.JTable gradeTable;
    private javax.swing.JButton hallBtn;
    private javax.swing.JFormattedTextField hallFee;
    private javax.swing.JComboBox<String> hallTypes;
    private javax.swing.JTextField homeName;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField line01;
    private javax.swing.JTextField line02;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField phone01;
    private javax.swing.JTextField phone02;
    private javax.swing.JTextField phone03;
    private javax.swing.JFormattedTextField sCharge;
    private javax.swing.JButton salaryBtn;
    private javax.swing.JButton saveHome;
    private javax.swing.JButton serviceBtn;
    private javax.swing.JTextField subjectName;
    private javax.swing.JTable subjectTable;
    private javax.swing.JTextField webLink;
    // End of variables declaration//GEN-END:variables

    // loard hallType into combobox[hallType] & add hall type price into hallMap [HashMap]
    private void loardHallType() {
        try {
            ResultSet resultSet = DB.search("SELECT * FROM `room_type`");
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            comboBoxModel.addElement("Select Type");
            while (resultSet.next()) {
                hallMap.put(resultSet.getString("type"), resultSet.getString("fee"));
                comboBoxModel.addElement(resultSet.getString("type"));
            }
            hallTypes.setModel(comboBoxModel);
            loardHallFee();
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // display hall Fee on the jTextfield [hallfee]
    private void loardHallFee() {
        String type = (String) hallTypes.getSelectedItem();
        if (type.equals("Select Type")) {
            hallFee.setText("");
        } else {
            hallFee.setText(hallMap.get(type));
        }
        textFieldContaller(hallTypes, hallFee);
    }

    // loard EMP types into combobox[empType] & add emp salary into hallMap [HashMap]
    private void loardEMPypes() {
        try {
            ResultSet resultSet = DB.search("SELECT * FROM `emp_type`");
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            comboBoxModel.addElement("Select Type");
            while (resultSet.next()) {
                if (!resultSet.getString("name").equals("Master Admin")) {
                    empMap.put(resultSet.getString("name"), resultSet.getString("salary"));
                    comboBoxModel.addElement(resultSet.getString("name"));
                }
            }
            empType.setModel(comboBoxModel);
            loardSalary();
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // display emp salary on the jTextfield [empSalary]
    private void loardSalary() {
        String type = (String) empType.getSelectedItem();
        if (type.equals("Select Type")) {
            empSalary.setText("");
        } else {
            empSalary.setText(empMap.get(type));
        }
        textFieldContaller(empType, empSalary);
    }

    // set text feild active and inactive
    private void textFieldContaller(JComboBox box, JTextField field) {
        String status = (String) box.getSelectedItem();
        if (status.equals("Select Type")) {
            field.setEditable(false);
        } else {
            field.setEditable(true);
        }
    }

    // put service charge into hashMap [serviceMap]
    private void loardserviceCharge() {
        try {
            ResultSet resultSet = DB.search("SELECT * FROM `service_charge`");
            while (resultSet.next()) {
                serviceMap.put(resultSet.getString("service_type_id"), resultSet.getString("fee"));
            }
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
        loardServiceFee();
    }

    // view [sCharge] Service charges that are get from teachers (n%)
    private void loardServiceFee() { 
        String redio = buttonGroup1.getSelection().getActionCommand();
        sCharge.setText(serviceMap.get(redio));
    }

    // update hall fees [btn : hallBtn]
    private void updateHallFee() {
        String fee = hallFee.getText().replace(",", "");
        String type = (String) hallTypes.getSelectedItem();
        if (Validator.AMOUNT.validate(fee)) {
            int status = JOptionPane.showConfirmDialog(this, "Are you sure you want to change the Class Room charges?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    DB.IUD("UPDATE `room_type` SET `fee`= '" + fee + "' WHERE `type`='" + type + "'");
                    loardHallType();
                    hallTypes.setSelectedItem(type);
                    JOptionPane.showMessageDialog(this, "Hall Fee Updated");
                } catch (ClassNotFoundException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
                } catch (SQLException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
                }
            } else {
                loardHallFee();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Fee", "Warning", JOptionPane.WARNING_MESSAGE);
            loardHallFee();
        }
    }

    // update EMP Salary fees [btn : salaryBtn]
    private void updateEmpSalary() {
        String salary = empSalary.getText().replace(",", "");
        String type = (String) empType.getSelectedItem();
        if (Validator.AMOUNT.validate(salary)) {
            int status = JOptionPane.showConfirmDialog(this, "Are you sure you want to change the Employee's Salary ?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    DB.IUD("UPDATE `emp_type` SET `salary`='" + salary + "' WHERE `name`='" + type + "'");
                    loardEMPypes();
                    empType.setSelectedItem(type);
                    JOptionPane.showMessageDialog(this, "Employee's Salary Updated");
                } catch (ClassNotFoundException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
                } catch (SQLException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
                }
            } else {
                loardSalary();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Salary", "Warning", JOptionPane.WARNING_MESSAGE);
            loardSalary();
        }
    }

    // update Service Fee [btn : salaryBtn]
    private void updateServiseFee() {
        String fee = sCharge.getText().replace(",", "");
        if (Validator.AMOUNT.validate(fee)) {
            int status = JOptionPane.showConfirmDialog(this, "Are you sure you want to change the Servise Charges ?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {
                try {
                    DB.IUD("UPDATE `service_charge` SET `fee`='" + fee + "' WHERE `service_type_id`='" + buttonGroup1.getSelection().getActionCommand() + "'");
                    loardserviceCharge();
                    loardServiceFee();
                    JOptionPane.showMessageDialog(this, "Servise Charges Updated");
                } catch (ClassNotFoundException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
                } catch (SQLException ex) {
                    LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
                }
            } else {
                loardServiceFee();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Fee", "Warning", JOptionPane.WARNING_MESSAGE);
            loardServiceFee();
        }
    }

    // reaset data fiels [brn: clean]
    private void cleanAll() {
        loardEMPypes();
        loardHallType();
        loardServiceFee();
    }

    //view Subjects In jTable [subjectTable]
    private void loardSubjects() {
        String name = subjectName.getText();
        try {
            ResultSet resultSet = DB.search("SELECT `name` FROM `subject` WHERE `name` LIKE '%" + name + "%' ");
            DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("name"));
                model.addRow(v);
            }
            subjectTable.setModel(model);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // View Grades on ComboBox [gradeCombo]
    private void loardGrades() {
        try {
            ResultSet resultSet = DB.search("SELECT * FROM `grade`");
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            comboBoxModel.addElement("Select a Grade");
            while (resultSet.next()) {
                comboBoxModel.addElement(resultSet.getString("name"));
            }
            gradeCombo.setModel(comboBoxModel);
            cleanGardes();
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // View Subject on jTbale [gradeTable]
    private void selectSubject() {
        try {
            int row = subjectTable.getSelectedRow();
            String query = "SELECT * FROM `subject`"
                    + "INNER JOIN `grade_has_subject` ON grade_has_subject.subject_id = subject.id "
                    + "INNER JOIN `grade` ON grade_has_subject.grade_id = grade.id "
                    + "WHERE `subject`.`name` = '" + subjectTable.getValueAt(row, 0) + "';";
            ResultSet resultSet = DB.search(query);

            DefaultTableModel model = (DefaultTableModel) gradeTable.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString(7)); // Grade Name
                model.addRow(vector);
            }
            gradeTable.setModel(model);
            loardGrades();
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // Clear Action on Subject Panal 
    private void clearSubject() {
        subjectTable.clearSelection();
        DefaultTableModel model = (DefaultTableModel) gradeTable.getModel();
        model.setRowCount(0);
        subjectName.setText("");
        loardSubjects();
        loardGrades();
    }

    // Remove Selected Subject Form ComboBox [gradeCombo]
    private void cleanGardes() {
        for (int row = 0; row < gradeTable.getRowCount(); row++) {
            Object cellValue = gradeTable.getValueAt(row, 0);
            gradeCombo.removeItem(cellValue);
        }
    }

    // View Added Grade of a Subject on jTbale [gradeTbale]
    private void addGrade() {
        if (subjectTable.getSelectedRow() >= 0) {
            if (gradeCombo.getSelectedItem().equals("Select a Grade")) {
                JOptionPane.showMessageDialog(this, "Please Select a Grade");
            } else {
                Object[] garde = {(String) gradeCombo.getSelectedItem()};
                DefaultTableModel model = (DefaultTableModel) gradeTable.getModel();
                model.addRow(garde);
                loardGrades();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Subject");
        }
    }

    // Remove Grade of a Subject From jTbale [gradeTbale]
    private void dropGrade() {
        if (gradeTable.getSelectedRow() >= 0) {
            int status = JOptionPane.showConfirmDialog(this, "Are you sure you want to Remove [" + gradeTable.getValueAt(gradeTable.getSelectedRow(), 0) + " ]", "Warning", JOptionPane.YES_NO_OPTION);
            if (status == JOptionPane.YES_OPTION) {

                DefaultTableModel model = (DefaultTableModel) gradeTable.getModel();
                model.removeRow(gradeTable.getSelectedRow());
                loardGrades();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Grade");
        }
    }

    // Update Subject data on Database 
    private void updateSubject() {
        String subject = (String) subjectTable.getValueAt(subjectTable.getSelectedRow(), 0);
        String delete = "DELETE `grade_has_subject` FROM `grade_has_subject` "
                + "INNER JOIN `subject` ON `subject`.`id` = `grade_has_subject`.`subject_id` "
                + "WHERE `subject`.`name` = '" + subject + "';";
        int rowCount = gradeTable.getRowCount();
        try {
            DB.IUD(delete);
            for (int row = 0; row < rowCount; row++) {
                DB.IUD("INSERT INTO grade_has_subject (`subject_id`, `grade_id`) "
                        + "SELECT subject.id, grade.id FROM subject `subject` "
                        + "INNER JOIN `grade` ON subject.name = '" + subject + "' AND grade.name = '" + gradeTable.getValueAt(row, 0) + "'");
            }
            clearSubject();
            cleanGardes();
            JOptionPane.showMessageDialog(this, "Subject Update Success", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }

    }

    // add new Subject to database 
    private void newSubject() {
        int subjectCount = subjectTable.getRowCount();
        if (subjectCount == 0) {
            try {
                DB.IUD("INSERT INTO `subject` (`name`) VALUES ('" + WordFormat.capitalizedStart(subjectName.getText()) + "')");
                JOptionPane.showMessageDialog(this, "New Subject Added [" + WordFormat.capitalizedStart(subjectName.getText()) + "]", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException ex) {
                LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
            } catch (SQLException ex) {
                LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
            }
        } else {
            if (subjectName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Subject Name is required", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "This subject already Exists", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // loard City into comboBox [city]
    private void loardCity() {
        try {
            ResultSet resultSet = DB.search("SELECT * FROM `city`");
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            comboBoxModel.addElement("Select City");
            while (resultSet.next()) {
                comboBoxModel.addElement(resultSet.getString("name"));
            }
            city.setModel(comboBoxModel);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Database Connecting Problem", ex);
        } catch (SQLException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "SQL Query Problem", ex);
        }
    }

    // update homeifo.ser file
    private void SaveHomeData() {
        try {
            String name = this.homeName.getText();
            String line1 = this.line01.getText();
            String line2 = this.line02.getText();
            String homeCity = (String) this.city.getSelectedItem();
            String phone1 = this.phone01.getText();
            String phone2 = this.phone02.getText();
            String phone3 = this.phone03.getText();
            String weblink = this.webLink.getText();
            String homeFax = this.fax.getText();
            String image = setLogo();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Institute name required",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (line1.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Address Line-01 required",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (line2.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Address Line-02 required",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (homeCity.equals("Select City")) {
                JOptionPane.showMessageDialog(
                        this,
                        "City required",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (phone1.isEmpty() & phone2.isEmpty() & phone3.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Least one mobile number required",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                new HomeInfo().setHome(new Home(name, line1, line2, homeCity, phone1, phone2, phone3, weblink, homeFax, image));
                loardHome();
                JOptionPane.showMessageDialog(this, "Home Information Update Success", "Data Update", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Error occurred while Updating Homeinfo", ex);
        }
    }
    // getdata from homenfo.ser

    private void loardHome() {
        try {
            Home home = new HomeInfo().getHome();

            this.homeName.setText(home.getHomeName());
            this.line01.setText(home.getLine01());
            this.line02.setText(home.getLine02());
            this.city.setSelectedItem(home.getCity());
            this.phone01.setText(home.getLine01());
            this.phone02.setText(home.getPhone02());
            this.phone03.setText(home.getPhone03());
            this.webLink.setText(home.getWebLink());
            this.fax.setText(home.getFax());
            logo.setIcon(new ImageIcon(home.getLogo()));
            SwingUtilities.updateComponentTreeUI(logo);
        } catch (IOException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Error occurred while Loarding Homeinfo", ex);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Error occurred while Loarding Homeinfo", ex);
        }
    }

    //validate and pic a image
    private void pickLogo() {
        JFileChooser chooser = new JFileChooser();
        int showOpenDialog = chooser.showOpenDialog(this);

        if (showOpenDialog == 0) {
            String filePath = chooser.getSelectedFile().getAbsolutePath();
            if (filePath.endsWith(".jpg") || filePath.endsWith(".png") || filePath.endsWith(".jpeg")) {
                String path = filePath.replace("\\", "/");
                logo.setIcon(new ImageIcon(filePath));
                logopath = path;
            } else {
                JOptionPane.showMessageDialog(this, "Please select a PNG,JPG,JPEG image file.", "Invalid File Type", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //  copy picked image into system data folders
    private String setLogo() {
        try {
            // Delete Old Image
            String oldImage = new HomeInfo().getHome().getLogo();
            if (logopath == null) {
                System.out.println("logosetre null out");
                return oldImage;
            }
            if (oldImage != null) {
                new File(oldImage).delete();
            }

            // create img Folder
            Files.createDirectories(Path.of(System.getProperty("user.dir") + "\\img\\"));

            //Copy New Image and Send Path
            Path sourcePath = Path.of(logopath);
            String[] imageName = logopath.split("/");
            String newPath = System.getProperty("user.dir") + "\\img\\" + imageName[imageName.length - 1];
            Path targetPath = Path.of(newPath);
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            return newPath;

        } catch (IOException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Error occurred while copying image", ex);
        } catch (ClassNotFoundException ex) {
            LogCenter.logger.log(java.util.logging.Level.WARNING, "Error occurred while copying image", ex);

        }
        return null;
    }
}
