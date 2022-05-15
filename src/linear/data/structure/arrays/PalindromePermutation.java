package linear.data.structure.arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	/*
	Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
	A palindrome is a word or phrase that is the same forwards and backwards. A permutation
	is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
	1.5
	1.6
	EXAMPLE
	Input: Tact Coa
	Output: True (permutations: "taco cat", "atco eta", etc.)
	 */

	public static void main(String[] args) {

		System.out.println(palPerm("Tact Coa"));
		
	}
	
	private static final int NUM_LOWERCASE_LETTERS = 26;

	public static boolean palPerm(String str) {
        str = str.toLowerCase().replaceAll("\\s", "");
        Map<Character, Integer> map = new HashMap(NUM_LOWERCASE_LETTERS);
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }
        
        //  Odd length strings: Can have at most 1 character an odd # of times
        // Even length strings: Can have either 0,2,4,6... number of odd characters.
        //                      Anything above 1 means not a palindrome.
        int oddCount = 0;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}
