import java.util.Scanner;

public class RomanToInteger {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a Roman numeral: ");
		String romanNumeral = scanner.nextLine().toUpperCase();

		try {
			int result = romanToInteger(romanNumeral);
			System.out.println("Equivalent Integer: " + result);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Roman numeral. Please enter a valid Roman numeral.");
		}
	}

	public static int romanToInteger(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Input is null or empty.");
		}

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			int currentVal = romanCharToValue(s.charAt(i));

			if (i < s.length() - 1) {
				int nextVal = romanCharToValue(s.charAt(i + 1));

				if (currentVal < nextVal) {
					result -= currentVal;
				} else {
					result += currentVal;
				}
			} else {
				result += currentVal;
			}
		}

		return result;
	}

	public static int romanCharToValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new IllegalArgumentException("Invalid Roman numeral character: " + c);
		}
	}

}