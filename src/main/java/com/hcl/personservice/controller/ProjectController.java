package com.hcl.personservice.controller;

import com.hcl.personservice.dto.AddressDto;
import com.hcl.personservice.dto.ProjectDto;
import com.hcl.personservice.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/personService/v1/project"})
public class ProjectController {
    private final Logger LOGGER= LoggerFactory.getLogger(com.hcl.personservice.controller.PersonController.class.getName());
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {this.projectService = projectService;}
    @GetMapping
    public List<ProjectDto> getAll(){
        LOGGER.info("getAll");
        return projectService.getAll();
    }
    @GetMapping({"/{id}"})
    public ProjectDto getOneById(@PathVariable long id){
        LOGGER.info("getOneById - {}",id);
        return projectService.getOneById(id);
    }
    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto projectDto){
        LOGGER.info("create - {}",projectDto);
        return projectService.create(projectDto);
    }
    @PutMapping
    public ProjectDto update(@RequestBody ProjectDto projectDto){
        LOGGER.info("update - {}",projectDto);
        return projectService.update(projectDto);
    }
    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable long id){
        LOGGER.info("delete - {}",id);
        return projectService.delete(id);
    }
}
