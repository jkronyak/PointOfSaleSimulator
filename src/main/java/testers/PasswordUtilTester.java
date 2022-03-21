package testers;

import utils.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordUtilTester {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "Password";
            System.out.println( PasswordUtil.getHashedPassword(password, PasswordUtil.getSalt()) );

    }



}
