package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
@Table(name = "nhaxe")
public class nhaxe {
   @Id
   @Column(name="ma_nha_xe")
    private String manhaxe;
    @Column(name="ten_nha_xe")
    private String tennhaxe;
    @Column(name="nam_thanh_lap")
    private int namthanhlap;
    @OneToMany(mappedBy = "nhaxe")
    private List<xe> xeList;
    public nhaxe(){}
    public String getManhaxe() {
        return manhaxe;
    }
    public String getTennhaxe() {
        return tennhaxe;
    }
    public int getNamthanhlap() {
        return namthanhlap;
    }
}
