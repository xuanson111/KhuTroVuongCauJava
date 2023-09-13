package org.example.view;

import org.example.controller.connect;
import org.example.model.phong_tro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmKhach_Hang {
    private JTable table1;
    private JButton btnTimkiem;
    private JButton btnQuaylai;
    private JButton btnLammoi;
    private JPanel Khach_hang;
    private JTextField txtMaph_timkiem;
    private JTextField txtThang_timkiem;
    private JTextField txtNam_timkiem;
    DefaultTableModel model;
    ArrayList<phong_tro>list;

public frmKhach_Hang() {
    JFrame frame = new JFrame("Hóa đơn");
    frame.setBounds(400, 200, 800, 400);
    frame.setContentPane(Khach_hang);
    model = (DefaultTableModel) table1.getModel();
    model.setColumnIdentifiers(new Object[]{
            "STT", "Mã hóa đơn", "Mã phòng", "Số điện", "Số nước", "Tháng","Năm","Hạn thanh toán", "Tổng tiền"
    });
    showTableHoaDon();
    btnLammoi.setMnemonic(KeyEvent.VK_A);
    btnLammoi.setToolTipText("ALT + A");
    btnQuaylai.setMnemonic(KeyEvent.VK_Z);
    btnQuaylai.setToolTipText("ALT + Z");
    btnTimkiem.setMnemonic(KeyEvent.VK_O);
    btnTimkiem.setToolTipText("ALT + O");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    btnTimkiem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnLammoi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            txtMaph_timkiem.setText("");
            txtThang_timkiem.setText("");
            txtNam_timkiem.setText("");
            //list.clear();
            showTableHoaDon();
        }
    });
    btnQuaylai.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new frmHeThong01();
        }
    });

    btnTimkiem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            list.clear();
            list = new connect().TimKiem(txtMaph_timkiem.getText(),Integer.parseInt(txtThang_timkiem.getText()),Integer.parseInt(txtNam_timkiem.getText()));
            int i = 1;
            for (phong_tro pt : list) {
                model.addRow(new Object[] {
                        i++, pt.getMahd(), pt.getMaphong(), pt.getSodien(), pt.getSonuoc(), pt.getThang(),pt.getNam(),pt.getHanthanhtoan(),pt.gettongtien()
                });
            }
        }
    });

}
    public void showTableHoaDon() {
        int i = 1;
        list = new connect().getListHoaDon();
        for (phong_tro hd : list) {
            model.addRow(new Object[]{
                    i++, hd.getMahd(), hd.getMaphong(), hd.getSodien(), hd.getSonuoc(), hd.getThang(),hd.getNam(),hd.getHanthanhtoan(), hd.gettongtien()
            });
        }
    }
}
