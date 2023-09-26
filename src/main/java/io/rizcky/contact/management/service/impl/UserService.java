package io.rizcky.contact.management.service.impl;


import io.rizcky.contact.management.entity.User;
import io.rizcky.contact.management.exception.ApiException;
import io.rizcky.contact.management.model.UserRequest;
import io.rizcky.contact.management.repository.UserRepository;
import io.rizcky.contact.management.security.BCrypt;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;
    public void register(UserRequest request){
        Set<ConstraintViolation<UserRequest>> constraintViolations = validator.validate(request);
        if(constraintViolations.size() != 0){
            //error
            throw new ConstraintViolationException(constraintViolations);
        }

        if(userRepository.existsById(request.getUsername())){
            throw new ApiException("Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);


    }
}
