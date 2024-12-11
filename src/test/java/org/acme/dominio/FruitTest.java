package org.acme.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    @ParameterizedTest
    @CsvSource({
        "Apple, 100",
        "Banana, 50",
        "Cherry, 200"
    })
    @DisplayName("Valid fruits should be created successfully")
    void testValidFruits(String name, int price) {
        Fruit fruit = new Fruit(name, price);
        assertEquals(name, fruit.name());
        assertEquals(price, fruit.price());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("Invalid prices should throw IllegalArgumentException")
    void testInvalidPrices(int price) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Fruit("Apple", price));
        assertEquals("Price cannot be negative", exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null or empty names should throw IllegalArgumentException")
    void testInvalidNames(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Fruit(name, 100));
        assertEquals("Name cannot be null or blank", exception.getMessage());
    }
}
