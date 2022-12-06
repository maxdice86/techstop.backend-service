package com.techstop.backendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techstop.backendservice.model.Wait_Time;


@Repository
public interface WaitTimeRepository extends JpaRepository<Wait_Time, Long> {
 
 @Modifying
 @Query(
		 value = "update wait_time set wait_time =?1 where id = 0 ",
		 nativeQuery = true
		 )
 void updateTime(int time);

}
