package com.hasan.crowdcarnival.config;

import com.hasan.crowdcarnival.models.User;
import com.hasan.crowdcarnival.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.getUserByUserName(email);
        if (user ==null){
            throw new UsernameNotFoundException("User couldn't found !!");
        }

        MyUserDetails myUserDetails = new MyUserDetails(user);
        return myUserDetails;
    }
}
