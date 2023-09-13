package org.example.controller;

import org.example.model.PhieuGopY;

import java.sql.*;
import java.util.ArrayList;

public class ketnoiPhieuGopY {
    private Connection con;

    public ketnoiPhieuGopY () {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<PhieuGopY> getListPhieu() {
        ArrayList<PhieuGopY> list = new ArrayList<>();
        String query = "select * from PhieuGopY";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGopY hd = new PhieuGopY();
                hd.setMaPhieu(rs.getString("MaPhieu"));
                hd.setMaKH(rs.getString("MaKhachHang"));
                hd.setNoiDung(rs.getString("NoiDung"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
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

    public boolean deletePhieu(String MaPhieu) {
        String query = "delete from PhieuGopY where MaPhieu=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, MaPhieu);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean insertPhieu(PhieuGopY phieu) {
        String query = "insert into PhieuGopY values (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, phieu.getMaPhieu());
            ps.setNString(2, phieu.getMaKH());
            ps.setNString(3, phieu.getNoiDung());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updatePhieu(PhieuGopY phieu) {
        String query = "update PhieuGopY set NoiDung = ? where MaKhachHang = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, phieu.getNoiDung());
            ps.setNString(2, phieu.getMaKH());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


}
