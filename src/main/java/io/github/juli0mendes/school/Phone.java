package io.github.juli0mendes.school;

public class Phone {

    private String areaCode;
    private String number;

    public Phone(String areaCode, String number) {
        if (areaCode == null || areaCode.length() != 2 || number == null || number.length() != 9) {
            throw new IllegalArgumentException("Invalid phone");
        }
        this.areaCode = areaCode;
        this.number = number;
    }
}
