package io.github.juli0mendes.school.domain.studant;

public class StudantNotExistsException extends RuntimeException {

    private static final long serialVersionUID = 6272146327864761773L;

    public StudantNotExistsException(LegalDocument number) {
        super("Studant not exists with Legal Document Number: " + number);
    }
}
