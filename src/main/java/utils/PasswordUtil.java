package utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


public class PasswordUtil {


    public static String getHashedPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {

            try {
                PBEKeySpec keySpec = new PBEKeySpec(password.strip().toCharArray(), salt, 10000, 128);
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

                byte[] hashedPasswordBytes = keyFactory.generateSecret(keySpec).getEncoded();

                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < hashedPasswordBytes.length; i++) {
                    stringBuilder.append( Integer.toString((hashedPasswordBytes[i] & 0xff) + 0x100, 16).substring(1) );
                }

                String hashedPassword = stringBuilder.toString();

                return hashedPassword;
            } catch(NoSuchAlgorithmException | InvalidKeySpecException e) {

                e.printStackTrace();
                throw e;
            }
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte salt[] = new byte[16];
        random.nextBytes(salt);

        System.out.println(salt);
        return salt;
    }

}
