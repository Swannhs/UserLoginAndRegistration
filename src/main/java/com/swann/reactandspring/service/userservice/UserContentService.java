package com.swann.reactandspring.service.userservice;

import com.swann.reactandspring.entity.UserPost.UserContent;
import com.swann.reactandspring.entity.user.User;
import com.swann.reactandspring.repository.content.UserContentRepository;
import com.swann.reactandspring.repository.user.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContentService {
    @Autowired
    private UserContentRepository repository;

    @Autowired
    private UserRegisterRepository registerRepository;

    public UserContent saveOrUpdate(UserContent content, String name){
        User user = registerRepository.findByUsername(name);
        content.setUser(user);
        return repository.save(content);
    }

    public Iterable<UserContent> viewAllContent(){
        return repository.findAll();
    }
}
