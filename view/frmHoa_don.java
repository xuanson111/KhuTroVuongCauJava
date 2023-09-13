package org.example.view;

import org.example.controller.connect;
import org.example.model.phong_tro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class frmHoa_don {
    private JTable table1;
    private JTextField txtHantt;
    private JTextField txtMahd;
    private JTextField txtNam;
    private JTextField txtThang;
    private JTextField txtMaph;
    private JTextField txtSodien;
    private JTextField txtSonuoc;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnQuaylai;
    private JPanel Hoa_don;
    private JButton timKiemButton;
    private JTextField txtMaphong_timkiem;
    private JTextField txtThang_timkiem;
    private JTextField txtNam_timkiem;
    private JButton btnLammoi;
    DefaultTableModel model;
    ArrayList<phong_tro> list;
public frmHoa_don() {
    JFrame frame = new JFrame("Hóa đơn");
    frame.setBounds(400, 200, 800, 500);
    frame.setContentPane(Hoa_don);
    model = (DefaultTableModel) table1.getModel();
    model.setColumnIdentifiers(new Object[]{
            "STT", "Mã hóa đơn", "Mã phòng", "Số điện", "Số nước", "Tháng","Năm","Hạn thanh toán", "Tổng tiền"
    });
    showTableHoaDon();
    btnLammoi.setMnemonic(KeyEvent.VK_A);
    btnLammoi.setToolTipText("ALT + A");
    btnQuaylai.setMnemonic(KeyEvent.VK_Z);
    btnQuaylai.setToolTipText("ALT + Z");
    timKiemButton.setMnemonic(KeyEvent.VK_O);
    timKiemButton.setToolTipText("ALT + O");
    btnThem.setMnemonic(KeyEvent.VK_I);
    btnThem.setToolTipText("ALT + I");
    btnSua.setMnemonic(KeyEvent.VK_E);
    btnSua.setToolTipText("ALT + E");
    btnXoa.setMnemonic(KeyEvent.VK_X);
    btnXoa.setToolTipText("ALT + X");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    float tongtien;
    btnThem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                phong_tro hd = new phong_tro();
                hd.setMahd(txtMahd.getText());
                hd.setMaphong(txtMaph.getText());
                hd.setSodien(Integer.parseInt(txtSodien.getText()));
                hd.setSonuoc(Integer.parseInt(txtSonuoc.getText()));
                hd.setThang(Integer.parseInt(txtThang.getText()));
                hd.setNam(Integer.parseInt(txtNam.getText()));
                try {
                    hd.setHanthanhtoan(new SimpleDateFormat("dd/MM/yyyy").parse(txtHantt.getText()));
                } catch (ParseException ex) {
                }

                boolean check = new connect().addHoaDon(hd);
                if (check) {
                    JOptionPane.showMessageDialog(frame, "Thêm thành công");
                    btnLammoi.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "Thêm thất bại");

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin");
            }
        }
    });
    btnXoa.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean check = new connect().deleteHoaDon(txtMahd.getText());
            if (check) {
                JOptionPane.showMessageDialog(frame, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(frame, "Xóa thất bại");
            }
            btnLammoi.doClick();
        }
    });
    btnSua.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                phong_tro hd = new phong_tro();
                hd.setMahd(txtMahd.getText());
                hd.setMaphong(txtMaph.getText());
                hd.setSodien(Integer.parseInt(txtSodien.getText()));
                hd.setSonuoc(Integer.parseInt(txtSonuoc.getText()));
                hd.setThang(Integer.parseInt(txtThang.getText()));
                hd.setNam(Integer.parseInt(txtNam.getText()));
                try {
                    hd.setHanthanhtoan(new SimpleDateFormat("dd/MM/yyyy").parse(txtHantt.getText()));
                } catch (ParseException ex) {
                }
                boolean check = new connect().UpdateHoaDon(hd);

                if (check) {
                    JOptionPane.showMessageDialog(frame, "Sửa thành công");
                    btnLammoi.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "Sửa thất bại");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin");
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

            txtMahd.setText(table1.getValueAt(row, 1).toString());
            txtMaph.setText(table1.getValueAt(row, 2).toString());
            txtSodien.setText(table1.getValueAt(row, 3).toString());
            txtSonuoc.setText(table1.getValueAt(row, 4).toString());
            txtThang.setText(table1.getValueAt(row, 5).toString());
            txtNam.setText(table1.getValueAt(row, 6).toString());
            txtHantt.setText(table1.getValueAt(row, 7).toString());
        }
    });
    btnQuaylai.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new frmHeThong();
        }
    });
    timKiemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            list.clear();
            list = new connect().TimKiem(txtMaphong_timkiem.getText(),Integer.parseInt(txtThang_timkiem.getText()),Integer.parseInt(txtNam_timkiem.getText()));
            int i = 1;
            for (phong_tro pt : list) {
                model.addRow(new Object[] {
                        i++, pt.getMahd(), pt.getMaphong(), pt.getSodien(), pt.getSonuoc(), pt.getThang(),pt.getNam(),pt.getHanthanhtoan(),pt.gettongtien()
                });
            }
        }
    });
    btnLammoi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            txtMahd.setText("");
            txtMaph.setText("");
            txtSodien.setText("");
            txtSonuoc.setText("");
            txtThang.setText("");
            txtNam.setText("");
            txtHantt.setText("");
            txtMaphong_timkiem.setText("");
            txtThang_timkiem.setText("");
            txtNam_timkiem.setText("");
            //list.clear();
            showTableHoaDon();
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
