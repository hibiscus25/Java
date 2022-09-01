package B_ReadMe.security;

/*
   алгоритм  sha - 1 и MD - 5, реализованные в классе MessageDigest, являются однонаправленными
            - результат шифровки в них нельзя расшифровать, то есть восстановить по хэш - ключу исходный текст
            - расширенная версия алгортима MD - 5 даже генерирует в каждом случае ее использования для одного и того же текста разный результат.
                - она также добавляет к результату так называемый random prefix (salt), благодаря которому защита становится более надежной

   Так как самого пароля в базе данных нет, как его сверить?
            - преобразовываем то, что ввел пользователь в качестве пароля,
            - зашифровываем введенный текст по тому же алгоритму
            - сравниваем результат c хранимым в базе данных  хэш - ключом
                - если пользователь ввел правильный пароль, оба ключа будут одинаковыми

        Правильно сравнивать зашифрованные ключи по байтам, с помощью метода isEqual(), который сравнивает
    два массива байтов и возвращает в качестве результата значение типа boolean.
 */


import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordComparer {
    private String value = null;                                            //пароль из базы
    private MessageDigest d = null;

    public PasswordComparer(String value, boolean decode, String algorithm) {
        if (decode == true) {                                              //декодирование пароля из базы по алгоритму BASE64
            try {
                BASE64Decoder dec = new BASE64Decoder();
                this.value = new String(dec.decodeBuffer(value));
                dec = null;
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            this.value = value;
        }

        try {
            d = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Illegal algoritm value");
        }
    }


    //---------------------------------- проверка на количество попыток ввода -----------------------------------------

    private int failedCount = 0;
    private static int maxFailedCount = 3;

    public int getFailedCount() {                                 // возвращает число неудачных попыток
        return failedCount;
    }

    private synchronized void incrementFailedCount() {            // увеличивает число неудачных попыток
        failedCount++;
    }

    private synchronized void resetFailedCount() {               // сбрасывает значение счетчика неудачных попыток на 0
        failedCount = 0;
    }

    //---------------------------------- проверка на совпадение хэш - ключей -------------------------------------------

    public synchronized boolean isEqual(String password) throws IllegalAccessException {
        boolean success = false;                                                                // результат сравнения

        //генерация исключения, если достигнуто максимальное число неудачных попыток ввода пароля
        if (getFailedCount() == maxFailedCount)
            throw new IllegalAccessException("Достигнуто максимальное число неудачных попыток ввода пароля");

        // сравнение хэш - ключей
        try {
            String encPassword = new String(PasswordEncrypter.encrypt(password, d.getAlgorithm()));
            success = d.isEqual(value.getBytes(), encPassword.getBytes());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        //в зависимости от результата проверки хэш-ключей увеличивается значение счетчика неудачных попыток или он сбрасывается на ноль
        if (success == true) {
            resetFailedCount();
        } else {
            incrementFailedCount();
        }

        return success;
    }
}
