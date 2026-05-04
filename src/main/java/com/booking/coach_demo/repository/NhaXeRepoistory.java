package com.booking.coach_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.coach_demo.entity.nhaxe;
import java.util.List;
public interface NhaXeRepoistory extends JpaRepository<nhaxe, String> {
    List<nhaxe> findByTennhaxe(String tennhaxe);
}
