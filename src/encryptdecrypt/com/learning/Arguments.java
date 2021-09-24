package com.learning;

public class Arguments {
    private String mode = "enc";
    private String data = "";
    private int key = 0;
    private String in;
    private String out;
    private String alg;

    public Arguments(String[] args) {
        if (isValidSize(args)) {
            initialize(args);
        } else {
            System.err.println("Error. Empty argument value");
            System.exit(1);
        }
    }

    private boolean isValidSize(String[] args) {
        return args.length % 2 == 0;
    }

    private void initialize(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = initializeMode(args[i + 1]);
                    break;
                case "-key":
                    key = initializeKey(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    alg = initializeAlg(args[i + 1]);
                    break;
            }
        }
    }

    private String initializeMode(String modeArgument) {
        if ("dec".equals(modeArgument) || "enc".equals(modeArgument)) {
            return modeArgument.toUpperCase();
        } else {
            System.err.println("Error. This argument can only be enc or dec. Argument was " + modeArgument);
            System.exit(1);
            return "";
        }
    }

    private int initializeKey(String keyArgument) {
        try {
            return Integer.parseInt(keyArgument);
        } catch (NumberFormatException e) {
            System.err.println("Error. Value of the key argument is not a number");
            System.exit(1);
            return 0;
        }
    }

    private String initializeAlg(String algArgument) {
        if (algArgument.equals("unicode") || algArgument.equals("shift")) {
            return algArgument;
        } else {
            System.err.println("Error. This argument can only be shift or unicode. Argument was " + algArgument);
            System.exit(1);
            return "";
        }
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public String getOut() {
        return out;
    }

    public String getIn() {
        return in;
    }

    public String getAlg() {
        return alg;
    }
}

