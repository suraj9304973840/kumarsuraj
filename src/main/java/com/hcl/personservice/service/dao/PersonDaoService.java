package com.hcl.personservice.service.dao;

import com.hcl.personservice.model.Person;
import com.hcl.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonDaoService {
    @Autowired
    private PersonRepository personRepository;
    /*private final List<Person> people =new ArrayList<>(Arrays.asList(new Person(1001,"SURAJ","Kumar", LocalDate.now()),
            new Person(1002,"Rahul","Singh",LocalDate.now()),
            new Person(1003,"Shashank","Singh",LocalDate.now())));*/

    public List<Person> getAll() {
        return personRepository.findAll();
       // return people;
    }

    public Optional<Person> getOneById(long id) {
         return personRepository.findById(id);
         /*Optional<Person> optionalPerson = people.stream().filter(person -> person.getId() == id).findFirst();
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        return null;*/
    }

    public Person create(Person person) {
        return personRepository.save(person);
        //adds the new person to the list
       /* people.add(person);
        //get the added person and return
        return getOneById(person.getId());*/
    }

    public Person update(Person person) {
        return personRepository.save(person);
        // remove the existing person object from the list
       /* delete(person.getId());
        //add the updated person object to the list
        return create(person);*/
    }

    public boolean delete(long id) {
        personRepository.deleteById(id);
        return true;
        //remove the existing person object from the list
        //return people.removeIf(person -> person.getId()==id);
    }
}
