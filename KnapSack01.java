package com.him.knapsack;

import java.util.LinkedList;
import java.util.List;

public class KnapSack01 {
	public static void main(String[] args) {
		int maxWeight = 7;
		int[] weights = {2, 5, 1, 3, 4};
		int[] profits = {15, 14, 10, 45, 30};

		System.out.println("Max profit " + maxProfitKnapsack(weights, profits, maxWeight));
	}

	static int maxProfitKnapsack(int[] weights, int[] profits, int maxWeight) {
		int[][] dp = new int[weights.length + 1][maxWeight + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int weightsIndex = i - 1;
				if (j >= weights[weightsIndex]) {
					dp[i][j] = Math.max(profits[weightsIndex] + dp[i - 1][j - weights[weightsIndex]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		print2DArray(dp);
		return dp[weights.length][maxWeight];
	}

	static void print2DArray(int[][] array2D) {
		for (int[] rows : array2D) {
			System.out.println();
			for (int col : rows) {
				System.out.print(col + " ");
			}
		}
		System.out.println();
	}
}
