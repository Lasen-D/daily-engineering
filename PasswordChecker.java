import java.util.Scanner;

public class PasswordChecker {

    public static String checkStrength(String password) {
        if (password.length() < 8) {
            return "Weak: password is too short";
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
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println(checkStrength(password));
        scanner.close();
    }
}
