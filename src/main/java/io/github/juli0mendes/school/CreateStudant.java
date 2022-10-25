package io.github.juli0mendes.school;

import io.github.juli0mendes.school.application.studant.enroll.StudantDto;
import io.github.juli0mendes.school.application.studant.enroll.StudantUseCase;
import io.github.juli0mendes.school.infrastructure.studant.StudantRepositoryMemory;

public class CreateStudant {

    public static void main(String[] args) {
        var name = "Jùlio";
        var legalDocumentNumber = "12345678900";
        var email = "jmendes@live.com";

        var studantUseCase = new StudantUseCase(new StudantRepositoryMemory());

        studantUseCase.enroll(new StudantDto(name, legalDocumentNumber, email));
    }
}
