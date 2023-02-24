package com.goias.msusers.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profile;

    public User(String userName, String userEmail, String userPassword, Profile profile) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.profile = profile;
    }
}
