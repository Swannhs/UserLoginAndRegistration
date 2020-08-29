package com.swann.reactandspring.controller.user;

import com.swann.reactandspring.entity.user.User;
import com.swann.reactandspring.exception.MapValidationErrorService;
import com.swann.reactandspring.service.userservice.UserRegisterService;
import com.swann.reactandspring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private UserRegisterService service;

    @Autowired
    private MapValidationErrorService errorService;

    @Autowired
    private UserValidator validator;

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody User register, BindingResult result){

        // Password match
        validator.validate(register, result);
        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        User newUser = service.saveOrUpdate(register);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
