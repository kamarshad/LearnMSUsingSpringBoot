package com.KSTech.learnmicroserviceswithspringboot.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Post {
    @Id // Put as its a primary key
    @GeneratedValue // wants spring boot to fill it in sequence
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
