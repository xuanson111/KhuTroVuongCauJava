package org.example.view;

import org.example.model.KhachHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class frmKhachHang extends JFrame{
    ArrayList<KhachHang> list;
    DefaultTableModel model;
    public frmKhachHang(){
        JFrame frm = new JFrame("Thông tin Khách hàng");
        frm.setContentPane(panelMain);
//        frm.setSize(800, 400);
        frm.setBounds(500, 200, 800, 400);
        list=new org.example.controller.knKhachHang().getListKhachHang();
        btnLamMoi.setMnemonic(KeyEvent.VK_A);
        btnLamMoi.setToolTipText("ALT + A");
        btnThoat.setMnemonic(KeyEvent.VK_Z);
        btnThoat.setToolTipText("ALT + Z");
        btnTimKiem.setMnemonic(KeyEvent.VK_O);
        btnTimKiem.setToolTipText("ALT + O");
        btnThem.setMnemonic(KeyEvent.VK_I);
        btnThem.setToolTipText("ALT + I");
        btnSua.setMnemonic(KeyEvent.VK_E);
        btnSua.setToolTipText("ALT + E");
        btnXoa.setMnemonic(KeyEvent.VK_X);
        btnXoa.setToolTipText("ALT + X");
        createTable();
        showTable();

        frm.setVisible(true);

        //Them Khach hang
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    KhachHang k=new KhachHang();
                    k.setMaKhachHang(txtMaKhachHang.getText());
                    k.setTenKhachHang(txtTenKhachHang.getText());
                    k.setMaPhong(txtMaPhong.getText());
                    k.setDiaChi(txtDiaChi.getText());
                    k.setSoCMND(txtSoCMND.getText());
                    k.setSoDienThoai(txtSoDienThoai.getText());
                    boolean kt = new org.example.controller.knKhachHang().addKhachHang(k);
                    if(kt){
                        JOptionPane.showMessageDialog(frm,"Đã thêm Khách hàng!");
                        btnLamMoi.doClick();
                    }else{
                        JOptionPane.showMessageDialog(frm,"Thêm bị lỗi!");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(frm, "Hãy nhập đầy đủ thông tin!");
                }
            }
        });

        //Làm mới
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                txtMaKhachHang.setText("");
                txtTenKhachHang.setText("");
                txtMaPhong.setText("");
                txtDiaChi.setText("");
                txtSoCMND.setText("");
                txtSoDienThoai.setText("");
                txtTimKiem.setText("");
//                list.clear();
                showTable();
            }
        });

        //Xóa khách hàng
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean kt = new org.example.controller.knKhachHang().deleteKhachHang(txtMaKhachHang.getText());
                if (kt) {
                    JOptionPane.showMessageDialog(frm, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(frm, "Xóa thất bại");
                }
                btnLamMoi.doClick();
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = jTable1.getSelectedRow();
                int col = jTable1.getSelectedColumn();

                JOptionPane.showMessageDialog(null, jTable1.getValueAt(row, col).toString());

                txtMaKhachHang.setText(jTable1.getValueAt(row, 1).toString());
                txtTenKhachHang.setText(jTable1.getValueAt(row,2).toString());
                txtMaPhong.setText(jTable1.getValueAt(row, 3).toString());
                txtDiaChi.setText(jTable1.getValueAt(row, 4).toString());
                txtSoCMND.setText(jTable1.getValueAt(row, 5).toString());
                txtSoDienThoai.setText(jTable1.getValueAt(row, 6).toString());
            }
        });
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                list.clear();
                list = new org.example.controller.knKhachHang().timKiem(txtTimKiem.getText());
                int i = 1;
                for (KhachHang kh : list) {
                    model.addRow(new Object[] {
                            i++, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getMaPhong(), kh.getDiaChi(), kh.getSoCMND(), kh.getSoDienThoai()
                    });
                }
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    KhachHang k=new KhachHang();
                    k.setMaKhachHang(txtMaKhachHang.getText());
                    k.setTenKhachHang(txtTenKhachHang.getText());
                    k.setMaPhong(txtMaPhong.getText());
                    k.setDiaChi(txtDiaChi.getText());
                    k.setSoCMND(txtSoCMND.getText());
                    k.setSoDienThoai(txtSoDienThoai.getText());
                    boolean kt = new org.example.controller.knKhachHang().updateKhachHang(k);
                    if(kt){
                        JOptionPane.showMessageDialog(frm,"Đã sửa Khách hàng!");
                        btnLamMoi.doClick();
                    }else{
                        JOptionPane.showMessageDialog(frm,"Sửa bị lỗi!");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(frm, "Hãy nhập đầy đủ thông tin!");
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
    }

    public void createTable(){
        model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(new Object[]{
                "STT","MaKhachHang", "TenKhachHang", "MaPhong", "DiaChi","SoCMND","SoDienThoai"
        });
    }


    public void showTable() {
        int i=1;
        list = new org.example.controller.knKhachHang().getListKhachHang();
        for (KhachHang k : list) {
            model.addRow(new Object[]{i++, k.getMaKhachHang(), k.getTenKhachHang(), k.getMaPhong(),
                    k.getDiaChi(), k.getSoCMND(), k.getSoDienThoai()});
        }
    }


    private JTable jTable1;
    private JTextField txtMaKhachHang;
    private JTextField txtTenKhachHang;
    private JTextField txtMaPhong;
    private JTextField txtDiaChi;
    private JTextField txtSoCMND;
    private JTextField txtSoDienThoai;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnLamMoi;
    private JScrollPane jPanel1;
    private JTextField txtTimKiem;
    private JButton btnTimKiem;
    private JPanel panelMain;
    private JButton btnThoat;

}
