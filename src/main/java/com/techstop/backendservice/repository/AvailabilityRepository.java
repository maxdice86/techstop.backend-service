package com.techstop.backendservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techstop.backendservice.model.Availability;


@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, String> {

 List<Availability> findByIdIgnoreCase(String id); 
 
 @Modifying
 @Query(
		 value = "update availability set online =?1, lunch = ?2 where id = ?3 ",
		 nativeQuery = true
		 )
 void updateStatus(boolean online, boolean lunch, String cwid);

}
