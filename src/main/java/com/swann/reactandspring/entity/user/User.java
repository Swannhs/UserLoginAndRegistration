package com.swann.reactandspring.entity.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.model.core.ID;
import com.swann.reactandspring.entity.UserPost.UserContent;
import com.swann.reactandspring.service.Time;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends Time<ID> implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "You should have an username")
    @Column(updatable = false, unique = true)
    private String username;

    @NotNull(message = "Please enter your first name")
    private String firstName;

    @NotNull(message = "Please enter your last name")
    private String lastName;

    @Email(message = "Please provide a valid email")
    @NotNull(message = "Please enter your email")
    private String email;


    @NotNull(message = "Please enter password")
    @Length(min = 4, message = "Please provide at least 4 characters")
    private String password;

    @NotNull(message = "Please enter confirm password")
    @Transient
    private String confirm;

    @JsonIgnore
    private String profilePicture;

    @JsonIgnore
    private String fileName;

    @JsonIgnore
    private String fileType;

    @JsonIgnore
    @Lob
    private byte[] data;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    private List<UserContent> contents = new ArrayList<>();


    /*
    UserDetails interface methods
     */

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
