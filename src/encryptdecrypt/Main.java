package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Arguments arguments = new Arguments(args);
        Encryption encryption;
        if (arguments.getAlg().equals("unicode")) {
            encryption = new UnicodeEncryption(arguments);
        } else {
            encryption = new ShiftEncryption(arguments);
        }
        encryption.execute();
    }
}