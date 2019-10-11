package me.ibrokhim.controller;

import me.ibrokhim.entity.Task;
import me.ibrokhim.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List getAll() {
        return taskService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Task getById(@PathVariable UUID id) {
        return taskService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task insert(@RequestBody Task task) {
        return taskService.insert(task);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping(value = "/{id}")
    public Task delete(@PathVariable UUID id) {
        return taskService.delete(id);
    }
}
