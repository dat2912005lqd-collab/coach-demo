package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
@Table(name = "tuyenxe")
public class tuyenxe {
    @Id
    @Column(name="ma_tuyen")
    private String matuyen;
    @Column(name="ten_tuyen")
    private String tentuyen;
   @Column(name="don_gia")
    private double donGia;
    @OneToMany(mappedBy = "tuyenXe")
    private List<lichtrinhxe> lichTrinhXes;
    public tuyenxe(){}
    public String getMatuyen() {
        return matuyen;
    }
    public String getTentuyen() {
        return tentuyen;
    }
    public double getDonGia() {
        return donGia;
    }
    
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public void setMatuyen(String matuyen) {
        this.matuyen = matuyen;
    }
    
    public void setTentuyen(String tentuyen) {
        this.tentuyen = tentuyen;
    }
}
