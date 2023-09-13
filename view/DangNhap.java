package org.example.view;

import org.example.controller.ketnoiHopDong;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;

public class DangNhap extends JFrame{
    private JPanel main;
    private JTextField taikhoan;
    private JPasswordField matkhau;
    private JButton dangNhapButton;
    private JButton thoatButton;

    public DangNhap() {
        this.dispose();
        JFrame frame = new JFrame("Đăng nhập");
        frame.setBounds(600, 200, 350, 250);
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dangNhapButton.setMnemonic(KeyEvent.VK_O);
        dangNhapButton.setToolTipText("ALT + O");
        thoatButton.setMnemonic(KeyEvent.VK_Z);
        thoatButton.setToolTipText("ALT + Z");
        frame.setVisible(true);
        thoatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        dangNhapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String TaiKhoan = taikhoan.getText();
                    String Matkhau = matkhau.getText();

                    String query = "select * from TaiKhoan where TaiKhoan = '" + TaiKhoan + "' and MatKhau ='" + Matkhau + "'";
                    ResultSet rs = new ketnoiHopDong().execute(query);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Đăng nhập thành công");
                        frame.dispose();
                        if (new ketnoiHopDong().getLoaiTaiKhoan(TaiKhoan, Matkhau).equals("Loai0") == true) {
                            new frmHeThong();
                        } else {
                            new frmHeThong01();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Đăng nhập thất bại");
                        taikhoan.setText("");
                        matkhau.setText("");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Đăng nhập thất bại");
                }
            }
        });
    }
}
