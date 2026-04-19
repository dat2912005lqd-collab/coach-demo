package com.booking.coach_demo.service;
import org.springframework.stereotype.Service;
import com.booking.coach_demo.repository.LichTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ThongKeService {
    @Autowired
    private LichTrinhRepository lichTrinhRepository;
    public double tinhThuNhap(){
        return lichTrinhRepository.findAll().stream()
                .mapToDouble(lht -> lht.getTuyenXe().getDonGia() * lht.getSoLuongHanhKhach())
                .sum();
    }

    public double tinhThuNhap(String maXe){
        return lichTrinhRepository.findByXe_Maxe(maXe).stream()
                .mapToDouble(lht -> lht.getTuyenXe().getDonGia() * lht.getSoLuongHanhKhach())
                .sum();
    }
}
