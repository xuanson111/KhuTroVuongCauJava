package org.example.controller;

import org.example.model.LoaiPhong;
import java.sql.*;
import java.util.ArrayList;

public class knThongTinPhongTro {
   private Connection conn ;

    public void setCon(Connection conn) {
        this.conn = conn;
    }
    public knThongTinPhongTro() {

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<LoaiPhong> getListPhongTro() {
        ArrayList<LoaiPhong> list = new ArrayList<>();
        String query = "select * from PhongTro";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
                lp.setMaPhong(rs.getString("MaPhong"));
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                list.add(lp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean deletePhongTro(String MaPhong) {
        String query = "delete from PhongTro where MaPhong = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaPhong);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean AddPhongTro(LoaiPhong lp) {
        String query = "Insert into  PhongTro  values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, lp.getMaPhong());
            ps.setNString(2, lp.getMaLoaiPhong());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean UpdatePhongTro(LoaiPhong lp) {
        String query = "update PhongTro set MaLoaiPhong = ? where PhongTro.MaPhong=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(2, lp.getMaPhong());
            ps.setNString(1, lp.getMaLoaiPhong());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public ArrayList<LoaiPhong> TimKiem(String maphong) {
        ArrayList<LoaiPhong> list = new ArrayList<LoaiPhong>();
        String query = " select * from PhongTro where MaPhong = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, maphong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
                lp.setMaPhong(rs.getString("MaPhong"));
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                list.add(lp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //bang 2
    public ArrayList<LoaiPhong> getListLoaiPhong() {
        ArrayList<LoaiPhong> list = new ArrayList<>();
        String query = " select * from LoaiPhong ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
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
    public boolean deleteLoaiPhong(String MaLoaiPhong) {
        String query = "delete from LoaiPhong where MaLoaiPhong = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaLoaiPhong);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean AddLoaiPhong(LoaiPhong lp) {
        String query = "Insert  into LoaiPhong values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, lp.getMaLoaiPhong());
            ps.setFloat(2,lp.getGiaPhong());
            ps.setFloat(3,lp.getDienTich());
            ps.setNString(4, lp.getVatDung());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean UpdateLoaiPhong(LoaiPhong lp) {
        String query = "update LoaiPhong set GiaPhong=?, DienTich=?, VatDung=? where MaLoaiPhong =? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(4, lp.getMaLoaiPhong());
            ps.setFloat(1,lp.getGiaPhong());
            ps.setFloat(2,lp.getDienTich());
            ps.setNString(3, lp.getVatDung());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public ArrayList<LoaiPhong> TimKiem2(String MaLoaiPhong) {
        ArrayList<LoaiPhong> list = new ArrayList<LoaiPhong>();
        String query = " select * from LoaiPhong where MaLoaiPhong = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaLoaiPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                lp.setGiaPhong(rs.getFloat ("GiaPhong"));
                lp.setDienTich(rs.getFloat ("DienTich"));
                lp.setVatDung(rs.getString("VatDung"));
                list.add(lp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
