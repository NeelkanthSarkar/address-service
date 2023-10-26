package com.addressservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.addressservice.entity.Address;
import com.addressservice.jparepo.AddressRepo;
import com.addressservice.utils.AddressMapper;
import com.addressservice.utils.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	
    //method to get all the addresses available currently
	public ResponseEntity<List<AddressResponse>> getAllAddressAvailable(){
		
		List<AddressResponse> listOfAddressResponse = addressRepo.findAll()
				.stream()
				  .map(addr->{
					  return AddressMapper.mapAddressToAddressResponse(addr, new AddressResponse());
				  }).
				    collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(listOfAddressResponse);
	}


	public ResponseEntity<AddressResponse> saveNewAddressOfUser(Address address) {
		  Address addr = addressRepo.save(address);
		  AddressResponse addResp = AddressMapper.mapAddressToAddressResponse(addr, new AddressResponse());
		  
		return ResponseEntity.status(HttpStatus.CREATED).body(addResp);
	}


	public ResponseEntity<List<AddressResponse>> getAddressByUserId(Integer userId) {
		  List<AddressResponse> listOfAddressResponse = addressRepo.findByUserId(userId)
				                                                       .stream()
				                                                         .map(addr->
				                                                         {
				                                                        	 return AddressMapper.mapAddressToAddressResponse(addr, new AddressResponse());
				                                                         }
				                                                         ).collect(Collectors.toList());
		  
		return ResponseEntity.status(HttpStatus.FOUND).body(listOfAddressResponse);
	}
	
}
