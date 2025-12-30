import java.util.Scanner;

public class ProfitCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cost price: ");
        double costPrice = scanner.nextDouble();

        System.out.print("Enter selling price: ");
        double sellingPrice = scanner.nextDouble();

        System.out.print("Enter quantity sold: ");
        int quantity = scanner.nextInt();

        double profit = (sellingPrice - costPrice) * quantity;
        double margin = (profit / (sellingPrice * quantity)) * 100;

        System.out.println("\nTotal Profit: " + profit);
        System.out.println("Profit Margin: " + String.format("%.2f", margin) + "%");

        scanner.close();
    }
}
