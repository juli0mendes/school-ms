package io.github.juli0mendes.school.domain.studant;

public interface PasswordEncryptor {

    String encrypt(String password);

    boolean validateEncryptedPassword(String encryptedPassword, String password);
}
