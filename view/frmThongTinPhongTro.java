package org.example.view;

import org.example.controller.knThongTinPhongTro;
import org.example.model.LoaiPhong;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmThongTinPhongTro {
    private JPanel frmThongTinPhongTro;
    private JTable table1;
    private JTextField txtMaph;
    private JButton btnThem;
    private JButton buttonSua;
    private JButton buttonXoa;
    private JTable table2;
    private JTextField txtLp2;
    private JTextField txtGp;
    private JTextField txtDt;
    private JTextField txtVd;
    private JButton ButtonThem2;
    private JButton ButtonSua2;
    private JButton ButtonXoa2;
    private JTextField txtNhap_maphong;
    private JTextField txtNhap_loaiphong;
    private JButton btntìmkiem1;
    private JButton btntimkiem2;
    private JButton ButtonLammoi;
    private JButton buttonQuaylai;
    private JTextField txtLp;
    DefaultTableModel model;
    DefaultTableModel model2;
    ArrayList<LoaiPhong> list;
    ArrayList<LoaiPhong> list2;
    public frmThongTinPhongTro() {
        JFrame frame = new JFrame("Thông tin phòng trọ");
        frame.setBounds(400, 10, 800, 800);
        frame.setContentPane(frmThongTinPhongTro);
        model = (DefaultTableModel) table1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT", "Mã phòng", "Loại phòng"
        });
        showTablePhongTro();
        model2 = (DefaultTableModel) table2.getModel();
        model2.setColumnIdentifiers(new Object[]{
                "STT", "Loại phòng", "Giá phòng", "Diện tích", "Vật dụng"
        });
        showTableLoaiPhong();
        buttonQuaylai.setMnemonic(KeyEvent.VK_Z);
        buttonQuaylai.setToolTipText("Alt + Z");
        ButtonLammoi.setMnemonic(KeyEvent.VK_A);
        ButtonLammoi.setToolTipText("Alt + A");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        LoaiPhong lp = new LoaiPhong();
                        lp.setMaPhong(txtMaph.getText());
                        lp.setMaLoaiPhong(txtLp.getText());
                        boolean check = new knThongTinPhongTro().AddPhongTro(lp);
                        if (check) {
                            JOptionPane.showMessageDialog(frame, "Thêm thành công!");
                            ButtonLammoi.doClick();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Thêm thất bại!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin!");
                    }
                }
        });
        buttonSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoaiPhong lp = new LoaiPhong();
                    lp.setMaPhong(txtMaph.getText());
                    lp.setMaLoaiPhong(txtLp.getText());
                    boolean check = new knThongTinPhongTro().UpdatePhongTro(lp);

                    if (check) {
                        JOptionPane.showMessageDialog(frame, "Sửa thành công");
                        ButtonLammoi.doClick();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sửa thất bại");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin");
                }
                model.setRowCount(0);
                showTablePhongTro();
            }

        });
        buttonXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = new knThongTinPhongTro().deletePhongTro(txtMaph.getText());
                if (check) {
                    JOptionPane.showMessageDialog(frame, "Xóa thành công");
                    ButtonLammoi.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "Xóa thất bại");
                }

            }
        });
        btntìmkiem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    model.setRowCount(0);
//                    list.clear();
                    list = new knThongTinPhongTro().TimKiem(txtNhap_maphong.getText());
                    int i = 1;
                    for (LoaiPhong lp : list) {
                        model.addRow(new Object[] {
                                i++, lp.getMaPhong(), lp.getMaLoaiPhong()
                        });
                    }

            }
        });

        // bang 2
        ButtonThem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoaiPhong lp = new LoaiPhong();
                    lp.setMaLoaiPhong(txtLp2.getText());
                    lp.setGiaPhong(Float.parseFloat(txtGp.getText()));
                    lp.setDienTich(Float.parseFloat(txtDt.getText()));
                    lp.setVatDung(txtVd.getText());

                    boolean check = new knThongTinPhongTro().AddLoaiPhong(lp);
                    if (check) {
                        JOptionPane.showMessageDialog(frame, "Thêm thành công!");
                        ButtonLammoi.doClick();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Thêm thất bại!");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin!");
                }
            }
        });
        ButtonSua2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoaiPhong lp = new LoaiPhong();
                    lp.setMaLoaiPhong(txtLp2.getText());
                    lp.setGiaPhong(Float.parseFloat(txtGp.getText()));
                    lp.setDienTich(Float.parseFloat(txtDt.getText()));
                    lp.setVatDung(txtVd.getText());
                    boolean check = new knThongTinPhongTro().UpdateLoaiPhong(lp);

                    if (check) {
                        JOptionPane.showMessageDialog(frame, "Sửa thành công");
                        ButtonLammoi.doClick();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Sửa thất bại");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Hãy nhập đầy đủ thông tin");
                }
                model2.setRowCount(0);
                showTableLoaiPhong();
            }
        });
        ButtonXoa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = new knThongTinPhongTro().deleteLoaiPhong(txtLp2.getText());
                if (check) {
                    JOptionPane.showMessageDialog(frame, "Xóa thành công");
                    ButtonLammoi.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "Xóa thất bại");
                }
                showTableLoaiPhong();
            }

        });
//mos
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();

                JOptionPane.showMessageDialog(null, table1.getValueAt(row, col).toString());

                txtMaph.setText(table1.getValueAt(row, 1).toString());
                txtLp.setText(table1.getValueAt(row, 2).toString());

                model2.setRowCount(0);
                list2.clear();
                txtNhap_loaiphong.setText(txtLp.getText()) ;
                list2 = new knThongTinPhongTro().TimKiem2(txtNhap_loaiphong.getText());
                int i = 1;
                for (LoaiPhong lp : list2) {
                    model2.addRow(new Object[] {
                            i++, lp.getMaLoaiPhong(), lp.getGiaPhong(), lp.getDienTich(), lp.getVatDung()
                    });
                }
            }
        });
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table2.getSelectedRow();
                int col = table2.getSelectedColumn();

                JOptionPane.showMessageDialog(null, table2.getValueAt(row, col).toString());

                txtLp2.setText(table2.getValueAt(row, 1).toString());
                txtGp.setText(table2.getValueAt(row, 2).toString());
                txtDt.setText(table2.getValueAt(row, 3).toString());
                txtVd.setText(table2.getValueAt(row, 4).toString());
            }
        });
        ButtonLammoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                model2.setRowCount(0);
                txtMaph.setText("");
                txtLp.setText("");
                txtLp2.setText("");
                txtGp.setText("");
                txtDt.setText("");
                txtVd.setText("");
                txtNhap_loaiphong.setText("");
                txtNhap_maphong.setText("");
                showTablePhongTro();
                showTableLoaiPhong();
            }
        });
        buttonQuaylai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new frmHeThong();
            }
        });

        btntimkiem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model2.setRowCount(0);
//                list2.clear();
                list2 = new knThongTinPhongTro().TimKiem2(txtNhap_loaiphong.getText());
                int i = 1;
                for (LoaiPhong lp : list2) {
                    model2.addRow(new Object[] {
                            i++, lp.getMaLoaiPhong(), lp.getGiaPhong(), lp.getDienTich(), lp.getVatDung()
                    });
                }
            }
        });
    }

    public void showTablePhongTro() {
        int i = 1;
        list = new knThongTinPhongTro().getListPhongTro();
        for (LoaiPhong lp : list) {
            model.addRow(new Object[]{
                    i++, lp.getMaPhong(), lp.getMaLoaiPhong()});
        }
    }
    public void showTableLoaiPhong() {
        int i = 1;
        list2 = new knThongTinPhongTro().getListLoaiPhong();
        for (LoaiPhong lp : list2) {
            model2.addRow(new Object[]{
                    i++,lp.getMaLoaiPhong(), lp.getGiaPhong(),  lp.getDienTich(), lp.getVatDung() });
        }
    }
}
