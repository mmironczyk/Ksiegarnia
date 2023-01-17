package com.ksiegarnia.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/** Klasa odpowiedzialna za szyfrowanie haseł poprzez SHA256*/
public class SHA {

    /** Funkcja generująca hash SHA-256 dla podanego hasła
     * @param passwordToHash hasło do zaszyfrowania
     * @return Funkcja zwraca zaszyfrowane hasło.
     * @see java.security.MessageDigest
     * */
    public static String encrypt(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
