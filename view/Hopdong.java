package org.example.view;

import org.example.controller.ketnoiHopDong;
import org.example.model.HopDong1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Hopdong {
    private JTable table1;
    private JTextField txtMaHD;
    private JTextField txtTienCoc;
    private JTextField txtHieuLuc;
    private JTextField txtNgayBD;
    private JTextField txtMaPhong;
    private JButton themButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton lamMoiButton;
    private JButton quayLaiButton;
    private JButton timKiemButton;
    private JTextField txtTimKiem;
    private JPanel panelMain;
    DefaultTableModel model;
    ArrayList<HopDong1> list;
    public Hopdong() {
        JFrame frame = new JFrame("Hợp đồng");
//        frame.setSize(800, 400);
        frame.setBounds(400, 200, 800, 400);
        frame.setContentPane(panelMain);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã hợp đồng", "Mã phòng", "Ngày băt đầu", "Hiệu lực", "Tiền cọc"
        });
        showTableHopDong();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lamMoiButton.setMnemonic(KeyEvent.VK_A);
        lamMoiButton.setToolTipText("ALT + A");
        quayLaiButton.setMnemonic(KeyEvent.VK_Z);
        quayLaiButton.setToolTipText("ALT + Z");
        timKiemButton.setMnemonic(KeyEvent.VK_O);
        timKiemButton.setToolTipText("ALT + O");
        themButton.setMnemonic(KeyEvent.VK_I);
        themButton.setToolTipText("ALT + I");
        suaButton.setMnemonic(KeyEvent.VK_E);
        suaButton.setToolTipText("ALT + E");
        xoaButton.setMnemonic(KeyEvent.VK_X);
        xoaButton.setToolTipText("ALT + X");
        frame.setVisible(true);

        //Thêm hợp đồng
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HopDong1 hd = new HopDong1();
                    hd.setMaHopDong(txtMaHD.getText());
                    hd.setMaPhong(txtMaPhong.getText());
                    hd.setHieuLuc(Integer.parseInt(txtHieuLuc.getText()));
                    hd.setTienCoc(Float.parseFloat(txtTienCoc.getText()));
                    try {
                        hd.setNgayBatDau(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayBD.getText()));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    boolean check = new ketnoiHopDong().addHopDong(hd);
                    if (check) {
                        JOptionPane.showMessageDialog(frame, "Thêm thành công");
                        lamMoiButton.doClick();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Thêm thất bại");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Hãy nhập đúng đủ thông tin");
                }
            }
        });
        // Xóa hợp đồng
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = new ketnoiHopDong().deleteHopDong(txtMaHD.getText());
                if (check) {
                    JOptionPane.showMessageDialog(frame, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(frame, "Xóa thất bại");
                }
                lamMoiButton.doClick();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();

                JOptionPane.showMessageDialog(null, table1.getValueAt(row, col).toString());

                txtMaHD.setText(table1.getValueAt(row, 1).toString());
                txtMaPhong.setText(table1.getValueAt(row, 2).toString());
                txtNgayBD.setText(table1.getValueAt(row, 3).toString());
                txtHieuLuc.setText(table1.getValueAt(row, 4).toString());
                txtTienCoc.setText(table1.getValueAt(row, 5).toString());
            }
        });

        //Làm mới
        lamMoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                txtMaHD.setText("");
                txtMaPhong.setText("");
                txtNgayBD.setText("");
                txtHieuLuc.setText("");
                txtTienCoc.setText("");
                txtTimKiem.setText("");
                showTableHopDong();
            }
        });
        //Tìm kiếm theo mã phòng
        timKiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                list = new ketnoiHopDong().TimKien(txtTimKiem.getText());
                int i = 1;
                for (HopDong1 hopdong : list) {
                    model.addRow(new Object[] {
                            i++, hopdong.getMaHopDong(), hopdong.getMaPhong(), hopdong.getNgayBatDau(), hopdong.getHieuLuc(), hopdong.getTienCoc()
                    });
                }
            }
        });
        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HopDong1 hd = new HopDong1();
                    hd.setMaHopDong(txtMaHD.getText());
                    hd.setMaPhong(txtMaPhong.getText());
                    try {
                        hd.setNgayBatDau(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayBD.getText()));
                    } catch (ParseException ex) {
                    }
                    hd.setHieuLuc(Integer.parseInt(txtHieuLuc.getText()));
                    hd.setTienCoc(Float.parseFloat(txtTienCoc.getText()));

                    boolean check = new ketnoiHopDong().UpdateHopDong(hd);

                    if (check) {
                        JOptionPane.showMessageDialog(frame, "Sửa thành công");
                        lamMoiButton.doClick();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sửa thất bại");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin");
                }
            }
        });
        quayLaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong();
            }
        });
    }

    public void showTableHopDong() {
        int i = 1;
        list = new ketnoiHopDong().getListHopDong();
        for (HopDong1 hd : list) {
            model.addRow(new Object[]{
                    i++, hd.getMaHopDong(), hd.getMaPhong(), hd.getNgayBatDau(), hd.getHieuLuc(), hd.getTienCoc()
            });
        }
    }

//    public void showResult() {
//        HopDong1 hd = list.get(list.size() - 1);
//        model.addRow(new Object[]{
//                i++, hd.getMaHopDong(), hd.getMaPhong(), hd.getNgayBatDau(), hd.getHieuLuc(), hd.getTienCoc()
//        });
//    }

}
