package com.addressservice.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addressservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	 List<Address> findByUserId(Integer userId);

}
