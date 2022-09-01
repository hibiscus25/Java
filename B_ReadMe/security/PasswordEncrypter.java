package B_ReadMe.security;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {

    //------- кодирует по алгоритму SHA-1, SHA-256 или MD-5 (хэш-ключ имеет вид массива байтов) ---------------
    public static byte[] encrypt(String password, String algorithm) throws IllegalArgumentException {
        try{
            MessageDigest d = MessageDigest.getInstance(algorithm);         // классу передаем название алгоритма
            d.update(password.getBytes());                                  // передаем пароль (по которому генерируется хэш-ключ)
            return d.digest();                                              // получаем хэш -ключ, возвращаем - массив байтов
        }catch(NoSuchAlgorithmException nos){
            throw new IllegalArgumentException("Illegal algoritm value");
        }
    }

    //---------------------------------------------------------------------------------------------------------
                 /*
                        Поскольку в результате использования алгоритмов  SHA-1, SHA-256 или MD-5 и хэширования данных можем получить ключ,
                    в котором будут также и непечатаемые символы:
                            - символ конца строки,
                            - табуляция и тд)
                    можно преобразовывать результат кодировки  (хэш - ключ) по алгоритму Base64
                        В результате такого кодированнный хэш-ключ будет иметь - СИМВОЛЬНЫЙ ВИД
                */
    //---------------------------------------------------------------------------------------------------------

    //----------- метод кодирует по алгоритму BASE 64 (в результате ключ имеет символьный вид) ----------------
    public static String encryptAndEncode(String password, String algorithm) throws IllegalArgumentException {
        BASE64Encoder enc = new BASE64Encoder();
        String encoded = enc.encode(encrypt(password, algorithm));
        enc = null;
        return encoded;
    }
}

