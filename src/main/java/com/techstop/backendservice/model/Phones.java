package com.techstop.backendservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phones {
		
	@Id
	@Column
	private String types;
	
	@Column
	private int quantity;

	
	public Phones() {
		
	}

	public Phones(String types, int qauntity) {
		super();
		this.types = types;
		this.quantity = qauntity;
	}


	public String getTypes() {
		return types;
	}


	public void setTypes(String types) {
		this.types = types;
	}


	public int getQauntity() {
		return quantity;
	}


	public void setQauntity(int qauntity) {
		this.quantity = qauntity;
	}

	
}





	
	