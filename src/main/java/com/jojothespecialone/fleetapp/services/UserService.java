package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.User;
import com.jojothespecialone.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
