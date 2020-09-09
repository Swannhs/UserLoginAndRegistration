package com.swann.reactandspring.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@MappedSuperclass
public abstract class Time<ID> {

    @JsonIgnore
    @Column(name = "created_date")
    private Date CreateDate;

    @JsonIgnore
    @Column(name = "updated_date")
    private Date UpdateDate;

    @PrePersist
    protected void onCreate(){
        this.CreateDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.UpdateDate = new Date();
    }
}
