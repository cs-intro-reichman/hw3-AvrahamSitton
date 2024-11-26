// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {

	static double epsilon = 0.001; // Approximation accuracy
	static int iterationCounter = 0; // Number of iterations

	// Gets the loan data and computes the periodical payment.
	// Expects to get three command-line arguments: loan amount (double),
	// interest rate (double, as a percentage), and number of payments (int).
	public static void main(String[] args) {
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {
		double balance = loan;
		// double interestFactor = 1 + rate / 100;

		// Iterate through each period and update the balance
		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * (1 + rate / 100);
		}

		return balance;
	}

	// Uses brute force to find the periodical payment that brings the loan balance
	// close to 0.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g = loan / n, // Initial guess for the payment (rough estimate)
				preBalnce = endBalance(loan, rate, n, g),
				currentBalance = preBalnce;
		int maxIteration = (int) Math.pow(loan, 2);
		while (endBalance(loan, rate, n, g) > epsilon) {
			if (preBalnce > epsilon && currentBalance < epsilon) {
				return g - epsilon;
			}
			preBalnce = currentBalance;
			g += epsilon;
			iterationCounter++;
			if (iterationCounter > maxIteration) {
				System.out.println("");
				break;

			}
		}

		return g;
	}

	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		double sup = loan * 1 + rate / 100;
		double inf = loan / n;
		double mid = (sup + inf) / 2;
		double currentB = endBalance(loan, rate, n, mid);
		while (sup - inf > epsilon) {
			if (currentB > 0) {
				inf = mid;
			} else {
				sup = mid;
			}
			mid = (sup + inf) / 2;
			iterationCounter++;
			currentB = endBalance(loan, rate, n, mid);
			// System.out.println("brut"+ iterationCounter+ " " + result);

		}
		return mid;
	}
}
// Computes the ending balance of a loan, given the loan amount, the periodical
// interest rate (as a percentage), the number of periods (n), and the
// periodical payment.
/*
 * private static double endBalance(double loan, double rate, int n, double
 * payment) {
 * double endBalance = loan;
 * double interestFactor = 1 + rate / 100;
 * for (int i = 0; i < n; i++) {
 * endBalance = (endBalance - payment) * interestFactor;
 * System.out.println("endba " + endBalance);
 * }
 * 
 * return endBalance;
 * }
 */

/*
 * public static double bruteForceSolver(double loan, double rate, int n, double
 * epsilon) {
 * double g = loan / n; // Initial guess for the payment (rough estimate)
 * double increment = 0.0001; // Small increment to adjust the payment guess
 * iterationCounter = 0;
 * 
 * 
 * while (Math.abs(endBalance(loan, rate, n, g)) >= epsilon) {
 * g += increment; // Increase the payment guess
 * iterationCounter++; // Count the iterations
 * }
 * 
 * return g;
 * }
 */

// Uses sequential search to compute an approximation of the periodical payment
// that will bring the ending balance of a loan close to 0.
// Given: the sum of the loan, the periodical interest rate (as a percentage),
// the number of periods (n), and epsilon, the approximation's accuracy
// Side effect: modifies the class variable iterationCounter.

// Uses bisection search to compute an approximation of the periodical payment
// that will bring the ending balance of a loan close to 0.
// Given: the sum of the loan, the periodical interest rate (as a percentage),
// the number of periods (n), and epsilon, the approximation's accuracy
// Side effect: modifies the class variable iterationCounter.
/*
 * public static double bisectionSolver(double loan, double rate, int n, double
 * epsilon) {
 * double low = loan / n * 1.0;
 * double high = loan * 1.0;
 * double mid = (high + low) / 2.0;
 * int iterationCounter = 0;
 * while ((high - low) > epsilon) {
 * if (LoanCalc.endBalance(loan, rate, n, mid) > 0) {
 * low = mid;
 * } else {
 * high = mid;
 * }
 * mid = (high + low) / 2;
 * iterationCounter++;
 * }
 * return mid;
 */
