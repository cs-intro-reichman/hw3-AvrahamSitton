public class LoanCalc {
	public static void main(String[] args) {
		double epsilon = 0.001;
		int iterationCounter;

		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println("number of iterations: " + iterationCounter);

	}
}

public static double endBalance(double loan, double rate, int n, double payment) {
	double balance = loan;
	rate = rate / 100.0;
	for (int i = 0; i < n; i++) {
		balance = (balance - payment) * rate * 1.0;
	}
	return balance;

}

public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
	rate = rate / 100;
	int iterationCounter = 0;
	double payment = loan / n;
	while (endBalance(loan, rate, n, n) > epsilon) {
		payment += epsilon;
		iterationCounter++;
	}
	return payment;
}

public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
	double low = loan / n,
			high = loan,
			mid = 0.0;
	int iterationCounter = 0;
	while ((high - low) > epsilon) {
		mid = (high + low) / 2;
		double balance = endBalance(loan, rate, n, mid);
		if (balance > 0) {
			low = mid;

		} else {
			high = mid;
		}
		iterationCounter++;
	}
	return mid;
}
