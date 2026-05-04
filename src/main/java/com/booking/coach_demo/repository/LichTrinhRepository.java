package com.booking.coach_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.coach_demo.entity.lichtrinhxe;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public interface LichTrinhRepository extends JpaRepository<lichtrinhxe, String> {
    List<lichtrinhxe> findByXe_Maxe(String maxe);
    Optional<lichtrinhxe> findById(String id);
    List<lichtrinhxe> findByTuyenXe_Matuyen(String maTuyen);
    List<lichtrinhxe> findByNgayGioXuatBenBetween(LocalDateTime start, LocalDateTime end);
}
