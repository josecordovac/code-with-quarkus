package org.acme.application;

import org.acme.adapters.out.InMemoryTaskRepository;
import org.acme.dominio.SimpleTask;
import org.acme.dominio.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private final TaskService service = new TaskService(new InMemoryTaskRepository());

    @Test
    void testAddAndListTasks() {
        Task task = new SimpleTask("1", "Task Service Test");
        service.addTask(task);

        assertEquals(1, service.listTasks().size());
        assertEquals(task, service.listTasks().get(0));
    }

    @Test
    void testDeleteTask() {
        Task task = new SimpleTask("1", "Delete Task Test");
        service.addTask(task);
        service.deleteTask("1");

        assertTrue(service.listTasks().isEmpty());
    }
}
