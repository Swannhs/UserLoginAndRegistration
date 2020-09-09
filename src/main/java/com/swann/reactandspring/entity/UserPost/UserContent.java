package com.swann.reactandspring.entity.UserPost;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.model.core.ID;
import com.swann.reactandspring.entity.user.User;
import com.swann.reactandspring.service.Time;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class UserContent extends Time<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please write a title of the content")
    private String title;

    @JsonIgnore
    private String thumbnail;
    @JsonIgnore
    private byte[] data;

    @NotNull(message = "Please enter a content")
    @Type(type = "text")
    private String content;
    @JsonIgnore
    private String images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private String contentCreator;

}
