
/**
 * Class: CMSC201 
 * Instructor: Ashique Tanveer
 * Description: a program that prompts the user to enter a credit card number as a long integer. 
 * Display whether the number is valid or invalid
 * Due: 03/21/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Mark Kasule
*/

import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) {

		long creditCard;

		// Enter credit card
		System.out.print("Enter a credit card number as a long integer: ");
		creditCard = inputData();

		// display results
		displayResult(creditCard);

	}

	/**
	 * input credit card’s number from keyboard Return this credit Card’s number
	 * 
	 * @return credit card number
	 */
	public static long inputData() {
		Scanner input = new Scanner(System.in);
		long credit = input.nextLong(); // hold credit card input
		return credit;
	}

	/**
	 * Return the number of digits in d
	 * 
	 * @param d is the credit card number
	 * @return size of number
	 */
	public static int getSize(long d) {

		// convert the long numbers into string to get length
		String card = d + "";
		int cardLength = card.length();
		return cardLength;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of the
	 * two digits
	 * 
	 * @param number
	 */
	public static int getDigit(int number) {

		if (number < 9) {
			return number;
		} else {
			return (number / 10) + (number % 10);
		}
	}

	/**
	 * Get the result from Step 2
	 * 
	 * @param number holds credit card number
	 * @return doubledSum the sum of doubled values
	 */
	public static int sumOfDoubleEvenPlace(long number) {

		// convert to string and get length
		String card = number + ""; // converts to string
		int doubledSum = 0; // holds sum of doubled values

		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
			doubledSum += getDigit(Integer.parseInt(card.charAt(i) + "") * 2);
		}
		return doubledSum;
	}

	/**
	 * Return sum of odd-place digits in number
	 * 
	 * @param number credit card numbers
	 * @return oddPlaceSum of second odd placed number
	 */
	public static int sumOfOddPlace(long number) {
		// convert long to string to access characters
		String card = number + "";

		int oddPlaceSum = 0; // accumulator for sum of odd place digits

		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
			// add each number at every index
			int num = Integer.parseInt((card.charAt(i) + ""));

			oddPlaceSum += num;
		}
		return oddPlaceSum;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits in
	 * number is less than k, return number.
	 * 
	 * @param number credit card number
	 * @param k      number of digits
	 * @return number
	 */

	public static long getPrefix(long number, int k) {

		String card = number + "";
		// access k values in string then convert to long
		if (getSize(number) > k) {
			return Long.parseLong(card.substring(0, k));
		} else {
			return number;
		}
	}

	/**
	 * Return true if the digit d is a prefix for number
	 * 
	 * @param number credit card number
	 * @param d      prefix number
	 * @return valid
	 */
	public static boolean prefixMatched(long number, int d) {

		boolean valid = false; // flag
		long result = getPrefix(number, getSize(d)); // credit card number

		if (result == d) {
			valid = true;
		}
		return valid;
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean valid;
		int sumOfResults;

		// sum the results of doubledSum and oddPlaceSum
		sumOfResults = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

		valid = ((sumOfResults % 10 == 0) && (getSize(number) >= 13) && (getSize(number) <= 16)
				&& (prefixMatched(number, 4)) || (prefixMatched(number, 5)) || (prefixMatched(number, 37))
				|| (prefixMatched(number, 6)));

		return valid;
	}

	/**
	 * Display result using a method println()
	 */
	public static void displayResult(long number) {

		System.out.println(number + " is " + (isValid(number) ? "Valid" : "Invalid"));
	}

}
