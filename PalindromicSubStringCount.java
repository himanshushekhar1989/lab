package lab;

import java.util.Arrays;
import java.util.LinkedList;

public class PalindromicSubStringCount {

	public static void main(String[] args) {
		String input = "abccbc";
		int count = 0;
		boolean[][] dp = new boolean[input.length()][input.length()];

		for (int gap = 0; gap < input.length(); gap++) {

			for (int i = 0, j = i + gap; j < input.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					dp[i][j] = input.charAt(i) == input.charAt(j);
				} else {
					dp[i][j] = input.charAt(i) == input.charAt(j) && dp[i + 1][j - 1];
				}
				if (dp[i][j]) {
					count++;
				}
			}
		}

		for (boolean[] temp : dp) {
			for (boolean temp1 : temp) {
				System.out.print(temp1 + " ");
			}
			System.out.println();
		}

		System.out.println("Total number of palindromic string " + count);
	}
}
