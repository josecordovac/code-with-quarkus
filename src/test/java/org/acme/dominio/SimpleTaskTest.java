package org.acme.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTaskTest {

    @Test
    @DisplayName("Constructor should throw exception for null description")
    void testNullDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new SimpleTask("1", null));
        assertEquals("Description cannot be null or blank", exception.getMessage());
    }

    @Test
    @DisplayName("Constructor should throw exception for blank description")
    void testBlankDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new SimpleTask("1", " "));
        assertEquals("Description cannot be null or blank", exception.getMessage());
    }

    @Test
    @DisplayName("Constructor should create valid SimpleTask")
    void testValidDescription() {
        SimpleTask task = new SimpleTask("1", "Valid Task");
        assertEquals("1", task.getId());
        assertEquals("Valid Task", task.getDescription());
    }
}
