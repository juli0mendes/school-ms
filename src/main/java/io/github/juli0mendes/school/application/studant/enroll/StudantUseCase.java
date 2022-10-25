package io.github.juli0mendes.school.application.studant.enroll;

import io.github.juli0mendes.school.domain.studant.StudantRepository;

public class StudantUseCase {

    private final StudantRepository studantRepository;

    public StudantUseCase(StudantRepository studantRepository) {
        this.studantRepository = studantRepository;
    }

    public void enroll(StudantDto studantDto) {
        var studant = studantDto.create();
        this.studantRepository.enroll(studant);
    }
}
