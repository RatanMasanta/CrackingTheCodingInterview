package linear.data.structure.arrays;

import java.util.Stack;

public class StringCompression {
	
	/*
	 * 
	 * Implement a method to perform basic string compression using the counts
		of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
		"compressed" string would not become smaller than the original string, your method should return
		the original string. You can assume the string has only uppercase and lowercase letters (a - z).
	 */

	public static void main(String[] args) {
		System.out.println(performCompression("aabbcccdaab"));

	}
	
	public static String performCompression(String uncompressedString) {
		char[] charArray = uncompressedString.toCharArray();
		Stack<String> stack = new Stack<>();
		int count = 0;
		for(int i = 0;i<charArray.length; i++ ) {
			if(i == 0) {
				stack.push(String.valueOf(charArray[i]));
				count+=1;
				continue;
			}
			if(stack.peek().equals(String.valueOf(charArray[i]))) {
				count++;
			} else {
				stack.push( String.valueOf(count));
				stack.push(String.valueOf(charArray[i]));
				count = 1;
			}
			
		}
		stack.push(String.valueOf(count));
		StringBuffer sb = new StringBuffer();
		int length = stack.size();
		while(length > 0) {
			sb.append(stack.pop());
			length--;
		}
		return sb.reverse().toString();
	}
	
	

}
