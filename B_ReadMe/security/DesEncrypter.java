package B_ReadMe.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;



public class DesEncrypter {
    static Cipher ecipher = null;
    static Cipher dcipher = null;

    public DesEncrypter(SecretKey key) {
        try {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException el) {
            //пусто
        } catch (InvalidKeyException ma) {
            //пусто
        }
    }
    
    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("utf8");
            byte[] enc = ecipher.doFinal(utf8);
            return new BASE64Encoder().encode(enc);
        } catch (UnsupportedEncodingException | BadPaddingException e) {
            //пусто
        } catch (IllegalBlockSizeException e) {
            //пусто
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = new BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8,"utf8");
        } catch (IOException | BadPaddingException e) {
            //пусто
        } catch (IllegalBlockSizeException el) {
            //пусто
        }
        return null;
    }

    public static void main(String[] args){
        try{
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();      //ключ для алгоритма шифрования

            DesEncrypter encrypter = new DesEncrypter(key);
                String encrypted = encrypter.encrypt("Проверка 22555");
                String decrypted = encrypter.decrypt(encrypted);

            System.out.println("Расшифровано: " + encrypted);
            System.out.println("Расшифровано: " + decrypted);
        }catch (NoSuchAlgorithmException e){
            //пусто
        }
    }
}
