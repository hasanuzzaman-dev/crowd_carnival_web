package com.hasan.crowdcarnival.services;

import com.hasan.crowdcarnival.models.Project;
import com.hasan.crowdcarnival.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }
    public Page<Project> findAllByActive(boolean isActive, Pageable pageable){
        return projectRepository.findAllByIsActive(isActive,pageable);
    }

    public Optional<Project> findById(Long projectId){
        return projectRepository.findById(projectId);
    }
}
