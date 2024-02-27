package com.hcl.personservice.controller;

import com.hcl.personservice.dto.AddressDto;
import com.hcl.personservice.dto.PersonDto;
import com.hcl.personservice.service.AddressService;
import com.hcl.personservice.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping({"api/personService/v1/address"})
    public class AddressController {
        private final Logger LOGGER= LoggerFactory.getLogger(com.hcl.personservice.controller.AddressController.class.getName());
        private final AddressService addressService;
        @Autowired
        public AddressController(AddressService addressService){
            this.addressService = addressService;
        }
        @GetMapping
        public List<AddressDto> getAll(){
            LOGGER.info("getAll");
            return addressService.getAll();
        }
        @GetMapping({"/{id}"})
        public AddressDto getOneById(@PathVariable long id){
            LOGGER.info("getOneById - {}",id);
            return addressService.getOneById(id);
        }
        @PostMapping
        public AddressDto create(@RequestBody AddressDto addressDto){
            LOGGER.info("create - {}",addressDto);
            return addressService.create(addressDto);
        }
        @PutMapping
        public AddressDto update(@RequestBody AddressDto addressDto){
            LOGGER.info("update - {}",addressDto);
            return addressService.update(addressDto);
        }
        @DeleteMapping({"/{id}"})
        public boolean delete(@PathVariable long id){
            LOGGER.info("delete - {}",id);
            return addressService.delete(id);
        }
}
