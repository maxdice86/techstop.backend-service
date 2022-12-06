package com.techstop.backendservice.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techstop.backendservice.model.Availability;
import com.techstop.backendservice.model.Phones;
import com.techstop.backendservice.model.Request;
import com.techstop.backendservice.model.RequestedPhones;
import com.techstop.backendservice.model.TechResponseView;
import com.techstop.backendservice.model.Wait_Time;
import com.techstop.backendservice.repository.AvailabilityRepository;
import com.techstop.backendservice.repository.PhonesRepository;
import com.techstop.backendservice.repository.RequestRepository;
import com.techstop.backendservice.repository.TechViewRespository;
import com.techstop.backendservice.repository.WaitTimeRepository;

@Service
@Transactional

public class ServiceBackend {
	@Autowired
	private PhonesRepository phonesRepository;
	
	@Autowired
	private AvailabilityRepository statusRepository;
	
	@Autowired
	private WaitTimeRepository waitTimeResopitory;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private TechViewRespository techViewRespository;
	
//	@Autowired
//	private RequestedPhones requestedPhones;
//	
	

	public List<Phones> getAllPhones(){
		return phonesRepository.findAll();
	};
	
	public List<Phones> getAllPhonesByType(String type){	
		return phonesRepository.findByTypesIgnoreCase(type);
	};

	public void updateQuantity(int amount, String type){
		phonesRepository.updateQuantity(amount, type);
	};
	
	//APIS FOR AVAILABILTY//
	
	public List<Availability> getAllStatus(){
		return statusRepository.findAll();
	};
	
	public List<Availability> getAllStatusByType(String type){	
		return statusRepository.findByIdIgnoreCase(type);
	};

	public void updateStatus(boolean on, boolean lun, String type){
		statusRepository.updateStatus(on,lun,type);
	};
	//APIS FOR WAIT TIME///
	
	public List<Wait_Time> getTime(){
		return waitTimeResopitory.findAll();
	};
	
	public void updateTime(int time){
		waitTimeResopitory.updateTime(time);
	};
	
	//APIS FOR REQUEST PHONE///
	
	
	public List<Request> getAllRequest(){
		return requestRepository.findAll();
	};
	
	public void createRequest(Request req) {
			
		requestRepository.save(req);
		
	}
	
	
	//////////TECH VIEWS FOR REQUESTS/////////////////////
	public List<TechResponseView> getRequestViews(){
		
		return techViewRespository.findAll();
	}
	public List<TechResponseView> getRequestViewsById(String id){
			
		return techViewRespository.findByReqIdIgnoreCase(id);
	}
	
	public List<TechResponseView>  getRequestViewsByCwid(String id){
		
		return techViewRespository.findByReqCwidIgnoreCase(id);
	}
}
