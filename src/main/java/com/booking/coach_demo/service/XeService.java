package com.booking.coach_demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.coach_demo.repository.XeRepository;
import com.booking.coach_demo.entity.xe;
import java.util.List;
import java.time.LocalDate;
@Service
public class XeService {
    @Autowired
    private XeRepository xeRepository;
    public xe addXe(xe xe){
        LocalDate now = LocalDate.now();
        if(xe.getHanKiemDinh().isBefore(now.plusMonths(1))){
            throw new IllegalArgumentException("H?n ki?m ??nh ph?i sau ng?y hi?n t?i");
        }
        return xeRepository.save(xe);
    }
    public List<xe> getAllXe() {
        return xeRepository.findAll();
    }
    public xe getXeById(String maloaixe){
        return xeRepository.findById(maloaixe).orElse(null);
    }
}

