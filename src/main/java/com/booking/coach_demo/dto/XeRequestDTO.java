package com.booking.coach_demo.dto;
import java.time.LocalDate;
public class XeRequestDTO {
 private String maxe;
 private String hangSanXuat;
 private String bienSo;
 private LocalDate hanKiemDinh;
 private String maLoaiXe;
 private String maNhaXe;
 public XeRequestDTO() {}
 public String getMaxe() {
     return maxe;
 }
    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }
    public String getHangSanXuat() {
        return hangSanXuat;
    }
    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public String getBienSo() {
        return bienSo;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    public LocalDate getHanKiemDinh() {
        return hanKiemDinh;
    }
    public void setHanKiemDinh(LocalDate hanKiemDinh) {
        this.hanKiemDinh = hanKiemDinh;
    }
    public String getMaLoaiXe() {
        return maLoaiXe;
    }
    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }
    public String getMaNhaXe() {
        return maNhaXe;
    }
    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }
}
