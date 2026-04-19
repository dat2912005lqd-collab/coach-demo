package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
@Entity
@Table(name = "loaixe")
public class loaixe {
    @Id
    @Column(name="loaixe")
    private String maloaixe;
    @Column(name="mo_ta_loai_xe")
    private String tennhaxe;
    @Column(name="so_luong_cho_ngoi")
    private String soLuongChoNgoi;
    public loaixe() {}
    public String getMaloaixe() {
        return maloaixe;
    }
    public String getTennhaxe() {
        return tennhaxe;
    }
    public String getSoLuongChoNgoi() {
        return soLuongChoNgoi;
    }
    
    public void setMaloaixe(String maloaixe) {
        this.maloaixe = maloaixe;
    }
}
