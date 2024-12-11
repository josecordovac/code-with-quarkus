package org.acme.adapters.in;

import org.acme.application.TaskService;
import org.acme.dominio.SimpleTask;
import org.acme.dominio.Task;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    private TaskService serviceMock;
    private TaskController controller;

    @BeforeEach
    void setup() {
        serviceMock = Mockito.mock(TaskService.class);
        controller = new TaskController(serviceMock);
    }

    @Test
    void testListTasks() {
        // Configurar el mock para devolver una lista de tareas
        Task task1 = new SimpleTask("1", "Task 1");
        Task task2 = new SimpleTask("2", "Task 2");
        when(serviceMock.listTasks()).thenReturn(List.of(task1, task2));

        // Llamar al método y verificar el resultado
        List<Task> result = controller.listTasks();
        assertEquals(2, result.size());
        assertEquals(task1, result.get(0));
        assertEquals(task2, result.get(1));
        verify(serviceMock, times(1)).listTasks();
    }

    @Test
    void testCreateTask() {
        // Crear una tarea
        Task task = new SimpleTask("1", "New Task");

        // Llamar al método y verificar la respuesta
        Response response = controller.createTask(task);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(task, response.getEntity());

        // Verificar que el servicio fue llamado correctamente
        verify(serviceMock, times(1)).addTask(task);
    }

    @Test
    void testDeleteTaskSuccess() {
        // Simular eliminación exitosa
        doNothing().when(serviceMock).deleteTask("1");

        // Llamar al método y verificar la respuesta
        Response response = controller.deleteTask("1");
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

        // Verificar que el servicio fue llamado correctamente
        verify(serviceMock, times(1)).deleteTask("1");
    }

    @Test
    void testDeleteTaskFailure() {
        // Simular una excepción al eliminar
        doThrow(new RuntimeException("Task not found")).when(serviceMock).deleteTask("2");

        // Llamar al método y verificar la respuesta
        Response response = controller.deleteTask("2");
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertEquals("Task not found", response.getEntity());

        // Verificar que el servicio fue llamado correctamente
        verify(serviceMock, times(1)).deleteTask("2");
    }
}