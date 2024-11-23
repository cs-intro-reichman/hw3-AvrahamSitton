/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

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

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean isAnagram = true;
		int a = preProcess(str1).length();
		int b = preProcess(str2).length();
		int sumAscii1 = 0;
		int sumAscii2 = 0;
		if (a != b) {
			isAnagram = false;
		} else {
			for (int i = 0; i < a; i++) {
				sumAscii1 += (int) str1.charAt(i); System.out.print(" " + sumAscii1 + " ");
				sumAscii2 += (int) str2.charAt(i); System.out.print(" " + sumAscii2 + " ");
			}
			if ((sumAscii1 - sumAscii2) != 0) {
				isAnagram = false;
			} else
				isAnagram = true;
		}
		return isAnagram;

	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String standString = "";

		for (int i = 0; i <= str.length(); i++) {
			char character = str.charAt(i);
			int asciiValue = (int) character;

			if (asciiValue == 32) {
				i++;
			} else {
				if (asciiValue > 90) {
					standString += str.charAt(i);
				} else {
					if (asciiValue > 65) {
						standString += (char)character + 32;
						//asciiValue += 32;
						//standString += (int) character;
					}
				}
			}
		}
		return standString;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String randomAnagram = "";
		String removing = "";
		while (randomAnagram.length() != str.length()) {
			int ranRange = (int) Math.random() * str.length();
			char character = (char) ranRange;
			if (!removing.contains(String.valueOf(character))) {
				removing += (char) character;
				randomAnagram += str.charAt(ranRange);
			}

		}
		return randomAnagram;

	}

}