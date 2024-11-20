// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	public static int plus(int x1, int x2) {

		for (int i = 0; i < x2; i++)
			x1++;
		return x1;
	}

	public static int minus(int x1, int x2) {

		for (int i = 0; i < x2; i++)
			x1--;
		return x1;
	}

	public static int times(int x1, int x2) {

		int result = 0;
		while (x2 > 0) {
			result = plus(result, x1);
			x2--;

		}

		return result;
	}

	public static int pow(int x, int n) {

		int result = 1;
		while (n > 0) {
			result = times(x, result);
			n--;
		}

		return result;
	}

	public static int div(int x1, int x2) {

		int result = 0;
		while ((times(x2, result) < x1)) {
			result++;

		}
		if (times(x2, result) == x1) {
			return result;
		} else {
			return minus(result, 1);
		}
	}

	public static int mod(int x1, int x2) {
		int result = 0;
		if ((times(div(x1, x2), x2) == x2)) {
			return 0;
		} else {
			result = minus(x2, times(div(x1, x2), x2));
		}
		return result;
	}

	public static int sqrt(int x) {
		int result = 0;
		while (times(result, result) < x) {
			result++;
		}
		if (times(result, result) == x) {
			return result;
		} else
			return (minus(result, 1));
	}
}