package main.backend;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryption {
	
	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	
	// getSalt needs to be run first for a global salt value for the password encryption, which needs to be stored in the database somewhere
	// if not on the database, it can just be within the program
	// generateSecurePassword is the only function that needs to be run directly from this class, everything else is handled by the class
	// worth putting a global variable of the 'salt' value within the login and register forms
	public static String getSalt(int length) {
		
		StringBuilder returnValue = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}
	
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	
	private static String generateSecurePassword(String password, String salt) {
		String returnValue = null;
		
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		
		return returnValue;
	}

	/**
     * Parses and checks a password
     * 
     * @param hash
     * @param password
     */
    public boolean verifyPassword(String hash, String password) {
        if(hash.substring(0, 3).equals("$1$")) {
            // Type 1 password
            String salt = hash.substring(3, 3 + 25);

            String justHash = hash.substring(3+25);

            String enteredPassword = PasswordEncryption.generateSecurePassword(password, salt);

            return enteredPassword.equals(justHash);
        }

        return false;
    }

    /**
     * Encrypts a password
     * 
     * @param password
     */
    public String encryptPassword(String password) {

		// Type 1 has salt length of 25
        String salt = PasswordEncryption.getSalt(25);
        
		return this.encryptPassword(password, salt);
    }

	/**
	 * USE ONLY FOR TESTING PURPOSES
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public String encryptPassword(String password, String salt) {
		StringBuilder encrypted = new StringBuilder();

        // Set type of password encryption
        encrypted.append("$1$");

        encrypted.append(salt);

        String hash = PasswordEncryption.generateSecurePassword(password, salt);

        encrypted.append(hash);

        return encrypted.toString();
	}
}
