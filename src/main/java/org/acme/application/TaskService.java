package org.acme.application;

import org.acme.dominio.Task;
import org.acme.dominio.TaskRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return repository.findById(id);
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}
