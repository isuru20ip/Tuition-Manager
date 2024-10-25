package GUI;

import GUI.panal.ClassManagement;
import GUI.panal.ClassScheduleManagement;
import GUI.panal.CourseManagement;
import GUI.panal.Dashboard_sub;
import GUI.panal.PaymentManagement;
import GUI.panal.Reporting;
import GUI.panal.Settings;
// import GUI.panal.Settings;
import GUI.panal.StudentAttendance;
import GUI.panal.StudentManagement;
import GUI.panal.TeacherManagement;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import GUI.panal.EmployeeSalaryCalculation;
import GUI.panal.EmployeeManagement;
import GUI.panal.EnrollmentManagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JFrame {

    Dashboard_sub panel = new Dashboard_sub();
    
    public Dashboard() {
        initComponents();
        time();
        date();
        main.add(panel);

    }

    //Time
    Timer t;
    SimpleDateFormat st;

    public void time() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");

                String tt = st.format(dt);
                time.setText(tt);

            }
        });
        t.start();

    }

    //Date
    public void date() {
        DateTimeFormatter dates = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        date.setText(dates.format(now));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        dashboard = new javax.swing.JButton();
        student_management = new javax.swing.JButton();
        teacher_management = new javax.swing.JButton();
        class_management = new javax.swing.JButton();
        course_management = new javax.swing.JButton();
        hall_management = new javax.swing.JButton();
        student_enrollment = new javax.swing.JButton();
        class_schedule = new javax.swing.JButton();
        attendance = new javax.swing.JButton();
        payment_management = new javax.swing.JButton();
        employee_management = new javax.swing.JButton();
        employee_salary = new javax.swing.JButton();
        system_access = new javax.swing.JButton();
        reports = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setEndColor(new java.awt.Color(255, 51, 204));
        kGradientPanel1.setStartColor(new java.awt.Color(51, 255, 255));

        jPanel6.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Main logo.png"))); // NOI18N

        jPanel7.setOpaque(false);

        dashboard.setBackground(new java.awt.Color(153, 255, 102));
        dashboard.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/dashboard icon.png"))); // NOI18N
        dashboard.setText(" Dashboard");
        dashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dashboard.setContentAreaFilled(false);
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardMousePressed(evt);
            }
        });
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        student_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        student_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/student.png"))); // NOI18N
        student_management.setText(" Student Management");
        student_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_management.setContentAreaFilled(false);
        student_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_managementActionPerformed(evt);
            }
        });

        teacher_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        teacher_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/teacher.png"))); // NOI18N
        teacher_management.setText(" Teacher Management");
        teacher_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        teacher_management.setContentAreaFilled(false);
        teacher_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacher_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacher_managementActionPerformed(evt);
            }
        });

        class_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        class_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/add class.png"))); // NOI18N
        class_management.setText(" Class Management");
        class_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        class_management.setContentAreaFilled(false);
        class_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        class_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_managementActionPerformed(evt);
            }
        });

        course_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        course_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/course.png"))); // NOI18N
        course_management.setText(" Course Management");
        course_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        course_management.setContentAreaFilled(false);
        course_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        course_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_managementActionPerformed(evt);
            }
        });

        hall_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        hall_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/hall.png"))); // NOI18N
        hall_management.setText(" Hall Management");
        hall_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        hall_management.setContentAreaFilled(false);
        hall_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hall_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hall_managementActionPerformed(evt);
            }
        });

        student_enrollment.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        student_enrollment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/student enroll.png"))); // NOI18N
        student_enrollment.setText(" Student Enrollment");
        student_enrollment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_enrollment.setContentAreaFilled(false);
        student_enrollment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_enrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_enrollmentActionPerformed(evt);
            }
        });

        class_schedule.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        class_schedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/add class.png"))); // NOI18N
        class_schedule.setText(" Class Schedule Management");
        class_schedule.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        class_schedule.setContentAreaFilled(false);
        class_schedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        class_schedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_scheduleActionPerformed(evt);
            }
        });

        attendance.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/attendance.png"))); // NOI18N
        attendance.setText(" Attendance");
        attendance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        attendance.setContentAreaFilled(false);
        attendance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceActionPerformed(evt);
            }
        });

        payment_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        payment_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/payment.png"))); // NOI18N
        payment_management.setText(" Payment Management");
        payment_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        payment_management.setContentAreaFilled(false);
        payment_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_managementActionPerformed(evt);
            }
        });

        employee_management.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        employee_management.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/employee.png"))); // NOI18N
        employee_management.setText(" Employee Management");
        employee_management.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        employee_management.setContentAreaFilled(false);
        employee_management.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_managementActionPerformed(evt);
            }
        });

        employee_salary.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        employee_salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/payment.png"))); // NOI18N
        employee_salary.setText(" Salary Calculation");
        employee_salary.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        employee_salary.setContentAreaFilled(false);
        employee_salary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_salaryActionPerformed(evt);
            }
        });

        system_access.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        system_access.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/access.png"))); // NOI18N
        system_access.setText(" System access management");
        system_access.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        system_access.setContentAreaFilled(false);
        system_access.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        reports.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/reports.png"))); // NOI18N
        reports.setText(" Reports");
        reports.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reports.setContentAreaFilled(false);
        reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsActionPerformed(evt);
            }
        });

        settings.setFont(new java.awt.Font("SchulbuchNord", 0, 14)); // NOI18N
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/settings.png"))); // NOI18N
        settings.setText(" Settings");
        settings.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settings.setContentAreaFilled(false);
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(system_access)
                    .addComponent(settings)
                    .addComponent(reports)
                    .addComponent(student_enrollment)
                    .addComponent(class_schedule)
                    .addComponent(attendance)
                    .addComponent(employee_management)
                    .addComponent(payment_management)
                    .addComponent(class_management)
                    .addComponent(hall_management)
                    .addComponent(course_management)
                    .addComponent(employee_salary)
                    .addComponent(dashboard)
                    .addComponent(student_management)
                    .addComponent(teacher_management))
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(student_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(teacher_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(class_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(course_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hall_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(student_enrollment, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(class_schedule, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payment_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employee_management, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employee_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(system_access, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reports, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton15.setBackground(new java.awt.Color(255, 51, 204));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/logout.png"))); // NOI18N
        jButton15.setText("Log Out");
        jButton15.setAlignmentX(0.5F);
        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton15)))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(234, 238, 244));

        time.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        time.setText("Time");

        date.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        date.setText("Date");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/user.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/bell.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        main.setBackground(new java.awt.Color(234, 238, 244));
        main.setPreferredSize(new java.awt.Dimension(967, 668));
        main.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        loadPanal(new Dashboard_sub());
    }//GEN-LAST:event_dashboardActionPerformed

    private void student_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_managementActionPerformed
        loadPanal(new StudentManagement());
    }//GEN-LAST:event_student_managementActionPerformed

    private void teacher_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_managementActionPerformed
        loadPanal(new TeacherManagement());
    }//GEN-LAST:event_teacher_managementActionPerformed

    private void class_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_managementActionPerformed
        loadPanal(new ClassManagement());
    }//GEN-LAST:event_class_managementActionPerformed

    private void course_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_managementActionPerformed
        loadPanal(new CourseManagement());
    }//GEN-LAST:event_course_managementActionPerformed

    private void hall_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hall_managementActionPerformed

    }//GEN-LAST:event_hall_managementActionPerformed

    private void student_enrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_enrollmentActionPerformed
        loadPanal(new EnrollmentManagement(this));
    }//GEN-LAST:event_student_enrollmentActionPerformed

    private void class_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_scheduleActionPerformed
        loadPanal(new ClassScheduleManagement(this));
    }//GEN-LAST:event_class_scheduleActionPerformed

    private void attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceActionPerformed
        loadPanal(new StudentAttendance());
    }//GEN-LAST:event_attendanceActionPerformed

    private void payment_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_managementActionPerformed
        loadPanal(new PaymentManagement());
    }//GEN-LAST:event_payment_managementActionPerformed

    private void employee_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_managementActionPerformed
        loadPanal(new EmployeeManagement());
    }//GEN-LAST:event_employee_managementActionPerformed

    private void employee_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_salaryActionPerformed
        loadPanal(new EmployeeSalaryCalculation());
    }//GEN-LAST:event_employee_salaryActionPerformed

    private void reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsActionPerformed
        loadPanal(new Reporting());
    }//GEN-LAST:event_reportsActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        loadPanal(new Settings());
    }//GEN-LAST:event_settingsActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void dashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMousePressed

        
    }//GEN-LAST:event_dashboardMousePressed

    private void dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseEntered
        dashboard.setBackground(Color.red);
    }//GEN-LAST:event_dashboardMouseEntered

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendance;
    private javax.swing.JButton class_management;
    private javax.swing.JButton class_schedule;
    private javax.swing.JButton course_management;
    private javax.swing.JButton dashboard;
    private javax.swing.JLabel date;
    private javax.swing.JButton employee_management;
    private javax.swing.JButton employee_salary;
    private javax.swing.JButton hall_management;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPanel main;
    private javax.swing.JButton payment_management;
    private javax.swing.JButton reports;
    private javax.swing.JButton settings;
    private javax.swing.JButton student_enrollment;
    private javax.swing.JButton student_management;
    private javax.swing.JButton system_access;
    private javax.swing.JButton teacher_management;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    private void loadPanal(JPanel panal) {
        main.removeAll();
        main.add(panal, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(main);
    }
}
