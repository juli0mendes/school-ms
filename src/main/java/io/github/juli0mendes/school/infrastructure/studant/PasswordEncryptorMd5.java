package io.github.juli0mendes.school.infrastructure.studant;

import io.github.juli0mendes.school.domain.studant.PasswordEncryptor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptorMd5 implements PasswordEncryptor {
    
    @Override
    public String encrypt(String password) {
        try {
            var messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());

            var bytes = messageDigest.digest();

            var sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating encrypted password.");
        }
    }

    @Override
    public boolean validateEncryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(this.encrypt(password));
    }
}
