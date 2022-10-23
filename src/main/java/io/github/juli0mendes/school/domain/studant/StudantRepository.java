package io.github.juli0mendes.school.domain.studant;

import java.util.List;

public interface StudantRepository {

    void enroll(Studant studant);

    Studant findByLegalDocument(LegalDocument legalDocument);

    List<Studant> findAllEnrolled();
}