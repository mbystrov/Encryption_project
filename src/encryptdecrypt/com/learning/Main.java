package com.learning;

public class Main {

    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        Application application = new Application(arguments);
        application.runApp();
    }
}
