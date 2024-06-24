/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.elibrary.security;

import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
//import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author Firdhaus
 */
public class Encryption {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEYVALUE = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };

    public static String Encrypt(String textToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, Exception {
        Key key = GenerateKey();
        Cipher desCipher;
        desCipher = Cipher.getInstance(ALGORITHM);
        desCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] text = textToEncrypt.getBytes();
        byte[] textEncrypted = desCipher.doFinal(text);
        //String bytesEncoded = Base64.encodeToString(textEncrypted);

        // Encode data on your side using BASE64
        byte[] bytesEncoded = Base64.encodeBase64(textEncrypted);
        //System.out.println("encoded value is " + new String(bytesEncoded));


        return new String(bytesEncoded);
    }

    public static String Decrypt(String textToDecrypt) {
        try {
//            textToDecrypt = URLDecoder.decode(textToDecrypt,"UTF-8");
            Key key = GenerateKey();
            Cipher desCipher;
            desCipher = Cipher.getInstance(ALGORITHM);
            desCipher.init(Cipher.DECRYPT_MODE, key);
            //byte[] valueDecoded = Base64.decode(textToDecrypt);

            // Decode data on other side, by processing encoded data
            byte[] valueDecoded = Base64.decodeBase64(textToDecrypt);
            //System.out.println("Decoded value is " + new String(valueDecoded));
            byte[] textDecrypted = desCipher.doFinal(valueDecoded);
            return new String(textDecrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return(e.getMessage());
        }

    }

    private static Key GenerateKey() throws Exception {
        Key key = new SecretKeySpec(KEYVALUE, ALGORITHM);
        return key;
    }

}
