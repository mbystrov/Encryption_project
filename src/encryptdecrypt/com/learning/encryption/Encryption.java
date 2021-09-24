package com.learning.encryption;

public abstract class Encryption {
    private String mode;

    public Encryption(String mode) {
        this.mode = mode;
    }

    public String transform(String input, int key) {
        if (mode.equals("dec")) {
            return decrypt(input, key);
        }
        return encrypt(input, key);
    }

    protected abstract String decrypt(String text, int key);

    protected abstract String encrypt(String text, int key);
}