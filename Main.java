import java.security.SecureRandom;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PasswordGenerator pg=new PasswordGenerator();
        System.out.print("Enter the length of the password : ");
        int passwordLength =sc.nextInt();
        String generatedPassword = pg.generatePassword(passwordLength);
        System.out.println("Generated Password: " + generatedPassword);

    }
}


class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:',.<>?";

    public static String generatePassword(int length) {
        String password = "";
        SecureRandom random = new SecureRandom();

        // To ensure at least one character from each category
        password += getRandomChar(LOWERCASE_CHARS, random);
        password += getRandomChar(UPPERCASE_CHARS, random);
        password += getRandomChar(NUMBERS, random);
        password += getRandomChar(SPECIAL_CHARS, random);

        // Fill the rest of the password with random characters
        for (int i = 4; i < length; i++) {
            String charSet = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
            password += getRandomChar(charSet, random);
        }

        // Shuffle the password
        password = shuffleString(password, random);

        return password;
    }

    private static char getRandomChar(String charSet, SecureRandom random) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    private static String shuffleString(String inputString, SecureRandom random) {
        char[] characters = inputString.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

}





