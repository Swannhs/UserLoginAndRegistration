package com.swann.reactandspring.service.userservice;

import com.swann.reactandspring.repository.user.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserRegisterRepository repository;


}
