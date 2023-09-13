package org.example.model;

public class KhachHang {
    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setMaKhachHang(String maKhachHang) {
        MaKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        TenKhachHang = tenKhachHang;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void setSoCMND(String soCMND) {
        SoCMND = soCMND;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    private String MaKhachHang, TenKhachHang, MaPhong, DiaChi, SoCMND, SoDienThoai;

}
