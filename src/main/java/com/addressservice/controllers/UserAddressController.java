package com.addressservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addressservice.entity.Address;
import com.addressservice.services.AddressService;
import com.addressservice.utils.AddressResponse;

@RestController
public class UserAddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/addresses")
	public ResponseEntity<List<AddressResponse>> getAllAddresses()
	{
		return addressService.getAllAddressAvailable();
	}
	
	@PostMapping("/address")
	public ResponseEntity<AddressResponse> saveNewAddress(@RequestBody Address address) {
		return addressService.saveNewAddressOfUser(address); 
	}
	
	@GetMapping("/address/{userId}")
	public ResponseEntity<List<AddressResponse>> getUsersAddress(@PathVariable("userId") Integer userId){
		return addressService.getAddressByUserId(userId);
	}

}
