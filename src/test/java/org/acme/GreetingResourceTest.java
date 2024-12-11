package org.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        GreetingResource resource = new GreetingResource();
        String response = resource.hello();

        assertEquals("Fruit[name=Apple, price=100]", response);
    }
}