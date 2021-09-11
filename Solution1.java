package com.him;

/*

Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1's. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,0],[2,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left-row-column and width/height):
  [
    [[0,0],[1,1]],
    [[2,0],[1,1]],
    [[2,3],[3,2]],
    [[3,1],[1,3]],
    [[5,3],[2,2]],
    [[7,6],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left-row-column and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

image4 = [
  [1, 1, 1, 1, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1],
]

findRectangles(image4) =>
  // (using top-left-row-column, and bottom-right or width/height):
  [
    [[1,1],[3,3]],
  ]

n: number of rows in the input image
m: number of columns in the input image


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	public static void main(String[] argv) {

		int[][] image1 = {
				{0, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{0, 1, 1, 0, 0, 0, 1},
				{1, 0, 1, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 1, 1},
				{1, 0, 1, 0, 0, 1, 1},
				{1, 1, 1, 0, 0, 1, 1},
				{1, 1, 1, 1, 1, 1, 0},
		};

		int[][] image2 = {
				{0},
		};

		int[][] image3 = {
				{1},
		};

		int[][] image4 = {
				{1, 1, 1, 1, 1},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1},
		};

		//Arrays.stream(printCoordinates(image4)).forEach(System.out::println);

		getCoordinates(image1).stream().forEach(arr -> System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " "));

	}

	static int[] printCoordinates(int[][] image) {
		boolean firstZero = true;
		int[] result = new int[4];
		Arrays.fill(result, -1);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] == 0) {
					if (firstZero) {
						result[0] = i;
						result[1] = j;
						firstZero = false;
					} else {
						result[2] = i;
						result[3] = j;
					}

				}

			}
		}

		if (result[2] == -1 && result[3] == -1) {
			result[2] = result[0];
			result[3] = result[1];
		}

		return result;
	}

	static List<int[]> getCoordinates(int[][] image) {

		boolean[][] visted = new boolean[image.length][image[0].length];

		List<int[]> result = new ArrayList<>();

		for (int i = 0; i < image.length; i++) {

			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] == 0 && !visted[i][j]) {
					int[] coArray = new int[4];
					coArray[0] = i;
					coArray[1] = j;
					findCoordinates(image, i, j, visted, coArray);
					result.add(coArray);
				}
			}
		}

		return result;


	}

	static void findCoordinates(int[][] image, int i, int j, boolean[][] visted, int[] coArray) {
		if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] == 1 || visted[i][j]) {
			return;
		}

		visted[i][j] = true;
		if (i >= coArray[2] && j >= coArray[3]) {
			coArray[2] = i;
			coArray[3] = j;
		}
		/*coArray[2] = i;
		coArray[3] = j;*/
		findCoordinates(image, i - 1, j, visted, coArray);
		findCoordinates(image, i, j - 1, visted, coArray);
		findCoordinates(image, i + 1, j, visted, coArray);
		findCoordinates(image, i, j + 1, visted, coArray);


	}


}

