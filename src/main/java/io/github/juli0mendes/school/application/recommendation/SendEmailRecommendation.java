package io.github.juli0mendes.school.application.recommendation;

import io.github.juli0mendes.school.domain.studant.Studant;

public interface SendEmailRecommendation {

    void sendTo(Studant recommended);
}
