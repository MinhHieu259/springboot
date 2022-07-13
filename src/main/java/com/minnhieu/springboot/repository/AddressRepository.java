package com.minnhieu.springboot.repository;

import com.minnhieu.springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
