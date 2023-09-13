package org.example.controller;

import org.example.model.LoaiPhong;
import java.sql.*;
import java.util.ArrayList;

public class knThongKePhongTrong {
    private Connection conn;

    public void setCon(Connection conn) {
        this.conn = conn;
    }

    public knThongKePhongTrong() {

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<LoaiPhong> getListPhongTrong() {
        ArrayList<LoaiPhong> list = new ArrayList<>();
        String query = "select PhongTro.MaPhong ,LoaiPhong.MaLoaiPhong , LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung "
        +"from PhongTro,LoaiPhong where PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong and PhongTro.MaPhong not in (select MaPhong from KhachHang)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
                lp.setMaPhong(rs.getString("MaPhong"));
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                lp.setGiaPhong(rs.getFloat("GiaPhong"));
                lp.setDienTich(rs.getFloat("DienTich"));
                lp.setVatDung(rs.getString("VatDung"));
                list.add(lp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;

    }
    public ArrayList<LoaiPhong> TimKiem(String MaLoaiPhong) {
        ArrayList<LoaiPhong> list = new ArrayList<LoaiPhong>();
        String query = " select PhongTro.MaPhong ,LoaiPhong.MaLoaiPhong , LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung " +
                "from PhongTro,LoaiPhong where PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong and PhongTro.MaPhong not in (select MaPhong from KhachHang)" +
                "and LoaiPhong.MaLoaiPhong=?";
        try {

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setNString(1, MaLoaiPhong);
        ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    LoaiPhong lp = new LoaiPhong();
                    lp.setMaPhong(rs.getString("MaPhong"));
                    lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                    lp.setGiaPhong(rs.getFloat("GiaPhong"));
                    lp.setDienTich(rs.getFloat("DienTich"));
                    lp.setVatDung(rs.getString("VatDung"));
                    list.add(lp);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


}
