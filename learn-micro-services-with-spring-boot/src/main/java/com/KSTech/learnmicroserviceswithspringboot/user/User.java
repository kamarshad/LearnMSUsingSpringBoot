package com.KSTech.learnmicroserviceswithspringboot.user;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.geometry.Pos;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

// lombok fulfil  the setter and getter definitions during the byte code conversion activity
@Getter
@Setter
@ApiModel(description = "All about the user model")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    @Size(min = 2, message = "User name should not be less than 2 characters")
    @ApiModelProperty(notes = "User name should not be less than 2 characters")
    private String userName;
    @Past
    @ApiModelProperty(notes = "Birth Date should not be present or future")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(long userId, String userName, Date dateOfBirth) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    // Until i have not added this default constructor, the new record was not being added
    // Because the default constructor has gone as soon we provided the parametrized constructor
    // Since when that
    protected User() { }
}
