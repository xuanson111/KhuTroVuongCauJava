package org.example.controller;

import org.example.model.HopDong1;

import java.sql.*;
import java.util.ArrayList;

public class ketnoiHopDong {
    private Connection con;

    public ketnoiHopDong() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getLoaiTaiKhoan(String taiKhoan, String matKhau) {
        String query = "select * from TaiKhoan where TaiKhoan = '" + taiKhoan + "' and MatKhau = '" + matKhau +"'";
        String loaiTK = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiTK = rs.getString("LoaiTaiKhoan");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loaiTK;
    }

    public ResultSet execute(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<HopDong1> getListHopDong() {
        ArrayList<HopDong1> list = new ArrayList<>();
        String query = "select * from HopDong";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDong1 hd = new HopDong1();
                hd.setMaHopDong(rs.getString("MaHopDong"));
                hd.setMaPhong(rs.getString("MaPhong"));
                hd.setNgayBatDau(rs.getDate("NgayBatDau"));
                hd.setHieuLuc(rs.getInt("HieuLuc"));
                hd.setTienCoc(rs.getFloat("TienCoc"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean addHopDong(HopDong1 hd) {
        String query = "insert into HopDong" + " values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, hd.getMaHopDong());
            ps.setString(2, hd.getMaPhong());
            ps.setDate(3, new Date(hd.getNgayBatDau().getTime()));
            ps.setInt(4, hd.getHieuLuc());
            ps.setFloat(5, hd.getTienCoc());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteHopDong(String mahd) {
        String query = "delete from HopDong where MaHopDong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, mahd);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean UpdateHopDong(HopDong1 hd) {
        String query = "update HopDong set MaPhong = ?, NgayBatDau=?, HieuLuc=?, TienCoc = ? where MaHopDong=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, hd.getMaPhong());
            ps.setDate(2, new Date(hd.getNgayBatDau().getTime()));
            ps.setInt(3, hd.getHieuLuc());
            ps.setFloat(4, hd.getTienCoc());
            ps.setNString(5, hd.getMaHopDong());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<HopDong1> TimKien(String maphong) {
        ArrayList<HopDong1> list = new ArrayList<HopDong1>();
        String query = "select * from HopDong where MaPhong = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, maphong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDong1 hopDong1 = new HopDong1();
                hopDong1.setMaHopDong(rs.getString("MaHopDong"));
                hopDong1.setMaPhong(rs.getString("MaPhong"));
                hopDong1.setNgayBatDau(rs.getDate("NgayBatDau"));
                hopDong1.setHieuLuc(rs.getInt("HieuLuc"));
                hopDong1.setTienCoc(rs.getFloat("TienCoc"));
                list.add(hopDong1);
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return list;
    }

}
