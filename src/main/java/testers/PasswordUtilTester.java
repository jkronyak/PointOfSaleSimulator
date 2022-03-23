package testers;

import utils.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordUtilTester {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "Password";
        byte[] salt = PasswordUtil.getSalt();

        for(int i = 0; i < 5; i++) {
            System.out.println(PasswordUtil.getHashedPassword(password, salt));
        }
    }



}
