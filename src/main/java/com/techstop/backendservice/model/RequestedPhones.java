package com.techstop.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.sound.midi.Sequence;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.techstop.backendservice.generators.CustomSequenceGenerator;

@Entity
@Embeddable
@Table(name = "requested_phones")
public class RequestedPhones {
		
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "req_seq")
//	@SequenceGenerator(
//			name ="req_seq",
//			sequenceName = "req_seq"
//			)
//    @GenericGenerator(
//        name = "req_seq", 
//        strategy = "com.techstop.backendservice.generators.CustomSequenceGenerator", 
//        parameters = {
//            @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "50"),
//            @Parameter(name = CustomSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "TR"),
//            @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private Long id;
	
	@Column
	private String types;
	
	@Column
	private int amount;

	
	public RequestedPhones() {
		
	}

	
	public RequestedPhones(String types, int amount) {
		super();
		this.types = types;
		this.amount = amount;
	}

	public RequestedPhones(Long id, String types, int amount) {
		super();
		this.id = id;
		this.types = types;
		this.amount = amount;
	}


	public Long getIdreq_phones() {
		return id;
	}


	public void setIdreq_phones(Long idreq_phones) {
		this.id = idreq_phones;
	}


	public String getTypes() {
		return types;
	}


	public void setTypes(String types) {
		this.types = types;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}





	
	