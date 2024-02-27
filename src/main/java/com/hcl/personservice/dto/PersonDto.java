package com.hcl.personservice.dto;

import java.time.LocalDate;
import java.util.Set;

public class PersonDto {
    private long Id;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate joiningDate;
    private String numberOfYearsOfExperience;
    private ProjectDto projectDto;
    private Set<AddressDto> addressDto;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getNumberOfYearsOfExperience() {
        return numberOfYearsOfExperience;
    }
    public void setNumberOfYearsOfExperience(String numberOfYearsOfExperience) {
        this.numberOfYearsOfExperience = numberOfYearsOfExperience;
    }
    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public Set<AddressDto> getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(Set<AddressDto> addressDto) {
        this.addressDto = addressDto;
    }
}
