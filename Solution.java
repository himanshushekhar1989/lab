package lab;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {


	public static void main(String[] args) {

		System.out.println("Result is ");
		Arrays.stream(findErrorNums(new int[]{4, 3, 1, 2, 4, 6})).forEach(System.out::println);


		Duck d2 = new Duck("George", "blue", 10);
		Duck d3 = new Duck("Jerry", "black", 10);
		Duck d4 = new Duck("Kramer", "pik", 10);
		Duck d1 = new Duck("Elaine", "white", 10);

		List<Duck> list = new ArrayList<>();
		list.add(d4);
		list.add(d2);
		list.add(d1);
		list.add(d3);
		Comparator<Duck> nameComparator = Comparator.comparing(Duck::getName);
		list.sort(nameComparator);
		list.forEach(d->System.out.println(d.getName()));

	}

	public static int[] plusOne(int[] digits) {
		int[] result = digits;

		if (digits[digits.length - 1] + 1 > 9) {
			int carry = 0;

			for (int i = digits.length - 1; i >= 0; i--) {
				int sum = 0;
				if (i == digits.length - 1) {
					sum = digits[i] + 1;
					carry = sum / 10;
					result[i] = sum % 10;
				} else {
					sum = digits[i] + carry;
					result[i] = sum % 10;
					carry = sum / 10;
				}


			}
			if (carry == 1) {
				result = new int[digits.length + 1];
				for (int i = digits.length - 1; i >= 0; i--) {
					result[i] = digits[i];
				}
				result[0] = 1;
			}

		} else {
			digits[digits.length - 1] = digits[digits.length - 1] + 1;
		}


		return result;

	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		StringBuilder num2Builder = new StringBuilder(num2);
		StringBuilder num1Builder = new StringBuilder(num1);
		if (num1.length() > num2.length()) {
			while (num1.length() != num2Builder.length()) {
				num2Builder.insert(0, "0");
			}
		} else if (num1.length() < num2.length()) {
			while (num2.length() != num1Builder.length()) {
				num1Builder.insert(0, "0");
			}
		}

		int count = 0;
		int[] result = new int[num2Builder.length() + num1Builder.length()];

		for (int i = num1Builder.length() - 1; i >= 0; i--) {
			int carry = 0;
			count = num1Builder.length() - 1 - i;

			for (int j = num2Builder.length() - 1; j >= 0; j--) {
				int temp = (num1Builder.charAt(i) - '0') * (num2Builder.charAt(j) - '0') + carry;
				int index = (num1Builder.length() + num2Builder.length()) - count - 1;
				int val = result[index] + temp;
				if (j > 0) {
					carry = val / 10;
					result[index] = val % 10;

				} else {
					result[index] = val;
				}
				count++;
			}

		}
		StringBuilder strResult = new StringBuilder();
		Arrays.stream(result).forEach(strResult::append);

		while (strResult.charAt(0) == '0' && strResult.length() > 1) {
			strResult.deleteCharAt(0);
		}

		return strResult.toString();

	}

	public static BigInteger getNum(String[] numStr) {
		BigInteger num = new BigInteger("0".getBytes());
		for (String s : numStr) {

			num = num.multiply(new BigInteger("10".getBytes())).add(new BigInteger(s.getBytes()));
		}
		return num;

	}

	public static int getStrVal(char num) {

		int i;
		switch (num) {
			case '9':
				i = 9;
				break;
			case '8':
				i = 8;
				break;
			case '7':
				i = 7;
				break;
			case '6':
				i = 6;
				break;
			case '5':
				i = 5;
				break;
			case '4':
				i = 4;
				break;
			case '3':
				i = 3;
				break;
			case '2':
				i = 2;
				break;
			case '1':
				i = 1;
				break;
			default:
				i = 0;


		}
		return i;

	}

	public static int[] findErrorNums(int[] nums) {
		int dup = -1;
		int correctedNum = 1;
		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				dup = nums[i];
			} else if (nums[i] > nums[i - 1] + 1) {
				correctedNum = nums[i - 1] + 1;
			}
		}

		return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : correctedNum};
	}

	static class Duck {
		String name;
		String color;
		int age;

		public Duck(String name, String color, int age) {
			this.name = name;
			this.color = color;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}


