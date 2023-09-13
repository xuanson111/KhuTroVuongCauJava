package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class frmHeThong extends JFrame{
    private JButton btnThongTinPT;
    private JButton thongTinKhachHangButton;
    private JButton dangXuatButton;
    private JButton hopDongButton;
    private JButton gopYButton;
    private JButton hoaDonButton;
    private JButton thongKePhongTrongButton;
    private JButton DSphongButton;
    private JPanel panelMain;
    private JButton KHbntThueTheoPhong;
    DefaultTableModel model;

    public frmHeThong() {
        JFrame frame = new JFrame("Hệ thống");
        frame.setBounds(400, 200, 600, 400);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        dangXuatButton.setMnemonic(KeyEvent.VK_Z);
        dangXuatButton.setToolTipText("ALT + Z");
        hopDongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Hopdong();
            }
        });
        dangXuatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DangNhap();
            }
        });

        KHbntThueTheoPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmKHThueTheoPhong();
            }
        });
        gopYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmPhieuGopY();
            }
        });
        thongTinKhachHangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmKhachHang();
            }
        });
        DSphongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmDSThue();
            }
        });
        hoaDonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHoa_don();
            }
        });
        thongKePhongTrongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmThongKePhongTrong();
            }
        });
        btnThongTinPT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmThongTinPhongTro();
            }
        });
    }
}
