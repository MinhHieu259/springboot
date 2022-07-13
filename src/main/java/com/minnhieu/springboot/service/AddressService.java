package com.minnhieu.springboot.service;

import com.minnhieu.springboot.model.Address;
import com.minnhieu.springboot.model.User;

import java.util.List;

public interface AddressService {
    List<Address> addressList();
    Address findOne(Long id);
    Address addAddress(Address address);
    String deleteAddress(Long id);
}
