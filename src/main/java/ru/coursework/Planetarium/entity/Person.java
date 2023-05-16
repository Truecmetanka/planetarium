package ru.coursework.Planetarium.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String email;
    String password;
    String name;

    String role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "perosn_id")
    private List<Article> favorites = new ArrayList<>();

}
