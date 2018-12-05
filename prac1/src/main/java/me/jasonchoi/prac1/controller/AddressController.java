package me.jasonchoi.prac1.controller;

import me.jasonchoi.prac1.model.Address;
import me.jasonchoi.prac1.service.AddressService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/list")
    public List<Address> addressList() {
        return addressService.addressList();
    }

    @RequestMapping("/list/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @RequestMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }


    @RequestMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }
}
