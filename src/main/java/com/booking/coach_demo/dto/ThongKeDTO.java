package com.booking.coach_demo.dto;
public class ThongKeDTO {
    private String tenNhaXe;
    private double tongThuNhap;
    public ThongKeDTO(String tenNhaXe, double tongThuNhap) {
        this.tenNhaXe = tenNhaXe;
        this.tongThuNhap = tongThuNhap;
    }
    public String getTenNhaXe() {
        return tenNhaXe;
    }
    public double getTongThuNhap() {
        return tongThuNhap;
    }
    
}
