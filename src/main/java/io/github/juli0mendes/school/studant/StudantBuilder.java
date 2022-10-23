package io.github.juli0mendes.school.studant;

public class StudantBuilder {

    private Studant studant;

    public StudantBuilder withNameAndLegalDocumentNumberAndEmail(String name, String legalDocumentNumber, String emailAddress) {
        this.studant = new Studant(new LegalDocument(legalDocumentNumber), name, new Email(emailAddress));
        return this;
    }

    public StudantBuilder withPhones(String areaCode, String number) {
        this.studant.addPhone(areaCode, number);
        return this;
    }

    public Studant build() {
        return this.studant;
    }
}
