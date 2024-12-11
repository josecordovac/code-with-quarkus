package org.acme.dominio;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(String id);
    void save(Task task);
    void deleteById(String id);
}
