package org.example.view;

import org.example.model.DSThue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmDSThue extends JFrame{
    private JTextField txtMaLoaiPhong;
    private JButton btnTimKiem;
    private JTable jTable1;
    private JPanel panelMain;
    private JButton btnLamMoi;
    private JButton btnThoat;

    ArrayList<DSThue> list;
    DefaultTableModel model;
    public frmDSThue() {
        JFrame frm = new JFrame("Danh sách thuê");
        frm.setContentPane(panelMain);
//        frm.setSize(800, 400);
        frm.setBounds(500, 200, 800, 400);
        list = new org.example.controller.knDSThue().getListPhong();
        btnLamMoi.setMnemonic(KeyEvent.VK_A);
        btnLamMoi.setToolTipText("ALT + A");
        btnThoat.setMnemonic(KeyEvent.VK_Z);
        btnThoat.setToolTipText("ALT + Z");
        btnTimKiem.setMnemonic(KeyEvent.VK_O);
        btnTimKiem.setToolTipText("ALT + O");
        createTable();
        showTable();

        frm.setVisible(true);
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                txtMaLoaiPhong.setText("");
                showTable();
            }
        });
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                list.clear();
                list = new org.example.controller.knDSThue().timKiem(txtMaLoaiPhong.getText());
                int i=1;
                for (DSThue thue : list) {
                    model.addRow(new Object[]{i++, thue.getMaPhong(), thue.getMaLoaiPhong(), thue.getGiaPhong(), thue.getDienTich(), thue.getVatDung(), thue.getSoKhach()});
                }
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
                new frmHeThong();
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = jTable1.getSelectedRow();
                int col = jTable1.getSelectedColumn();
                JOptionPane.showMessageDialog(null, jTable1.getValueAt(row, col).toString());
                txtMaLoaiPhong.setText(jTable1.getValueAt(row, 2).toString());
            }
        });
    }

    public void createTable(){
        model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT","MaPhong", "MaLoaiPhong", "GiaPhong", "DienTich","VatDung","SoKhach"
        });
    }


    public void showTable() {
        int i=1;
        list = new org.example.controller.knDSThue().getListPhong();
        for (DSThue thue : list) {
            model.addRow(new Object[]{i++, thue.getMaPhong(), thue.getMaLoaiPhong(), thue.getGiaPhong(), thue.getDienTich(), thue.getVatDung(), thue.getSoKhach()});
        }
    }
}
