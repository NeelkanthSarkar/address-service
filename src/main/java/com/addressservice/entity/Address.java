package com.addressservice.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "^([a-zA-Z]+[a-zA-Z0-9\\-\\,\\.\\ ]*)*$", message = "Address 1 must be 0 to 30 chars long")
	@Length(max=40)
	@NotNull
	private String address1;
	
	@Column( name = "address2")
	@Pattern(regexp = "^([a-zA-Z]+[a-zA-Z0-9\\-\\,\\.\\ ]*)*$", message = "Address 2 must be 0 to 30 chars long")
	@Length(max=40)
	@NotNull
	private String address2;
	
	@Column( name = "city") 
	@Pattern(regexp = "^[a-zA-Z]{2,40}$" , message = "City must be 2 to 30 chars long")
	@NotBlank
	private String city;
	
	@Column( name = "state")
	@Pattern(regexp = "^[a-zA-Z]{2,40}$", message = "State must be 2 to 30 chars long")
	@NotBlank
	private String state;
	
	@Column( name = "country")
	@Pattern(regexp = "^[a-zA-Z]{2,40}$" , message = "Country must be 2 to 30 chars long")
	@NotBlank
	private String country;
	
	@Column( name = "pin_code")
	@Min(value = 100000, message = "Pincode must be 6 digit number")
	@Max(value = 999999, message = "Pincode must be 6 digit number")
	@NotNull
	private int pinCode;
}
