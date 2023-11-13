package com.example.demo.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema="unihack")
public class User {

    @Id
    private Long userId;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Info> info;

}

