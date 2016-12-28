package ru.innopolis.utils.encryption;

import org.springframework.stereotype.Component;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
import static ru.innopolis.constants.AccountFormatConstraints.PASSWORD_SALT;

/**
 * Класс-шифровальщик.
 */
@Component
public class EncryptorImpl implements Encryptor{

    public EncryptorImpl() {
    }

    /**
     * Метод шифрует сообщение.
     * @return зашифрованное сообщение.
     */
    public String encrypt(String message){
        return md5Hex(md5Hex(message) + PASSWORD_SALT);
    }
}
