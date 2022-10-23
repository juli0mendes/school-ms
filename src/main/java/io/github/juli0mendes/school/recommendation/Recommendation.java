package io.github.juli0mendes.school.recommendation;

import io.github.juli0mendes.school.studant.Studant;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Recommendation {

    private Studant indicated;
    private Studant indicator;
    private LocalDateTime dateRecommendation;

    public Recommendation(Studant indicated, Studant indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.dateRecommendation = now();
    }

    public Studant getIndicated() {
        return this.indicated;
    }

    public Studant getIndicator() {
        return this.indicator;
    }
}