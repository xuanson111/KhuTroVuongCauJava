package org.example.controller;
import org.example.model.phong_tro;

import java.sql.*;
import java.util.ArrayList;

public class connect {
    private Connection con;
    public void setCon(Connection con) {
        this.con = con;
    }
    public connect() {

        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=KhuTroVuonCau; trustServerCertificate=true", "sa", "xuanson12345678");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // hóa đơn
    public ArrayList<phong_tro> getListHoaDon() {
        ArrayList<phong_tro> list = new ArrayList<>();
        String query = "select MaHoaDon, HoaDon.MaPhong, SoDien, SoNuoc, Thang, Nam, HanThanhToan, (SoDien * 4000 + SoNuoc* 30000 + LoaiPhong.GiaPhong + 20000 + 100000) as tongtien\n" +
                "from HoaDon, PhongTro, LoaiPhong\n" +
                "where HoaDon.MaPhong = PhongTro.MaPhong\n" +
                "and PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phong_tro hd = new phong_tro();
                hd.setMahd(rs.getString("MaHoaDon"));
                hd.setMaphong(rs.getString("MaPhong"));
                hd.setSodien(rs.getInt("SoDien"));
                hd.setSonuoc(rs.getInt("SoNuoc"));
                hd.setThang(rs.getInt("Thang"));
                hd.setNam(rs.getInt("Nam"));
                hd.setHanthanhtoan(rs.getDate("HanThanhToan"));
                hd.settongtien(rs.getFloat("tongtien"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public boolean addHoaDon(phong_tro hd) {
        String query = "insert into HoaDon" + " values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, hd.getMahd());
            ps.setString(2, hd.getMaphong());
            ps.setInt(3, hd.getSodien());
            ps.setInt(4, hd.getSonuoc());
            ps.setInt(5, hd.getThang());
            ps.setInt(6, hd.getNam());
            ps.setDate(7, new Date(hd.getHanthanhtoan().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean deleteHoaDon(String mahd) {
        String query = "delete from HoaDon where MaHoaDon = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, mahd);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean UpdateHoaDon(phong_tro hd) {
        String query = "update HoaDon set MaPhong = ?, SoDien=?, SoNuoc=?, Thang = ? , Nam = ?, HanThanhToan = ? where MaHoaDon=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, hd.getMaphong());
            ps.setInt(2, hd.getSodien());
            ps.setInt(3, hd.getSonuoc());
            ps.setInt(4, hd.getThang());
            ps.setInt(5, hd.getNam());
            ps.setDate(6, new Date(hd.getHanthanhtoan().getTime()));
            ps.setNString(7, hd.getMahd());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deletePhieu(String maph) {
        String query = "delete from PhieuGopY where MaPhieu = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setNString(1, maph);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // khach hang
    public ResultSet execute(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
    public ArrayList<phong_tro> TimKiem(String maphong, int thang, int nam) {
        ArrayList<phong_tro> list = new ArrayList<phong_tro>();
        String query = "select MaHoaDon, HoaDon.MaPhong, SoDien, SoNuoc, Thang, Nam, HanThanhToan, (SoDien * 4000 + SoNuoc* 30000 + LoaiPhong.GiaPhong + 20000 + 100000) as tongtien " +
                " from HoaDon, PhongTro, LoaiPhong " +
                " where HoaDon.MaPhong = PhongTro.MaPhong " +
                " and PhongTro.MaLoaiPhong = LoaiPhong.MaLoaiPhong "+
                " and HoaDon.MaPhong = ? and Thang = ? and Nam = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, maphong);
            ps.setInt(2, thang );
            ps.setInt(3, nam);
            ResultSet rss = ps.executeQuery();
            while (rss.next()) {
                phong_tro hd = new phong_tro();
                hd.setMahd(rss.getString("MaHoaDon"));
                hd.setMaphong(rss.getString("MaPhong"));
                hd.setSodien(rss.getInt("SoDien"));
                hd.setSonuoc(rss.getInt("SoNuoc"));
                hd.setThang(rss.getInt("Thang"));
                hd.setNam(rss.getInt("Nam"));
                hd.setHanthanhtoan(rss.getDate("HanThanhToan"));
                hd.settongtien(rss.getFloat("tongtien"));
                list.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
