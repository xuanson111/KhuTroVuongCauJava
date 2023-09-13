package org.example.view;

import org.example.controller.knThongKePhongTrong;
import org.example.model.LoaiPhong;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class frmKHtkptrong {
    private JPanel frmKHtkptrong;
    private JButton buttonQuaylai;
    private JTable table1;
    private JButton ButtonTimkiem;
    private JTextField txtTimkiem;
    private JButton buttonLammoi;
    DefaultTableModel model;
    ArrayList<LoaiPhong> list;

    public frmKHtkptrong() {
        JFrame frame = new JFrame("Thông kê phòng trống cho Khách hàng");
        frame.setBounds(400, 200, 800, 400);
        frame.setContentPane(frmKHtkptrong);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã phòng", "Loại phòng", "Giá phòng", "Diện tích", "Vật dụng"
        });
        showTableKHPhongTrong();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ButtonTimkiem.setMnemonic(KeyEvent.VK_O);
        ButtonTimkiem.setToolTipText("ALT + O");
        buttonLammoi.setMnemonic(KeyEvent.VK_A);
        buttonLammoi.setToolTipText("ALT + A");
        buttonQuaylai.setMnemonic(KeyEvent.VK_Z);
        buttonQuaylai.setToolTipText("ALT + Z");
        buttonLammoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTimkiem.setText("");
                model.setRowCount(0);
                showTableKHPhongTrong();
            }
        });
        buttonQuaylai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong01();
            }
        });

        ButtonTimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                list.clear();
                list = new knThongKePhongTrong().TimKiem(txtTimkiem.getText());
                int i = 1;
                for (LoaiPhong lp : list) {
                    model.addRow(new Object[]{
                            i++, lp.getMaPhong(), lp.getMaLoaiPhong(), lp.getGiaPhong(), lp.getDienTich(), lp.getVatDung()
                    });
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                JOptionPane.showMessageDialog(null, table1.getValueAt(row, col).toString());
                txtTimkiem.setText(table1.getValueAt(row, 2).toString());
            }
        });
    }
    public void showTableKHPhongTrong() {
        int i = 1;
        list = new knThongKePhongTrong().getListPhongTrong();
        for (LoaiPhong lp : list) {
            model.addRow(new Object[]{
                    i++, lp.getMaPhong(), lp.getMaLoaiPhong(), lp.getGiaPhong(), lp.getDienTich(), lp.getVatDung()});
        }
    }
}

