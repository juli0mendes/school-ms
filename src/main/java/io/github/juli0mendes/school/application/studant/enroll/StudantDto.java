package io.github.juli0mendes.school.application.studant.enroll;

import io.github.juli0mendes.school.domain.studant.Email;
import io.github.juli0mendes.school.domain.studant.LegalDocument;
import io.github.juli0mendes.school.domain.studant.Studant;

public class StudantDto {

    private String name;
    private String legalDocumentNumber;
    private String email;

    public StudantDto(String name, String legalDocumentNumber, String email) {
        this.name = name;
        this.legalDocumentNumber = legalDocumentNumber;
        this.email = email;
    }

    public Studant create() {
        return new Studant(
                new LegalDocument(this.legalDocumentNumber),
                this.name,
                new Email(this.email));
    }
}
