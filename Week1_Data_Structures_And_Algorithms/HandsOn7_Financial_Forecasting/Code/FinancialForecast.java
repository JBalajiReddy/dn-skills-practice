public class FinancialForecast {

  //recursion
  public static double calculateFutureValue(double initialAmount, double growthRate, int years) {
    if (years == 0) {
      return initialAmount;
    }
    return (1 + growthRate) * calculateFutureValue(initialAmount, growthRate, years - 1);
  }

  //memoization
  public static double calculateFutureValueMemo(double initialAmount, double growthRate, int years, Double[] memo) {
    if (years == 0)
      return initialAmount;
    if (memo[years] != null)
      return memo[years];
    memo[years] = (1 + growthRate) * calculateFutureValueMemo(initialAmount, growthRate, years - 1, memo);
    return memo[years];
  }
}

//Formula -> futureValue = initialAmount * (1 + growthRate) ^ years
