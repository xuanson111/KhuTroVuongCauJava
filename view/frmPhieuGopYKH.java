package org.example.view;

import org.example.controller.ketnoiPhieuGopY;
import org.example.model.PhieuGopY;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class frmPhieuGopYKH {
    private JTextField txtMaKH;
    private JTextField txtNoiDung;
    private JPanel panelMain;
    private JButton btnQuayLai;
    private JButton btnGopY;

    public frmPhieuGopYKH() {
        JFrame frame = new JFrame("Phiếu góp ý");
        frame.setBounds(500, 200, 500, 300);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btnGopY.setMnemonic(KeyEvent.VK_O);
        btnGopY.setToolTipText("ALT + O");
        btnQuayLai.setMnemonic(KeyEvent.VK_Z);
        btnQuayLai.setToolTipText("ALT + Z");
        frame.setVisible(true);

        btnGopY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maphieu = "MP_" + txtMaKH.getText();
                String makh = txtMaKH.getText();
                String noidung = txtNoiDung.getText();
                PhieuGopY phieu = new PhieuGopY();

                try {
                    String query = "select * from PhieuGopY where MaPhieu = '" + maphieu + "'";
                    ResultSet rs = new ketnoiPhieuGopY().execute(query);
                    if (rs.next()) {
                        phieu.setMaKH(makh);
                        phieu.setNoiDung(noidung);
                        boolean check = new ketnoiPhieuGopY().updatePhieu(phieu);
                        if (check) {
                            JOptionPane.showMessageDialog(frame, "Cảm ơn bạn đã góp ý");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Xin hãy điền đầy đủ thông tin");
                        }
                    } else {
                        phieu.setMaPhieu(maphieu);
                        phieu.setMaKH(makh);
                        phieu.setNoiDung(noidung);
                        boolean check = new ketnoiPhieuGopY().insertPhieu(phieu);
                        if (check) {
                            JOptionPane.showMessageDialog(frame, "Cảm ơn bạn đã góp ý");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Xin hãy điền đầy đủ thông tin");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong01();
            }
        });
    }
}
