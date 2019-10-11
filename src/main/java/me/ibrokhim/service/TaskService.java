package me.ibrokhim.service;

import me.ibrokhim.entity.Task;
import me.ibrokhim.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(UUID id) {
        return taskRepository.getOne(id);
    }

    public Task insert(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public Task delete(UUID id) {
        Task task = taskRepository.getOne(id);

        if (task != null) {
            taskRepository.delete(task);
        }

        return null;
    }
}
