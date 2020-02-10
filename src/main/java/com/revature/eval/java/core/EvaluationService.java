package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		
		String answer = new String();
		
		for (int i=0; i<string.length();i++) {
			answer += string.substring(string.length()-1-i, string.length()-i);
		}
		
		return answer;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		String[] words = phrase.split("\\s|\\-", -1);
		
		String acronym = new String();
		
		for(String word: words) {
			acronym += word.substring(0,1).toUpperCase();
		}
		
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return getSideOne() == getSideTwo() && getSideTwo() == getSideThree() && getSideOne() == getSideThree();
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			return (getSideOne() == getSideTwo() && getSideOne() != getSideThree()) || (getSideTwo() == getSideThree() && getSideTwo() != getSideOne()) || (getSideOne() == getSideThree() && getSideOne() != getSideTwo());
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return getSideOne() != getSideTwo() && getSideTwo() != getSideThree() && getSideOne() != getSideThree();
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String[] score1 = {"A","E","I","O","U","L","N","R","S","T"};
		String[] score2 = {"D","G"};
		String[] score3 = {"B","C","M","P"};
		String[] score4 = {"F","H","V","W","Y"};
		String[] score5 = {"K"};
		String[] score8 = {"J","X"};
		String[] score10 = {"Q","Z"};
		
		int score = 0;
		
		for(int i = 0; i<string.length(); i++) {
			String letter = string.substring(i, i+1).toUpperCase();
			
			if (Arrays.asList(score1).contains(letter)) {
				score++;
			} else if(Arrays.asList(score2).contains(letter)) {
				score += 2;
			} else if(Arrays.asList(score3).contains(letter)) {
				score += 3;
			} else if(Arrays.asList(score4).contains(letter)) {
				score += 4;
			} else if(Arrays.asList(score5).contains(letter)) {
				score += 5;
			} else if(Arrays.asList(score8).contains(letter)) {
				score += 8;
			} else if(Arrays.asList(score10).contains(letter)) {
				score += 10;
			}
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
//		System.out.println(string.replaceAll("[^\\d]",""));
		
		String digits = string.replaceAll("[^\\d]","");
		if (digits.length() > 11 || digits.length() < 8) {
			throw new IllegalArgumentException();
		}
		
		// Where is the country code case in the tests?
		
		return digits;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		
		String[] words = string.split("[^\\w]");
		
		for(String word: words) {
			if (!wordCounts.containsKey(word) && !word.equals("")) {
				int count = 0;
				for(String w: words) {
					if (word.equals(w)) {
						count++;
					}
				}
				wordCounts.put(word, count);
			}
		}
		
//		System.out.println(wordCounts);
		
		return wordCounts;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TO DO
			
			int high = sortedList.size();
			int low = 0;
			
			int ind = high / 2;
			int com = t.compareTo(sortedList.get(ind));
			
			if (t.compareTo(sortedList.get(0)) == 0) {
				return 0;
			} else if (t.compareTo(sortedList.get(sortedList.size()-1)) == 0) {
				return sortedList.size()-1;
			}
			
			while(com != 0 && high != low ) {
				
				if (com > 0) {
					low = ind;
				} else if (com < 0) {
					high = ind;
				}
				
				ind = (high + low) / 2;
				com = t.compareTo(sortedList.get(ind));
				
//				System.out.println(ind);
			}
			
			return com == 0 ? ind : -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		String[] words = string.split("\\s");
		String result = new String();
		
		int index = 0;
		
		for (String word:words) {
			
			result += index > 0 ? " " : "";
			
			int conInd = 0;
			// check if consonant at the beginning of the word
			if(!(word.charAt(conInd) == 'a' || word.charAt(conInd) == 'e' || word.charAt(conInd) == 'i' || word.charAt(conInd) == 'o' || word.charAt(conInd) == 'u')) {
				while(!(word.charAt(conInd) == 'a' || word.charAt(conInd) == 'e' || word.charAt(conInd) == 'i' || word.charAt(conInd) == 'o' || word.charAt(conInd) == 'u')) {
					if((word.charAt(conInd) == 'Q' || word.charAt(conInd) == 'q') && word.charAt(conInd+1) == 'u') {
						conInd++;
					}
					conInd++;
				}
				result += word.substring(conInd, word.length()) + word.substring(0,conInd) + "ay";
			} else {
				result += word +"ay";
			}
			index++;
		}
		
//		System.out.println(result);
		
		return result;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		List<Integer> digits = new ArrayList<Integer>();
		
		int temp = new Integer(input);
		
		while(temp != 0) {
			digits.add(temp%10);
			temp /= 10;
		}
		
		int sum = 0;
		
		for(int digit:digits) {
			sum += Math.pow(digit, digits.size());
		}
		
//		System.out.println(sum +" "+(sum==input));
		
		return sum == input;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> primes = new ArrayList<Long>();
		
		long counter = 2;
		
		while(counter < l) {
			if (l%counter == 0) {
				boolean isPrime = true;
				long temp = 2;
				while(temp < counter/2) {
					isPrime = temp%counter == 0 ? false : true;
					temp++;
				}
				if (isPrime) {
					primes.add(counter);
					l /= counter;
					counter = 2;
				}
			} else {
				counter++;
			}
		}
		
		primes.add(l);
		
//		System.out.println(primes);

		return primes;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			char[] letters = string.toCharArray();
			char[] ciArr = new char[letters.length];
			
			int ind = 0;
			for(int letter: letters) {
				if(letter < 91 && letter > 64) { // Capital Letters
					if(letter + key > 90) {
						ciArr[ind] = (char) (64 + (key - (90 - letter)));
					} else {
						ciArr[ind] += (char) (letter + key);
					}
				} else if (letter < 123 && letter > 95) { // Lowercase Letters
					if(letter + key > 122) {
						ciArr[ind] = (char) (96 + (key - (122 - letter)));
					} else {
						ciArr[ind] += (char) (letter + key);
					}
				} else {
					ciArr[ind] += (char) letter;
				}
//				System.out.print(ciArr[ind]);
				ind++;
			}
			
//			System.out.println(Arrays.toString(ciArr));
			
			String cipher = new String(ciArr);
						
			return cipher;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		
		int counter = 2;
		
		while (i > 0) {
			
			int temp = 2;
			boolean isPrime = true;
			
			while(temp <= counter/2) {
				if (counter%temp == 0) {
					isPrime = false;
					break;
				}
				temp++;
			}
			
			if(isPrime) {
				i--;
//				System.out.println(counter);
			}
			
			if (i > 0) {
				counter++;				
			}
		}
		
		return counter;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			// position from end = positon from beginning
			
			char[] letters = string.replaceAll("[^\\w]", "").toCharArray();
			char[] ciArr = new char[letters.length + (int)Math.ceil(letters.length/5)+1];
			
//			System.out.println(Arrays.toString(letters));
			
			int ind = 0;
			int spaceCounter = 1;
			
			for(int letter: letters) {
				if(letter < 91 && letter > 64) { // Capital Letters
					ciArr[ind] = (char) (65 + (90 - letter));
				} else if (letter < 123 && letter > 96) { // Lowercase Letters
					ciArr[ind] = (char) (97 + (122 - letter));;
				} else {
					ciArr[ind] += (char) letter;
				}
//				System.out.print(ciArr[ind]);
				
				if (spaceCounter == 5) {
					ind++;
					ciArr[ind] = ' ';
					spaceCounter = 0;
				}
				spaceCounter++;
				
				ind++;					
			}
			
//			System.out.println(Arrays.toString(ciArr).toLowerCase().replaceAll("\\s", ""));
			
			String cipher = new String(ciArr).toLowerCase();
			
			if (cipher.substring(cipher.length()-2, cipher.length()-1).equals(" ")) {
				cipher = cipher.substring(0, cipher.length()-2);
			} else {
				cipher = cipher.substring(0, cipher.length()-1);				
			}
			
//			System.out.println(cipher);
			
						
			return cipher;
			
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			char[] letters = string.replaceAll("[^\\w]", "").toCharArray();
			char[] ciArr = new char[letters.length];
			
			int ind = 0;
			
			for(int letter: letters) {
				if(letter < 91 && letter > 64) { // Capital Letters
					ciArr[ind] = (char) (65 + (90 - letter));
				} else if (letter < 123 && letter > 96) { // Lowercase Letters
					ciArr[ind] = (char) (97 + (122 - letter));;
				} else {
					ciArr[ind] += (char) letter;
				}
				
				ind++;					
			}
			
			String cipher = new String(ciArr).toLowerCase();
			
//			System.out.println(cipher);
			
			return cipher;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		String[] digits = string.replaceAll("-", "").split("");
		
		if("X".equals(digits[9])) {
			digits[9] = "10";
		}
//		System.out.println(Arrays.toString(digits));
		
		int sum = 0;
		int mult = 10;
		
		for(String digit : digits) {
			if (digit.matches("\\d+")) {
				int num = Integer.parseInt(digit);
				sum += num*mult;
				mult--;
			} else {
				return false;
			}
		}

//		System.out.println(sum);
		
		return sum % 11 == 0 ? true : false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		String[] charArr = string.replace(" ","").split("");
		
		HashSet<String> letterSet = new HashSet<String>(Arrays. asList(charArr));
		
//		System.out.println(letterSet);
		
		return letterSet.size() < 26 ? false: true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		if (given.isSupported(ChronoUnit.SECONDS)) {
//			System.out.println(given + " " + (given.plus(1000000000, ChronoUnit.SECONDS)));
			return given.plus(1000000000, ChronoUnit.SECONDS);
		}
		else {
			LocalDate date = (LocalDate) given;
//			System.out.println(date.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS));
			return date.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS);
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		int j = 1;
		
		HashSet<Integer> nums = new HashSet<Integer>();
		
		while (j < i) {
			
			for(int num : set) {
				if (j%num == 0) {
					nums.add(j);					
				}
			}
			j++;
		}
		
//		System.out.println(nums);
		
		int sum = 0;
		for (int k : nums) {
			sum += k;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		String[] digits = string.replace(" ", "").split("");
		
		int[] nums = new int[digits.length]; 
		
		int index = 0;
		
		for(String digit:digits) {
			if (!digit.matches("\\d")) {
				return false;
			}
			
			int num = Integer.parseInt(digit);
			
			if(index%2 == 0)
			{
				num *= 2;
				if (num > 10) {
					num -= 9;
				}
				nums[index] = num;
				
			} else {
				nums[index] = num;
			}
			
			index++;
		}
		
		int sum = 0;
		
		for(int i: nums) {
			sum+=i;
		}
		
		return sum%10 == 0 ? true : false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		String[] input = string.split("\\s");
		List<String> parsedInfo = new ArrayList<String>();
		
		for (String arg: input) {
			if (arg.matches("^-?\\d+\\??$") || arg.equals("plus") || arg.equals("minus") || arg.equals("multiplied") || arg.equals("divided")) {
				parsedInfo.add(arg);
			}
		}
		
//		System.out.println(parsedInfo);
		
		switch(parsedInfo.get(1)) {
			case "plus":
				return Integer.parseInt(parsedInfo.get(0)) + Integer.parseInt(parsedInfo.get(2).replace("?", ""));
			case "minus":
				return Integer.parseInt(parsedInfo.get(0)) - Integer.parseInt(parsedInfo.get(2).replace("?", ""));
			case "multiplied":
				return Integer.parseInt(parsedInfo.get(0)) * Integer.parseInt(parsedInfo.get(2).replace("?", ""));
			case "divided":
				return Integer.parseInt(parsedInfo.get(0)) / Integer.parseInt(parsedInfo.get(2).replace("?", ""));
		}
		
		return 0;
	}

}
