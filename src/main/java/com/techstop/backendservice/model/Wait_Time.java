package com.techstop.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wait_Time {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private int wait_time;
	
	
	public Wait_Time() {
		
	}


	public Wait_Time(Long id, int wait_time) {
		super();
		this.id = id;
		this.wait_time = wait_time;
	}


	public int getWait_time() {
		return wait_time;
	}


	public void setWait_time(int wait_time) {
		this.wait_time = wait_time;
	}


	
	
}





	
	