package com.swann.reactandspring.admin;

import com.swann.reactandspring.exception.MapValidationErrorService;
import com.swann.reactandspring.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MapValidationErrorService mapService;
    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/admin/update")
    public ResponseEntity<?> updateAdmin(@Valid @RequestBody LoginRequest request, BindingResult result){
        ResponseEntity<?> error = mapService.MapValidationService(result);
        if (error != null) return error;
        return null;
    }
}
