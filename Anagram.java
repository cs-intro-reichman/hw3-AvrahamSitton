/** Functions for checking if a given string is an anagram. */
public class Anagram {
	// static int isSpace = 0;

	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		System.out.println(preProcess("I am a weakish speller"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	public static String preProcess(String str) {

		String standString = "";
		char character = '\u0000';
		int asciiValue = 0;
		// isSpace = 0;

		for (int i = 0; i < str.length(); i++) {
			asciiValue = (int) str.charAt(i);
			// asciiValue = (int) character;

			/*
			 * if (asciiValue == ' ') {
			 * //continue;
			 * //isSpace++;
			 * 
			 * } else {
			 */
			if (asciiValue > 'Z') {
				standString += str.charAt(i);

			} else if (asciiValue > 'A') {
				standString += (char) (character + ' ');

			} else
				standString += str.charAt(i);

		}
		return standString;

	}
	// return standString;
	// }
	// return standString;
	// }

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		// boolean isAnagram = true;
		/*
		 * String temp1 = preProcess(str1),
		 * temp2 = preProcess(str2);
		 */

		int a = (int) Math.abs(preProcess(str1).length() - preProcess(str2).length()),
				b = preProcess(str1).length(),
				c = preProcess(str2).length(),
				sumAscii1 = 0,
				sumAscii2 = 0;
		for (int i = 0; i < b; i++) {
			sumAscii1 += (int) preProcess(str1).charAt(i);

		}
		for (int i = 0; i < c; i++) {
			sumAscii2 += (int) preProcess(str2).charAt(i);

		}
		return (Math.abs(sumAscii1 - sumAscii2) == 0 || Math.abs(sumAscii1 - sumAscii2) == 32 * a);

	}

	public static String randomAnagram(String str) {
		str = preProcess(str);
		String randomAnagram = "";
		String removing = "";

		while (randomAnagram.length() != str.length()) {
			int ranRange = (int) (Math.random() * str.length());
			char character = (char) ranRange;
			if (!removing.contains(String.valueOf(character))) {
				removing += (char) character;
				randomAnagram += str.charAt(ranRange);

			}

		}
		return randomAnagram;
	}
}
