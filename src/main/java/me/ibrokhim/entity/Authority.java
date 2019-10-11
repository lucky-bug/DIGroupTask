package me.ibrokhim.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private int id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String authority;

    @Getter
    @Setter
    @Column(nullable = false)
    private String description;
}
