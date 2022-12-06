package com.techstop.backendservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techstop.backendservice.model.Availability;
import com.techstop.backendservice.model.Request;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

 List<Request> findByCwidIgnoreCase(String cwid);
 
}
