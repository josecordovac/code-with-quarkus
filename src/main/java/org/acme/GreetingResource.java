package org.acme;

import org.acme.dominio.Fruit;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        Fruit fruit = new Fruit("Apple", 100);
        return fruit.toString();
    }
}
