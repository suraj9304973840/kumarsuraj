package com.hcl.personservice.service;
import com.hcl.personservice.dto.AddressDto;
import com.hcl.personservice.model.Address;
import com.hcl.personservice.service.dao.AddressDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressDaoService addressDaoService;
    public List<AddressDto> getAll(){
        final List<Address> addresses =addressDaoService.getAll();
        return toDto(addresses);
    }
    public AddressDto getOneById(long id){
        Optional<Address> optionalAddress = addressDaoService.getOneById(id);
        if (optionalAddress.isPresent()){
            return toDto(optionalAddress.get());
        }
        return null;
    }
    public AddressDto create(AddressDto addressDto){
        final Address address =toEntity(addressDto);
        final Address savedAddress = addressDaoService.create(address);
        final AddressDto result = toDto(savedAddress);
        return result;
    }
    public AddressDto update(AddressDto addressDto){
        final Address address = toEntity(addressDto);
        final Address updatedAddress=addressDaoService.update(address);
        return toDto(updatedAddress);
    }
    public boolean delete(long id){
        return addressDaoService.delete(id);
    }
    //------------------------------------------------------------------------------------
    private List<AddressDto> toDto(List<Address> addresses){
        final List<AddressDto> result = addresses.stream().map(address -> toDto(address)).collect(Collectors.toList());
        return result;
    }
    private AddressDto toDto(Address address){
        AddressDto result = new AddressDto();
        result.setId(address.getId());
        result.setCity(address.getCity());
        result.setState(address.getState());
        return result;
    }
    private Address toEntity(AddressDto addressDto){
        Address address =new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        return address;
    }
}
