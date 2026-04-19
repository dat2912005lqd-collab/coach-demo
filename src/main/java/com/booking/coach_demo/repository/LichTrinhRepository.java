package com.booking.coach_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.coach_demo.entity.lichtrinhxe;
import java.util.List;
public interface LichTrinhRepository extends JpaRepository<lichtrinhxe, String> {
    List<lichtrinhxe> findByXe_Maxe(String maxe);
}
