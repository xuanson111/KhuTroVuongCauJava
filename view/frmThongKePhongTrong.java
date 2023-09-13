package org.example.view;

import org.example.controller.knThongKePhongTrong;
import org.example.model.LoaiPhong;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmThongKePhongTrong {
    private JPanel frmThongKePhongTrong;
    private JButton btnQuayLai;
    private JTable table1;
    private JButton ButtonTimKiem;
    private JTextField txtTimkiem;
    private JButton buttonLammoi;
    DefaultTableModel model;
    ArrayList<LoaiPhong> list;

    public frmThongKePhongTrong() {
        JFrame frame = new JFrame("Thông kê phòng trống");
        frame.setBounds(400, 200, 800, 400);
        frame.setContentPane(frmThongKePhongTrong);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã phòng", "Loại phòng", "Giá phòng", "Diện tích", "Vật dụng"
        });
        showTablePhongTrong();
        ButtonTimKiem.setMnemonic(KeyEvent.VK_O);
        ButtonTimKiem.setToolTipText("ALT + O");
        buttonLammoi.setMnemonic(KeyEvent.VK_A);
        buttonLammoi.setToolTipText("ALT + A");
        btnQuayLai.setMnemonic(KeyEvent.VK_Z);
        btnQuayLai.setToolTipText("ALT + Z");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ButtonTimKiem.addActionListener(new ActionListener() {
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

        buttonLammoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTimkiem.setText("");
                model.setRowCount(0);
                showTablePhongTrong();
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
                txtTimkiem.setText(table1.getValueAt(row, 2).toString());
            }
        });
    }
    public void showTablePhongTrong() {
        int i = 1;
        list = new knThongKePhongTrong().getListPhongTrong();
        for (LoaiPhong lp : list) {
            model.addRow(new Object[]{
                    i++, lp.getMaPhong(), lp.getMaLoaiPhong(), lp.getGiaPhong(), lp.getDienTich(), lp.getVatDung()});
        }
    }
}
