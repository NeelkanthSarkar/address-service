package com.addressservice.utils;

import com.addressservice.entity.Address;

public class AddressMapper {

	public static AddressResponse mapAddressToAddressResponse(Address address,AddressResponse addressResponse) {
		
		addressResponse.setAddressId(address.getAddressId());
		addressResponse.setUserId(address.getUserId());
		addressResponse.setAddress1(address.getAddress1());
		addressResponse.setAddress2(address.getAddress2());
		addressResponse.setCity(address.getCity());
		addressResponse.setState(address.getState());
		addressResponse.setCountry(address.getCountry());
		addressResponse.setPinCode(address.getPinCode());
		
		return addressResponse;
	}
}
