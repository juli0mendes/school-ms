package io.github.juli0mendes.school.domain.studant.application.studant;

import io.github.juli0mendes.school.application.studant.enroll.StudantDto;
import io.github.juli0mendes.school.application.studant.enroll.StudantUseCase;
import io.github.juli0mendes.school.domain.studant.LegalDocument;
import io.github.juli0mendes.school.domain.studant.Studant;
import io.github.juli0mendes.school.infrastructure.studant.StudantRepositoryMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudantUseCaseTest {

    @Test
    void shouldEnrollStudant() {
        var repository = new StudantRepositoryMemory();
        var useCase = new StudantUseCase(repository);
        var studant = new StudantDto("Júlio", "12345678900", "jmendes@live.com");

        useCase.enroll(studant);

        var studantExists = repository.findByLegalDocument(new LegalDocument("12345678900"));

        assertEquals("Júlio", studantExists.getName());
        assertEquals("12345678900", studantExists.getLegalDocument());
        assertEquals("jmendes@live.com", studantExists.getEmail());
    }
}
