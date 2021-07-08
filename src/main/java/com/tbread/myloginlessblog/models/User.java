package com.tbread.myloginlessblog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends TimeStamped {
    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kakaoId = null;
    }

    public User(String username, String password, String email, UserRole role, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.kakaoId = kakaoId;
    }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

/*
* 카카오 유저는 이부분 예외처리를 해줘야한다.
* 근데 어떻게?
* */
    @Column(nullable = false, unique = true)
    @Size(min=3,max=10)
    @Pattern(regexp = "^[a-z0-9A-Z]*$")
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column(nullable = true)
    private Long kakaoId;
}
