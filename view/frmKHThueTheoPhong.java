package org.example.view;

import org.example.controller.ketnoiKHThue;
import org.example.model.KHThueTheoPhong;
import org.example.model.KHThueTheoPhong1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class frmKHThueTheoPhong {
    private JPanel panelMain;
    private JTable table1;
    private JButton btnQuayLai;
    private JButton btnLamMoi;
    private JTextField txtMaPhong;
    private JButton xemButton;
    DefaultTableModel model;

    ArrayList<KHThueTheoPhong> list;
    ArrayList<KHThueTheoPhong1> list1;

    public frmKHThueTheoPhong() {
        JFrame frame = new JFrame("Thống kê khách hàng thuê theo phòng");
        frame.setBounds(500, 200, 700, 400);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã phòng", "Số lượng khách hàng"
        });
        showTable();
        btnLamMoi.setMnemonic(KeyEvent.VK_A);
        btnLamMoi.setToolTipText("ALT + A");
        btnQuayLai.setMnemonic(KeyEvent.VK_Z);
        btnQuayLai.setToolTipText("ALT + Z");
        xemButton.setMnemonic(KeyEvent.VK_O);
        xemButton.setToolTipText("ALT + O");
        frame.setVisible(true);

        xemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnCount(0);
                model.setRowCount(0);
                model = (DefaultTableModel) table1.getModel();
                model.setColumnIdentifiers(new Object[]{
                        "STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số CCND", "Số điện thoại"
                });
                showTalbe1(txtMaPhong.getText());
            }
        });
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnCount(0);
                model.setRowCount(0);
                model = (DefaultTableModel) table1.getModel();
                model.setColumnIdentifiers(new Object[]{
                        "STT", "Mã phòng", "Số lượng khách hàng"
                });
                txtMaPhong.setText("");
                showTable();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();

                JOptionPane.showMessageDialog(null, table1.getValueAt(row, col));
                txtMaPhong.setText(table1.getValueAt(row, 1).toString());
            }
        });
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong();
            }
        });
    }

    public void showTable() {
        int i = 1;
        list = new ketnoiKHThue().getListKHThueTheoPhong();
        for (KHThueTheoPhong kh : list) {
            model.addRow(new Object[] {
                    i++, kh.getMaPhong(), kh.getSoLuong()
            });
        }
    }

    public void showTalbe1(String maphong) {
        int i = 1;
        list1 = new ketnoiKHThue().getListKHThueTheoPhong1(maphong);
        for (KHThueTheoPhong1 kh : list1) {
            model.addRow(new Object[]{
                    i++, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDiaChi(), kh.getSoCMND(), kh.getSoDienThoai()
            });
        }

    }
}
