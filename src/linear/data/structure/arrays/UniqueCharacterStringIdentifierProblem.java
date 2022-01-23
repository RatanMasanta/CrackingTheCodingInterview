package linear.data.structure.arrays;
public class UniqueCharacterStringIdentifierProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isUniqueChars("wordss"));
		
	}
	
	// Create a boolean array of indexes and check
	// o(n) time complexity
	public static boolean isUniqueChars(String word) {
		if(word.length() > 128)
			return false;
		boolean[] charSet = new boolean[128];
		for(int i = 0; i<word.length(); i++) {
			int val = word.charAt(i);
			if(charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	
	//method2
	public static boolean isUniqueCharsMethod2(String word) {
		int checker = 0;
		for(int i = 0; i<word.length();i++) {
			int val = word.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

}
