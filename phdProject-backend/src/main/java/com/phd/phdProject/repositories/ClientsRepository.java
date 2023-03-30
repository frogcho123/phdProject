package com.phd.phdProject.repositories;

import com.phd.phdProject.entities.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

 @Query("SELECT p FROM Clients p WHERE lower(p.firstName) =:first_name ")
 Optional<Clients> findByFirstName(String first_name);

 @Query("SELECT p FROM Clients p WHERE (p.id) =:id ")
 Clients findClientsById(Long id);

 @Query("SELECT p FROM Clients p LEFT JOIN p.city c LEFT JOIN p.sex q " +
         "WHERE lower(p.firstName) " +
         "LIKE :#{#firstName == null || #firstName.isEmpty()? '%' : '%'+#firstName+'%'} " +
         "AND lower(p.secondName) " +
         "LIKE :#{#secondName == null || #secondName.isEmpty()? '%' : '%'+#secondName+'%'} " +
         "AND lower(p.lastName) " +
         "LIKE :#{#lastName == null || #lastName.isEmpty()? '%' : '%'+#lastName+'%'} " +
         "AND lower(p.nickName) " +
         "LIKE :#{#nickName == null || #nickName.isEmpty()? '%' : '%'+#nickName+'%'} " +
         "AND lower(q.type) " +
         "LIKE :#{#sex == null || #sex.isEmpty()? '%' : '%'+#sex+'%'} " +
         "AND (p.egn = :egn OR :egn IS NULL) " +
         "AND lower(c.name) " +
         "LIKE :#{#city == null || #city.isEmpty()? '%' : '%'+#city+'%'} " +
         "AND (p.current = :current OR :current IS NULL) " +
         "AND (p.saving = :saving OR :saving IS NULL) " +
         "AND (p.credit = :credit OR :credit IS NULL) "
 )
 Page<Clients> findPageClient(Pageable pageable, String firstName, String secondName, String lastName, String nickName,
                              String sex, Long egn, String city, Double current, Double saving, Double credit);
}
