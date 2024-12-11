package org.acme.adapters.in;

import org.acme.application.TaskService;
import org.acme.dominio.Task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TaskController {

    private final TaskService service;

    // Constructor
    public TaskController(TaskService service) {
        this.service = service;
    }

    // Endpoint para obtener todas las tareas
    @GET
    public List<Task> listTasks() {
        return service.listTasks();
    }

    // Endpoint para obtener una tarea por ID
    @GET
    @Path("/{id}")
    public Task getTask(@PathParam("id") String id) {
        return service.getTaskById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    }

    // Endpoint para crear una nueva tarea
    @POST
    public Response createTask(Task task) {
        service.addTask(task);
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    // Endpoint para eliminar una tarea por ID
    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") String id) {
        try {
            service.deleteTask(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
