package com.booking.coach_demo.dto;
import java.time.LocalDateTime;
public class LichTrinhRequestDTO {
    private String tenTaiXe;
    private String maTuyen;
    private LocalDateTime ngayGioXuatBen;
    private int soLuongHanhKhach;
    // Booking fields
    private String tenHanhKhach;
    private String soDienThoai;
    private String email;
    private String soGhe;
    private String ghiChu;
    
    public LichTrinhRequestDTO() {}
    
    public String getTenTaiXe() {
        return tenTaiXe;
    }
    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }
    
    public String getMaTuyen() {
        return maTuyen;
    }
    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }
    
    public LocalDateTime getNgayGioXuatBen() {
        return ngayGioXuatBen;
    }
    public void setNgayGioXuatBen(LocalDateTime ngayGioXuatBen) {
        this.ngayGioXuatBen = ngayGioXuatBen;
    }
    
    public int getSoLuongHanhKhach() {
        return soLuongHanhKhach;
    }
    public void setSoLuongHanhKhach(int soLuongHanhKhach) {
        this.soLuongHanhKhach = soLuongHanhKhach;
    }
    
    public String getTenHanhKhach() {
        return tenHanhKhach;
    }
    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }
    
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSoGhe() {
        return soGhe;
    }
    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }
    
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
