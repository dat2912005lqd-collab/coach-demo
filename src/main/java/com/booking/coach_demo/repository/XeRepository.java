package com.booking.coach_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.coach_demo.entity.xe;
public interface XeRepository extends JpaRepository<xe, String> {
    
}
