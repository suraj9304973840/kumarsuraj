package com.hcl.personservice.service;

import com.hcl.personservice.dto.AddressDto;
import com.hcl.personservice.dto.PersonDto;
import com.hcl.personservice.dto.ProjectDto;
import com.hcl.personservice.model.Address;
import com.hcl.personservice.model.Person;
import com.hcl.personservice.model.Project;
import com.hcl.personservice.service.dao.PersonDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final String SPACE =" ";
    @Autowired
    private PersonDaoService personDaoService;
    public List<PersonDto> getAll(){
        final List<Person> persons =personDaoService.getAll();
        return toDto(persons);
    }
    public PersonDto getOneById(long id){
        Optional<Person> optionalPerson = personDaoService.getOneById(id);
        if (optionalPerson.isPresent()){
            return toDto(optionalPerson.get());
        }
        return null;
    }
    public PersonDto create(PersonDto personDto){
        final Person person =toEntity(personDto);
        final Person savedPerson = personDaoService.create(person);
        final PersonDto result = toDto(savedPerson);
        return result;
    }
    public PersonDto update(PersonDto personDto){
        final Person person = toEntity(personDto);
        final Person updatedPerson=personDaoService.update(person);
        return toDto(updatedPerson);
    }
    public boolean delete(long id){
        return personDaoService.delete(id);
    }
    //------------------------------------------------------------------------------------
    private List<PersonDto> toDto(List<Person> persons){
        final List<PersonDto> result = persons.stream().map(person -> toDto(person)).collect(Collectors.toList());
        return result;
    }
    private PersonDto toDto(Person person){
        PersonDto result = new PersonDto();
        result.setId(person.getId());
        result.setFirstName(person.getFirstName());
        result.setLastName(person.getLastName());
        result.setFullName(fullName(person.getFirstName(),person.getLastName()));
        result.setJoiningDate(person.getJoiningDate());
        result.setNumberOfYearsOfExperience(findExperience(person.getJoiningDate()));

        Set<AddressDto> addressDtos=toDto(person.getAddress());
        result.setAddressDto(addressDtos);

        final Project project =person.getProject();
        ProjectDto projectDto =toDto(project);
        result.setProjectDto(projectDto);
        return result;
    }

    private String findExperience(LocalDate joiningDate) {
        final long experience = ChronoUnit.YEARS.between(joiningDate,LocalDate.now());
        return String.valueOf(experience);
    }

    private String fullName(final String firstName,final String lastName){
        return firstName+SPACE+lastName;
    }
    private Person toEntity(PersonDto personDto){
        Person person =new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setJoiningDate(personDto.getJoiningDate());

        final Set<AddressDto> addressDto =personDto.getAddressDto();
        Set<Address> addresses =toEntity(addressDto);
        person.setAddress(addresses);
        for(Address address:addresses){
            address.setPerson(person);
        }
        //addresses.forEach(address -> address.setPerson(person));


        final ProjectDto projectDto =personDto.getProjectDto();
        Project project =  toEntity(projectDto);

        person.setProject(project);
        project.setPerson(person);

        return person;
    }
    private  Project toEntity(ProjectDto projectDto){
        Project project=new Project();
        project.setId(projectDto.getId());
        project.setTitle(projectDto.getTitle());
        project.setTechnology(projectDto.getTechnology());
        return project;
    }
    private ProjectDto toDto(Project project){
        ProjectDto projectDto =new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setTitle(project.getTitle());
        projectDto.setTechnology(project.getTechnology());
        return projectDto;
    }
    private Set<Address> toEntity(Set<AddressDto> addressDto1) {
        return addressDto1.stream().map(addressDto -> toEntity(addressDto)).collect(Collectors.toSet());
    }
    private Address toEntity(AddressDto addressDto){
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        return address;
    }
    private Set<AddressDto> toDto(Set<Address> addresses){
        return addresses.stream().map(address -> toDto(address)).collect(Collectors.toSet());
    }
    private AddressDto toDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        return addressDto;
    }
}
