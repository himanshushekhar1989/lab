package com.him;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {

		//replaceWildcardWithBinary("1??0".toCharArray(),0);
		//getSebSequence("abc".toCharArray(), "", 0);
		//maximumArea(new int[]{6, 2, 5, 4, 5, 1, 6});

		Map<Integer, List<Character>> map = new HashMap<>();
		List<Character> list5 = new ArrayList<>();
		list5.add('m');
		list5.add('n');
		list5.add('o');
		list5.add('p');
		List<Character> list7 = new ArrayList<>();
		list7.add('u');
		list7.add('v');
		List<Character> list3 = new ArrayList<>();
		list3.add('g');
		list3.add('h');
		list3.add('i');
		map.put(5, list5);
		map.put(7, list7);
		map.put(3, list3);
		//printSubSeq("573", "", 0, map);
		nextGreaterNumber(59721);

	}

	private static void getSebSequence(char[] arr, String ssf, int index) {

		if (index == arr.length) {
			System.out.println(ssf);
			return;
		}

		getSebSequence(arr, ssf + arr[index], index + 1);
		getSebSequence(arr, ssf, index + 1);
	}

	private static void replaceWildcardWithBinary(char[] str, int index) {
		if (index == str.length) {
			System.out.println(str);
			return;
		}
		if (str[index] == '?') {
			str[index] = '0';
			replaceWildcardWithBinary(str, index + 1);

			str[index] = '1';
			replaceWildcardWithBinary(str, index + 1);
			str[index] = '?';
		} else {
			replaceWildcardWithBinary(str, index + 1);
		}
	}

	private static void maximumArea(int[] arr) {
		int[] rb = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				int pos = stack.peek();
				rb[pos] = i;
				stack.pop();
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			rb[stack.pop()] = arr.length;
		}

		int[] lb = new int[arr.length];
		stack.empty();
		stack.push(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				int pos = stack.peek();
				lb[pos] = i;
				stack.pop();
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			lb[stack.pop()] = -1;
		}

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < rb.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = width * arr[i];
			maxArea = Math.max(maxArea, area);
		}
		System.out.print("Right min boundary -> ");
		Arrays.stream(rb).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.print("Left min boundary -> ");
		Arrays.stream(lb).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Max area " + maxArea);
	}

	private static void nextGreaterNumber(int num) {
		char[] numChar = (num + "").toCharArray();
		int i = numChar.length - 2;

		while (i >= 0 && numChar[i] >= numChar[i + 1]) {
			i--;
		}
		if (i == -1) {
			System.out.println(-1);
			return;
		}
		int k = numChar.length - 1;
		while (numChar[i] >= numChar[k]) {
			k--;
		}
		char temp = numChar[k];
		numChar[k] = numChar[i];
		numChar[i] = temp;
		int m = numChar.length - 1;

		while (m > k) {
			char swap = numChar[k];
			numChar[k] = numChar[m];
			numChar[m] = swap;
			k++;
			m--;

		}
		for (char p : numChar) {
			System.out.print(p);
		}

	}

	private static void printSubSeq(String str, String ssf, int index, Map<Integer, List<Character>> map) {
		if (str.length() == index) {
			System.out.println(ssf);
			return;
		}
		for (int i = 0; i < map.get(Integer.parseInt(String.valueOf(str.charAt(index)))).size(); i++) {
			printSubSeq(str, ssf + map.get(Integer.parseInt(String.valueOf(str.charAt(index)))).get(i), index + 1, map);
		}

	}
}
