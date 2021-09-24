package com.learning.encryption;

public class UnicodeEncryption extends Encryption {

    public UnicodeEncryption(String mode) {
        super(mode);
    }

    @Override
    public String encrypt(String text, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : text.toCharArray()) {
            stringBuilder.append((char) (letter + key));
        }
        return stringBuilder.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : text.toCharArray()) {
            stringBuilder.append((char) (letter - key));
        }
        return stringBuilder.toString();
    }
}
