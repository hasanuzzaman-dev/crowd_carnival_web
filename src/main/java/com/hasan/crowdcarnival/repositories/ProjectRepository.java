package com.hasan.crowdcarnival.repositories;

import com.hasan.crowdcarnival.models.Contact;
import com.hasan.crowdcarnival.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Page<Project> findAllByIsActive(boolean isActive, Pageable pageable);

}
