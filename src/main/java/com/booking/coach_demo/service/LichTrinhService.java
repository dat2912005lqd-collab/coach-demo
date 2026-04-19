package com.booking.coach_demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.coach_demo.repository.LichTrinhRepository;
import com.booking.coach_demo.entity.lichtrinhxe;
import java.util.List;
@Service
public class LichTrinhService {
    @Autowired
    private LichTrinhRepository lichTrinhRepository;
    public lichtrinhxe addLichTrinh(lichtrinhxe lichtrinhxe){
        return lichTrinhRepository.save(lichtrinhxe);
    }
    public List<lichtrinhxe> getByMaXe(String maxe){
        return lichTrinhRepository.findByXe_Maxe(maxe);
    }
    
}
