package me.jasonchoi.prac1.service;

import me.jasonchoi.prac1.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> addressList();

    Address findById(Long id);

    Address addAddress(Address address);

    String deleteAddress(Long id);
}
