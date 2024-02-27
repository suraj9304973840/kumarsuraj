package com.hcl.personservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String firstName;
    private String lastName;

    private LocalDate joiningDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Project project;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private Set<Address> address;


    public Person() {
    }

    public Person(long id, String firstName, String lastName,LocalDate joiningDate) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate=joiningDate;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
