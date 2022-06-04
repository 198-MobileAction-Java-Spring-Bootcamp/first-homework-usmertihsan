package com.usmert.Homework1.springCore;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USER_")
public class User {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    @Column(name = "user_id")

    private Long userId;

    @Column(name="USER_NAME",length = 50)
    private String userName;

    @Column(name="USER_LAST_NAME",length = 50)
    private String userLastName;

    @Column(name="USER_EMAIL",length = 50)
    private String userEmail;

    @Column(name="USER_TELEPHONE_NUMBER",length = 15)
    private String userTelephoneNumber;

    @Column(name="USER_BIRTHDATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date userBirthDate;

    @Column(name="USER_SITUATION")
    @Transient
    private boolean isActive;

}
