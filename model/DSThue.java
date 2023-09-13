package org.example.model;

public class DSThue {

    public String getMaPhong() {
        return MaPhong;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public String getVatDung() {
        return VatDung;
    }


    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }


    public void setMaLoaiPhong(String maLoaiPhong) {
        MaLoaiPhong = maLoaiPhong;
    }


    public void setVatDung(String vatDung) {
        VatDung = vatDung;
    }

    private String MaPhong, MaLoaiPhong, VatDung;

    public float getGiaPhong() {
        return GiaPhong;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setGiaPhong(float giaPhong) {
        GiaPhong = giaPhong;
    }

    public void setDienTich(float dienTich) {
        DienTich = dienTich;
    }

    private float  GiaPhong, DienTich;

    public int getSoKhach() {
        return SoKhach;
    }

    public void setSoKhach(int soKhach) {
        SoKhach = soKhach;
    }

    private int SoKhach;
}
