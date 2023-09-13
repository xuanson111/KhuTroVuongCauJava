package org.example.controller;

import org.example.model.DSThue;

import java.sql.*;
import java.util.ArrayList;

public class knDSThue {
    private Connection conn;

    public knDSThue() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=KhuTroVuonCau;encrypt=true;trustServerCertificate=true";
        try {
            conn = DriverManager.getConnection(connectionUrl, "sa", "xuanson12345678");
            if (conn != null)
                System.out.println("Connected");
            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public ArrayList<DSThue> getListPhong() {
        ArrayList<DSThue> list = new ArrayList<>();
        String sql = "select KhachHang.MaPhong, LoaiPhong.MaLoaiPhong, LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung, count(*) as SoKhach\n" +
                "from PhongTro, KhachHang, LoaiPhong\n" +
                "where PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong\n" +
                "and KhachHang.MaPhong =  PhongTro.MaPhong\n" +
                "group by KhachHang.MaPhong, LoaiPhong.MaLoaiPhong, LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DSThue thue =new DSThue();
                thue.setMaPhong(rs.getString("MaPhong"));
                thue.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                thue.setGiaPhong(rs.getFloat("GiaPhong"));
                thue.setDienTich(rs.getFloat("DienTich"));
                thue.setVatDung(rs.getString("VatDung"));
                thue.setSoKhach(rs.getInt("SoKhach"));
                list.add(thue);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return list;
    }

    public ArrayList<DSThue> timKiem(String MaLoaiPhong){
        ArrayList<DSThue> list=new ArrayList<DSThue>();
        String query="select KhachHang.MaPhong, LoaiPhong.MaLoaiPhong, LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung, count(*) as SoKhach\n" +
                "from PhongTro, KhachHang, LoaiPhong\n" +
                "where PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong\n" +
                "and KhachHang.MaPhong =  PhongTro.MaPhong\n" +
                "and LoaiPhong.MaLoaiPhong = ?\n" +
                "group by KhachHang.MaPhong, LoaiPhong.MaLoaiPhong, LoaiPhong.GiaPhong, LoaiPhong.DienTich, LoaiPhong.VatDung";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaLoaiPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DSThue thue=new DSThue();
                thue.setMaPhong(rs.getString("MaPhong"));
                thue.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                thue.setGiaPhong(rs.getFloat("GiaPhong"));
                thue.setDienTich(rs.getFloat("DienTich"));
                thue.setVatDung(rs.getString("VatDung"));
                thue.setSoKhach(rs.getInt("SoKhach"));
                list.add(thue);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return list;
    }

    public static void main(String[] args) {
        new knDSThue();
    }
}
