package com.addressservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
	
	private int addressId;
	private int userId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private int pinCode;

}
