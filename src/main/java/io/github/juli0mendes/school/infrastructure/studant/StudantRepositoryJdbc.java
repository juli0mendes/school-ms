package io.github.juli0mendes.school.infrastructure.studant;

import io.github.juli0mendes.school.domain.studant.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudantRepositoryJdbc implements StudantRepository {

    private final Connection connection;

    public StudantRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Studant studant) {

        try {
            var sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";

            var preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, studant.getLegalDocument());
            preparedStatement.setString(2, studant.getName());
            preparedStatement.setString(3, studant.getEmail());

            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            preparedStatement = this.connection.prepareStatement(sql);

            for (Phone phone : studant.getPhones()) {
                preparedStatement.setString(1, phone.getAreaCode());
                preparedStatement.setString(2, phone.getNumber());

                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Studant findByLegalDocument(LegalDocument legalDocument) {

        try {
            var sql = "SELECT id, legal_document_number, nome, email FROM ALUNO WHERE legal_document_number = ?";

            var preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, legalDocument.getNumber());

            var resultSet = preparedStatement.executeQuery();
            var exists = resultSet.next();

            if (!exists) throw new StudantNotExistsException(legalDocument);

            var studant = new StudantBuilder()
                    .withNameAndLegalDocumentNumberAndEmail(
                            resultSet.getString("name"),
                            resultSet.getString("legal_document_number"),
                            resultSet.getString("email_address"))
                    .build();

            Long id = resultSet.getLong("id");

            sql = "SELECT area_code, number FROM PHONE WHERE studant_id = ?";

            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studant.addPhone(resultSet.getString("area_code"), resultSet.getString("number"));
            }

            resultSet.close();

            return studant;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Studant> findAllEnrolled() {
        try {
            var sql = "SELECT id, legal_document_number, nome, email FROM ALUNO";

            var preparedStatement = this.connection.prepareStatement(sql);

            var resultSet = preparedStatement.executeQuery();

            List<Studant> studants = new ArrayList<>();
            Studant studant = null;

            while (resultSet.next()) {
                studant = new StudantBuilder()
                        .withNameAndLegalDocumentNumberAndEmail(
                                resultSet.getString("NAME"),
                                resultSet.getString("LEGAL_DOCUMENT_NUMBER"),
                                resultSet.getString("EMAIL_ADDRESS"))
                        .build();

                studants.add(studant);
            }

            resultSet.close();

            return studants;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
