package com.hasan.crowdcarnival.services;

import com.hasan.crowdcarnival.models.Project;
import com.hasan.crowdcarnival.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }
}
