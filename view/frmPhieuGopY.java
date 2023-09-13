package org.example.view;

import org.example.model.PhieuGopY;
import org.example.controller.ketnoiPhieuGopY;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmPhieuGopY {
    private JPanel panel1;
    private JTable table1;
    private JButton btnQuayLai;
    private JButton btnXoa;
    private JTextField txtMaPhieu;
    private JButton btnLamMoi;

    DefaultTableModel model;
    ArrayList<PhieuGopY> list;

    public frmPhieuGopY() {
        JFrame frame = new JFrame("Phiếu góp ý");
        frame.setBounds(500, 200, 700, 400);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã phiêu", "Mã khách hàng", "Nội dung"
        });
        showTablePhieu();
        btnLamMoi.setMnemonic(KeyEvent.VK_A);
        btnLamMoi.setToolTipText("ALT + A");
        btnXoa.setMnemonic(KeyEvent.VK_X);
        btnXoa.setToolTipText("ALT + X");
        btnQuayLai.setMnemonic(KeyEvent.VK_Z);
        btnQuayLai.setToolTipText("ALT + Z");
        frame.setVisible(true);

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = new ketnoiPhieuGopY().deletePhieu(txtMaPhieu.getText());
                if (check) {
                    JOptionPane.showMessageDialog(frame, "Xóa thành công");
                    btnLamMoi.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "Xóa thất bại");
                }
            }
        });
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                txtMaPhieu.setText("");
                showTablePhieu();
            }
        });
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                JOptionPane.showMessageDialog(null, table1.getValueAt(row, col).toString());
                txtMaPhieu.setText(table1.getValueAt(row, 1).toString());
            }
        });
    }

    public void showTablePhieu() {
        int i = 1;
        list = new ketnoiPhieuGopY().getListPhieu();
        for (PhieuGopY hd : list) {
            model.addRow(new Object[]{
                    i++, hd.getMaPhieu(), hd.getMaKH(), hd.getNoiDung()
            });
        }
    }
}
