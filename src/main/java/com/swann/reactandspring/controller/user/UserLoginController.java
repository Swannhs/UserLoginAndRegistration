package com.swann.reactandspring.controller.user;

import com.swann.reactandspring.exception.MapValidationErrorService;
import com.swann.reactandspring.payload.JWTLoginSuccessResponse;
import com.swann.reactandspring.payload.LoginRequest;
import com.swann.reactandspring.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import static com.swann.reactandspring.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private MapValidationErrorService service;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping
    public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequest request, BindingResult result){
        ResponseEntity<?> error = service.MapValidationService(result);
        if (error != null) return error;
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }
}
