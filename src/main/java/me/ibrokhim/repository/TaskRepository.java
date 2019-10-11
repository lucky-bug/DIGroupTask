package me.ibrokhim.repository;

import me.ibrokhim.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
