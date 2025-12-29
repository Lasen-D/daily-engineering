import java.util.Scanner;

public class PasswordChecker {

    public static String checkStrength(String password) {
        if (password.length() < 8) {
            return "Weak";
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = 0;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        if (score <= 1) return "Weak";
        else if (score == 2) return "Medium";
        else return "Strong";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String strength = checkStrength(password);
            System.out.println("Strength: " + strength);

            if (!strength.equals("Weak")) {
                break;
            }

            System.out.println("Password too weak. Try again.\n");
        }

        System.out.println("Password accepted.");
        scanner.close();
    }
}
