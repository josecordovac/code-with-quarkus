package org.acme.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testSimpleTaskCreation() {
        Task task = new SimpleTask("1", "Simple Task");
        assertEquals("1", task.getId());
        assertEquals("Simple Task", ((SimpleTask) task).getDescription());
    }

    @Test
    void testTimedTaskCreation() {
        Task task = new TimedTask("2", "Timed Task", 60);
        assertEquals("2", task.getId());
        assertEquals("Timed Task", ((TimedTask) task).getDescription());
        assertEquals(60, ((TimedTask) task).getDurationInMinutes());
    }

    @Test
    void testInvalidTimedTask() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new TimedTask("3", "Invalid Task", -10));
        assertEquals("Duration must be positive", exception.getMessage());
    }
}
