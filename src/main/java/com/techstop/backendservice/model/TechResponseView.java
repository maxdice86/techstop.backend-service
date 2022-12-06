package com.techstop.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "techresponseview")
public class TechResponseView {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	 private Long id;

	 private String  reqId;
	 
	 private String  reqCwid;
	 
	 private String  reqTypes;
 
	 private String  reqAmount;
	 
	 private String  reqTime;
	 
	 private String  reqDate;


	 public TechResponseView() {}


	public Long getId() {
		return id;
	}
//	@Column(name="reqId", nullable = false, unique = true)
	public String getReqId() {
		return reqId;
	}


	public String getReqCwid() {
		return reqCwid;
	}


	public String getReqTypes() {
		return reqTypes;
	}


	public String getReqAmount() {
		return reqAmount;
	}


	public String getReqTime() {
		return reqTime;
	}


	public String getReqDate() {
		return reqDate;
	}
	 
	 
}
