package me.ibrokhim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Getter
    @Column(nullable = false, unique = true)
    private UUID id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private boolean completed;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Getter
    @Setter
    @CreatedDate
    private Date createdDate;

    @Getter
    @Setter
    @LastModifiedDate
    private Date lastModifiedDate;

    public Task(UUID id, String name, boolean completed, User user) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.user = user;
    }

    public Task(String name, boolean completed, User user) {
        this(UUID.randomUUID(), name, completed, user);
    }

    public Task(String name, User user) {
        this(UUID.randomUUID(), name, false, user);
    }

    public Task() {
        this(null, null, false, null);
    }
}
