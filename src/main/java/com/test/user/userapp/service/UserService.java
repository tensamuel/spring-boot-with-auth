package com.test.user.userapp.service;

import com.test.user.userapp.dto.User;
import com.test.user.userapp.entity.UserEntity;
import com.test.user.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user){
        userRepository.save(prepareEntity(user));
        return "User successfully registered";
    }

    private UserEntity prepareEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        return userEntity;
    }
}
