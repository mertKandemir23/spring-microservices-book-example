package com.kandemirmert.bookstore.repository;

import com.kandemirmert.bookstore.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {
}
