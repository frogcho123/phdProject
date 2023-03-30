package com.phd.phdProject.repositories;
import com.phd.phdProject.entities.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SexRepository extends JpaRepository<Sex, Long>{
}
