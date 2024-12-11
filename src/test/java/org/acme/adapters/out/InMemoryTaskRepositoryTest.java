package org.acme.adapters.out;

import org.acme.dominio.SimpleTask;
import org.acme.dominio.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskRepositoryTest {

    private final InMemoryTaskRepository repository = new InMemoryTaskRepository();

    @Test
    void testSaveAndFindAll() {
        Task task = new SimpleTask("1", "Test Task");
        repository.save(task);

        List<Task> tasks = repository.findAll();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    void testDeleteById() {
        Task task = new SimpleTask("1", "Test Task");
        repository.save(task);
        repository.deleteById("1");

        assertTrue(repository.findAll().isEmpty());
    }
}
