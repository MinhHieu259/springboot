package com.minnhieu.springboot.service.impl;

import com.minnhieu.springboot.model.Address;
import com.minnhieu.springboot.model.User;
import com.minnhieu.springboot.repository.AddressRepository;
import com.minnhieu.springboot.repository.UserRepository;
import com.minnhieu.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address addAddress(Address address) {
        address.setUser(userRepository.findById(address.getUser().getId()).get());
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddress(Long id) {
        Address address = addressRepository.getById(id);
        addressRepository.delete(address);
        return "address delete successfully";
    }
}
