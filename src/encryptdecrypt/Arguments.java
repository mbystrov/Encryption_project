package encryptdecrypt;

public class Arguments {
    private String mode = "enc";
    private String data = "";
    private int key = 0;
    private String in;
    private String out;
    private String alg;

    public Arguments(String[] args) {
        initialize(args);
    }

    private void initialize(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
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
                    alg = args[i + 1];
                    break;
            }
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

