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

		for (int i = 0; i < str.length(); i++) {
			character = str.charAt(i);
			asciiValue = (int) character;

			if (asciiValue == ' ') {
				continue;
				// System.out.println(" " + asciiValue + " " + character + " " + standString);
			} else {
				if (asciiValue > 'Z') {
					standString += str.charAt(i);
					//System.out.println(" " + asciiValue + " " + character + " " + standString);

				} else if (asciiValue > 'A') {
					standString += (char) (character + ' ');
					//System.out.println(" " + asciiValue + " " + character + " " + standString);
				} else
					standString += str.charAt(i);

				// asciiValue += 32;
				// standString += (int) character;
			}
		}

		return standString;
	}
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		boolean isAnagram = true;
		int a = preProcess(str1).length(),
				b = preProcess(str2).length(),
				sumAscii1 = 0,
				sumAscii2 = 0;
		if (a != b) {
			isAnagram = false;
		} else {
			for (int i = 0; i < a; i++) {
				sumAscii1 += (int) str1.charAt(i);
				//System.out.print(" " + sumAscii1 + " ");
				sumAscii2 += (int) str2.charAt(i);
			//	System.out.print(" " + sumAscii2 + " ");
			}
			if ((sumAscii1 - sumAscii2) != 0) {
				isAnagram = false;
			} else
				isAnagram = true;
		}
		return isAnagram;
	}
public static String randomAnagram(String str) {
		str = preProcess(str);
		String randomAnagram = "";
		String removing = "";
		// String newStr = "";

		while (randomAnagram.length() != str.length()) {
			int ranRange = (int) (Math.random() * str.length());
			char character = (char) ranRange;
			// System.out.println(ranRange + " " + character + " " +
			// randomAnagram.length());
			if (!removing.contains(String.valueOf(character))) {
				removing += (char) character;
				randomAnagram += str.charAt(ranRange);
				// System.out.println(ranRange + " " + character + " " + randomAnagram.length()
				// + " " + randomAnagram);

			}

		}
		return randomAnagram;
	}
}
		/*
		 * str1 = preProcess(str1);
		 * str2 = preProcess(str2);
		 * for(int i = 0; i < str1.length(); i++){
		 * for(int j = 0; j < str1.length(); j++){
		 * if(str1.charAt(i) == str2.charAt(j)){
		 * counterSteps++;
		 * break;
		 * }
		 * }
		 * }
		 * if(counterSteps == str1.length()){
		 * return true;
		 * }
		 * else{
		 * return false;
		 * }
		 */
	

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"


	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	
		/*
		 * for(int i = 0; i < str.length(); i++){
		 * str = str.toLowerCase();
		 * if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || str.charAt(i) == ' '){
		 * newStr += str.charAt(i);
		 * }
		 * }
		 */
		// return preProcess(newStr);
	
	/*
	 * private static String preProcess1(String str) {
	 * String newStr = "";
	 * for(int i = 0; i < str.length(); i++){
	 * str = str.toLowerCase();
	 * if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')){
	 * newStr += str.charAt(i);
	 * }
	 * }
	 * return newStr;
	 * }
	 */

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	/*
	 * public static String randomAnagram(String str) {
	 * String newStr = "";
	 * while (str.length() > 0) {
	 * int random = (int)(str.length() * Math.random());
	 * newStr += str.charAt(random);
	 * str = str.substring(0, random) + str.substring(random + 1);
	 * }
	 * return newStr;
	 * }
	 */
