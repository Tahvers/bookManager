package com.example.bookmanager.entity;

import com.example.bookmanager.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    @OneToMany(mappedBy = "user")
    private Set<UserBook> userBooks = new HashSet<>();
    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDate.now();
        }
    }
}
