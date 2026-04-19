package com.booking.coach_demo.dto;
import java.time.LocalDateTime;
public class LichTrinhRequestDTO {
    private String tenTaiXe;
    private String maTuyen;
    private LocalDateTime ngayGioXuatBen;
    private int soLuongHanhKhach;
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
    
}
