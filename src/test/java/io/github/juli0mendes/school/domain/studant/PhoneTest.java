package io.github.juli0mendes.school.domain.studant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneTest {

    @Test
    void shouldNotCreatePhonesWithInvalidAreaCodes() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, "99988774455"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", "99988774455"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("1", "99988774455"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("123", "99988774455"));
    }

    @Test
    void shouldNotCreatePhonesWithInvalidNumbers() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("21", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("21", ""));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("21", "123"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("21", "1234567890"));
    }

    @Test
    void shouldCreatePhoneWithValidAreaCodeAndNumber() {
        var phoneCreated = new Phone("21", "996633225");

        assertNotNull(phoneCreated);
    }
}
