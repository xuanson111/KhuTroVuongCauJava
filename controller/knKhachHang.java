package org.example.controller;

import org.example.model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class knKhachHang {
    private Connection conn;

    public knKhachHang() {
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

    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang k = new KhachHang();
                k.setMaKhachHang(rs.getString("MaKhachHang"));
                k.setTenKhachHang(rs.getString("TenKhachHang"));
                k.setMaPhong(rs.getString("MaPhong"));
                k.setDiaChi(rs.getString("DiaChi"));
                k.setSoCMND(rs.getString("SoCMND"));
                k.setSoDienThoai(rs.getString("SoDienThoai"));
                list.add(k);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return list;
    }

    public boolean addKhachHang(KhachHang k) {
        String query = "insert into KhachHang(MaKhachHang, TenKhachHang, MaPhong, DiaChi, SoCMND, SoDienThoai)"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, k.getMaKhachHang());
            ps.setString(2, k.getTenKhachHang());
            ps.setString(3, k.getMaPhong());
            ps.setString(4,k.getDiaChi());
            ps.setString(5,k.getSoCMND());
            ps.setString(6,k.getSoDienThoai());
            return ps.executeUpdate()>0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteKhachHang(String MaKhachHang){
        String query="delete from KhachHang where MaKhachHang=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaKhachHang);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateKhachHang(KhachHang k){
        String query = "update KhachHang set TenKhachHang=?, MaPhong=?, DiaChi= ?,SoCMND = ?, SoDienThoai= ?  where MaKhachHang=?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, k.getTenKhachHang());
            ps.setNString(2, k.getMaPhong());
            ps.setNString(3,k.getDiaChi());
            ps.setNString(4,k.getSoCMND());
            ps.setNString(5,k.getSoDienThoai());
            ps.setNString(6,k.getMaKhachHang());;
            return ps.executeUpdate()>0;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> timKiem(String MaKhachHang){
        ArrayList<KhachHang> list = new ArrayList<KhachHang>();
        String query = "select * from KhachHang where MaKhachHang = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setNString(1, MaKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang k1 = new KhachHang();
                k1.setMaKhachHang(rs.getString("MaKhachHang"));
                k1.setTenKhachHang(rs.getString("TenKhachHang"));
                k1.setMaPhong(rs.getString("MaPhong"));
                k1.setDiaChi(rs.getString("DiaChi"));
                k1.setSoCMND(rs.getString("SoCMND"));
                k1.setSoDienThoai(rs.getString("SoDienThoai"));
                list.add(k1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return list;
    }

    public static void main(String[] args) {
        new knKhachHang();
    }
}
