package me.ibrokhim.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private UUID id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean accountNonExpired;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean accountNonLocked;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean credentialsNonExpired;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean enabled;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Task> tasks;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Authority> authorities;
}
