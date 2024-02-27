package com.hcl.personservice.service;

import com.hcl.personservice.dto.AddressDto;
import com.hcl.personservice.dto.ProjectDto;
import com.hcl.personservice.model.Address;
import com.hcl.personservice.model.Project;
import com.hcl.personservice.repository.AddressRepository;
import com.hcl.personservice.repository.PersonRepository;
import com.hcl.personservice.service.dao.AddressDaoService;
import com.hcl.personservice.service.dao.ProjectDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectDaoService projectDaoService;
    public List<ProjectDto> getAll(){
        final List<Project> projects =projectDaoService.getAll();
        return toDto(projects);
    }
    public ProjectDto getOneById(long id){
        Optional<Project> optionalProject = projectDaoService.getOneById(id);
        if (optionalProject.isPresent()){
            return toDto(optionalProject.get());
        }
        return null;
    }
    public ProjectDto create(ProjectDto projectDto){
        final Project project =toEntity(projectDto);
        final Project savedProject = projectDaoService.create(project);
        final ProjectDto result = toDto(savedProject);
        return result;
    }
    public ProjectDto update(ProjectDto projectDto){
        final Project project= toEntity(projectDto);
        final Project updatedProject=projectDaoService.update(project);
        return toDto(updatedProject);
    }
    public boolean delete(long id){
        return projectDaoService.delete(id);
    }
    //------------------------------------------------------------------------------------
    private List<ProjectDto> toDto(List<Project> projects){
        final List<ProjectDto> result = projects.stream().map(project -> toDto(project)).collect(Collectors.toList());
        return result;
    }
    private ProjectDto toDto(Project project){
        ProjectDto result =new ProjectDto();
        result.setId(project.getId());
        result.setTitle(project.getTitle());
        result.setTechnology(project.getTechnology());
        return result;
    }
    private Project toEntity(ProjectDto projectDto){
        Project project=new Project();
        project.setId(projectDto.getId());
        project.setTitle(projectDto.getTitle());
        project.setTechnology(projectDto.getTechnology());
        return project;
    }
}
