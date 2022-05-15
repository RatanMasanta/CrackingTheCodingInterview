package linear.data.structure.arrays;

public class StringRotation {

	/*
	 * Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
		of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
		call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").
	 */

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle","erbottlewat"));

	}

	/*
	 *  If we imagine that 52 is a rotation of 51, then we can ask what the rotation point is. For example, if you
		rotate waterbottle after wat. you get erbottlewat. In a rotation, we cut 51 into two parts, x and y,
		and rearrange them to get 52.
		51 = xy = waterbottle
		x = wat
		y = erbottle
		s2 = yx = erbottlewat
		So, we need to check if there's a way to split s1 into x and y such that xy = s1 and yx = s2. Regardless of
		where the division between x and y is, we can see thatyx will always be a substring of xyxy.That is, s2 will
		always be a substring of s1s1.
		And this is precisely how we solve the problem: simply do isSubstring(slsl, s2).
	 * 
	 */
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String doubledString = s1 + s1;
		return doubledString.contains(s2);
	}

}
