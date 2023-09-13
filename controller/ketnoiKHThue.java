package org.example.controller;

import org.example.model.KHThueTheoPhong;
import org.example.model.KHThueTheoPhong1;

import java.sql.*;
import java.util.ArrayList;

public class ketnoiKHThue {
    private Connection con;
    public ketnoiKHThue() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<KHThueTheoPhong> getListKHThueTheoPhong() {
        ArrayList<KHThueTheoPhong> list = new ArrayList<KHThueTheoPhong>();
        String query = "select KhachHang.MaPhong, count(*) soluong" +
                " from KhachHang" +
                " group by KhachHang.MaPhong";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KHThueTheoPhong kh = new KHThueTheoPhong();
                kh.setMaPhong(rs.getString("MaPhong"));
                kh.setSoLuong(rs.getInt("soluong"));
                list.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<KHThueTheoPhong1> getListKHThueTheoPhong1(String maphong) {
        ArrayList<KHThueTheoPhong1> list = new ArrayList<KHThueTheoPhong1>();
        String query = "select KhachHang.MaKhachHang, TenKhachHang, DiaChi, SoCMND, SoDienThoai" +
                " from KhachHang " +
                " where MaPhong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, maphong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KHThueTheoPhong1 kh = new KHThueTheoPhong1();
                kh.setMaKhachHang(rs.getString("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoCMND(rs.getString("SoCMND"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                list.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
