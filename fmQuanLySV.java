package asm_java3;
import java.awt.Image;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

    // khai bao ds nv 
public class fmQuanLySV extends javax.swing.JFrame {
        String imageName = null;
        String loi = "no avatar";
        String strHINH=null;
        Icon icon = null;
    ArrayList<STD> list = new ArrayList<>();
    public void load_data()
    { 
        
        list.clear();
        try {
            // url
           String url = "jdbc:sqlserver://localhost:1433;databaseName =ts00531_huynhthibaotran_soft203_asm";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. Tạo 1 Connection để kết nối
            Connection con = DriverManager.getConnection(url,"sa","123");
            // tao preparedStatement
            PreparedStatement ps = con.prepareStatement("select * from Students");
            // tao resultset
            ResultSet rs = ps.executeQuery(); // thi hanh cau lenh
            // dung vong lap duyet qua tung dong
            DefaultTableModel model = (DefaultTableModel) tblBangdiem.getModel();
            model.setRowCount(0); // Xóa tất cả các dòng trong bảng
            while(rs.next())
            {
                // tao 1 doi tuong sv
                STD sv = new STD();
                sv.setIDSV(rs.getString("MaSV"));
                sv.setName(rs.getString("HoTen"));
                sv.setEmail(rs.getString("Email"));
                sv.setSdt(rs.getString("SoDT"));
                sv.setSex(rs.getBoolean("GioiTinh"));
                sv.setAddress(rs.getString("DiaChi"));
                sv.setImg(rs.getString("Hinh"));
                // them sv vao ds
                list.add(sv);
                // Tạo một đối tượng DefaultTableModel để quản lý dữ liệu của bảng

                // Thêm dòng mới với dữ liệu tương ứng vào bảng
                model.addRow(new Object[]{
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("Email"),
                    rs.getString("SoDT"),
                    rs.getBoolean("GioiTinh"),
                    rs.getString("DiaChi"),
                    rs.getString("Hinh")
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//public void upImage(String imageName) {
     //   ImageIcon icon = new ImageIcon("D:\\code ki 2\\Khoi dau\\Java\\java kì 2\\lab2\\ngay2_thamkhao\\ASM_java3\\ASM_java3\\src\\asm_java3\\img" + imageName);
      //  Image image = icon.getImage();
      //  ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), image.SCALE_SMOOTH));
        
        
   // }
        int index = 0;
        public void showDetails() {
        //1. xác định đang click vào vị trị hàng nào của bảng       
        //2. Lấy ra nhân viên tại vị trị index
        STD emp = list.get(index);
        //3. Hiện thị chi tiết thông tin của nhân viên emp lên các controls
        txtID.setText(emp.getIDSV());
        txtIName.setText(emp.getName());
        txtEmail.setText("" + emp.getEmail());
        if (emp.getSex()) {
        btnSex.setSelectedItem("Nam");
    } else {
        btnSex.setSelectedItem("Nữ");
    }
        txtISDT.setText(emp.getSdt());
        txtIAdress.setText(emp.getAddress());
            lblHinh.setText(emp.getImg());
    }
    public fmQuanLySV() {
        initComponents();
        load_data();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSex = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtIAdress = new javax.swing.JTextField();
        btnUpdate1 = new javax.swing.JToggleButton();
        btnNew = new javax.swing.JToggleButton();
        btnDelete1 = new javax.swing.JToggleButton();
        btnSave1 = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangdiem = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtISDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Quản Lý SV");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Họ Tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã SV:");

        txtIName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtINameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giới Tính:");

        btnSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        btnSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSexActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/update-icon.png"))); // NOI18N
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-New-icon.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-Close-icon.png"))); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/save-icon.png"))); // NOI18N
        btnSave1.setText("Save");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        tblBangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MSSV", "Họ tên", "Email", "SĐT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ));
        tblBangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangdiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangdiem);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("SĐT:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-First-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-Rewind-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-Forward-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASM_java3/Button-Last-icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSex, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(txtISDT, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(29, 29, 29)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtIName, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete1)
                            .addComponent(btnUpdate1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtINameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtINameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtINameActionPerformed

    private void btnSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSexActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
        try {
            // url
            String url = "jdbc:sqlserver://localhost:1433;databaseName =ts00531_huynhthibaotran_soft203_asm";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. Tạo 1 Connection để kết nối
            Connection con = DriverManager.getConnection(url,"sa","123");
            // tao preparedStatement
            upImage(imageName);
            PreparedStatement ps = con.prepareStatement("insert into Students values(?,?,?,?,?,?,?)");
            // gan gia tri cho tham so
            ps.setString(1, txtID.getText());
            ps.setString(2, txtIName.getText());
            ps.setString(3, txtEmail.getText());
            ps.setString(4, txtISDT.getText());
            ps.setBoolean(5, "Nam".equals(btnSex.getSelectedItem()) ? true : false);
            ps.setString(6, txtIAdress.getText());
           
            ps.setString(7,strHINH ); 
            
            
        
            // thi hanh 
            int kq = ps.executeUpdate();
            if(kq == 1)
            {
                JOptionPane.showMessageDialog(this, "them thanh cong");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "them that bai");
            }
            // dong connect
            ps.close();
            con.close();
            // load data
            load_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
                try {
            // url
            String url = "jdbc:sqlserver://localhost:1433;databaseName =ts00531_huynhthibaotran_soft203_asm";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. Tạo 1 Connection để kết nối
            Connection con = DriverManager.getConnection(url,"sa","123");
            // tao preparedStatement
            PreparedStatement ps = con.prepareStatement("delete from Students where MaSV = ?");
            // gan gia tri cho tham so
            ps.setString(1, txtID.getText());
            // thi hanh 
            int kq = ps.executeUpdate();
            if(kq == 1)
            {
                JOptionPane.showMessageDialog(this, "xoa thanh cong");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "xoa that bai");
            }
            // dong connect
            ps.close();
            con.close();
            // load data
            load_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
                try {
            // url
             String url = "jdbc:sqlserver://localhost:1433;databaseName =ts00531_huynhthibaotran_soft203_asm";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. Tạo 1 Connection để kết nối
            Connection con = DriverManager.getConnection(url,"sa","123");
            // tao preparedStatement
            PreparedStatement ps = con.prepareStatement("update Students set HoTen = ? , Email = ?, SoDT = ?, GioiTinh = ?, DiaChi = ?, Hinh = ? where MaSV = ? ");
            // gan gia tri cho tham so
            ps.setString(7, txtID.getText());
            ps.setString(1, txtIName.getText());
            ps.setString(2, txtEmail.getText());
            ps.setString(3, txtISDT.getText());
            ps.setBoolean(4, "Nam".equals(btnSex.getSelectedItem()) ? true : false);
            ps.setString(5, txtIAdress.getText());
            ps.setString(6,"miinmeow.jpg\"");
            // thi hanh 
            int kq = ps.executeUpdate();
            if(kq == 1)
            {
                JOptionPane.showMessageDialog(this, "update thanh cong");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "update that bai");
            }
            // dong connect
            ps.close();
            con.close();
            // load data
            load_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed
public void reset(){   txtID.setText("");
        txtIName.setText("");
        txtEmail.setText("");
        txtISDT.setText("");
        txtIAdress.setText("");
        lblHinh.setIcon(null);
        lblHinh.setText("");
        
        //2. con nhảy focus tại txtMANV
   }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      reset();
     
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblBangdiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangdiemMouseClicked
        index = tblBangdiem.getSelectedRow();
        showDetails();
        
    }//GEN-LAST:event_tblBangdiemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        index = 0;
        tblBangdiem.setRowSelectionInterval(index, index);
        showDetails();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        index = list.size()-1;
        tblBangdiem.setRowSelectionInterval(index, index);
        showDetails();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(index > 0)
       {
           index --;
           tblBangdiem.setRowSelectionInterval(index, index);
           showDetails();
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(index < list.size()-1)
       {
           index ++;
           tblBangdiem.setRowSelectionInterval(index, index);
           showDetails();
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                Image img = ImageIO.read(file);
                 strHINH=file.getName();
                lblHinh.setText("");
                int width = lblHinh.getWidth();
                int height=lblHinh.getHeight();
               
                lblHinh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
                
            } catch (IOException ex) {
                System.out.println("lỗi"+ex.toString());            }
       
    }//GEN-LAST:event_lblHinhMouseClicked
  

        
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmQuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmQuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmQuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmQuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                JFrame fm = new fmQuanLySV();
                fm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDelete1;
    private javax.swing.JToggleButton btnNew;
    private javax.swing.JToggleButton btnSave1;
    private javax.swing.JComboBox<String> btnSex;
    private javax.swing.JToggleButton btnUpdate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JTable tblBangdiem;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIAdress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIName;
    private javax.swing.JTextField txtISDT;
    // End of variables declaration//GEN-END:variables
}
