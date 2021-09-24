package com.learning.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextInput {

    public static String readText(String data, String in) {
        if (!data.isEmpty()) {
            return data;
        } else if (in == null) {
            return "";
        } else {
            return readTextFromFile(in);
        }
    }

    private static String readTextFromFile(String in) {
        try {
            return new String(Files.readAllBytes(Paths.get(in)));
        } catch (IOException e) {
            System.out.printf("Error. File \"%s\" is not found", in);
            System.exit(0);
            return null;
        }
    }
}
