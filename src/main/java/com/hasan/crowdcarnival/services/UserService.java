package com.hasan.crowdcarnival.services;

import com.hasan.crowdcarnival.models.Project;
import com.hasan.crowdcarnival.models.User;
import com.hasan.crowdcarnival.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User save(User user){
        return userRepository.save(user);
    }

    public User getUserByUsername(String email){
        return userRepository.getUserByUserName(email);
    }
}
