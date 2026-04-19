package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import org.hibernate.loader.ast.spi.Loadable;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
@Entity
@Table(name = "xe")
public class xe {
    @Id
    @Column(name="ma_xe")
    private String maxe;
    @ManyToOne
    @JoinColumn(name="maLoaiXe")
    private loaixe loaixe;
    @ManyToOne
    @JoinColumn(name="ma_nha_xe")
    private nhaxe nhaxe;
    @Column(name="hang_san_xuat")
    private String hangxe;
    @Column(name="bien_so")
    private String bienso;
    @Column(name="han_kiem_dinh")
    private String hankiemdinh;
    public xe(){}
    
    public String getMaxe() {
        return maxe;
    }
    public String getHangxe() {
        return hangxe;
    }
    public String getLoaixe() {
        if(loaixe != null) {
            return loaixe.getMaloaixe();
        }
        return null;
    }
    public String getBienso() {
        return bienso;
    }
    public String getHankiemdinh() {
        return hankiemdinh;
    }
    public String getManhaxe() {
        return nhaxe.getManhaxe();
    }
    
    public String getTennhaxe() {
        if(nhaxe != null) {
            return nhaxe.getTennhaxe();
        }
        return null;
    }

    public LocalDate getHanKiemDinh() {
        return LocalDate.parse(hankiemdinh);
    }
}
