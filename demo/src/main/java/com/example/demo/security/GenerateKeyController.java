package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.PublicKey;

@RestController
public class GenerateKeyController {
    @Autowired
    PhoneNumberEncryption phoneNumberEncryption;

    @PostMapping ("/encryptPhone")
    String encryptPhone(@RequestBody String phoneNumber) {
        try {
            KeyPair keyPair = phoneNumberEncryption.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            byte[] encryptedPhoneNumber = phoneNumberEncryption.encryptPhone(phoneNumber, publicKey);
            return DatatypeConverter.printBase64Binary(encryptedPhoneNumber);
        } catch (Exception ex) {
            return "Error";
        }
    }

}
