package io.github.juli0mendes.school.domain.studant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    void shouldNotCreateEmailsWithInvalidAddresses() {
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailInvalido"));
    }

    @Test
    void shouldCreateEmailWithValidAddress() {
        var emailCreated = new Email("jmendes@live.com");

        assertNotNull(emailCreated);
    }
}
