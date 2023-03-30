package com.phd.phdProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.phd.phdProject.entities.City;
import com.phd.phdProject.entities.Clients;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long>{
}
