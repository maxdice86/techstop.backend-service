package com.techstop.backendservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techstop.backendservice.model.TechResponseView;

@Repository
public interface TechViewRespository  extends JpaRepository<TechResponseView, Long> {
	
	List<TechResponseView> findByReqIdIgnoreCase(String reqId);
	
	 @Query(
			 value = "select id , reqId, reqCwid, reqTypes, reqAmount, reqTime, reqDate from techresponseview where reqCwid = ?1",
			 nativeQuery = true
			 )
	 List<TechResponseView>  findByReqCwidIgnoreCase(String reqCwid);
	
	 
}