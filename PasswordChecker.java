import java.util.Scanner;

public class PasswordChecker {

    public static String getPasswordStrength(String password) {
        if (password.length() < 8) return "Weak";

        int score = 0;
        if (hasUpperCase(password)) score++;
        if (hasLowerCase(password)) score++;
        if (hasDigit(password)) score++;
        if (hasSpecialChar(password)) score++;

        if (score <= 1) return "Weak";
        if (score == 2) return "Medium";
        return "Strong";
    }

    private static boolean hasUpperCase(String s) {
        return s.chars().anyMatch(Character::isUpperCase);
    }

    private static boolean hasLowerCase(String s) {
        return s.chars().anyMatch(Character::isLowerCase);
    }

    private static boolean hasDigit(String s) {
        return s.chars().anyMatch(Character::isDigit);
    }

    private static boolean hasSpecialChar(String s) {
        return s.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.trim().isEmpty()) {
                System.out.println("Password cannot be empty.\n");
                continue;
            }

            String strength = getPasswordStrength(password);
            System.out.println("Strength: " + strength);

            if (!strength.equals("Weak")) break;

            System.out.println("Password too weak. Try again.\n");
        }

        System.out.println("Password accepted.");
        scanner.close();
    }
}
