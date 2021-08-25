package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public abstract class Encryption {
    Arguments arguments;

    public Encryption(Arguments arguments) {
        this.arguments = arguments;
    }

    public void execute() {
        String input = readText();
        String crypted = transformText(input);
        outputText(crypted);
    }

    public String readText() {
        if (!arguments.getData().isEmpty()) {
            return arguments.getData();
        } else if (arguments.getData().isEmpty() && arguments.getIn() == null) {
            return "";
        } else {
            try {
                return new String(Files.readAllBytes(Paths.get(arguments.getIn())));
            } catch (IOException e) {
                System.out.printf("Error. File \"%s\" is not found", arguments.getIn());
                System.exit(0);
            }
        }
        return null;
    }

    public void outputText(String crypted) {
        if (arguments.getOut() != null) {
            writeTextToFile(crypted);
            return;
        }
        System.out.println(crypted);
    }

    public void writeTextToFile(String crypted) {
        File file = new File(arguments.getOut());
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(crypted);
        } catch (IOException e) {
            System.out.printf("Error. The path \"%s\" is incorrect", arguments.getOut());
            System.exit(0);
        }
    }

    public abstract String transformText(String input);
}

class ShiftEncryption extends Encryption {

    public ShiftEncryption(Arguments arguments) {
        super(arguments);
    }

    public String transformText(String input) {
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            boolean isCharacterSkipped = (charArr[i] < 'a' || charArr[i] > 'z') && (charArr[i] < 'A' || charArr[i] > 'Z');
            switch (ModeArgument.valueOf(arguments.getMode().toUpperCase(Locale.ROOT))) {
                case ENC:
                    if (isCharacterSkipped)
                        continue;
                    if ((charArr[i] + arguments.getKey() % 26) <= 'Z' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                        charArr[i] = (char) (charArr[i] + arguments.getKey() % 26);
                        continue;
                    }
                    if ((charArr[i] + arguments.getKey() % 26) <= 'z' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                        charArr[i] = (char) (charArr[i] + arguments.getKey() % 26);
                        continue;
                    }
                    if ((charArr[i] + arguments.getKey() % 26) > 'Z' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                        charArr[i] = (char) ((charArr[i] + arguments.getKey() % 26) % 'Z' + 'A' - 1);
                        continue;
                    }
                    if ((charArr[i] + arguments.getKey() % 26) > 'z' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                        charArr[i] = (char) ((charArr[i] + arguments.getKey() % 26) % 'z' + 'a' - 1);
                    }
                    break;
                case DEC:
                    if (isCharacterSkipped)
                        continue;
                    if ((charArr[i] - arguments.getKey() % 26) >= 'A' && charArr[i] >= 'A' && charArr[i] <= 'Z') {
                        charArr[i] = (char) (charArr[i] - arguments.getKey() % 26);
                        continue;
                    }
                    if ((charArr[i] - arguments.getKey() % 26) >= 'a' && charArr[i] >= 'a' && charArr[i] <= 'z') {
                        charArr[i] = (char) (charArr[i] - arguments.getKey() % 26);
                        continue;
                    }
                    if (((charArr[i] - arguments.getKey() % 26) < 'A' && charArr[i] >= 'A' && charArr[i] <= 'Z') ||
                            ((charArr[i] - arguments.getKey() % 26) < 'a' && charArr[i] >= 'a' && charArr[i] <= 'z')) {
                        charArr[i] = (char) (26 + charArr[i] - arguments.getKey() % 26);
                    }
                    break;
                default:
                    System.out.println("Error. Incorrect mode: " + arguments.getMode());
                    System.exit(0);
            }
        }
        return String.valueOf(charArr);
    }
}

class UnicodeEncryption extends Encryption {

    public UnicodeEncryption(Arguments arguments) {
        super(arguments);
    }

    public String transformText(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : input.toCharArray()) {
            switch (ModeArgument.valueOf(arguments.getMode().toUpperCase(Locale.ROOT))) {
                case ENC:
                    stringBuilder.append((char) (letter + arguments.getKey()));
                    break;
                case DEC:
                    stringBuilder.append((char) (letter - arguments.getKey()));
                    break;
                default:
                    System.out.println("Error. Incorrect mode: " + arguments.getMode());
                    System.exit(0);
            }
        }
        return stringBuilder.toString();
    }
}