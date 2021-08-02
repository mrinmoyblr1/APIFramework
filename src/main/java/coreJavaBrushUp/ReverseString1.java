package coreJavaBrushUp;

public class ReverseString1 {

	public static void main(String[] args) {

		String str = "madam";
		String reverseString = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverseString = reverseString + str.charAt(i);

		}

		System.out.println(reverseString);

		if (reverseString.equalsIgnoreCase(str)) {
			System.out.println("The String is palindrome");
		} else {
			System.out.println("Not palindrome");
		}

	}

}
