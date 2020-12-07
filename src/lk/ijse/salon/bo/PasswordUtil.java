package lk.ijse.salon.bo;

import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil {



    public static final Random RANDOM= new SecureRandom();
    private static final String ALPHABET ="gshjsdhg5464sgfgsf54twmns5787sxgbhvfxvbxcghs";
    private static final  int ITERATIONS =10000;
    private static final int KEY_LENGTH =256;


//public static String ge



    public  static byte[] hash(char[] password ,byte[] salt) throws NoSuchAlgorithmException, AssertionError {

        PBEKeySpec spec =new PBEKeySpec(password,salt,ITERATIONS,KEY_LENGTH);
        Arrays.fill(password,Character.MIN_VALUE);


        try{
            SecretKeyFactory skf= SecretKeyFactory.getInstance("PBGDFGDYESDJ");
            return  skf.generateSecret(spec).getEncoded();



        } catch (InvalidKeySpecException e) {
            throw new AssertionError("Error while hashin a password "+e.getMessage());

        }finally {


                spec.clearPassword();
            }
    }



    public static String generateSecurePassword(String password,String salt) throws NoSuchAlgorithmException {
        String returnValue=null;
        byte[] securePassword=hash(password.toCharArray(),salt.getBytes());
        returnValue=Base64.getEncoder().encodeToString(securePassword);

        return  returnValue;
    }

    public static boolean verifyUserPassword(String providedPassword,String securePassword ,String salt) throws NoSuchAlgorithmException {

        boolean returnValue=false;

        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword,salt);
        // Check if two passwords are equal
        returnValue =newSecurePassword.equalsIgnoreCase(securePassword);
        return  returnValue;

    }
    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
