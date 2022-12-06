package com.techstop.backendservice.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techstop.backendservice.model.Availability;
import com.techstop.backendservice.model.Phones;
import com.techstop.backendservice.model.Request;
import com.techstop.backendservice.model.RequestedPhones;
import com.techstop.backendservice.model.TechResponseView;
import com.techstop.backendservice.model.Wait_Time;
import com.techstop.backendservice.repository.PhonesRepository;
import com.techstop.backendservice.service.ServiceBackend;

@CrossOrigin ("http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/techstop/")
public class Controller {
	
	@Autowired
	ServiceBackend backendService;
	
	
	/////////PHONES MAPPING////////////
	
	@GetMapping("/phones")
	public List<Phones> getAllRecords(){
		return backendService.getAllPhones();
	};
	
	@GetMapping("/phones/{type}")
	public List<Phones> getAllPhonesByType(@PathVariable String type){	
		return backendService.getAllPhonesByType(type);
	};
	
	@PatchMapping("/phones/{a}/{t}")
	public void updateRecord(@PathVariable int a,@PathVariable String t){
				backendService.updateQuantity(a, t);
	};
	
	
	//////////////GET TECH STATUS MAPPINGS////////////////
	
	@GetMapping("/status")
	public List<Availability> getAllStatus(){
		return backendService.getAllStatus();
	};
	
	@GetMapping("/status/{type}")
	public List<Availability> getAllStatusByType(@PathVariable String type){	
		return backendService.getAllStatusByType(type);
	};
	@PatchMapping("/status/{on}/{lun}/{t}")
	public void updateStatus(@PathVariable boolean on,@PathVariable boolean lun, @PathVariable String t){
				backendService.updateStatus(on,lun,t);
	};
	
	
	/////////////ESTIMATED TIME MAPPINGS//////////////////
	
	@GetMapping("/time")
	public List<Wait_Time> getTime(){
		return backendService.getTime();
	};
	@PatchMapping("/time/{time}")
	public void updateTime(@PathVariable int time){
		System.out.println(time);
		backendService.updateTime(time);
	};
	
//	@GetMapping("/request/{id}")
//	public void getRequestViewsByCwid(@PathVariable String id){
//		backendService.getRequestViewsByCwid(id);
//	};
	
	@GetMapping("/request")
	public List<TechResponseView> getAllRequest(){
		  
				return backendService.getRequestViews();
	};
	
	@GetMapping("/request/{id}")
	public TechResponseView getRequestViewsByCwid(@PathVariable String id){
		  
		List<TechResponseView> list =	 backendService.getRequestViewsByCwid(id);
		TechResponseView lastView = list.get(list.size()-1);
		return lastView;		
	};
	
	@RequestMapping(
    value = "/", 
    method = RequestMethod.POST )
	public void createRequest(@RequestBody LinkedHashMap<String, String> req) {
		
		RequestedPhones phone = new RequestedPhones(req.get("types"),Integer.parseInt(req.get("amount")));
		Request request = new Request(req.get("cwid"),req.get("pickup_time"), req.get("dates"),List.of(phone));
		
		backendService.createRequest(request);
	
//	public void process(@RequestBody LinkedHashMap<String, String>  payload) 
//    throws Exception {
//
//    System.out.println(Boolean.parseBoolean(payload.get("online")));

	}
}
