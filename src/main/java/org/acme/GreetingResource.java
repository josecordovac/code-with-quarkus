package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return """
                {
                    "name": "John Doe",
                    "age": 45,
                    "address": "Doe Street, 23, Java Town"
                }
                """;
    }
}
