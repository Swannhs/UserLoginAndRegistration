package com.swann.reactandspring.service.userservice;

import com.swann.reactandspring.entity.user.User;
import com.swann.reactandspring.exception.EmailAlreadyExist;
import com.swann.reactandspring.exception.UserNameAlreadyExist;
import com.swann.reactandspring.repository.user.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
    @Autowired
    private UserRegisterRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User saveOrUpdate(User newUser) {
        if (repository.findByEmail(newUser.getEmail()) != null) {
            throw new EmailAlreadyExist("Duplex email address");
        } else {
            try {
                newUser.setPassword(encoder.encode(newUser.getPassword()));
                newUser.setUsername(newUser.getUsername());

                return repository.save(newUser);
            } catch (Exception ex) {
                throw new UserNameAlreadyExist("UserName is already exist");
            }
        }
    }
}
