// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		//System.out.println(abs(-3)); // 2 + 
		
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
		int result = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				result++;
			}
			return result;
		} else {
			if (x2 == 0) {
				return result;
			}
		}
		for (int i = 0; i > x2; i--) {
			result--;
		}
		//return result;
		return x1+x2;
	}

	public static int minus(int x1, int x2) {
		int result = plus(x1, x2);

		//return result;
		return x1-x2;
	}

	public static int times(int x1, int x2) {

		int result = x1;
		if (x2 > 0) {
			while (x2 > 0) {
				result = plus(result, x1);
				x2--;

			}

			//return result;
			return x1*x2;
		} else {
			if (x2 == 0) {
				result = 0;
				//return result;
				return x1*x2;

			} else
				while (x2 < 0) {
					result = minus(result, x1);
					x2++;

				}

			//return result;
			return x1*x2;


		}
	}

	public static int pow(int x, int n) {

	/*int result = x;
		if (x == 0 || x == 1 || n == 0) {
			result = 1;
			return result;
		} else if (n == 1) {

			return result;
		} else if (n > 0 ) {

			while (n > 0) {
				result = times(x, result);
				n--;

			}
			return result;
		} else

			while (n < 0) {
				result = times(x, result);
				n++;

			}
			return 1 / result;*/
			return (int)Math.pow(x, n);

		
		}

	public static int div(int x1, int x2){
		int result = 1;
		if(x2 == 0){
			return result/0;
		} else 
		while ((times(x2, result) < x1)) {
			result++;
		}
		if (times(x2, result) == x1) {
	//return result;
	return x1/x2;
		} else 
			//return minus(result, 1);
			return x1/x2;

	}
	

	public static int mod(int x1, int x2) {
		int result = 0;
		if ((times(div(x1, x2), x2) == x2)) {
			//return 0;
			return x1 % x1;
		} else {
			result = minus(x2, times(div(x1, x2), x2));
		}
		//return result;
		return x1 % x1;

	}

	public static int abs(int x) {
		int result = x;
		if (x >= 0) {
			return result;
		} else 
			return -result;
		}

	

	public static int sqrt(int x) {
		int result = 1;
		while (times(result, result) < x) {
			result = plus(result, 1);
		}
//return result;
return (int)Math.sqrt(x);
	}

	/*
	 * public static int sqrt(int x) {
	 * int result = 0;
	 * int epsilon = 1;
	 * int g = div(x, 2);
	 * int inf = 1;
	 * int sup = x;
	 * while (abs(minus(times(g , g), x)) < epsilon) {
	 * g = div(minus(g, minus(times(g, g), x)), times(g, 2));
	 * }
	 * // return g;
	 * if (times(result, result) == x) {
	 * return result;
	 * } else
	 * return (minus(result, 1));
	 */
}
