package B_ReadMe.security;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // ---------------------------------- зашифровали пароль -------------------------------------
            String pwd = "1291328diMA";
            String algorithm = "SHA-1";

                String encrypted = new String(PasswordEncrypter.encrypt(pwd, algorithm));
                String encoded = PasswordEncrypter.encryptAndEncode(pwd, algorithm);

                    System.out.println("Зашифрованный пароль: " + encrypted);
                    System.out.println("Кодированный шифр: " + encoded);

        // --------------------------- расшифровка пароля  ------------------------
            PasswordComparer ps = new PasswordComparer(encoded, true, algorithm);

            String[] passwordInput = {"2334", "dljfdljf",pwd};

            for (String el : passwordInput) {
                System.out.println(ps.isEqual(el));
            }
    }
}
