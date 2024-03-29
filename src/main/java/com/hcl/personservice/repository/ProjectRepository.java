package com.hcl.personservice.repository;

import com.hcl.personservice.model.Address;
import com.hcl.personservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,Long> {
}
