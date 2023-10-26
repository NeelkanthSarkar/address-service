package com.addressservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table( name = "address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column( name = "address_id")
	private int addressId;
	
	@Column( name = "user_id")
	private int userId;
	
	@Column( name = "address1")
	private String address1;
	
	@Column( name = "address2")
	private String address2;
	
	@Column( name = "city") 
	private String city;
	
	@Column( name = "state")
	private String state;
	
	@Column( name = "country")
	private String country;
	
	@Column( name = "pin_code")
	private int pinCode;

}
