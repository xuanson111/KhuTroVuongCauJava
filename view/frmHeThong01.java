package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class frmHeThong01 extends JFrame{
    private JPanel panelMain;
    private JButton thongKeButton;
    private JButton gopYButton;
    private JButton hoaDonButton;
    private JButton dangXuatButton;

    public frmHeThong01() {
        JFrame frame = new JFrame("Hệ thống");
        frame.setBounds(400, 200, 600, 400);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dangXuatButton.setMnemonic(KeyEvent.VK_Z);
        dangXuatButton.setToolTipText("ALT + Z");
        frame.setVisible(true);
        dangXuatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DangNhap();
            }
        });
        gopYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmPhieuGopYKH();
            }
        });
        hoaDonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmKhach_Hang();
            }
        });
        thongKeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmKHtkptrong();
            }
        });
    }
}
