package io.github.juli0mendes.school.studant;

import java.util.ArrayList;
import java.util.List;

public class Studant {

    private LegalDocument legalDocumentNumber;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Studant(LegalDocument legalDocumentNumber, String name, Email email) {
        this.legalDocumentNumber = legalDocumentNumber;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String areaCode, String number) {
        this.phones.add(new Phone(areaCode, number));
    }

    public LegalDocument getLegalDocumentNumber() {
        return legalDocumentNumber;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
