package io.github.juli0mendes.school.domain.studant;

import java.util.ArrayList;
import java.util.List;

public class Studant {

    private LegalDocument legalDocument;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Studant(LegalDocument legalDocumentNumber, String name, Email email) {
        this.legalDocument = legalDocumentNumber;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String areaCode, String number) {
        this.phones.add(new Phone(areaCode, number));
    }

    public String getLegalDocument() {
        return legalDocument.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
