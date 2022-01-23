package linear.data.structure.arrays;

public class PermutationStringIdentifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPermutation("earth","there"));
	}
	
	//Solution 1
	
	public static String sortString(String str) {
		char[] content = str.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean checkPermutation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		return sortString(s1).equals(sortString(s2));
	}

	// Solution 2
	
	private static boolean permutation(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] letters = new int[128]; // Assumption: ASCII
		
		for(int i=0;i<s.length();i++){
			letters[s.charAt(i)]++;
		}
		
		for(int i=0; i<t.length(); i++) {
			letters[t.charAt(i)]--;
			if(letters[t.charAt(i)] < 0) {
				return false;
			}
		}
		return true; 
	}
}
