package com.learning;

import com.learning.encryption.Encryption;
import com.learning.encryption.ShiftEncryption;
import com.learning.encryption.UnicodeEncryption;
import com.learning.input.TextInput;
import com.learning.output.TextOutput;

public class Application {
    private Arguments arguments;

    public Application(Arguments arguments) {
        this.arguments = arguments;
    }

    public void runApp() {
        Encryption encryption;
        if (arguments.getAlg().equals("unicode")) {
            encryption = new UnicodeEncryption(arguments.getMode());
        } else {
            encryption = new ShiftEncryption(arguments.getMode());
        }
        String input = TextInput.readText(arguments.getData(), arguments.getIn());
        String transformed = encryption.transform(input, arguments.getKey());
        String output = TextOutput.outputText(transformed, arguments.getOut());
        System.out.println(output);
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }
}