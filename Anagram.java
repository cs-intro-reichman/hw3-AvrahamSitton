import java.util.Random;

import javax.print.DocFlavor.STRING;

public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

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
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  
	public static String RemoveSpaces(String str) {
		String str1 = "";
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) != 32) {
				str1 += str.charAt(i);
			}
		}
		return str1;
	} 
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = RemoveSpaces(preProcess(str1));
		str2 =RemoveSpaces(preProcess(str2));
		if (str1.length() != str2.length())
			return false;
		else{
			while (!str1.isEmpty()) {
				char c = str1.charAt(0);
				int index = str2.indexOf(c);
				if (index == -1){
					return false;
				}
				str1 = str1.substring(1);
			}
		}
			return str1.isEmpty();
	}
	 
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"

	// return str.toLowerCase().replaceAll("[^a-z]", " ");
	public static String preProcess(String str) {
		String str2 = "";
		for (int i = 0; i < str.length(); i++){
			if ((str.charAt(i) < 65 || str.charAt(i) > 122) && str.charAt(i) != 32) {
			continue;
			}
			else{
				str2 += str.charAt(i);
			}
		}
		return str2.toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		StringBuilder result = new StringBuilder();
		Random random = new Random();
		while (!str.isEmpty()) {
			int index = random.nextInt(str.length());
			result.append(str.charAt(index));
			str = str.substring(0, index) + str.substring(index + 1);
		}
		return result.toString();
	}
}//Functions for checking if a given string is an anagram. */
/*public class Anagram {
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
				//isSpace = 0;

		for (int i = 0; i < str.length(); i++) {
			character = str.charAt(i);
			asciiValue = (int) character;
			//if (asciiValue == ' ') {
			//	standString += str.charAt(i);
				// isSpace++;
			//} else 
			/*if (asciiValue > 'Z' || asciiValue == ' ') {
				standString += str.charAt(i);

			} else */
			/* if(asciiValue > 'A'){
				if (asciiValue < 'Z') {
					standString += (char) (character + ' ');
	
				}

			 }
			 else if( asciiValue == ' '){
			
				continue;
			}
			standString += str.charAt(i);
			// (char) isSpace +
		}
		//standString += str.charAt(i);
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

		// int a = (int) str1.charAt(0), // (int) Math.abs(preProcess(str1).length() -
		// preProcess(str2).length()),
		// b = (int) str2.charAt(0),
	/* 	int c = preProcess(str1).length(),
				d = preProcess(str2).length(),
				sumAscii1 = 0,
				sumAscii2 = 0;
		for (int i = 0; i < c; i++) {
			if ((int) preProcess(str1).charAt(i) != 32) {
				sumAscii1 += (int) preProcess(str1).charAt(i);
			}

		}
		for (int i = 0; i < d; i++) {
			if ((int) preProcess(str2).charAt(i) != 32) {
				sumAscii2 += (int) preProcess(str2).charAt(i);
			}
		}
		return ((sumAscii1 - sumAscii2 == 0));

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
}*/
 