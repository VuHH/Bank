package com.example.demo.security;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

@Service
public class PhoneNumberEncryption {

    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public byte[] encryptPhone(String phoneNumber, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(phoneNumber.getBytes());
    }

    public String decryptPhone(String encryptedPhoneNumber) throws Exception {
        PrivateKey privateKey = generateKeyPair().getPrivate();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(DatatypeConverter.parseBase64Binary(encryptedPhoneNumber));
        return new String(decrypted);
    }
}
