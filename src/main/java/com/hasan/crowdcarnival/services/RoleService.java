package com.hasan.crowdcarnival.services;

import com.hasan.crowdcarnival.models.Role;
import com.hasan.crowdcarnival.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
}
