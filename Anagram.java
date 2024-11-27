import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function. 
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
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

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String newStr1 ="";
		String newStr2 ="";
		String temp = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i<str1.length(); i++) // return string1 without the spaces and the nuber of space in the string
		{
			if(temp.indexOf(str1.charAt(i))!= -1)
			{
				newStr1 = newStr1 + str1.charAt(i);
			}

		}
		for (int j = 0; j<str2.length(); j++) // return string2 without the spaces and the nuber of space in the string
		{
			if(temp.indexOf(str2.charAt(j))!= -1)
			{
				newStr2 = newStr2 + str2.charAt(j);
			}
		}
		if (newStr1.length()!=newStr2.length()) {return false;} // if the length is diffrent - the string cannoy be anagram
		for (int i=0; i<newStr1.length(); i++)
		{
			char c = newStr1.charAt(i);
			int str2Index = newStr2.indexOf(c);
			if (str2Index == -1) {
				return false;
			}
			newStr2 = newStr2.substring(0, str2Index) + newStr2.substring(str2Index + 1);
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"
	public static String preProcess(String str) {
		String newString = "";
		int sLength = str.length();
		str = str.toLowerCase();
		String test = "abcdefghijklmnopqrstuvwxyz";
		for (int i=0; i<sLength; i++)
		{
			if (test.indexOf(str.charAt(i))!= -1 || str.charAt(i) == ' ')
			{
				newString =newString + str.charAt(i);
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		str = preProcess(str);
		String temp = "abcdefghijklmnopqrstuvwxyz";
		String newSrt = "";
		for (int i = 0; i<str.length(); i++) // return string without the spaces and the nuber of space in the string
		{
			if(temp.indexOf(str.charAt(i))!= -1)
			{
				newSrt = newSrt + str.charAt(i);
			}

		}
		str = newSrt;
		String sRandom = "";
		int random =0;
		for (int i=0; i<str.length(); i++)
		{
			//if(temp.indexOf(newSrt.charAt(i))!= -1)
			//{
				random = (int) (Math.random() * newSrt.length());
				sRandom = sRandom + newSrt.charAt(random);
				newSrt = newSrt.substring(0, random) + newSrt.substring(random + 1);

			//}
		}
		return sRandom;
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
 