package me.ibrokhim.repository;

import me.ibrokhim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User getOneByUsername(String username);
}
