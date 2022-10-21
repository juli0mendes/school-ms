package io.github.juli0mendes.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LegalDocumentTest {

    @Test
    void shouldNotCreateLegalDocumentsWithInvalidNumbers() {
        assertThrows(IllegalArgumentException.class,
                () -> new LegalDocument(null));

        assertThrows(IllegalArgumentException.class,
                () -> new LegalDocument(""));

        assertThrows(IllegalArgumentException.class,
                () -> new LegalDocument("132456"));
    }

    @Test
    void shouldCreateLegalDocumentWithValidNumber() {
        var legalDocumentNumberCreated = new LegalDocument("13859704729");

        assertNotNull(legalDocumentNumberCreated);
    }
}
