package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.User;
import com.jojothespecialone.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private BCryptPasswordEncoder encoder;
    @Autowired private UserRepository userRepository;

    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
