import java.util.Scanner;

public class ForecastTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Financial Forecasting Test");

    System.out.print("Enter the initial amount in Rupees:");
    double initialAmount = sc.nextDouble();

    System.out.print("Enter the growth rate (as a decimal): ");
    double growthRate = sc.nextDouble();

    System.out.print("Enter the number of years: ");
    int years = sc.nextInt();

    // Without memoization
    double futureValue = FinancialForecast.calculateFutureValue(initialAmount, growthRate, years);
    System.out.printf("Recursive Future Value after %d years: Rs %.2f", years, futureValue);
    System.out.println();

    // With memoization
    Double[] memo = new Double[years + 1];
    double optimizedValue = FinancialForecast.calculateFutureValueMemo(initialAmount, growthRate, years, memo);
    System.out.printf("Optimized Future Value after %d years: Rs %.2f", years, optimizedValue);
    sc.close();
  }
}
