package org.example.model;
import java.util.Date;
public class phong_tro {
    private String Mahd, Maphong;
    private int Sodien, Sonuoc, Thang, Nam;
    private Date Hanthanhtoan;
    float tongtien;

    public String getMahd(){
        return Mahd;
    }

    public void setMahd(String Mahd){
        this.Mahd = Mahd;
    }

    public String getMaphong(){
        return Maphong;
    }

    public void setMaphong(String Maphong){
        this.Maphong = Maphong;
    }

    public int getSodien(){
        return Sodien;
    }
    public void setSodien(int Sodien){
        this.Sodien = Sodien;
    }

    public int getSonuoc(){
        return Sonuoc;
    }

    public void setSonuoc(int Sonuoc){
        this.Sonuoc = Sonuoc;
    }

    public int getThang(){
        return Thang;
    }

    public void setThang(int Thang){
        this.Thang = Thang;
    }

    public int getNam(){
        return Nam;
    }

    public void setNam(int Nam){
        this.Nam = Nam;
    }

    public Date getHanthanhtoan(){
        return Hanthanhtoan;
    }

    public void setHanthanhtoan(Date Hanthanhtoan){
        this.Hanthanhtoan = Hanthanhtoan;
    }
    public float gettongtien(){
        return tongtien;
    }

    public void settongtien(float tongtien){
        this.tongtien = tongtien;
    }
}
