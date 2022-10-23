package io.github.juli0mendes.school;

public class Email {

    // value object
    private final static String REGEX_EMAIL = "^(.+)@(\\S+)$";

    private String address;

    public Email(String address) {
        if (address == null || !address.matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
}