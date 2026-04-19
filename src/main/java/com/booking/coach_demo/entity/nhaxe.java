package com.booking.coach_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "nhaxe")
public class nhaxe {
   @Id
    private String manhaxe;
    private String tennhaxe;
    private int namthanhlap;
    public nhaxe(){}
    public nhaxe(String manhaxe, String tennhaxe) {
        this.manhaxe = manhaxe;
        this.tennhaxe = tennhaxe;
    }
    public String getManhaxe() {
        return manhaxe;
    }
    public String getTennhaxe() {
        return tennhaxe;
    }
    public void setManhaxe(String manhaxe) {
        this.manhaxe = manhaxe;
    }
    public void setTennhaxe(String tennhaxe) {
        this.tennhaxe = tennhaxe;
    }

}
