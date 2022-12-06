package com.techstop.backendservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techstop.backendservice.model.Phones;


@Repository
public interface PhonesRepository extends JpaRepository<Phones, String> {

 List<Phones> findByTypesIgnoreCase(String type); 
 
 @Modifying
 @Query(
		 value = "update phones set quantity =?1 where types = ?2 ",
		 nativeQuery = true
		 )
 void updateQuantity(int amount, String type);

}
