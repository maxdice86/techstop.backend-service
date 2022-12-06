package com.techstop.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Availability {
		
	@Id
	@Column
	private String id;
	
	@Column
	private boolean online;
	@Column
	private boolean lunch;
	@Column
	private String cwid;
	

	
	public Availability() {
		
	}


	public Availability(String id, boolean online, boolean lunch, String cwid) {
		super();
		this.id = id;
		this.online = online;
		this.lunch = lunch;
		this.cwid = cwid;
	}


	public String getTypes() {
		return id;
	}


	public void setTypes(String types) {
		this.id = types;
	}


	public boolean getOnline() {
		return online;
	}

	public String getCwid() {
		return cwid;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}


	public boolean getLunch() {
		return lunch;
	}


	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}
	
	public void setCwid(String cwid) {
		this.cwid = cwid;
	}
	
}





	
	