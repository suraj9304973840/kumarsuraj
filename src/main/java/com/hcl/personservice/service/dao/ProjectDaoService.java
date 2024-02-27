package com.hcl.personservice.service.dao;

import com.hcl.personservice.model.Address;
import com.hcl.personservice.model.Project;
import com.hcl.personservice.repository.AddressRepository;
import com.hcl.personservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDaoService {
    @Autowired
    private ProjectRepository projectRepository;
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> getOneById(long id) {
        return projectRepository.findById(id);

    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public boolean delete(long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
