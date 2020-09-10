package com.test.user.userapp.service;

import com.test.user.userapp.dto.User;
import com.test.user.userapp.dto.UserDetailsImpl;
import com.test.user.userapp.entity.UserEntity;
import com.test.user.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByFirstName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
        User user1 = new User();
        user1.setFirstName(userName);
        user1.setLastName(userName);
        user1.setRoles("ADMIN");
        return new UserDetailsImpl(user1);
    }
}
