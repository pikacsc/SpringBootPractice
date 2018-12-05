package me.jasonchoi.prac1.service;

import me.jasonchoi.prac1.model.Address;
import me.jasonchoi.prac1.model.User;
import me.jasonchoi.prac1.repository.AddressRepository;
import me.jasonchoi.prac1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    private UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(new Address());
    }

    @Override
    public Address addAddress(Address address) {
        address.setUser(userRepository.findById(address.getUserId()).orElse(new User()));
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return  "{'message': 'Address deleted successfully.'}";
    }
}
