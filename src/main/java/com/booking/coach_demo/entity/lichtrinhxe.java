package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "lichtrinhxe")
public class lichtrinhxe {
    @Id
    @Column(name="id")
    private String id;
    @ManyToOne
    @JoinColumn(name="ma_xe")
    private xe xe;
    @ManyToOne
    @JoinColumn(name="tuyen")
    private tuyenxe tuyenXe;
    @Column(name="ten_tai_xe")
    private String taixe;
    @Column(name="capacity")
    private int capacity;
    @Column(name="ngay_gio_xuat_ben")
    private LocalDateTime ngayGioXuatBen;
    @Column(name="so_luong_hanh_khach")
    private int soLuongHanhKhach;
    public lichtrinhxe(){}
    public lichtrinhxe(String id, xe xe, String taixe, tuyenxe tuyenXe, int capacity, LocalDateTime ngayGioXuatBen, int soLuongHanhKhach) {
        this.id = id;
        this.xe = xe;
        this.taixe = taixe;
        this.tuyenXe = tuyenXe;
        this.capacity = capacity;
        this.ngayGioXuatBen = ngayGioXuatBen;
        this.soLuongHanhKhach = soLuongHanhKhach;
    }
    public String getMaxe() {
        return xe.getMaxe();
    }
    public String getBienSo() {
        return xe.getBienso();
    }
    public String getTenNhaXe() {
        return xe.getTennhaxe();
    }
    public String getTenTaiXe() {
        return taixe;
    }
    public String getMaTuyen() {
        return tuyenXe.getMatuyen();
    }
    public String getTenTuyen() {
        return tuyenXe.getTentuyen();
    }
    public String getTaixe() {
        return taixe;
    }
    public String getTuyen() {
        return tuyenXe.getMatuyen();
    }
    public int getCapacity() {
        return capacity;
    }
    public LocalDateTime getNgayGioXuatBen() {
        return ngayGioXuatBen;
    }
    public int getSoLuongHanhKhach() {
        return soLuongHanhKhach;
    }
    public tuyenxe getTuyenXe() {
        return tuyenXe;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
