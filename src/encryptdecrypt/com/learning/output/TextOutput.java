package com.learning.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextOutput {

    public static String outputText(String transformed, String out) {
        if (out != null) {
            writeTextToFile(transformed, out);
            return "Success! Text has been written to a file";
        }
        return transformed;
    }

    private static void writeTextToFile(String transformed, String out) {
        File file = new File(out);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(transformed);
        } catch (IOException e) {
            System.err.printf("Error. The path \"%s\" is incorrect", out);
            System.exit(1);
        }
    }
}
