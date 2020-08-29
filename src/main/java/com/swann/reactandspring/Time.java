package com.swann.reactandspring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class Time {
    @JsonIgnore
    private Date CreateDate;
    @JsonIgnore
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
