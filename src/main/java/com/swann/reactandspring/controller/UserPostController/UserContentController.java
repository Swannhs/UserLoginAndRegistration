package com.swann.reactandspring.controller.UserPostController;

import com.swann.reactandspring.entity.UserPost.UserContent;
import com.swann.reactandspring.exception.MapValidationErrorService;
import com.swann.reactandspring.service.userservice.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/user/post")
public class UserContentController {
    @Autowired
    private MapValidationErrorService errorService;

    @Autowired
    private UserContentService service;

    @PostMapping
    public ResponseEntity<?> createContent(@Valid @RequestBody UserContent content, BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        UserContent Content = service.saveOrUpdate(content, principal.getName());
        return new ResponseEntity<UserContent>(Content,HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public Iterable<UserContent> viewAllContent(){
        return service.viewAllContent();
    }
}
