package com.techstop.backendservice.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.*;

import com.techstop.backendservice.generators.CustomSequenceGenerator;

@Entity
public class Request {
		
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "req_seq")
    @GenericGenerator(
        name = "req_seq", 
        strategy = "com.techstop.backendservice.generators.CustomSequenceGenerator" ,
        parameters = {
            @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = CustomSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "TR"),
            @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	private String idrequest;
	
	@Column
	private String cwid;
	
	@Column
	private String pickup_time;
	
	@Column
	private String dates;
	
	@Embedded
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@JoinColumn(name = "phone_reqID", referencedColumnName = "idrequest")
	private List<RequestedPhones> req_phones;

	
	
	public Request(String cwid, String pickup_time, String dates, List<RequestedPhones> req_phones) {
		super();
		this.cwid = cwid;
		this.pickup_time = pickup_time;
		this.dates = dates;
		this.req_phones = req_phones;
	}
	
	
	public Request(String idrequest, String cwid, String pickup_time, String dates, List<RequestedPhones> req_phones) {
		super();
		this.idrequest = idrequest;
		this.cwid = cwid;
		this.pickup_time = pickup_time;
		this.dates = dates;
		this.req_phones = req_phones;
	}


	public Request() {
		
	}


	public String getIdrequest() {
		return idrequest;
	}


	public void setIdrequest(String idrequest) {
		this.idrequest = idrequest;
	}


	public String getCwid() {
		return cwid;
	}


	public void setCwid(String cwid) {
		this.cwid = cwid;
	}


	public String getPickup_time() {
		return pickup_time;
	}


	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}


	public String getDates() {
		return dates;
	}


	public void setDates(String dates) {
		this.dates = dates;
	}


	public List<RequestedPhones> getReq_phones() {
		return req_phones;
	}


	public void setReq_phones(List<RequestedPhones> req_phones) {
		this.req_phones = req_phones;
	}
	
	
}





	
	