package linear.data.structure.arrays;

public class URLifyString {

	public static void main(String[] args) {
		System.out.println(URLify("Mr John Smith "));
		URLifyHelper("Ben is smart    ", 12);
	}

	public static String URLify(String targetString) {
		String result = targetString.replaceAll(" ", "%20");
		return result;
	}


	//Book code
	/*
	 * public static String URLifyWithoutLibraryFunctionReplaceAll(String
	 * targetString) { char[] charArray = targetString.toCharArray(); String
	 * trimmedString = targetString.trim(); int trueLength = trimmedString.length();
	 * replaceSpaces(charArray, trueLength); return new String(charArray); }
	 */

	/*
	 * static void replaceSpaces(char[] str, int trueLength) { int spaceCount = 0,
	 * index, i = 0; for (i = 0; i < trueLength; i++) { if (str[i] == ' ') {
	 * spaceCount++; } }
	 * 
	 * index = trueLength + spaceCount * 2; if (trueLength < str.length)
	 * str[trueLength] = '\0'; //End Array for (i = trueLength - 1; i >= 0; i-- ) {
	 * if (str[i] == ' ') { str[index - 1] = '0'; str[index - 2] = '2'; str[index -
	 * 3] = '%'; index = index - 3; } else { str[index - 1] = str[i]; index--; } } }
	 */
	
	private static void URLifyHelper(String str, int trueLength) {
		char[] sentence = str.toCharArray();
		System.out.println(sentence);
		replaceWhitespace(sentence, trueLength);
		System.out.println(sentence);
	}

	public static void replaceWhitespace(char[] sentence, int trueLength) {
		/* Count number of spaces */
		int numSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if (sentence[i] == ' ') {
				numSpaces++;
			}
		}
		/* Replace each space with %20 */
		if (numSpaces > 0) {
			int j = trueLength - 1 + numSpaces * 2; // adds an additional 2 spots for each space.
			for (int i = trueLength - 1; i >= 0; i--) {
				if (sentence[i] == ' ') {
					sentence[j-2] = '%';
					sentence[j-1] = '2';
					sentence[j]   = '0';
					j = j - 3;
				} else {
					sentence[j] = sentence[i];
					j--;
				}
			}
		}
	}
}
