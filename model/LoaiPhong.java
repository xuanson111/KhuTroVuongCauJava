package org.example.model;

public class LoaiPhong {
    private String maLoaiPhong;
    private float giaPhong;
    private float dienTich;
    private String vatDung;
    private String maphong;


    public LoaiPhong() {
    }
    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }
    public String getMaPhong() {
        return maphong;
    }

    public void setMaPhong(String maphong) {
        this.maphong = maphong;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public String getVatDung() {
        return vatDung;
    }

    public void setVatDung(String vatDung) {
        this.vatDung = vatDung;
    }


}
