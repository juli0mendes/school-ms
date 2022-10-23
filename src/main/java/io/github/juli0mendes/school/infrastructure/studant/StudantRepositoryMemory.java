package io.github.juli0mendes.school.infrastructure.studant;

import io.github.juli0mendes.school.domain.studant.LegalDocument;
import io.github.juli0mendes.school.domain.studant.Studant;
import io.github.juli0mendes.school.domain.studant.StudantNotExistsException;
import io.github.juli0mendes.school.domain.studant.StudantRepository;

import java.util.ArrayList;
import java.util.List;

public class StudantRepositoryMemory implements StudantRepository {

    private List<Studant> studants = new ArrayList<>();

    @Override
    public void enroll(Studant studant) {
        this.studants.add(studant);
    }

    @Override
    public Studant findByLegalDocument(LegalDocument legalDocument) {
        return this.studants
                .stream()
                .filter(s -> s.getLegalDocument().equals(legalDocument.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudantNotExistsException(legalDocument));
    }

    @Override
    public List<Studant> findAllEnrolled() {
        return this.studants;
    }
}
