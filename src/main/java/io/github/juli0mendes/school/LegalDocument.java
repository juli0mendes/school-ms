package io.github.juli0mendes.school;

public class LegalDocument {

    // value object

    private String number;

    public LegalDocument(String number) {
        if (number == null || number.length() != 11) {
            throw new IllegalArgumentException("Invalid legal document number");
        }
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }
}
