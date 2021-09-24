package com.learning.encryption;

public class ShiftEncryption extends Encryption {

    public ShiftEncryption(String mode) {
        super(mode);
    }

    @Override
    public String encrypt(String text, int key) {
        char[] charArr = text.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            boolean isCharacterSkipped = (charArr[i] < 'a' || charArr[i] > 'z') && (charArr[i] < 'A' || charArr[i] > 'Z');
            if (isCharacterSkipped)
                continue;
            if ((charArr[i] + key % 26) <= 'Z' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                charArr[i] = (char) (charArr[i] + key % 26);
                continue;
            }
            if ((charArr[i] + key % 26) <= 'z' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                charArr[i] = (char) (charArr[i] + key % 26);
                continue;
            }
            if ((charArr[i] + key % 26) > 'Z' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                charArr[i] = (char) ((charArr[i] + key % 26) % 'Z' + 'A' - 1);
                continue;
            }
            if ((charArr[i] + key % 26) > 'z' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                charArr[i] = (char) ((charArr[i] + key % 26) % 'z' + 'a' - 1);
            }
        }
        return String.valueOf(charArr);
    }

    @Override
    public String decrypt(String text, int key) {
        char[] charArr = text.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            boolean isCharacterSkipped = (charArr[i] < 'a' || charArr[i] > 'z') && (charArr[i] < 'A' || charArr[i] > 'Z');
            if (isCharacterSkipped)
                continue;
            if ((charArr[i] - key % 26) >= 'A' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                charArr[i] = (char) (charArr[i] - key % 26);
                continue;
            }
            if ((charArr[i] - key % 26) >= 'a' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                charArr[i] = (char) (charArr[i] - key % 26);
                continue;
            }
            if (((charArr[i] - key % 26) < 'A' && charArr[i] >= 'A' && charArr[i] <= 'Z') ||
                    ((charArr[i] - key % 26) < 'a' && charArr[i] >= 'a' && charArr[i] <= 'z')) {
                charArr[i] = (char) (26 + charArr[i] - key % 26);
            }
        }
        return String.valueOf(charArr);
    }
}
