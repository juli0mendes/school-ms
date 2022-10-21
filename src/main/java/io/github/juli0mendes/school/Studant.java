package io.github.juli0mendes.school;

import java.util.ArrayList;
import java.util.List;

public class Studant {

    private LegalDocument legalDocumentNumber;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public void addPhone(String areaCode, String number) {
        this.phones.add(new Phone(areaCode, number));
    }
}
