package org.example.model;

import java.util.Date;

public class HopDong1 {
    private String MaHopDong, MaPhong;
    private Date NgayBatDau;
    private int HieuLuc;
    private float TienCoc;

    public HopDong1() { }

    public String getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        MaHopDong = maHopDong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public int getHieuLuc() {
        return HieuLuc;
    }

    public void setHieuLuc(int hieuLuc) {
        HieuLuc = hieuLuc;
    }

    public float getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(float tienCoc) {
        TienCoc = tienCoc;
    }
}
