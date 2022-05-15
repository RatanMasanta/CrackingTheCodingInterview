package linear.data.structure.arrays;

import java.util.Arrays;

public class RotateMatrix {
	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4 
	 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	 * 
	 */

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(rotateMatrix(matrix));
		for(int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	/* 
	 * 
	 * Because we're rotating the matrix by 90 degrees, the easiest way to do this is to implement the rotation in
		layers. We perform a circular rotation on each layer, moving the top edge to the right edge, the right edge
		to the bottom edge, the bottom edge to the left edge, and the left edge to the top edge.
		How do we perform this four-way edge swap? One option is to copy the top edge to an array, and then
		move the left to the top, the bottom to the left, and so on. This requires O(N) memory, which is actually
		unnecessary.
		A better way to do this is to implement the swap index by index. In this case, we do the following:
		1 for i = 0 to n
		2 temp= top[i];
		3 top[i] = left[i]
		4 left[i] = bottom[i]
		5 bottom[i] = right[i]
		6 right[i] = temp
		We perform such a swap on each layer, starting from the outermost layer and working our way inwards.
		(Alternatively, we could start from the inner layer and work outwards.)
		The code for this algorithm is below.
	 */

	public static boolean rotateMatrix(int[][] matrix) {
		if (matrix.length== 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first= layer;
			int last= n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;

				int top= matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];;
				// top -> right
				matrix[i][last] = top; // right<- saved top
			}
		}
		return true;
	}



}
